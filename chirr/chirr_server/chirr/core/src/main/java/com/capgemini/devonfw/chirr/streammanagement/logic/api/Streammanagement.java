package com.capgemini.devonfw.chirr.streammanagement.logic.api;

import java.util.List;

import com.capgemini.devonfw.chirr.streammanagement.logic.api.to.StreamEto;
import com.capgemini.devonfw.chirr.streammanagement.logic.api.usecase.UcFindStream;
import com.capgemini.devonfw.chirr.streammanagement.logic.api.usecase.UcManageStream;

/**
 * Interface for Streammanagement component.
 */
public interface Streammanagement extends UcFindStream, UcManageStream {

  /**
   * @return List of all Streams
   */
  List<StreamEto> findAllCatalogos();
}
