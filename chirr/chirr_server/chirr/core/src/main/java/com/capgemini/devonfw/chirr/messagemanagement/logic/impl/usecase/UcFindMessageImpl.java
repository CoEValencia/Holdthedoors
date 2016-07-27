package com.capgemini.devonfw.chirr.messagemanagement.logic.impl.usecase;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import com.capgemini.devonfw.chirr.general.logic.api.UseCase;
import com.capgemini.devonfw.chirr.messagemanagement.dataaccess.api.MessageEntity;
import com.capgemini.devonfw.chirr.messagemanagement.logic.api.to.MessageEto;
import com.capgemini.devonfw.chirr.messagemanagement.logic.api.to.MessageSearchCriteriaTo;
import com.capgemini.devonfw.chirr.messagemanagement.logic.api.usecase.UcFindMessage;
import com.capgemini.devonfw.chirr.messagemanagement.logic.base.usecase.AbstractMessageUc;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Use case implementation for searching, filtering and getting Messages
 */
@Named
@UseCase
@Validated
public class UcFindMessageImpl extends AbstractMessageUc implements UcFindMessage {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindMessageImpl.class);

  @Override
  public MessageEto findMessage(Long id) {

    LOG.debug("Get Message with id {} from database.", id);
    return getBeanMapper().map(getMessageDao().findOne(id), MessageEto.class);
  }

  @Override
  public PaginatedListTo<MessageEto> findMessageEtos(MessageSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<MessageEntity> messages = getMessageDao().findMessages(criteria);
    return mapPaginatedEntityList(messages, MessageEto.class);
  }

}
