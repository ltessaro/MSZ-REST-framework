package com.msz.ws.rs;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.msz.dao.IUserDAO;
import com.msz.model.User;
import com.msz.ws.rs.vo.EntityID;
import com.msz.ws.rs.vo.ResponseVO;
import com.msz.ws.rs.vo.UserVO;

@Path("/user")
public class UserResource {

	private final static Logger logger = Logger.getLogger(UserResource.class.getName());

	@Inject
	private IUserDAO dao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{userID}")
	public Response retrieve(@PathParam("userID") String userID) {
		try {
			User user = dao.findByID(Long.valueOf(userID));
			return ResponseVO.ok(user).buildResponse();
		} catch (Exception ex){
			logger.severe(ex.getMessage());
		}
		return ResponseVO.error(String.format("Internal server error")).buildResponse();
	}

	@POST
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(UserVO user) {
		try {
			User newUser = user.toModel();
			if (newUser.getId() == null) {
				newUser = dao.create(newUser);
				return ResponseVO.ok(newUser).message("User created successfully").buildResponse();
			} else {
				newUser = dao.update(newUser);
				return ResponseVO.ok(newUser).message("User updated successfully").buildResponse();
			}
		} catch (Exception ex) {
			logger.severe(ex.getMessage());			
		}
		return ResponseVO.error("Internal server error! :/").buildResponse();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{userID}")
	public Response delete(@PathParam("userID") String userID) {
		try {
			User user = dao.findByID(Long.valueOf(userID));
			dao.delete(user);
			return ResponseVO.ok(new EntityID(user.getId())).message("User deleted successfully").buildResponse();
		} catch (Exception ex){
			logger.severe(ex.getMessage());
		}
		return ResponseVO.error(String.format("Internal server error")).buildResponse();
	}
}
