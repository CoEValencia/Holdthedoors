package com.capgemini.devon.chirr.usermanagement.dataaccess.impl.dao;

import javax.inject.Named;

import org.joda.time.LocalDateTime;

import com.capgemini.devon.chirr.general.dataaccess.base.dao.ApplicationDaoImpl;
import com.capgemini.devon.chirr.usermanagement.dataaccess.api.UserEntity;
import com.capgemini.devon.chirr.usermanagement.dataaccess.api.dao.UserDao;
import com.capgemini.devon.chirr.usermanagement.logic.api.to.UserSearchCriteriaTo;
import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link UserDao}.
 */
@Named
public class UserDaoImpl extends ApplicationDaoImpl<UserEntity> implements UserDao {

  /**
   * The constructor.
   */
  public UserDaoImpl() {

    super();
  }

  @Override
  public Class<UserEntity> getEntityClass() {

    return UserEntity.class;
  }

  @Override
  public PaginatedListTo<UserEntity> findUsers(UserSearchCriteriaTo criteria) {

    UserEntity user = Alias.alias(UserEntity.class);
    EntityPathBase<UserEntity> alias = Alias.$(user);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    Long id = criteria.getId();
    if (id != null) {
      query.where(Alias.$(user.getId()).eq(id));
    }

    String name = criteria.getName();
    if (name != null) {
      query.where(Alias.$(user.getName()).eq(name));
    }

    String surname = criteria.getSurname();
    if (surname != null) {
      query.where(Alias.$(user.getSurname()).eq(surname));
    }

    String email = criteria.getEmail();
    if (email != null) {
      query.where(Alias.$(user.getEmail()).eq(email));
    }

    String password = criteria.getPassword();
    if (password != null) {
      query.where(Alias.$(user.getPassword()).eq(password));
    }

    String username = criteria.getUsername();
    if (username != null) {
      query.where(Alias.$(user.getUsername()).eq(username));
    }

    Long photo = criteria.getPhoto();
    if (photo != null) {
      query.where(Alias.$(user.getPhoto()).eq(photo));
    }

    LocalDateTime lastLogging = criteria.getLastLogging();
    if (lastLogging != null) {
      query.where(Alias.$(user.getLastLogging()).eq(lastLogging));
    }

    return findPaginated(criteria, query, alias);
  }

}