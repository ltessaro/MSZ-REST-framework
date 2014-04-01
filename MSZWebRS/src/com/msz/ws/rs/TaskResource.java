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

import com.msz.dao.ITaskDAO;
import com.msz.model.Task;
import com.msz.ws.rs.vo.EntityID;
import com.msz.ws.rs.vo.ResponseVO;
import com.msz.ws.rs.vo.TaskVO;

@Path("/task")
public class TaskResource {

	private final static Logger logger = Logger.getLogger(TaskResource.class.getName());

	@Inject
	private ITaskDAO dao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{taskID}")
	public Response retrieve(@PathParam("taskID") String taskID) {
		try {
			Task task = dao.findByID(Long.valueOf(taskID));
			return ResponseVO.ok(task).buildResponse();
		} catch (Exception ex){
			logger.severe(ex.getMessage());
		}
		return ResponseVO.error(String.format("Internal server error")).buildResponse();
	}

	@POST
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(TaskVO task) {
		try {
			Task newTask = task.toModel();
			if (newTask.getId() == null) {
				newTask = dao.create(newTask);
				return ResponseVO.ok(newTask).message("Task created successfully").buildResponse();
			} else {
				newTask = dao.update(newTask);
				return ResponseVO.ok(newTask).message("Task updated successfully").buildResponse();
			}
		} catch (Exception ex) {
			logger.severe(ex.getMessage());			
		}
		return ResponseVO.error("Internal server error! :/").buildResponse();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{taskID}")
	public Response delete(@PathParam("taskID") String taskID) {
		try {
			Task task = dao.findByID(Long.valueOf(taskID));
			dao.delete(task);
			return ResponseVO.ok(new EntityID(task.getId())).message("Task deleted successfully").buildResponse();
		} catch (Exception ex){
			logger.severe(ex.getMessage());
		}
		return ResponseVO.error(String.format("Internal server error")).buildResponse();
	}
}
