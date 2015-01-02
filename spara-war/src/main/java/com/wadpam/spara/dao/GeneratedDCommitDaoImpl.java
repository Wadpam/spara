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
import com.wadpam.spara.domain.DCommit;

/**
 * The DCommit domain-object specific finders and methods go in this POJO.
 * 
 * Generated on 2015-01-02T12:29:46.798+0100.
 * @author mardao DAO generator (net.sf.mardao.plugin.ProcessDomainMojo)
 */
public class GeneratedDCommitDaoImpl
  extends AbstractDao<DCommit, java.lang.String> {

  public GeneratedDCommitDaoImpl(Supplier supplier) {
    super(new DCommitMapper(supplier), supplier);
  }

// ----------------------- field finders -------------------------------
  /**
   * query-by method for field createdBy
   * @param createdBy the specified attribute
   * @return an Iterable of DCommits for the specified createdBy
   */
  public Iterable<DCommit> queryByCreatedBy(Object ticketKey, java.lang.String createdBy) {
    return queryByField(ticketKey, DCommitMapper.Field.CREATEDBY.getFieldName(), createdBy);
  }

  /**
   * query-by method for field createdDate
   * @param createdDate the specified attribute
   * @return an Iterable of DCommits for the specified createdDate
   */
  public Iterable<DCommit> queryByCreatedDate(Object ticketKey, java.util.Date createdDate) {
    return queryByField(ticketKey, DCommitMapper.Field.CREATEDDATE.getFieldName(), createdDate);
  }

  /**
   * query-by method for field message
   * @param message the specified attribute
   * @return an Iterable of DCommits for the specified message
   */
  public Iterable<DCommit> queryByMessage(Object ticketKey, java.lang.String message) {
    return queryByField(ticketKey, DCommitMapper.Field.MESSAGE.getFieldName(), message);
  }

  /**
   * query-by method for field updatedBy
   * @param updatedBy the specified attribute
   * @return an Iterable of DCommits for the specified updatedBy
   */
  public Iterable<DCommit> queryByUpdatedBy(Object ticketKey, java.lang.String updatedBy) {
    return queryByField(ticketKey, DCommitMapper.Field.UPDATEDBY.getFieldName(), updatedBy);
  }

  /**
   * query-by method for field updatedDate
   * @param updatedDate the specified attribute
   * @return an Iterable of DCommits for the specified updatedDate
   */
  public Iterable<DCommit> queryByUpdatedDate(Object ticketKey, java.util.Date updatedDate) {
    return queryByField(ticketKey, DCommitMapper.Field.UPDATEDDATE.getFieldName(), updatedDate);
  }

  /**
   * query-by method for field url
   * @param url the specified attribute
   * @return an Iterable of DCommits for the specified url
   */
  public Iterable<DCommit> queryByUrl(Object ticketKey, java.lang.String url) {
    return queryByField(ticketKey, DCommitMapper.Field.URL.getFieldName(), url);
  }


// ----------------------- DCommit builder -------------------------------

  public static DCommitMapper.Builder newBuilder() {
    return DCommitMapper.newBuilder();
  }

}
