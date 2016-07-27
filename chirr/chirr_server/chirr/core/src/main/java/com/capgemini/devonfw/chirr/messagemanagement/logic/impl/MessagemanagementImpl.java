package com.capgemini.devonfw.chirr.messagemanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.capgemini.devonfw.chirr.general.logic.base.AbstractComponentFacade;
import com.capgemini.devonfw.chirr.messagemanagement.logic.api.Messagemanagement;
import com.capgemini.devonfw.chirr.messagemanagement.logic.api.to.MessageEto;
import com.capgemini.devonfw.chirr.messagemanagement.logic.api.to.MessageSearchCriteriaTo;
import com.capgemini.devonfw.chirr.messagemanagement.logic.api.usecase.UcFindMessage;
import com.capgemini.devonfw.chirr.messagemanagement.logic.api.usecase.UcManageMessage;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Implementation of component interface of messagemanagement
 */
@Named
public class MessagemanagementImpl extends AbstractComponentFacade implements Messagemanagement {

  @Inject
  private UcFindMessage ucFindMessage;

  @Inject
  private UcManageMessage ucManageMessage;

  /**
   * The constructor.
   */
  public MessagemanagementImpl() {
    super();
  }

  @Override
  public MessageEto findMessage(Long id) {

    return this.ucFindMessage.findMessage(id);
  }

  @Override
  public PaginatedListTo<MessageEto> findMessageEtos(MessageSearchCriteriaTo criteria) {

    return this.ucFindMessage.findMessageEtos(criteria);
  }

  @Override
  public MessageEto saveMessage(MessageEto message) {

    return this.ucManageMessage.saveMessage(message);
  }

  @Override
  public boolean deleteMessage(Long id) {

    return this.ucManageMessage.deleteMessage(id);
  }
}
