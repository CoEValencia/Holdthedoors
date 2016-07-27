package com.capgemini.devonfw.chirr.messagemanagement.logic.api.usecase;

import com.capgemini.devonfw.chirr.messagemanagement.logic.api.to.MessageEto;

/**
 * Interface of UcManageMessage to centralize documentation and signatures of methods.
 */
public interface UcManageMessage {

  /**
   * Deletes a message from the database by its id 'messageId'.
   *
   * @param messageId Id of the message to delete
   * @return boolean <code>true</code> if the message can be deleted, <code>false</code> otherwise
   */
  boolean deleteMessage(Long messageId);

  /**
   * Saves a message and store it in the database.
   *
   * @param message the {@link MessageEto} to create.
   * @return the new {@link MessageEto} that has been saved with ID and version.
   */
  MessageEto saveMessage(MessageEto message);

}
