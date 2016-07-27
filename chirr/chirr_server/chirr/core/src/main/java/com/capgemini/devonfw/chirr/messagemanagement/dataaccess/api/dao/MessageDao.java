package com.capgemini.devonfw.chirr.messagemanagement.dataaccess.api.dao;

import com.capgemini.devonfw.chirr.general.dataaccess.api.dao.ApplicationDao;
import com.capgemini.devonfw.chirr.messagemanagement.dataaccess.api.MessageEntity;
import com.capgemini.devonfw.chirr.messagemanagement.logic.api.to.MessageSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Data access interface for Message entities
 */
public interface MessageDao extends ApplicationDao<MessageEntity> {

  /**
   * Finds the {@link MessageEntity messages} matching the given {@link MessageSearchCriteriaTo}.
   *
   * @param criteria is the {@link MessageSearchCriteriaTo}.
   * @return the {@link PaginatedListTo} with the matching {@link MessageEntity} objects.
   */
  PaginatedListTo<MessageEntity> findMessages(MessageSearchCriteriaTo criteria);
}
