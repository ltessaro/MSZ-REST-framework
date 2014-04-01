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

import com.msz.dao.INoteDAO;
import com.msz.model.Note;
import com.msz.ws.rs.vo.EntityID;
import com.msz.ws.rs.vo.NoteVO;
import com.msz.ws.rs.vo.ResponseVO;

@Path("/note")
public class NoteResource {

	private final static Logger logger = Logger.getLogger(NoteResource.class.getName());

	@Inject
	private INoteDAO dao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{noteID}")
	public Response retrieve(@PathParam("noteID") String noteID) {
		try {
			Note note = dao.findByID(Long.valueOf(noteID));
			return ResponseVO.ok(note).buildResponse();
		} catch (Exception ex){
			logger.severe(ex.getMessage());
		}
		return ResponseVO.error(String.format("Internal server error")).buildResponse();
	}

	@POST
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(NoteVO note) {
		try {
			Note newNote = note.toModel();
			if (newNote.getId() == null) {
				newNote = dao.create(newNote);
				return ResponseVO.ok(newNote).message("Note created successfully").buildResponse();
			} else {
				newNote = dao.update(newNote);
				return ResponseVO.ok(newNote).message("Note updated successfully").buildResponse();
			}
		} catch (Exception ex) {
			logger.severe(ex.getMessage());			
		}
		return ResponseVO.error("Internal server error! :/").buildResponse();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{noteID}")
	public Response delete(@PathParam("noteID") String noteID) {
		try {
			Note note = dao.findByID(Long.valueOf(noteID));
			dao.delete(note);
			return ResponseVO.ok(new EntityID(note.getId())).message("Note deleted successfully").buildResponse();
		} catch (Exception ex){
			logger.severe(ex.getMessage());
		}
		return ResponseVO.error(String.format("Internal server error")).buildResponse();
	}
}
