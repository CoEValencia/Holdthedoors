package com.capgemini.devonfw.chirr.usermanagement.logic.api.to;

import com.capgemini.devonfw.chirr.general.common.api.to.AbstractEto;
import com.capgemini.devonfw.chirr.usermanagement.common.api.User;

/**
 * Entity transport object of User
 */
public class UserEto extends AbstractEto implements User {

  private static final long serialVersionUID = 1L;

  private String name;

  private String lastname;

  private String username;

  private String password;

  @Override
  public String getName() {

    return name;
  }

  @Override
  public void setName(String name) {

    this.name = name;
  }

  @Override
  public String getLastname() {

    return lastname;
  }

  @Override
  public void setLastname(String lastname) {

    this.lastname = lastname;
  }

  @Override
  public String getUsername() {

    return username;
  }

  @Override
  public void setUsername(String username) {

    this.username = username;
  }

  @Override
  public String getPassword() {

    return password;
  }

  @Override
  public void setPassword(String password) {

    this.password = password;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
    result = prime * result + ((this.lastname == null) ? 0 : this.lastname.hashCode());
    result = prime * result + ((this.username == null) ? 0 : this.username.hashCode());
    result = prime * result + ((this.password == null) ? 0 : this.password.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    // class check will be done by super type EntityTo!
    if (!super.equals(obj)) {
      return false;
    }
    UserEto other = (UserEto) obj;
    if (this.name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!this.name.equals(other.name)) {
      return false;
    }
    if (this.lastname == null) {
      if (other.lastname != null) {
        return false;
      }
    } else if (!this.lastname.equals(other.lastname)) {
      return false;
    }
    if (this.username == null) {
      if (other.username != null) {
        return false;
      }
    } else if (!this.username.equals(other.username)) {
      return false;
    }
    if (this.password == null) {
      if (other.password != null) {
        return false;
      }
    } else if (!this.password.equals(other.password)) {
      return false;
    }
    return true;
  }
}
