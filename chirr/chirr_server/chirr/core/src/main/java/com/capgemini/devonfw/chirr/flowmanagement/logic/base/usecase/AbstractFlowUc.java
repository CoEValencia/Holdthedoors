package com.capgemini.devonfw.chirr.flowmanagement.logic.base.usecase;

import javax.inject.Inject;

import com.capgemini.devonfw.chirr.flowmanagement.dataaccess.api.dao.FlowDao;
import com.capgemini.devonfw.chirr.general.logic.base.AbstractUc;

/**
 * Abstract use case for Flows, which provides access to the commonly necessary data access objects.
 */
public class AbstractFlowUc extends AbstractUc {

  /** @see #getFlowDao() */
  @Inject
  private FlowDao flowDao;

  /**
   * Returns the field 'flowDao'.
   * 
   * @return the {@link FlowDao} instance.
   */
  public FlowDao getFlowDao() {

    return this.flowDao;
  }

}
