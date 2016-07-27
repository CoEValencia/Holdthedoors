package com.capgemini.devonfw.chirr.flowmanagement.logic.api.usecase;

import java.util.List;

import com.capgemini.devonfw.chirr.flowmanagement.logic.api.to.FlowEto;
import com.capgemini.devonfw.chirr.flowmanagement.logic.api.to.FlowSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

public interface UcFindFlow {

  /**
   * Returns a Flow by its id 'id'.
   *
   * @param id The id 'id' of the Flow.
   * @return The {@link FlowEto} with id 'id'
   */
  FlowEto findFlow(Long id);

  /**
   * Returns a paginated list of Flows matching the search criteria.
   *
   * @param criteria the {@link FlowSearchCriteriaTo}.
   * @return the {@link List} of matching {@link FlowEto}s.
   */
  PaginatedListTo<FlowEto> findFlowEtos(FlowSearchCriteriaTo criteria);

}
