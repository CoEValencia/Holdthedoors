package com.capgemini.devonfw.chirr.flowmanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.capgemini.devonfw.chirr.flowmanagement.logic.api.Flowmanagement;
import com.capgemini.devonfw.chirr.flowmanagement.logic.api.to.FlowEto;
import com.capgemini.devonfw.chirr.flowmanagement.logic.api.to.FlowSearchCriteriaTo;
import com.capgemini.devonfw.chirr.flowmanagement.logic.api.usecase.UcFindFlow;
import com.capgemini.devonfw.chirr.flowmanagement.logic.api.usecase.UcManageFlow;
import com.capgemini.devonfw.chirr.general.logic.base.AbstractComponentFacade;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Implementation of component interface of flowmanagement
 */
@Named
public class FlowmanagementImpl extends AbstractComponentFacade implements Flowmanagement {

  @Inject
  private UcFindFlow ucFindFlow;

  @Inject
  private UcManageFlow ucManageFlow;

  /**
   * The constructor.
   */
  public FlowmanagementImpl() {
    super();
  }

  @Override
  public FlowEto findFlow(Long id) {

    return this.ucFindFlow.findFlow(id);
  }

  @Override
  public PaginatedListTo<FlowEto> findFlowEtos(FlowSearchCriteriaTo criteria) {

    return this.ucFindFlow.findFlowEtos(criteria);
  }

  @Override
  public FlowEto saveFlow(FlowEto flow) {

    return this.ucManageFlow.saveFlow(flow);
  }

  @Override
  public boolean deleteFlow(Long id) {

    return this.ucManageFlow.deleteFlow(id);
  }
}
