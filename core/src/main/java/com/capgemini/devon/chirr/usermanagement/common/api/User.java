package com.capgemini.devon.chirr.usermanagement.common.api;

import org.joda.time.LocalDateTime;

import com.capgemini.devon.chirr.general.common.api.ApplicationEntity;

public interface User extends ApplicationEntity {

  public Long getId();

  public void setId(Long id);

  public String getName();

  public void setName(String name);

  public String getSurname();

  public void setSurname(String surname);

  public String getEmail();

  public void setEmail(String email);

  public String getPassword();

  public void setPassword(String password);

  public String getUsername();

  public void setUsername(String username);

  public Long getPhoto();

  public void setPhoto(Long photo);

  public LocalDateTime getLastLogging();

  public void setLastLogging(LocalDateTime lastLogging);

}
