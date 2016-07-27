package com.capgemini.devonfw.chirr.streammanagement.logic.base.usecase;

import javax.inject.Inject;

import com.capgemini.devonfw.chirr.general.logic.base.AbstractUc;
import com.capgemini.devonfw.chirr.streammanagement.dataaccess.api.dao.StreamDao;

/**
 * Abstract use case for Streams, which provides access to the commonly necessary data access objects.
 */
public class AbstractStreamUc extends AbstractUc {

  /** @see #getStreamDao() */
  @Inject
  private StreamDao streamDao;

  /**
   * Returns the field 'streamDao'.
   * 
   * @return the {@link StreamDao} instance.
   */
  public StreamDao getStreamDao() {

    return this.streamDao;
  }

}
