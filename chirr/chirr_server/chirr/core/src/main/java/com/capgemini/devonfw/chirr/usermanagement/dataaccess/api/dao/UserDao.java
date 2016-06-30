package com.capgemini.devonfw.chirr.usermanagement.dataaccess.api.dao;

import com.capgemini.devonfw.chirr.general.dataaccess.api.dao.ApplicationDao;
import com.capgemini.devonfw.chirr.usermanagement.dataaccess.api.UserEntity;
import com.capgemini.devonfw.chirr.usermanagement.logic.api.to.UserSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Data access interface for User entities
 */
public interface UserDao extends ApplicationDao<UserEntity> {

  /**
   * Finds the {@link UserEntity users} matching the given {@link UserSearchCriteriaTo}.
   *
   * @param criteria is the {@link UserSearchCriteriaTo}.
   * @return the {@link PaginatedListTo} with the matching {@link UserEntity} objects.
   */
  PaginatedListTo<UserEntity> findUsers(UserSearchCriteriaTo criteria);
}
