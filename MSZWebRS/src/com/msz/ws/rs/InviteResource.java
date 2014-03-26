package com.msz.ws.rs;

import java.util.logging.Logger;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.msz.dao.InviteDAO;
import com.msz.model.Invite;
import com.msz.ws.rs.vo.ResponseMap;

@ManagedBean
@Path("/invite")
public class InviteResource {

	private final static Logger logger = Logger.getLogger(InviteResource.class.getName());

	@Inject
	private InviteDAO dao;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{inviteID}")
	public Response getInviteByID(@PathParam("inviteID") String inviteID) {
		ResponseMap response = null;
		try {
			logger.fine(String.format("DAO Instance: %s", dao));
			Invite invite = dao.findByID(Long.parseLong(inviteID));
			logger.fine(String.format("It is invite: %s", invite));
			
			if (invite != null){
				response = new ResponseMap();
				response.setData(invite);
				return Response.accepted().entity(response).build();
			}
		} catch (Exception ex){
			ex.printStackTrace();
			logger.severe(ex.getMessage());
		}
		response = new ResponseMap(true, String.format("Invite not found: %s", inviteID));
		return Response.accepted().entity(response).build();
	}
}
