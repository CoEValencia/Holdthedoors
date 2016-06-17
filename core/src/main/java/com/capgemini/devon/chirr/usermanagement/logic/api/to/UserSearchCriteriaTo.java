package com.capgemini.devon.chirr.usermanagement.logic.api.to;

import org.joda.time.LocalDateTime;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link com.capgemini.devon.chirr.usermanagement.common.api.User}s.
 *
 */
public class UserSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private Long id;

  private String name;

  private String surname;

  private String email;

  private String password;

  private String username;

  private Long photo;

  private LocalDateTime lastLogging;

  /**
   * The constructor.
   */
  public UserSearchCriteriaTo() {

    super();
  }

  public Long getId() {

    return id;
  }

  public void setId(Long id) {

    this.id = id;
  }

  public String getName() {

    return name;
  }

  public void setName(String name) {

    this.name = name;
  }

  public String getSurname() {

    return surname;
  }

  public void setSurname(String surname) {

    this.surname = surname;
  }

  public String getEmail() {

    return email;
  }

  public void setEmail(String email) {

    this.email = email;
  }

  public String getPassword() {

    return password;
  }

  public void setPassword(String password) {

    this.password = password;
  }

  public String getUsername() {

    return username;
  }

  public void setUsername(String username) {

    this.username = username;
  }

  public Long getPhoto() {

    return photo;
  }

  public void setPhoto(Long photo) {

    this.photo = photo;
  }

  public LocalDateTime getLastLogging() {

    return lastLogging;
  }

  public void setLastLogging(LocalDateTime lastLogging) {

    this.lastLogging = lastLogging;
  }

}
