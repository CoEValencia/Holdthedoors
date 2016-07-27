package com.capgemini.devonfw.chirr.messagemanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import com.capgemini.devonfw.chirr.general.logic.api.UseCase;
import com.capgemini.devonfw.chirr.messagemanagement.dataaccess.api.MessageEntity;
import com.capgemini.devonfw.chirr.messagemanagement.logic.api.to.MessageEto;
import com.capgemini.devonfw.chirr.messagemanagement.logic.api.usecase.UcManageMessage;
import com.capgemini.devonfw.chirr.messagemanagement.logic.base.usecase.AbstractMessageUc;

/**
 * Use case implementation for modifying and deleting Messages
 */
@Named
@UseCase
@Validated
public class UcManageMessageImpl extends AbstractMessageUc implements UcManageMessage {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcManageMessageImpl.class);

  @Override
  public boolean deleteMessage(Long messageId) {

    MessageEntity message = getMessageDao().find(messageId);
    getMessageDao().delete(message);
    LOG.debug("The message with id '{}' has been deleted.", messageId);
    return true;
  }

  @Override
  public MessageEto saveMessage(MessageEto message) {

    Objects.requireNonNull(message, "message");

    MessageEntity messageEntity = getBeanMapper().map(message, MessageEntity.class);

    // initialize, validate messageEntity here if necessary

    getMessageDao().save(messageEntity);
    LOG.debug("Message with id '{}' has been created.", messageEntity.getId());
    return getBeanMapper().map(messageEntity, MessageEto.class);
  }
}
