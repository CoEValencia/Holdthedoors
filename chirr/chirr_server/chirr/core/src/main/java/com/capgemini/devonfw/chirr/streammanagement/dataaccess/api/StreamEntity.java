package com.capgemini.devonfw.chirr.streammanagement.dataaccess.api;

import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.capgemini.devonfw.chirr.general.dataaccess.api.ApplicationPersistenceEntity;
import com.capgemini.devonfw.chirr.streammanagement.common.api.Stream;

/**
 * TODO jhcore This type ...
 *
 * @author jhcore
 */
@Entity
@Table(name = "STREAM")
@Named
public class StreamEntity extends ApplicationPersistenceEntity implements Stream {

  private static final long serialVersionUID = 1L;

  @Column(name = "privated")
  private Boolean privated;

  @Column(name = "name")
  private String name;

  @Column(name = "userid")
  private Long userid;

  /**
   * @return name
   */
  public String getName() {

    return this.name;
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

  /**
   * @return privated
   */
  public Boolean isPrivated() {

    return this.privated;
  }

  /**
   * @param privated the privated to set
   */
  public void setPrivated(Boolean privated) {

    this.privated = privated;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {

    this.name = name;
  }

}
