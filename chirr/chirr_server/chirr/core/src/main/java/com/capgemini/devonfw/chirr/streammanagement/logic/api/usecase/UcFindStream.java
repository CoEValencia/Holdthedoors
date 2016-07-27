package com.capgemini.devonfw.chirr.streammanagement.logic.api.usecase;

import java.util.List;

import com.capgemini.devonfw.chirr.streammanagement.logic.api.to.StreamEto;
import com.capgemini.devonfw.chirr.streammanagement.logic.api.to.StreamSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

public interface UcFindStream {

  /**
   * Returns a Stream by its id 'id'.
   *
   * @param id The id 'id' of the Stream.
   * @return The {@link StreamEto} with id 'id'
   */
  StreamEto findStream(Long id);

  /**
   * Returns a paginated list of Streams matching the search criteria.
   *
   * @param criteria the {@link StreamSearchCriteriaTo}.
   * @return the {@link List} of matching {@link StreamEto}s.
   */
  PaginatedListTo<StreamEto> findStreamEtos(StreamSearchCriteriaTo criteria);

}
