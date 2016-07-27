package com.capgemini.devonfw.chirr.flowmanagement.logic.api.to;

import com.capgemini.devonfw.chirr.general.common.api.to.AbstractCto;

/**
 * Composite transport object of Flow
 */
public class FlowCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private FlowEto flow;

  public FlowEto getFlow() {

    return flow;
  }

  public void setFlow(FlowEto flow) {

    this.flow = flow;
  }

}
