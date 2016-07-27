package com.capgemini.devonfw.chirr.streammanagement.dataaccess.api.dao;

import java.util.List;

import com.capgemini.devonfw.chirr.general.dataaccess.api.dao.ApplicationDao;
import com.capgemini.devonfw.chirr.streammanagement.dataaccess.api.StreamEntity;
import com.capgemini.devonfw.chirr.streammanagement.logic.api.to.StreamSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Data access interface for Stream entities
 */
public interface StreamDao extends ApplicationDao<StreamEntity> {

  /**
   * Finds the {@link StreamEntity streams} matching the given {@link StreamSearchCriteriaTo}.
   *
   * @param criteria is the {@link StreamSearchCriteriaTo}.
   * @return the {@link PaginatedListTo} with the matching {@link StreamEntity} objects.
   */
  PaginatedListTo<StreamEntity> findStreams(StreamSearchCriteriaTo criteria);

  /**
   * @return all streams
   */
  List<StreamEntity> findAll();

}
