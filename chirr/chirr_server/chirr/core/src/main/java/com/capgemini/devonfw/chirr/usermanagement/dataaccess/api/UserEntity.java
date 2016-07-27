package com.capgemini.devonfw.chirr.usermanagement.dataaccess.api;

import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.capgemini.devonfw.chirr.general.dataaccess.api.ApplicationPersistenceEntity;
import com.capgemini.devonfw.chirr.usermanagement.common.api.User;

/**
 * TODO jhcore This type ...
 *
 * @author jhcore
 * @since 0.1
 */
@Entity
@Table(name = "USER")
@Named
public class UserEntity extends ApplicationPersistenceEntity implements User {

  @Column(name = "name")
  private String name;

  @Column(name = "lastname")
  private String lastname;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  private static final long serialVersionUID = 1L;

  /**
   * @return name
   */
  @Override
  public String getName() {

    return this.name;
  }

  /**
   * @param name new value of {@link #getname}.
   */
  @Override
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return lastname
   */
  @Override
  public String getLastname() {

    return this.lastname;
  }

  /**
   * @param lastname new value of {@link #getlastname}.
   */
  @Override
  public void setLastname(String lastname) {

    this.lastname = lastname;
  }

  /**
   * @return username
   */
  @Override
  public String getUsername() {

    return this.username;
  }

  /**
   * @param username new value of {@link #getusername}.
   */
  @Override
  public void setUsername(String username) {

    this.username = username;
  }

  /**
   * @return password
   */
  @Override
  public String getPassword() {

    return this.password;
  }

  /**
   * @param password new value of {@link #getpassword}.
   */
  @Override
  public void setPassword(String password) {

    this.password = password;
  }

  /**
   * @return serialversionuid
   */
  public static long getSerialversionuid() {

    return serialVersionUID;
  }

}
