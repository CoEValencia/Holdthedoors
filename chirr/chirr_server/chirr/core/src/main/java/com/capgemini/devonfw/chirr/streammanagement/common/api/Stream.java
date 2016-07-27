package com.capgemini.devonfw.chirr.streammanagement.common.api;

import com.capgemini.devonfw.chirr.general.common.api.ApplicationEntity;

public interface Stream extends ApplicationEntity {

  public Boolean isPrivated();

  public void setPrivated(Boolean privated);

  public String getName();

  public void setName(String name);

  public Long getUserid();

  public void setUserid(Long userid);

}
