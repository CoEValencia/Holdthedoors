package com.capgemini.devonfw.chirr.streammanagement.logic.api.usecase;

import com.capgemini.devonfw.chirr.streammanagement.logic.api.to.StreamEto;

/**
 * Interface of UcManageStream to centralize documentation and signatures of methods.
 */
public interface UcManageStream {

  /**
   * Deletes a stream from the database by its id 'streamId'.
   *
   * @param streamId Id of the stream to delete
   * @return boolean <code>true</code> if the stream can be deleted, <code>false</code> otherwise
   */
  boolean deleteStream(Long streamId);

  /**
   * Saves a stream and store it in the database.
   *
   * @param stream the {@link StreamEto} to create.
   * @return the new {@link StreamEto} that has been saved with ID and version.
   */
  StreamEto saveStream(StreamEto stream);

}
