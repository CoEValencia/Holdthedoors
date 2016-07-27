package com.capgemini.devonfw.chirr.messagemanagement.logic.base.usecase;

import javax.inject.Inject;

import com.capgemini.devonfw.chirr.general.logic.base.AbstractUc;
import com.capgemini.devonfw.chirr.messagemanagement.dataaccess.api.dao.MessageDao;

/**
 * Abstract use case for Messages, which provides access to the commonly necessary data access objects.
 */
public class AbstractMessageUc extends AbstractUc {

  /** @see #getMessageDao() */
  @Inject
  private MessageDao messageDao;

  /**
   * Returns the field 'messageDao'.
   * 
   * @return the {@link MessageDao} instance.
   */
  public MessageDao getMessageDao() {

    return this.messageDao;
  }

}
