package com.capgemini.devonfw.chirr.streammanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import com.capgemini.devonfw.chirr.general.logic.api.UseCase;
import com.capgemini.devonfw.chirr.streammanagement.dataaccess.api.StreamEntity;
import com.capgemini.devonfw.chirr.streammanagement.logic.api.to.StreamEto;
import com.capgemini.devonfw.chirr.streammanagement.logic.api.usecase.UcManageStream;
import com.capgemini.devonfw.chirr.streammanagement.logic.base.usecase.AbstractStreamUc;

/**
 * Use case implementation for modifying and deleting Streams
 */
@Named
@UseCase
@Validated
public class UcManageStreamImpl extends AbstractStreamUc implements UcManageStream {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcManageStreamImpl.class);

  @Override
  public boolean deleteStream(Long streamId) {

    StreamEntity stream = getStreamDao().find(streamId);
    getStreamDao().delete(stream);
    LOG.debug("The stream with id '{}' has been deleted.", streamId);
    return true;
  }

  @Override
  public StreamEto saveStream(StreamEto stream) {

    Objects.requireNonNull(stream, "stream");

    StreamEntity streamEntity = getBeanMapper().map(stream, StreamEntity.class);

    // initialize, validate streamEntity here if necessary

    getStreamDao().save(streamEntity);
    LOG.debug("Stream with id '{}' has been created.", streamEntity.getId());
    return getBeanMapper().map(streamEntity, StreamEto.class);
  }

}
