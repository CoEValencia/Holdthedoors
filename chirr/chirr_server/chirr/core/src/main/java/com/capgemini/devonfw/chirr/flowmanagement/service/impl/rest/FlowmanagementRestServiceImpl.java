package com.capgemini.devonfw.chirr.flowmanagement.service.impl.rest;

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

import com.capgemini.devonfw.chirr.flowmanagement.logic.api.Flowmanagement;
import com.capgemini.devonfw.chirr.flowmanagement.logic.api.to.FlowEto;
import com.capgemini.devonfw.chirr.flowmanagement.logic.api.to.FlowSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service class for REST calls in order to execute the methods in {@link Flowmanagement}.
 *
 */
@Path("/flowmanagement/v1")
@Named("FlowmanagementRestService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class FlowmanagementRestServiceImpl {

  @Inject
  private Flowmanagement flowmanagement;

  /**
   * Delegates to {@link Flowmanagement#findFlow}.
   *
   * @param id the ID of the {@link FlowEto}
   * @return the {@link FlowEto}
   */
  @GET
  @Path("/flow/{id}/")
  public ResponseEntity<FlowEto> getFlow(@PathParam("id") String id) {

    Long idAsLong;
    if (id == null) {
      throw new BadRequestException("missing id");
    }

    FlowEto flowEto = null;

    try {
      idAsLong = Long.parseLong(id);
      flowEto = this.flowmanagement.findFlow(idAsLong);

      if (flowEto == null)
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } catch (NumberFormatException e) {
      throw new BadRequestException("id is not a number");
    }
    return new ResponseEntity<>(flowEto, HttpStatus.OK);
  }

  /**
   * Delegates to {@link Flowmanagement#saveFlow}.
   *
   * @param flow the {@link FlowEto} to be saved
   * @return the recently created {@link FlowEto}
   */
  @POST
  @Path("/flow/")
  public FlowEto saveFlow(FlowEto flow) {

    return this.flowmanagement.saveFlow(flow);
  }

  /**
   * Delegates to {@link Flowmanagement#deleteFlow}.
   *
   * @param id ID of the {@link FlowEto} to be deleted
   */
  @DELETE
  @Path("/flow/{id}/")
  public void deleteFlow(@PathParam("id") String id) {

    Long idAsLong;

    if (id == null) {
      throw new BadRequestException("missing id");
    }
    try {
      idAsLong = Long.parseLong(id);

      if (!this.flowmanagement.deleteFlow(idAsLong))
        throw new NotFoundException("table not found");
    } catch (NumberFormatException e) {
      throw new BadRequestException("id is not a number");
    }
  }

  /**
   * Delegates to {@link Flowmanagement#findFlowEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding flows.
   * @return the {@link PaginatedListTo list} of matching {@link FlowEto}s.
   */
  @Path("/flow/search")
  @POST
  public PaginatedListTo<FlowEto> findFlowsByPost(FlowSearchCriteriaTo searchCriteriaTo) {

    return this.flowmanagement.findFlowEtos(searchCriteriaTo);
  }

}