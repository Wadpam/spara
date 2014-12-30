package com.wadpam.spara.dao;

import java.util.Collection;
import java.util.Date;
import java.nio.ByteBuffer;

import net.sf.mardao.dao.Mapper;
import net.sf.mardao.dao.Supplier;
import net.sf.mardao.domain.AbstractEntityBuilder;
import com.wadpam.spara.domain.DProject;

/**
 * The DProject domain-object specific mapping methods go here.
 *
 * Generated on 2014-12-30T10:42:27.179+0100.
 * @author mardao DAO generator (net.sf.mardao.plugin.ProcessDomainMojo)
 */
public class DProjectMapper
  implements Mapper<DProject, String> {

  private final Supplier supplier;

  public enum Field {
    ID("id"),
    CREATEDBY("createdBy"),
    CREATEDDATE("createdDate"),
    DESCRIPTION("description"),
    DISPLAYNAME("displayName"),
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

  public DProjectMapper(Supplier supplier) {
    this.supplier = supplier;
  }

  @Override
  public String fromKey(Object key) {
    return supplier.toStringKey(key);
  }

  @Override
  public DProject fromReadValue(Object value) {
    final DProject entity = new DProject();

    // set primary key:
    final Object key = supplier.getKey(value, Field.ID.getFieldName());
    entity.setId(supplier.toStringKey(key));

    // set all fields:
    entity.setCreatedBy(supplier.getString(value, Field.CREATEDBY.getFieldName()));
    entity.setCreatedDate(supplier.getDate(value, Field.CREATEDDATE.getFieldName()));
    entity.setDescription(supplier.getString(value, Field.DESCRIPTION.getFieldName()));
    entity.setDisplayName(supplier.getString(value, Field.DISPLAYNAME.getFieldName()));
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
  public String getId(DProject entity) {
    return entity != null ? entity.getId() : null;
  }

  @Override
  public Object getParentKey(DProject entity) {
    return null;
  }

  @Override
  public void setParentKey(DProject entity, Object parentKey) {
    // this entity has no parent
  }

  @Override
  public void updateEntityPostWrite(DProject entity, Object key, Object value) {
    entity.setId(supplier.toStringKey(key));
    entity.setCreatedBy(supplier.getString(value, Field.CREATEDBY.getFieldName()));
    entity.setCreatedDate(supplier.getDate(value, Field.CREATEDDATE.getFieldName()));
    entity.setUpdatedBy(supplier.getString(value, Field.UPDATEDBY.getFieldName()));
    entity.setUpdatedDate(supplier.getDate(value, Field.UPDATEDDATE.getFieldName()));
}

@Override
  public String getKind() {
    return DProject.class.getSimpleName();
  }

  @Override
  public Object toKey(Object parentKey, String id) {
    return supplier.toKey(parentKey, getKind(), id);
  }

  @Override
  public Object toWriteValue(DProject entity) {
    final String id = getId(entity);
    final Object parentKey = getParentKey(entity);
    final Object value = supplier.createWriteValue(parentKey, getKind(), id);

    // set all fields:
    supplier.setString(value, Field.CREATEDBY.getFieldName(), entity.getCreatedBy());
    supplier.setDate(value, Field.CREATEDDATE.getFieldName(), entity.getCreatedDate());
    supplier.setString(value, Field.DESCRIPTION.getFieldName(), entity.getDescription());
    supplier.setString(value, Field.DISPLAYNAME.getFieldName(), entity.getDisplayName());
    supplier.setString(value, Field.UPDATEDBY.getFieldName(), entity.getUpdatedBy());
    supplier.setDate(value, Field.UPDATEDDATE.getFieldName(), entity.getUpdatedDate());
    return value;
  }

  public static DProjectBuilder newBuilder() {
    return new DProjectBuilder();
  }

  public static class DProjectBuilder extends AbstractEntityBuilder<DProject> {

    @Override
    protected DProject newInstance() {
      return new DProject();
    }

    public DProjectBuilder id(String id) {
      entity.setId(id);
      return this;
    }

    public DProjectBuilder createdBy(String createdBy) {
      entity.setCreatedBy(createdBy);
      return this;
    }
    public DProjectBuilder createdDate(Date createdDate) {
      entity.setCreatedDate(createdDate);
      return this;
    }
    public DProjectBuilder description(String description) {
      entity.setDescription(description);
      return this;
    }
    public DProjectBuilder displayName(String displayName) {
      entity.setDisplayName(displayName);
      return this;
    }
    public DProjectBuilder updatedBy(String updatedBy) {
      entity.setUpdatedBy(updatedBy);
      return this;
    }
    public DProjectBuilder updatedDate(Date updatedDate) {
      entity.setUpdatedDate(updatedDate);
      return this;
    }
  }
}
