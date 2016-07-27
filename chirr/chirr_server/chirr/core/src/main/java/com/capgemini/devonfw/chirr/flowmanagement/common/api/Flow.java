package com.capgemini.devonfw.chirr.flowmanagement.common.api;

import com.capgemini.devonfw.chirr.general.common.api.ApplicationEntity;

public interface Flow extends ApplicationEntity {

  public String getName();

  public void setName(String name);

  public Long getStreamid();

  public void setStreamid(Long streamid);

  public Long getUserid();

  public void setUserid(Long userid);

}
