package com.capgemini.devonfw.chirr.streammanagement.service.impl.rest;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.devonfw.chirr.streammanagement.logic.api.Streammanagement;
import com.capgemini.devonfw.chirr.streammanagement.logic.api.to.StreamEto;
import com.capgemini.devonfw.chirr.streammanagement.logic.api.to.StreamSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service class for REST calls in order to execute the methods in {@link Streammanagement}.
 */
@Path("/streammanagement/v1")
@Named("StreammanagementRestService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class StreammanagementRestServiceImpl {

  @Inject
  private Streammanagement streammanagement;

  /**
   * Delegates to {@link Streammanagement#findStream}.
   *
   * @param id the ID of the {@link StreamEto}
   * @return the {@link StreamEto}
   */
  @GET
  @Path("/stream/{id}/")
  public ResponseEntity<StreamEto> getStream(@PathParam("id") String id) {

    Long idAsLong;
    if (id == null) {
      throw new BadRequestException("missing id");
    }

    StreamEto streamEto = null;

    try {
      idAsLong = Long.parseLong(id);
      streamEto = this.streammanagement.findStream(idAsLong);

      if (streamEto == null)
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } catch (NumberFormatException e) {
      throw new BadRequestException("id is not a number");
    }
    return new ResponseEntity<>(streamEto, HttpStatus.OK);
  }

  /**
   * Delegates to {@link Streammanagement#saveStream}.
   *
   * @param stream the {@link StreamEto} to be saved
   * @return the recently created {@link StreamEto}
   */
  @POST
  @Path("/stream/")
  public StreamEto saveStream(StreamEto stream) {

    return this.streammanagement.saveStream(stream);
  }

  /**
   * Delegates to {@link Streammanagement#deleteStream}.
   *
   * @param id ID of the {@link StreamEto} to be deleted
   */
  @DELETE
  @Path("/stream/{id}/")
  public void deleteStream(@PathParam("id") String id) {

    Long idAsLong;

    if (id == null) {
      throw new BadRequestException("missing id");
    }
    try {
      idAsLong = Long.parseLong(id);

      if (!this.streammanagement.deleteStream(idAsLong))
        throw new NotFoundException("table not found");
    } catch (NumberFormatException e) {
      throw new BadRequestException("id is not a number");
    }
  }

  /**
   * Delegates to {@link Streammanagement#findStreamEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding streams.
   * @return the {@link PaginatedListTo list} of matching {@link StreamEto}s.
   */
  @Path("/stream/search")
  @POST
  public PaginatedListTo<StreamEto> findStreamsByPost(StreamSearchCriteriaTo searchCriteriaTo) {

    return this.streammanagement.findStreamEtos(searchCriteriaTo);
  }

  @GET
  @Path("/stream/")
  public List<StreamEto> getAllStreams() {

    List<StreamEto> allStreams = this.streammanagement.findAllCatalogos();
    return allStreams;
  }

}
