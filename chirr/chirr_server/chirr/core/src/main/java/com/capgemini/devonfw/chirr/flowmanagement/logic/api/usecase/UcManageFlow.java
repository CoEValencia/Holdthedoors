package com.capgemini.devonfw.chirr.flowmanagement.logic.api.usecase;

import com.capgemini.devonfw.chirr.flowmanagement.logic.api.to.FlowEto;

/**
 * Interface of UcManageFlow to centralize documentation and signatures of methods.
 */
public interface UcManageFlow {

  /**
   * Deletes a flow from the database by its id 'flowId'.
   *
   * @param flowId Id of the flow to delete
   * @return boolean <code>true</code> if the flow can be deleted, <code>false</code> otherwise
   */
  boolean deleteFlow(Long flowId);

  /**
   * Saves a flow and store it in the database.
   *
   * @param flow the {@link FlowEto} to create.
   * @return the new {@link FlowEto} that has been saved with ID and version.
   */
  FlowEto saveFlow(FlowEto flow);

}
