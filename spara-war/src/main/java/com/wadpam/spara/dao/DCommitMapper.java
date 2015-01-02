package com.wadpam.spara.dao;

import java.util.Collection;
import java.util.Date;
import java.nio.ByteBuffer;

import net.sf.mardao.dao.Mapper;
import net.sf.mardao.dao.Supplier;
import net.sf.mardao.domain.AbstractEntityBuilder;
import com.wadpam.spara.domain.DCommit;

/**
 * The DCommit domain-object specific mapping methods go here.
 *
 * Generated on 2015-01-02T12:29:46.798+0100.
 * @author mardao DAO generator (net.sf.mardao.plugin.ProcessDomainMojo)
 */
public class DCommitMapper
  implements Mapper<DCommit, String> {

  private final Supplier supplier;

  public enum Field {
    TICKETKEY("ticketKey"),
    ID("id"),
    CREATEDBY("createdBy"),
    CREATEDDATE("createdDate"),
    MESSAGE("message"),
    UPDATEDBY("updatedBy"),
    UPDATEDDATE("updatedDate"),
    URL("url");

    private final String fieldName;

    Field(String fieldName) {
      this.fieldName = fieldName;
    }

    public String getFieldName() {
      return fieldName;
    }
  }

  public DCommitMapper(Supplier supplier) {
    this.supplier = supplier;
  }

  @Override
  public String fromKey(Object key) {
    return supplier.toStringKey(key);
  }

  @Override
  public DCommit fromReadValue(Object value) {
    final DCommit entity = new DCommit();

    // set primary key:
    final Object key = supplier.getKey(value, Field.ID.getFieldName());
    entity.setId(supplier.toStringKey(key));

    // set parent key:
    entity.setTicketKey(supplier.getParentKey(value, Field.TICKETKEY.getFieldName()));

    // set all fields:
    entity.setCreatedBy(supplier.getString(value, Field.CREATEDBY.getFieldName()));
    entity.setCreatedDate(supplier.getDate(value, Field.CREATEDDATE.getFieldName()));
    entity.setMessage(supplier.getString(value, Field.MESSAGE.getFieldName()));
    entity.setUpdatedBy(supplier.getString(value, Field.UPDATEDBY.getFieldName()));
    entity.setUpdatedDate(supplier.getDate(value, Field.UPDATEDDATE.getFieldName()));
    entity.setUrl(supplier.getString(value, Field.URL.getFieldName()));
    return entity;
  }

  @Override
  public String getCreatedByColumnName() {
    return Field.CREATEDBY.getFieldName();
  }

  @Override
  public String getCreatedDateColumnName() {
    return Field.CREATEDDATE.getFieldName();
  }

  @Override
  public String getUpdatedByColumnName() {
    return Field.UPDATEDBY.getFieldName();
  }

  @Override
  public String getUpdatedDateColumnName() {
    return Field.UPDATEDDATE.getFieldName();
  }

  @Override
  public String getId(DCommit entity) {
    return entity != null ? entity.getId() : null;
  }

  @Override
  public Object getParentKey(DCommit entity) {
    return null != entity ? entity.getTicketKey() : null;
  }

  @Override
  public void setParentKey(DCommit entity, Object parentKey) {
    entity.setTicketKey(parentKey);
  }

  @Override
  public void updateEntityPostWrite(DCommit entity, Object key, Object value) {
    entity.setId(supplier.toStringKey(key));
    entity.setCreatedBy(supplier.getString(value, Field.CREATEDBY.getFieldName()));
    entity.setCreatedDate(supplier.getDate(value, Field.CREATEDDATE.getFieldName()));
    entity.setUpdatedBy(supplier.getString(value, Field.UPDATEDBY.getFieldName()));
    entity.setUpdatedDate(supplier.getDate(value, Field.UPDATEDDATE.getFieldName()));
}

@Override
  public String getKind() {
    return DCommit.class.getSimpleName();
  }

  @Override
  public Object toKey(Object parentKey, String id) {
    return supplier.toKey(parentKey, getKind(), id);
  }

  @Override
  public Object toWriteValue(DCommit entity) {
    final String id = getId(entity);
    final Object parentKey = getParentKey(entity);
    final Object value = supplier.createWriteValue(parentKey, getKind(), id);

    // set all fields:
    supplier.setString(value, Field.CREATEDBY.getFieldName(), entity.getCreatedBy());
    supplier.setDate(value, Field.CREATEDDATE.getFieldName(), entity.getCreatedDate());
    supplier.setString(value, Field.MESSAGE.getFieldName(), entity.getMessage());
    supplier.setString(value, Field.UPDATEDBY.getFieldName(), entity.getUpdatedBy());
    supplier.setDate(value, Field.UPDATEDDATE.getFieldName(), entity.getUpdatedDate());
    supplier.setString(value, Field.URL.getFieldName(), entity.getUrl());
    return value;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder extends AbstractEntityBuilder<DCommit> {

    protected Builder() {
      super(new DCommit());
    }

    public Builder id(String id) {
      entity.setId(id);
      return this;
    }

    public Builder ticketKey(Object ticketKey) {
      entity.setTicketKey(ticketKey);
      return this;
    }

    public Builder createdBy(String createdBy) {
      entity.setCreatedBy(createdBy);
      return this;
    }

    public Builder createdDate(Date createdDate) {
      entity.setCreatedDate(createdDate);
      return this;
    }

    public Builder message(String message) {
      entity.setMessage(message);
      return this;
    }

    public Builder updatedBy(String updatedBy) {
      entity.setUpdatedBy(updatedBy);
      return this;
    }

    public Builder updatedDate(Date updatedDate) {
      entity.setUpdatedDate(updatedDate);
      return this;
    }

    public Builder url(String url) {
      entity.setUrl(url);
      return this;
    }

  }
}
