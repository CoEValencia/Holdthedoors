package com.capgemini.devonfw.chirr.messagemanagement.dataaccess.api;

import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.capgemini.devonfw.chirr.general.dataaccess.api.ApplicationPersistenceEntity;
import com.capgemini.devonfw.chirr.messagemanagement.common.api.Message;

/**
 * TODO jhcore This type ...
 *
 * @author jhcore
 */
@Entity
@Table(name = "MESSAGE")
@Named
public class MessageEntity extends ApplicationPersistenceEntity implements Message {
  @Column(name = "content")
  private String content;

  @Column(name = "flowid")
  private Long flowid;

  @Column(name = "userid")
  private Long userid;

  private static final long serialVersionUID = 1L;

  /**
   * @return content
   */
  public String getContent() {

    return this.content;
  }

  /**
   * @param content the content to set
   */
  public void setContent(String content) {

    this.content = content;
  }

  /**
   * @return flowid
   */
  public Long getFlowid() {

    return this.flowid;
  }

  /**
   * @param flowid the flowid to set
   */
  public void setFlowid(Long flowid) {

    this.flowid = flowid;
  }

  /**
   * @return userid
   */
  public Long getUserid() {

    return this.userid;
  }

  /**
   * @param userid the userid to set
   */
  public void setUserid(Long userid) {

    this.userid = userid;
  }

}
