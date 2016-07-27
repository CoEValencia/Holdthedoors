package com.capgemini.devonfw.chirr.streammanagement.logic.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.capgemini.devonfw.chirr.general.logic.base.AbstractComponentFacade;
import com.capgemini.devonfw.chirr.streammanagement.dataaccess.api.StreamEntity;
import com.capgemini.devonfw.chirr.streammanagement.dataaccess.api.dao.StreamDao;
import com.capgemini.devonfw.chirr.streammanagement.logic.api.Streammanagement;
import com.capgemini.devonfw.chirr.streammanagement.logic.api.to.StreamEto;
import com.capgemini.devonfw.chirr.streammanagement.logic.api.to.StreamSearchCriteriaTo;
import com.capgemini.devonfw.chirr.streammanagement.logic.api.usecase.UcFindStream;
import com.capgemini.devonfw.chirr.streammanagement.logic.api.usecase.UcManageStream;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Implementation of component interface of streammanagement
 */
@Named
public class StreammanagementImpl extends AbstractComponentFacade implements Streammanagement {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(StreammanagementImpl.class);

  @Inject
  private UcFindStream ucFindStream;

  @Inject
  private UcManageStream ucManageStream;

  @Inject
  private StreamDao streamDao;

  /**
   * The constructor.
   */
  public StreammanagementImpl() {

    super();
  }

  @Override
  public StreamEto findStream(Long id) {

    return this.ucFindStream.findStream(id);
  }

  @Override
  public PaginatedListTo<StreamEto> findStreamEtos(StreamSearchCriteriaTo criteria) {

    return this.ucFindStream.findStreamEtos(criteria);
  }

  @Override
  public StreamEto saveStream(StreamEto stream) {

    return this.ucManageStream.saveStream(stream);
  }

  @Override
  public boolean deleteStream(Long id) {

    return this.ucManageStream.deleteStream(id);
  }

  /**
   * Returns the field 'streamDao'.
   *
   * @return the {@link StreamDao} instance.
   */
  public StreamDao getStreamDao() {

    return this.streamDao;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<StreamEto> findAllCatalogos() {

    LOG.debug("Get all streams from database.");
    List<StreamEntity> streams = getStreamDao().findAll();
    return getBeanMapper().mapList(streams, StreamEto.class);
  }

}
