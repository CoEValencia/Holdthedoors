package com.capgemini.devonfw.chirr.usermanagement.logic.impl;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.capgemini.devonfw.chirr.general.common.api.UserProfile;
import com.capgemini.devonfw.chirr.general.common.api.datatype.Role;
import com.capgemini.devonfw.chirr.general.common.api.to.UserDetailsClientTo;
import com.capgemini.devonfw.chirr.general.logic.base.AbstractComponentFacade;
import com.capgemini.devonfw.chirr.usermanagement.dataaccess.api.UserEntity;
import com.capgemini.devonfw.chirr.usermanagement.dataaccess.api.dao.UserDao;
import com.capgemini.devonfw.chirr.usermanagement.logic.api.Usermanagement;
import com.capgemini.devonfw.chirr.usermanagement.logic.api.to.UserEto;
import com.capgemini.devonfw.chirr.usermanagement.logic.api.to.UserSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Implementation of component interface of usermanagement
 */
@Named
public class UsermanagementImpl extends AbstractComponentFacade
    implements Usermanagement, com.capgemini.devonfw.chirr.general.common.api.Usermanagement {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UsermanagementImpl.class);

  /** @see #getUserDao() */
  @Inject
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
   * {@inheritDoc}
   */
  @Override
  public UserProfile findUserProfileByLogin(String login, String password) {

    UserSearchCriteriaTo criteria = new UserSearchCriteriaTo();
    criteria.setUsername(login);

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    List<UserEntity> users = getUserDao().findUsers(criteria).getResult();

    if (users.size() <= 0) {
      UsernameNotFoundException exception = new UsernameNotFoundException("Authentication failed.");
      LOG.warn("Failed to get user {}.", login, exception);
      throw exception;
    } else if (!users.get(0).getPassword().equals(password)) {
      UsernameNotFoundException exception = new UsernameNotFoundException("Authentication failed.");
      LOG.warn("Bad password to the user {}.", login, exception);
      throw exception;
    } else {
      UserEntity user = users.get(0);
      UserDetailsClientTo profile = new UserDetailsClientTo();
      profile.setName(user.getUsername());
      profile.setFirstName(user.getName());
      profile.setLastName(user.getLastname());
      profile.setRole(Role.CHIEF);
      return profile;
    }

  }

}