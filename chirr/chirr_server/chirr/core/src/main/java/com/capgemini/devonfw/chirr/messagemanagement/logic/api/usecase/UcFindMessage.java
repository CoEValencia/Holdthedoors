package com.capgemini.devonfw.chirr.messagemanagement.logic.api.usecase;

import java.util.List;

import com.capgemini.devonfw.chirr.messagemanagement.logic.api.to.MessageEto;
import com.capgemini.devonfw.chirr.messagemanagement.logic.api.to.MessageSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

public interface UcFindMessage {

  /**
   * Returns a Message by its id 'id'.
   *
   * @param id The id 'id' of the Message.
   * @return The {@link MessageEto} with id 'id'
   */
  MessageEto findMessage(Long id);

  /**
   * Returns a paginated list of Messages matching the search criteria.
   *
   * @param criteria the {@link MessageSearchCriteriaTo}.
   * @return the {@link List} of matching {@link MessageEto}s.
   */
  PaginatedListTo<MessageEto> findMessageEtos(MessageSearchCriteriaTo criteria);

}
