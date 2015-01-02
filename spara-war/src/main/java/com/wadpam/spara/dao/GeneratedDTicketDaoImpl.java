package com.wadpam.spara.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import net.sf.mardao.core.CursorPage;
import net.sf.mardao.core.filter.Filter;
import net.sf.mardao.core.geo.DLocation;
import net.sf.mardao.dao.AbstractDao;
import net.sf.mardao.dao.Supplier;
import com.wadpam.spara.domain.DTicket;

/**
 * The DTicket domain-object specific finders and methods go in this POJO.
 * 
 * Generated on 2015-01-02T12:29:46.798+0100.
 * @author mardao DAO generator (net.sf.mardao.plugin.ProcessDomainMojo)
 */
public class GeneratedDTicketDaoImpl
  extends AbstractDao<DTicket, java.lang.Long> {

  public GeneratedDTicketDaoImpl(Supplier supplier) {
    super(new DTicketMapper(supplier), supplier);
  }

// ----------------------- field finders -------------------------------
  /**
   * query-by method for field createdBy
   * @param createdBy the specified attribute
   * @return an Iterable of DTickets for the specified createdBy
   */
  public Iterable<DTicket> queryByCreatedBy(Object projectKey, java.lang.String createdBy) {
    return queryByField(projectKey, DTicketMapper.Field.CREATEDBY.getFieldName(), createdBy);
  }

  /**
   * query-by method for field createdDate
   * @param createdDate the specified attribute
   * @return an Iterable of DTickets for the specified createdDate
   */
  public Iterable<DTicket> queryByCreatedDate(Object projectKey, java.util.Date createdDate) {
    return queryByField(projectKey, DTicketMapper.Field.CREATEDDATE.getFieldName(), createdDate);
  }

  /**
   * query-by method for field description
   * @param description the specified attribute
   * @return an Iterable of DTickets for the specified description
   */
  public Iterable<DTicket> queryByDescription(Object projectKey, java.lang.String description) {
    return queryByField(projectKey, DTicketMapper.Field.DESCRIPTION.getFieldName(), description);
  }

  /**
   * query-by method for field title
   * @param title the specified attribute
   * @return an Iterable of DTickets for the specified title
   */
  public Iterable<DTicket> queryByTitle(Object projectKey, java.lang.String title) {
    return queryByField(projectKey, DTicketMapper.Field.TITLE.getFieldName(), title);
  }

  /**
   * query-by method for field updatedBy
   * @param updatedBy the specified attribute
   * @return an Iterable of DTickets for the specified updatedBy
   */
  public Iterable<DTicket> queryByUpdatedBy(Object projectKey, java.lang.String updatedBy) {
    return queryByField(projectKey, DTicketMapper.Field.UPDATEDBY.getFieldName(), updatedBy);
  }

  /**
   * query-by method for field updatedDate
   * @param updatedDate the specified attribute
   * @return an Iterable of DTickets for the specified updatedDate
   */
  public Iterable<DTicket> queryByUpdatedDate(Object projectKey, java.util.Date updatedDate) {
    return queryByField(projectKey, DTicketMapper.Field.UPDATEDDATE.getFieldName(), updatedDate);
  }


// ----------------------- DTicket builder -------------------------------

  public static DTicketMapper.Builder newBuilder() {
    return DTicketMapper.newBuilder();
  }

}
