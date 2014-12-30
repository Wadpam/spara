package com.wadpam.spara.dao;

import java.util.Collection;
import java.util.Date;
import java.nio.ByteBuffer;

import net.sf.mardao.dao.Mapper;
import net.sf.mardao.dao.Supplier;
import net.sf.mardao.domain.AbstractEntityBuilder;
import com.wadpam.spara.domain.DTicket;

/**
 * The DTicket domain-object specific mapping methods go here.
 *
 * Generated on 2014-12-30T10:42:27.179+0100.
 * @author mardao DAO generator (net.sf.mardao.plugin.ProcessDomainMojo)
 */
public class DTicketMapper
  implements Mapper<DTicket, Long> {

  private final Supplier supplier;

  public enum Field {
    PROJECTKEY("projectKey"),
    ID("id"),
    CREATEDBY("createdBy"),
    CREATEDDATE("createdDate"),
    DESCRIPTION("description"),
    TITLE("title"),
    UPDATEDBY("updatedBy"),
    UPDATEDDATE("updatedDate");

    private final String fieldName;

    Field(String fieldName) {
      this.fieldName = fieldName;
    }

    public String getFieldName() {
      return fieldName;
    }
  }

  public DTicketMapper(Supplier supplier) {
    this.supplier = supplier;
  }

  @Override
  public Long fromKey(Object key) {
    return supplier.toLongKey(key);
  }

  @Override
  public DTicket fromReadValue(Object value) {
    final DTicket entity = new DTicket();

    // set primary key:
    final Object key = supplier.getKey(value, Field.ID.getFieldName());
    entity.setId(supplier.toLongKey(key));

    // set parent key:
    entity.setProjectKey(supplier.getParentKey(value, Field.PROJECTKEY.getFieldName()));

    // set all fields:
    entity.setCreatedBy(supplier.getString(value, Field.CREATEDBY.getFieldName()));
    entity.setCreatedDate(supplier.getDate(value, Field.CREATEDDATE.getFieldName()));
    entity.setDescription(supplier.getString(value, Field.DESCRIPTION.getFieldName()));
    entity.setTitle(supplier.getString(value, Field.TITLE.getFieldName()));
    entity.setUpdatedBy(supplier.getString(value, Field.UPDATEDBY.getFieldName()));
    entity.setUpdatedDate(supplier.getDate(value, Field.UPDATEDDATE.getFieldName()));
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
  public Long getId(DTicket entity) {
    return entity != null ? entity.getId() : null;
  }

  @Override
  public Object getParentKey(DTicket entity) {
    return null != entity ? entity.getProjectKey() : null;
  }

  @Override
  public void setParentKey(DTicket entity, Object parentKey) {
    entity.setProjectKey(parentKey);
  }

  @Override
  public void updateEntityPostWrite(DTicket entity, Object key, Object value) {
    entity.setId(supplier.toLongKey(key));
    entity.setCreatedBy(supplier.getString(value, Field.CREATEDBY.getFieldName()));
    entity.setCreatedDate(supplier.getDate(value, Field.CREATEDDATE.getFieldName()));
    entity.setUpdatedBy(supplier.getString(value, Field.UPDATEDBY.getFieldName()));
    entity.setUpdatedDate(supplier.getDate(value, Field.UPDATEDDATE.getFieldName()));
}

@Override
  public String getKind() {
    return DTicket.class.getSimpleName();
  }

  @Override
  public Object toKey(Object parentKey, Long id) {
    return supplier.toKey(parentKey, getKind(), id);
  }

  @Override
  public Object toWriteValue(DTicket entity) {
    final Long id = getId(entity);
    final Object parentKey = getParentKey(entity);
    final Object value = supplier.createWriteValue(parentKey, getKind(), id);

    // set all fields:
    supplier.setString(value, Field.CREATEDBY.getFieldName(), entity.getCreatedBy());
    supplier.setDate(value, Field.CREATEDDATE.getFieldName(), entity.getCreatedDate());
    supplier.setString(value, Field.DESCRIPTION.getFieldName(), entity.getDescription());
    supplier.setString(value, Field.TITLE.getFieldName(), entity.getTitle());
    supplier.setString(value, Field.UPDATEDBY.getFieldName(), entity.getUpdatedBy());
    supplier.setDate(value, Field.UPDATEDDATE.getFieldName(), entity.getUpdatedDate());
    return value;
  }

  public static DTicketBuilder newBuilder() {
    return new DTicketBuilder();
  }

  public static class DTicketBuilder extends AbstractEntityBuilder<DTicket> {

    @Override
    protected DTicket newInstance() {
      return new DTicket();
    }

    public DTicketBuilder id(Long id) {
      entity.setId(id);
      return this;
    }

    public DTicketBuilder createdBy(String createdBy) {
      entity.setCreatedBy(createdBy);
      return this;
    }
    public DTicketBuilder createdDate(Date createdDate) {
      entity.setCreatedDate(createdDate);
      return this;
    }
    public DTicketBuilder description(String description) {
      entity.setDescription(description);
      return this;
    }
    public DTicketBuilder title(String title) {
      entity.setTitle(title);
      return this;
    }
    public DTicketBuilder updatedBy(String updatedBy) {
      entity.setUpdatedBy(updatedBy);
      return this;
    }
    public DTicketBuilder updatedDate(Date updatedDate) {
      entity.setUpdatedDate(updatedDate);
      return this;
    }
  }
}
