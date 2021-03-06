package com.capgemini.devonfw.chirr.usermanagement.logic.api.to;

import com.capgemini.devonfw.chirr.general.common.api.to.AbstractCto;

/**
 * Composite transport object of User
 */
public class UserCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private UserEto user;

  public UserEto getUser() {

    return user;
  }

  public void setUser(UserEto user) {

    this.user = user;
  }

}
