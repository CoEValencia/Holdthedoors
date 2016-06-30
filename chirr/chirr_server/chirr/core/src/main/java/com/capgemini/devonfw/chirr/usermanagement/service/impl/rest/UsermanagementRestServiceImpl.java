package com.capgemini.devonfw.chirr.usermanagement.service.impl.rest;

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

import com.capgemini.devonfw.chirr.usermanagement.logic.api.Usermanagement;
import com.capgemini.devonfw.chirr.usermanagement.logic.api.to.UserEto;
import com.capgemini.devonfw.chirr.usermanagement.logic.api.to.UserSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service class for REST calls in order to execute the methods in {@link Usermanagement}.
 *
 */
@Path("/usermanagement/v1")
@Named("UsermanagementRestService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class UsermanagementRestServiceImpl {

  @Inject
  private Usermanagement usermanagement;

  /**
   * Delegates to {@link Usermanagement#findUser}.
   *
   * @param id the ID of the {@link UserEto}
   * @return the {@link UserEto}
   */
  @GET
  @Path("/user/{id}/")
  public ResponseEntity<UserEto> getUser(@PathParam("id") String id) {

    Long idAsLong;
    if (id == null) {
      throw new BadRequestException("missing id");
    }

    UserEto userEto = null;

    try {
      idAsLong = Long.parseLong(id);
      userEto = this.usermanagement.findUser(idAsLong);

      if (userEto == null)
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } catch (NumberFormatException e) {
      throw new BadRequestException("id is not a number");
    }
    return new ResponseEntity<>(userEto, HttpStatus.OK);
  }

  /**
   * Delegates to {@link Usermanagement#saveUser}.
   *
   * @param user the {@link UserEto} to be saved
   * @return the recently created {@link UserEto}
   */
  @POST
  @Path("/user/")
  public UserEto saveUser(UserEto user) {

    return this.usermanagement.saveUser(user);
  }

  /**
   * Delegates to {@link Usermanagement#deleteUser}.
   *
   * @param id ID of the {@link UserEto} to be deleted
   */
  @DELETE
  @Path("/user/{id}/")
  public void deleteUser(@PathParam("id") String id) {

    Long idAsLong;

    if (id == null) {
      throw new BadRequestException("missing id");
    }
    try {
      idAsLong = Long.parseLong(id);

      if (!this.usermanagement.deleteUser(idAsLong))
        throw new NotFoundException("table not found");
    } catch (NumberFormatException e) {
      throw new BadRequestException("id is not a number");
    }
  }

  /**
   * Delegates to {@link Usermanagement#findUserEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding users.
   * @return the {@link PaginatedListTo list} of matching {@link UserEto}s.
   */
  @Path("/user/search")
  @POST
  public PaginatedListTo<UserEto> findUsersByPost(UserSearchCriteriaTo searchCriteriaTo) {

    return this.usermanagement.findUserEtos(searchCriteriaTo);
  }

  @Path("/users")
  @GET
  public List<UserEto> findUsers() {

    return this.usermanagement.findUserEtos(new UserSearchCriteriaTo()).getResult();
  }

}