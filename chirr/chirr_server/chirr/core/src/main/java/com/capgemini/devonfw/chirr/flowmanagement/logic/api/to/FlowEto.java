package com.capgemini.devonfw.chirr.flowmanagement.logic.api.to;

import com.capgemini.devonfw.chirr.flowmanagement.common.api.Flow;
import com.capgemini.devonfw.chirr.general.common.api.to.AbstractEto;

/**
 * Entity transport object of Flow
 */
public class FlowEto extends AbstractEto implements Flow {

  private static final long serialVersionUID = 1L;

  private String name;

  private Long streamid;

  private Long userid;

  @Override
  public String getName() {

    return name;
  }

  @Override
  public void setName(String name) {

    this.name = name;
  }

  @Override
  public Long getStreamid() {

    return streamid;
  }

  @Override
  public void setStreamid(Long streamid) {

    this.streamid = streamid;
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
    result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
    result = prime * result + ((this.streamid == null) ? 0 : this.streamid.hashCode());
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
    FlowEto other = (FlowEto) obj;
    if (this.name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!this.name.equals(other.name)) {
      return false;
    }
    if (this.streamid == null) {
      if (other.streamid != null) {
        return false;
      }
    } else if (!this.streamid.equals(other.streamid)) {
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
