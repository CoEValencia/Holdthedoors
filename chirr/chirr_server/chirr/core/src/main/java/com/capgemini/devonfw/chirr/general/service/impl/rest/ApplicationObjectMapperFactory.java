package com.capgemini.devonfw.chirr.general.service.impl.rest;

import javax.inject.Named;

import io.oasp.module.rest.service.impl.json.ObjectMapperFactory;

/**
 * The MappingFactory class to resolve polymorphic conflicts within the chirr application.
 *
 * @author agreul
 */
@Named("ApplicationObjectMapperFactory")
public class ApplicationObjectMapperFactory extends ObjectMapperFactory {

  /**
   * The constructor.
   */
  public ApplicationObjectMapperFactory() {

    super();
    // register polymorphic base classes

    // NamedType[] subtypes;
    // register mapping for polymorphic sub-classes

  }
}
