package com.capgemini.devonfw.chirr.messagemanagement.logic.api.to;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link com.capgemini.devonfw.chirr.messagemanagement.common.api.Message}s.
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String content;

  private Long flowid;

  private Long userid;

  /**
   * The constructor.
   */
  public MessageSearchCriteriaTo() {

    super();
  }

  public String getContent() {

    return this.content;
  }

  public void setContent(String content) {

    this.content = content;
  }

  public Long getFlowid() {

    return this.flowid;
  }

  public void setFlowid(Long flowid) {

    this.flowid = flowid;
  }

  public Long getUserid() {

    return this.userid;
  }

  public void setUserid(Long userid) {

    this.userid = userid;
  }

}
