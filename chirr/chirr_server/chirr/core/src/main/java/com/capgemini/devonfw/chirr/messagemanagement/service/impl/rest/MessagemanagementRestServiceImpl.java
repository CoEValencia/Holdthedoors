package com.capgemini.devonfw.chirr.messagemanagement.service.impl.rest;

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

import com.capgemini.devonfw.chirr.messagemanagement.logic.api.Messagemanagement;
import com.capgemini.devonfw.chirr.messagemanagement.logic.api.to.MessageEto;
import com.capgemini.devonfw.chirr.messagemanagement.logic.api.to.MessageSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service class for REST calls in order to execute the methods in {@link Messagemanagement}.
 *
 */
@Path("/messagemanagement/v1")
@Named("MessagemanagementRestService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class MessagemanagementRestServiceImpl {

  @Inject
  private Messagemanagement messagemanagement;

  /**
   * Delegates to {@link Messagemanagement#findMessage}.
   *
   * @param id the ID of the {@link MessageEto}
   * @return the {@link MessageEto}
   */
  @GET
  @Path("/message/{id}/")
  public ResponseEntity<MessageEto> getMessage(@PathParam("id") String id) {

    Long idAsLong;
    if (id == null) {
      throw new BadRequestException("missing id");
    }

    MessageEto messageEto = null;

    try {
      idAsLong = Long.parseLong(id);
      messageEto = this.messagemanagement.findMessage(idAsLong);

      if (messageEto == null)
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } catch (NumberFormatException e) {
      throw new BadRequestException("id is not a number");
    }
    return new ResponseEntity<>(messageEto, HttpStatus.OK);
  }

  /**
   * Delegates to {@link Messagemanagement#saveMessage}.
   *
   * @param message the {@link MessageEto} to be saved
   * @return the recently created {@link MessageEto}
   */
  @POST
  @Path("/message/")
  public MessageEto saveMessage(MessageEto message) {

    return this.messagemanagement.saveMessage(message);
  }

  /**
   * Delegates to {@link Messagemanagement#deleteMessage}.
   *
   * @param id ID of the {@link MessageEto} to be deleted
   */
  @DELETE
  @Path("/message/{id}/")
  public void deleteMessage(@PathParam("id") String id) {

    Long idAsLong;

    if (id == null) {
      throw new BadRequestException("missing id");
    }
    try {
      idAsLong = Long.parseLong(id);

      if (!this.messagemanagement.deleteMessage(idAsLong))
        throw new NotFoundException("table not found");
    } catch (NumberFormatException e) {
      throw new BadRequestException("id is not a number");
    }
  }

  /**
   * Delegates to {@link Messagemanagement#findMessageEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding messages.
   * @return the {@link PaginatedListTo list} of matching {@link MessageEto}s.
   */
  @Path("/message/search")
  @POST
  public PaginatedListTo<MessageEto> findMessagesByPost(MessageSearchCriteriaTo searchCriteriaTo) {

    return this.messagemanagement.findMessageEtos(searchCriteriaTo);
  }

}