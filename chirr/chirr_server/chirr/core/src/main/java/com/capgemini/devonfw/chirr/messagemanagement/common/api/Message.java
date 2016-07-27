package com.capgemini.devonfw.chirr.messagemanagement.common.api;

import com.capgemini.devonfw.chirr.general.common.api.ApplicationEntity;

public interface Message extends ApplicationEntity {

  public String getContent();

  public void setContent(String content);

  public Long getFlowid();

  public void setFlowid(Long flowid);

  public Long getUserid();

  public void setUserid(Long userid);

}
