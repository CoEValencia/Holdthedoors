package com.capgemini.devonfw.chirr.messagemanagement.logic.api.to;

import com.capgemini.devonfw.chirr.general.common.api.to.AbstractCto;

/**
 * Composite transport object of Message
 */
public class MessageCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private MessageEto message;

  public MessageEto getMessage() {

    return message;
  }

  public void setMessage(MessageEto message) {

    this.message = message;
  }

}
