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
import com.wadpam.spara.domain.DProject;

/**
 * The DProject domain-object specific finders and methods go in this POJO.
 * 
 * Generated on 2014-12-30T10:42:27.179+0100.
 * @author mardao DAO generator (net.sf.mardao.plugin.ProcessDomainMojo)
 */
public class GeneratedDProjectDaoImpl
  extends AbstractDao<DProject, java.lang.String> {

  public GeneratedDProjectDaoImpl(Supplier supplier) {
    super(new DProjectMapper(supplier), supplier);
  }

// ----------------------- field finders -------------------------------
  /**
   * query-by method for field createdBy
   * @param createdBy the specified attribute
   * @return an Iterable of DProjects for the specified createdBy
   */
  public Iterable<DProject> queryByCreatedBy(java.lang.String createdBy) {
    return queryByField(null, DProjectMapper.Field.CREATEDBY.getFieldName(), createdBy);
  }

  /**
   * query-by method for field createdDate
   * @param createdDate the specified attribute
   * @return an Iterable of DProjects for the specified createdDate
   */
  public Iterable<DProject> queryByCreatedDate(java.util.Date createdDate) {
    return queryByField(null, DProjectMapper.Field.CREATEDDATE.getFieldName(), createdDate);
  }

  /**
   * query-by method for field description
   * @param description the specified attribute
   * @return an Iterable of DProjects for the specified description
   */
  public Iterable<DProject> queryByDescription(java.lang.String description) {
    return queryByField(null, DProjectMapper.Field.DESCRIPTION.getFieldName(), description);
  }

  /**
   * query-by method for field displayName
   * @param displayName the specified attribute
   * @return an Iterable of DProjects for the specified displayName
   */
  public Iterable<DProject> queryByDisplayName(java.lang.String displayName) {
    return queryByField(null, DProjectMapper.Field.DISPLAYNAME.getFieldName(), displayName);
  }

  /**
   * query-by method for field updatedBy
   * @param updatedBy the specified attribute
   * @return an Iterable of DProjects for the specified updatedBy
   */
  public Iterable<DProject> queryByUpdatedBy(java.lang.String updatedBy) {
    return queryByField(null, DProjectMapper.Field.UPDATEDBY.getFieldName(), updatedBy);
  }

  /**
   * query-by method for field updatedDate
   * @param updatedDate the specified attribute
   * @return an Iterable of DProjects for the specified updatedDate
   */
  public Iterable<DProject> queryByUpdatedDate(java.util.Date updatedDate) {
    return queryByField(null, DProjectMapper.Field.UPDATEDDATE.getFieldName(), updatedDate);
  }


// ----------------------- query methods -------------------------------


}
