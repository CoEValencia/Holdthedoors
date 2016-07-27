package com.capgemini.devonfw.chirr.streammanagement.logic.api.to;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link com.capgemini.devonfw.chirr.streammanagement.common.api.Stream}s.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StreamSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private Boolean privated;

  private String name;

  private Long userid;

  /**
   * The constructor.
   */
  public StreamSearchCriteriaTo() {

    super();
  }

  public Boolean isPrivated() {

    return this.privated;
  }

  public void setPrivated(Boolean privated) {

    this.privated = privated;
  }

  public String getName() {

    return this.name;
  }

  public void setName(String name) {

    this.name = name;
  }

  public Long getUserid() {

    return this.userid;
  }

  public void setUserid(Long userid) {

    this.userid = userid;
  }

}
