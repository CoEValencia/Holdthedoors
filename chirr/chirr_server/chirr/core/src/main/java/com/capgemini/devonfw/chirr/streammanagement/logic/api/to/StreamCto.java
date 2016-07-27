package com.capgemini.devonfw.chirr.streammanagement.logic.api.to;

import com.capgemini.devonfw.chirr.general.common.api.to.AbstractCto;

/**
 * Composite transport object of Stream
 */
public class StreamCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private StreamEto stream;

  public StreamEto getStream() {

    return stream;
  }

  public void setStream(StreamEto stream) {

    this.stream = stream;
  }

}
