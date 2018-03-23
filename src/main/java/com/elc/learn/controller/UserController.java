/* ***************************************************************************
 * Copyright 2018 Mindstix, Inc.  All rights reserved.
 * -- Mindstix Confidential
 * ***************************************************************************/

package com.elc.learn.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.elc.learn.config.UserService;
import com.elc.learn.exception.AbstractRestHandler;
import com.elc.learn.exception.DataFormatException;
import com.elc.learn.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/*
 * Demonstrates how to set up RESTful API endpoints using Spring MVC
 */

@RestController
@RequestMapping(value = "/example/v2/users")
@Api(tags = { "users" })
public class UserController extends AbstractRestHandler {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = { "application/json" }, produces = { "application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a user resource.", notes = "Returns the URL of the new resource in the Location header.")
    public void create(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
        User created = this.userService.createUser(user);
        response.setHeader("Location", request.getRequestURL().append("/").append(created.getId()).toString());
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = { "application/json" })
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a paginated list of all users.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    public @ResponseBody List<User> getAll(
            @ApiParam(value = "The page number (zero-based)", required = true) @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
            @ApiParam(value = "Tha page size", required = true) @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
            HttpServletRequest request, HttpServletResponse response) {
        return this.userService.getAllUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json" })
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single user.", notes = "You have to provide a valid user ID.")
    public @ResponseBody User getUser(@ApiParam(value = "The ID of the user.", required = true) @PathVariable("id") String id, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        User user = this.userService.getUser(id);
        checkResourceFound(user);
        // TODO: http://goo.gl/6iNAkz
        return user;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = { "application/json"}, produces = { "application/json" })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Update a user resource.", notes = "You have to provide a valid user ID in the URL and in the payload. The ID attribute can not be updated.")
    public void update(@ApiParam(value = "The ID of the existing user resource.", required = true) @PathVariable("id") String id, @RequestBody User user,
            HttpServletRequest request, HttpServletResponse response) {
        checkResourceFound(this.userService.getUser(id));
        if (id != user.getId())
            throw new DataFormatException("ID doesn't match!");
        this.userService.updateUser(user);
    }

    // TODO: @ApiImplicitParams, @ApiResponses
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = { "application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete a user resource.", notes = "You have to provide a valid user ID in the URL. Once deleted the resource can not be recovered.")
    public void delete(@ApiParam(value = "The ID of the existing user resource.", required = true) @PathVariable("id") String id,
            HttpServletRequest request, HttpServletResponse response) {
        checkResourceFound(this.userService.getUser(id));
        this.userService.deleteUser(id);
    }
}
