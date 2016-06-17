package com.capgemini.devon.chirr.usermanagement.logic.impl;

import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.capgemini.devon.chirr.general.logic.base.AbstractComponentFacade;
import com.capgemini.devon.chirr.usermanagement.dataaccess.api.UserEntity;
import com.capgemini.devon.chirr.usermanagement.dataaccess.api.dao.UserDao;
import com.capgemini.devon.chirr.usermanagement.logic.api.Usermanagement;
import com.capgemini.devon.chirr.usermanagement.logic.api.to.UserEto;
import com.capgemini.devon.chirr.usermanagement.logic.api.to.UserSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Implementation of component interface of usermanagement
 */
@Named
public class UsermanagementImpl extends AbstractComponentFacade implements Usermanagement {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UsermanagementImpl.class);

  /** @see #getUserDao() */
  private UserDao userDao;

  /**
   * The constructor.
   */
  public UsermanagementImpl() {
    super();
  }

  @Override
  public UserEto findUser(Long id) {

    LOG.debug("Get User with id {} from database.", id);
    return getBeanMapper().map(getUserDao().findOne(id), UserEto.class);
  }

  @Override
  public PaginatedListTo<UserEto> findUserEtos(UserSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<UserEntity> users = getUserDao().findUsers(criteria);
    return mapPaginatedEntityList(users, UserEto.class);
  }

  @Override
  public boolean deleteUser(Long userId) {

    UserEntity user = getUserDao().find(userId);
    getUserDao().delete(user);
    LOG.debug("The user with id '{}' has been deleted.", userId);
    return true;
  }

  @Override
  public UserEto saveUser(UserEto user) {

    Objects.requireNonNull(user, "user");
    UserEntity userEntity = getBeanMapper().map(user, UserEntity.class);

    // initialize, validate userEntity here if necessary
    getUserDao().save(userEntity);
    LOG.debug("User with id '{}' has been created.", userEntity.getId());

    return getBeanMapper().map(userEntity, UserEto.class);
  }

  /**
   * Returns the field 'userDao'.
   * 
   * @return the {@link UserDao} instance.
   */
  public UserDao getUserDao() {

    return this.userDao;
  }

  /**
   * Sets the field 'userDao'.
   * 
   * @param userDao New value for userDao
   */
  @Inject
  public void setUserDao(UserDao userDao) {

    this.userDao = userDao;
  }

}