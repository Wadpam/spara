package com.wadpam.spara.config;

/*
 * #%L
 * spara-war
 * %%
 * Copyright (C) 2014 Wadpam
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */


import com.google.common.collect.ImmutableMap;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;
import com.google.inject.servlet.GuiceServletContextListener;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import com.wadpam.guja.cache.CacheBuilderProvider;
import com.wadpam.guja.cache.MemCacheBuilderProvider;
import com.wadpam.guja.config.GujaBaseModule;
import com.wadpam.guja.config.GujaCoreModule;
import com.wadpam.guja.config.GujaGAEModule;
import com.wadpam.guja.oauth2.web.OAuth2Filter;
import com.wadpam.guja.oauth2.web.Oauth2ClientAuthenticationFilter;
import com.wadpam.spara.api.ProjectResource;
import com.wadpam.spara.api.SparaResource;
import com.wadpam.spara.api.TicketResource;
import com.wadpam.spara.dao.DCommitDaoBean;
import com.wadpam.spara.dao.DProjectDaoBean;
import com.wadpam.spara.dao.DTicketDaoBean;
import com.wadpam.spara.hooks.GithubResource;
import net.sf.mardao.dao.DatastoreSupplier;
import net.sf.mardao.dao.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * Configure Guice modules and the web context.
 *
 * @author mattiaslevin
 */
public class SparaGuiceServletContextListener extends GuiceServletContextListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(SparaGuiceServletContextListener.class);

    private static final String APP_CONFIG_PROPERTY_FILE = "/WEB-INF/app.properties";

    @Override
    protected Injector getInjector() {

        Injector injector = Guice.createInjector(
                new GujaCoreModule(),
                new GujaBaseModule(),
                new GujaGAEModule(),
                new JerseyServletModule() {

                    private void bindProperties() {
                        try {
                            Properties properties = new Properties();
                            properties.load(getServletContext().getResourceAsStream(APP_CONFIG_PROPERTY_FILE));
                            Names.bindProperties(binder(), properties);
                        } catch (IOException e) {
                            LOGGER.error("Failed to load app properties from resource file {} with error {}", APP_CONFIG_PROPERTY_FILE, e);
                        }

                    }

                    @Override
                    protected void configureServlets() {

                        // Bindings
                        bindProperties();

                        bind(Supplier.class).to(DatastoreSupplier.class);
                        bind(CacheBuilderProvider.class).to(MemCacheBuilderProvider.class);

                        bind(DProjectDaoBean.class);
                        bind(DTicketDaoBean.class);
                        bind(DCommitDaoBean.class);

                        bind(ProjectResource.class);
                        bind(TicketResource.class);

                        bind(GithubResource.class);
                        bind(SparaResource.class);

                        // Filters
                        //filter("/*").through(PersistFilter.class);
                        filter("/api/*").through(OAuth2Filter.class);
                        filter("/oauth/*").through(Oauth2ClientAuthenticationFilter.class);

                        // Servlets
                        serve("/*").with(GuiceContainer.class, ImmutableMap.of(
                                "jersey.config.server.tracing.type", "ALL",
                                "com.sun.jersey.spi.container.ContainerResponseFilters", "com.wadpam.guja.filter.ProtoWrapperFilter",
                                "com.sun.jersey.spi.container.ResourceFilters", "com.sun.jersey.api.container.filter.RolesAllowedResourceFilterFactory"
                        ));

                        // TODO Find a better way to configure Jersey filters (Guice integration does not support Jersey filter configuration here)
                    }
                }
        );
        try {
            SparaResource spara = injector.getInstance(SparaResource.class);
            spara.populateExample();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return injector;
    }
}



