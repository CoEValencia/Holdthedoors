package com.capgemini.devonfw.chirr.flowmanagement.dataaccess.api;

import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.capgemini.devonfw.chirr.flowmanagement.common.api.Flow;
import com.capgemini.devonfw.chirr.general.dataaccess.api.ApplicationPersistenceEntity;

/**
 * TODO jhcore This type ...
 *
 * @author jhcore
 */
@Entity
@Table(name = "FLOW")
@Named
public class FlowEntity extends ApplicationPersistenceEntity implements Flow {
  @Column(name = "name")
  private String name;

  @Column(name = "streamid")
  private Long streamid;

  @Column(name = "userid")
  private Long userid;

  private static final long serialVersionUID = 1L;

  /**
   * @return name
   */
  public String getName() {

    return this.name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return streamid
   */
  public Long getStreamid() {

    return this.streamid;
  }

  /**
   * @param streamid the streamid to set
   */
  public void setStreamid(Long streamid) {

    this.streamid = streamid;
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
