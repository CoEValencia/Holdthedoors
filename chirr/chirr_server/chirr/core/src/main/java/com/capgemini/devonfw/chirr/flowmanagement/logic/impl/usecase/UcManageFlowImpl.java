package com.capgemini.devonfw.chirr.flowmanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import com.capgemini.devonfw.chirr.flowmanagement.dataaccess.api.FlowEntity;
import com.capgemini.devonfw.chirr.flowmanagement.logic.api.to.FlowEto;
import com.capgemini.devonfw.chirr.flowmanagement.logic.api.usecase.UcManageFlow;
import com.capgemini.devonfw.chirr.flowmanagement.logic.base.usecase.AbstractFlowUc;
import com.capgemini.devonfw.chirr.general.logic.api.UseCase;

/**
 * Use case implementation for modifying and deleting Flows
 */
@Named
@UseCase
@Validated
public class UcManageFlowImpl extends AbstractFlowUc implements UcManageFlow {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcManageFlowImpl.class);

  @Override
  public boolean deleteFlow(Long flowId) {

    FlowEntity flow = getFlowDao().find(flowId);
    getFlowDao().delete(flow);
    LOG.debug("The flow with id '{}' has been deleted.", flowId);
    return true;
  }

  @Override
  public FlowEto saveFlow(FlowEto flow) {

    Objects.requireNonNull(flow, "flow");

    FlowEntity flowEntity = getBeanMapper().map(flow, FlowEntity.class);

    // initialize, validate flowEntity here if necessary

    getFlowDao().save(flowEntity);
    LOG.debug("Flow with id '{}' has been created.", flowEntity.getId());
    return getBeanMapper().map(flowEntity, FlowEto.class);
  }
}
