package com.capgemini.devonfw.chirr.flowmanagement.dataaccess.api.dao;

import com.capgemini.devonfw.chirr.flowmanagement.dataaccess.api.FlowEntity;
import com.capgemini.devonfw.chirr.flowmanagement.logic.api.to.FlowSearchCriteriaTo;
import com.capgemini.devonfw.chirr.general.dataaccess.api.dao.ApplicationDao;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Data access interface for Flow entities
 */
public interface FlowDao extends ApplicationDao<FlowEntity> {

  /**
   * Finds the {@link FlowEntity flows} matching the given {@link FlowSearchCriteriaTo}.
   *
   * @param criteria is the {@link FlowSearchCriteriaTo}.
   * @return the {@link PaginatedListTo} with the matching {@link FlowEntity} objects.
   */
  PaginatedListTo<FlowEntity> findFlows(FlowSearchCriteriaTo criteria);
}
