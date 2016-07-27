package com.capgemini.devonfw.chirr.streammanagement.logic.api.to;

import com.capgemini.devonfw.chirr.general.common.api.to.AbstractEto;
import com.capgemini.devonfw.chirr.streammanagement.common.api.Stream;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Entity transport object of Stream
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StreamEto extends AbstractEto implements Stream {

  private static final long serialVersionUID = 1L;

  private Boolean privated;

  private String name;

  private Long userid;

  @Override
  public Boolean isPrivated() {

    return this.privated;
  }

  @Override
  public void setPrivated(Boolean privated) {

    this.privated = privated;
  }

  @Override
  public String getName() {

    return this.name;
  }

  @Override
  public void setName(String name) {

    this.name = name;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + this.privated.hashCode();
    result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
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
    StreamEto other = (StreamEto) obj;
    if (this.privated != other.privated) {
      return false;
    }
    if (this.name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!this.name.equals(other.name)) {
      return false;
    }
    return true;
  }

  @Override
  public Long getUserid() {

    return this.userid;
  }

  @Override
  public void setUserid(Long userid) {

    this.userid = userid;
  }

}
