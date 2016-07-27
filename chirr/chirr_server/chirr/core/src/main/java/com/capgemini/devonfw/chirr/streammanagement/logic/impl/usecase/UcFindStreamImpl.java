package com.capgemini.devonfw.chirr.streammanagement.logic.impl.usecase;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import com.capgemini.devonfw.chirr.general.logic.api.UseCase;
import com.capgemini.devonfw.chirr.streammanagement.dataaccess.api.StreamEntity;
import com.capgemini.devonfw.chirr.streammanagement.logic.api.to.StreamEto;
import com.capgemini.devonfw.chirr.streammanagement.logic.api.to.StreamSearchCriteriaTo;
import com.capgemini.devonfw.chirr.streammanagement.logic.api.usecase.UcFindStream;
import com.capgemini.devonfw.chirr.streammanagement.logic.base.usecase.AbstractStreamUc;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Use case implementation for searching, filtering and getting Streams
 */
@Named
@UseCase
@Validated
public class UcFindStreamImpl extends AbstractStreamUc implements UcFindStream {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindStreamImpl.class);

  @Override
  public StreamEto findStream(Long id) {

    LOG.debug("Get Stream with id {} from database.", id);
    return getBeanMapper().map(getStreamDao().findOne(id), StreamEto.class);
  }

  @Override
  public PaginatedListTo<StreamEto> findStreamEtos(StreamSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<StreamEntity> streams = getStreamDao().findStreams(criteria);
    return mapPaginatedEntityList(streams, StreamEto.class);
  }

}
