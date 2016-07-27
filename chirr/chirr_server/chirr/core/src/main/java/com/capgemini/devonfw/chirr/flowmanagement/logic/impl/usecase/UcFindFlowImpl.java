package com.capgemini.devonfw.chirr.flowmanagement.logic.impl.usecase;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import com.capgemini.devonfw.chirr.flowmanagement.dataaccess.api.FlowEntity;
import com.capgemini.devonfw.chirr.flowmanagement.logic.api.to.FlowEto;
import com.capgemini.devonfw.chirr.flowmanagement.logic.api.to.FlowSearchCriteriaTo;
import com.capgemini.devonfw.chirr.flowmanagement.logic.api.usecase.UcFindFlow;
import com.capgemini.devonfw.chirr.flowmanagement.logic.base.usecase.AbstractFlowUc;
import com.capgemini.devonfw.chirr.general.logic.api.UseCase;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Use case implementation for searching, filtering and getting Flows
 */
@Named
@UseCase
@Validated
public class UcFindFlowImpl extends AbstractFlowUc implements UcFindFlow {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindFlowImpl.class);

  @Override
  public FlowEto findFlow(Long id) {

    LOG.debug("Get Flow with id {} from database.", id);
    return getBeanMapper().map(getFlowDao().findOne(id), FlowEto.class);
  }

  @Override
  public PaginatedListTo<FlowEto> findFlowEtos(FlowSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<FlowEntity> flows = getFlowDao().findFlows(criteria);
    return mapPaginatedEntityList(flows, FlowEto.class);
  }

}
