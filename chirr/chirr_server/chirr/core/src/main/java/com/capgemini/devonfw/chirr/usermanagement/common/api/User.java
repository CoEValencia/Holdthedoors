package com.capgemini.devonfw.chirr.usermanagement.common.api;

import com.capgemini.devonfw.chirr.general.common.api.ApplicationEntity;

public interface User extends ApplicationEntity {

  public String getName();

  public void setName(String name);

  public String getLastname();

  public void setLastname(String lastname);

  public String getUsername();

  public void setUsername(String username);

  public String getPassword();

  public void setPassword(String password);

}
