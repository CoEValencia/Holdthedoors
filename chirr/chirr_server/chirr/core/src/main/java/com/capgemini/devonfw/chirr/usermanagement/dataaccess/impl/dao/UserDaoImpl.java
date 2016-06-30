package com.capgemini.devonfw.chirr.usermanagement.dataaccess.impl.dao;

import javax.inject.Named;

import com.capgemini.devonfw.chirr.general.dataaccess.base.dao.ApplicationDaoImpl;
import com.capgemini.devonfw.chirr.usermanagement.dataaccess.api.UserEntity;
import com.capgemini.devonfw.chirr.usermanagement.dataaccess.api.dao.UserDao;
import com.capgemini.devonfw.chirr.usermanagement.logic.api.to.UserSearchCriteriaTo;
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

    String name = criteria.getName();
    if (name != null) {
      query.where(Alias.$(user.getName()).eq(name));
    }
    String lastname = criteria.getLastname();
    if (lastname != null) {
      query.where(Alias.$(user.getLastname()).eq(lastname));
    }
    String username = criteria.getUsername();
    if (username != null) {
      query.where(Alias.$(user.getUsername()).eq(username));
    }
    String password = criteria.getPassword();
    if (password != null) {
      query.where(Alias.$(user.getPassword()).eq(password));
    }
    return findPaginated(criteria, query, alias);
  }

}