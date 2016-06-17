package com.capgemini.devon.chirr.usermanagement.dataaccess.api;

import org.joda.time.LocalDateTime;

import com.capgemini.devon.chirr.general.dataaccess.api.ApplicationPersistenceEntity;
import com.capgemini.devon.chirr.usermanagement.common.api.User;

/**
 * TODO esoriafa This type ...
 *
 * @author esoriafa
 */

public class UserEntity extends ApplicationPersistenceEntity implements User {

  private Long id;

  private String name;

  private String surname;

  private String email;

  private String password;

  private String username;

  private Long photo;

  private LocalDateTime lastLogging;

  private static final long serialVersionUID = 1L;

  /**
   * @return id
   */
  @Override
  public Long getId() {

    return this.id;
  }

  /**
   * @param id the id to set
   */
  @Override
  public void setId(Long id) {

    this.id = id;
  }

  /**
   * @return name
   */
  public String getName() {

    return this.name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return surname
   */
  public String getSurname() {

    return this.surname;
  }

  /**
   * @param surname the surname to set
   */
  public void setSurname(String surname) {

    this.surname = surname;
  }

  /**
   * @return email
   */
  public String getEmail() {

    return this.email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {

    this.email = email;
  }

  /**
   * @return password
   */
  public String getPassword() {

    return this.password;
  }

  /**
   * @param password the password to set
   */
  public void setPassword(String password) {

    this.password = password;
  }

  /**
   * @return username
   */
  public String getUsername() {

    return this.username;
  }

  /**
   * @param username the username to set
   */
  public void setUsername(String username) {

    this.username = username;
  }

  /**
   * @return photo
   */
  public Long getPhoto() {

    return this.photo;
  }

  /**
   * @param photo the photo to set
   */
  public void setPhoto(Long photo) {

    this.photo = photo;
  }

  /**
   * @return lastLogging
   */
  public LocalDateTime getLastLogging() {

    return this.lastLogging;
  }

  /**
   * @param lastLogging the lastLogging to set
   */
  public void setLastLogging(LocalDateTime lastLogging) {

    this.lastLogging = lastLogging;
  }

  /**
   * @return serialversionuid
   */
  public static long getSerialversionuid() {

    return serialVersionUID;
  }

}
