package com.capgemini.devonfw.chirr.flowmanagement.logic.api.to;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link com.capgemini.devonfw.chirr.flowmanagement.common.api.Flow}s.
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlowSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String name;

  private Long streamid;

  private Long userid;

  /**
   * The constructor.
   */
  public FlowSearchCriteriaTo() {

    super();
  }

  public String getName() {

    return this.name;
  }

  public void setName(String name) {

    this.name = name;
  }

  public Long getStreamid() {

    return this.streamid;
  }

  public void setStreamid(Long streamid) {

    this.streamid = streamid;
  }

  public Long getUserid() {

    return this.userid;
  }

  public void setUserid(Long userid) {

    this.userid = userid;
  }

}
