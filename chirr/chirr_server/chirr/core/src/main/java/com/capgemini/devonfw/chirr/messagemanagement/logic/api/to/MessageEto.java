package com.capgemini.devonfw.chirr.messagemanagement.logic.api.to;

import com.capgemini.devonfw.chirr.general.common.api.to.AbstractEto;
import com.capgemini.devonfw.chirr.messagemanagement.common.api.Message;

/**
 * Entity transport object of Message
 */
public class MessageEto extends AbstractEto implements Message {

  private static final long serialVersionUID = 1L;

  private String content;

  private Long flowid;

  private Long userid;

  @Override
  public String getContent() {

    return content;
  }

  @Override
  public void setContent(String content) {

    this.content = content;
  }

  @Override
  public Long getFlowid() {

    return flowid;
  }

  @Override
  public void setFlowid(Long flowid) {

    this.flowid = flowid;
  }

  @Override
  public Long getUserid() {

    return userid;
  }

  @Override
  public void setUserid(Long userid) {

    this.userid = userid;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.content == null) ? 0 : this.content.hashCode());
    result = prime * result + ((this.flowid == null) ? 0 : this.flowid.hashCode());
    result = prime * result + ((this.userid == null) ? 0 : this.userid.hashCode());
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
    MessageEto other = (MessageEto) obj;
    if (this.content == null) {
      if (other.content != null) {
        return false;
      }
    } else if (!this.content.equals(other.content)) {
      return false;
    }
    if (this.flowid == null) {
      if (other.flowid != null) {
        return false;
      }
    } else if (!this.flowid.equals(other.flowid)) {
      return false;
    }
    if (this.userid == null) {
      if (other.userid != null) {
        return false;
      }
    } else if (!this.userid.equals(other.userid)) {
      return false;
    }
    return true;
  }
}
