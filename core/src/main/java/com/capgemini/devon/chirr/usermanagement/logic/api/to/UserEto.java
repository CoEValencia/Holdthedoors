package com.capgemini.devon.chirr.usermanagement.logic.api.to;

import org.joda.time.LocalDateTime;

import com.capgemini.devon.chirr.general.common.api.to.AbstractEto;
import com.capgemini.devon.chirr.usermanagement.common.api.User;

/**
 * Entity transport object of User
 */
public class UserEto extends AbstractEto implements User {

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
   * {@inheritDoc}
   */
  @Override
  public Long getId() {

    return id;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setId(Long id) {

    this.id = id;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getName() {

    return name;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setName(String name) {

    this.name = name;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getSurname() {

    return surname;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setSurname(String surname) {

    this.surname = surname;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getEmail() {

    return email;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setEmail(String email) {

    this.email = email;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getPassword() {

    return password;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setPassword(String password) {

    this.password = password;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getUsername() {

    return username;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setUsername(String username) {

    this.username = username;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Long getPhoto() {

    return photo;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setPhoto(Long photo) {

    this.photo = photo;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public LocalDateTime getLastLogging() {

    return lastLogging;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setLastLogging(LocalDateTime lastLogging) {

    this.lastLogging = lastLogging;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
    result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
    result = prime * result + ((this.surname == null) ? 0 : this.surname.hashCode());
    result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());
    result = prime * result + ((this.password == null) ? 0 : this.password.hashCode());
    result = prime * result + ((this.username == null) ? 0 : this.username.hashCode());
    result = prime * result + ((this.photo == null) ? 0 : this.photo.hashCode());
    result = prime * result + ((this.lastLogging == null) ? 0 : this.lastLogging.hashCode());
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
    if (this.id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!this.id.equals(other.id)) {
      return false;
    }
    if (this.name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!this.name.equals(other.name)) {
      return false;
    }
    if (this.surname == null) {
      if (other.surname != null) {
        return false;
      }
    } else if (!this.surname.equals(other.surname)) {
      return false;
    }
    if (this.email == null) {
      if (other.email != null) {
        return false;
      }
    } else if (!this.email.equals(other.email)) {
      return false;
    }
    if (this.password == null) {
      if (other.password != null) {
        return false;
      }
    } else if (!this.password.equals(other.password)) {
      return false;
    }
    if (this.username == null) {
      if (other.username != null) {
        return false;
      }
    } else if (!this.username.equals(other.username)) {
      return false;
    }
    if (this.photo == null) {
      if (other.photo != null) {
        return false;
      }
    } else if (!this.photo.equals(other.photo)) {
      return false;
    }
    if (this.lastLogging == null) {
      if (other.lastLogging != null) {
        return false;
      }
    } else if (!this.lastLogging.equals(other.lastLogging)) {
      return false;
    }
    return true;
  }
}
