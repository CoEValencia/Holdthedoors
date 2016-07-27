package com.capgemini.devonfw.chirr.streammanagement.dataaccess.impl.dao;

import java.util.List;

import javax.inject.Named;

import com.capgemini.devonfw.chirr.general.dataaccess.base.dao.ApplicationDaoImpl;
import com.capgemini.devonfw.chirr.streammanagement.dataaccess.api.StreamEntity;
import com.capgemini.devonfw.chirr.streammanagement.dataaccess.api.dao.StreamDao;
import com.capgemini.devonfw.chirr.streammanagement.logic.api.to.StreamSearchCriteriaTo;
import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link StreamDao}.
 */
@Named
public class StreamDaoImpl extends ApplicationDaoImpl<StreamEntity> implements StreamDao {

  /**
   * The constructor.
   */
  public StreamDaoImpl() {

    super();
  }

  @Override
  public Class<StreamEntity> getEntityClass() {

    return StreamEntity.class;
  }

  @Override
  public PaginatedListTo<StreamEntity> findStreams(StreamSearchCriteriaTo criteria) {

    StreamEntity stream = Alias.alias(StreamEntity.class);
    EntityPathBase<StreamEntity> alias = Alias.$(stream);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    if (criteria.isPrivated() != null) {
      Boolean privated = criteria.isPrivated();
      query.where(Alias.$(stream.isPrivated()).eq(privated));
    }
    String name = criteria.getName();
    if (name != null) {
      query.where(Alias.$(stream.getName()).eq(name));
    }
    return findPaginated(criteria, query, alias);
  }

  @Override
  public List<StreamEntity> findAll() {

    StreamEntity stream = Alias.alias(StreamEntity.class);
    EntityPathBase<StreamEntity> alias = Alias.$(stream);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    // query.where(Alias.$(1).eq(1));

    StreamSearchCriteriaTo criteria = new StreamSearchCriteriaTo();
    return findPaginated(criteria, query, alias).getResult();

  }

}
