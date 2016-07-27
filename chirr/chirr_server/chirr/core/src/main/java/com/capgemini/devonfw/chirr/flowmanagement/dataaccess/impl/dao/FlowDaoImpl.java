package com.capgemini.devonfw.chirr.flowmanagement.dataaccess.impl.dao;

import javax.inject.Named;

import com.capgemini.devonfw.chirr.flowmanagement.dataaccess.api.FlowEntity;
import com.capgemini.devonfw.chirr.flowmanagement.dataaccess.api.dao.FlowDao;
import com.capgemini.devonfw.chirr.flowmanagement.logic.api.to.FlowSearchCriteriaTo;
import com.capgemini.devonfw.chirr.general.dataaccess.base.dao.ApplicationDaoImpl;
import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link FlowDao}.
 */
@Named
public class FlowDaoImpl extends ApplicationDaoImpl<FlowEntity> implements FlowDao {

  /**
   * The constructor.
   */
  public FlowDaoImpl() {

    super();
  }

  @Override
  public Class<FlowEntity> getEntityClass() {

    return FlowEntity.class;
  }

  @Override
  public PaginatedListTo<FlowEntity> findFlows(FlowSearchCriteriaTo criteria) {

    FlowEntity flow = Alias.alias(FlowEntity.class);
    EntityPathBase<FlowEntity> alias = Alias.$(flow);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    String name = criteria.getName();
    if (name != null) {
      query.where(Alias.$(flow.getName()).contains(name));
    }
    Long streamid = criteria.getStreamid();
    if (streamid != null) {
      query.where(Alias.$(flow.getStreamid()).eq(streamid));
    }
    Long userid = criteria.getUserid();
    if (userid != null) {
      query.where(Alias.$(flow.getUserid()).eq(userid));
    }
    return findPaginated(criteria, query, alias);
  }

}