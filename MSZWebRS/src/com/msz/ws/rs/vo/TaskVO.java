package com.msz.ws.rs.vo;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.msz.model.Task;
import com.msz.model.User;

@XmlRootElement(name = "task")
@XmlAccessorType(XmlAccessType.NONE)
public class TaskVO implements Serializable {
	private static final long serialVersionUID = -743312769394804964L;

	@XmlElement
	private Long id;
	@XmlElement
	private String subject;
	@XmlElement
	private String description;
	@XmlElement
	private Date createdAt;
	@XmlElement
	private Date dueDate;
	@XmlElement
	private Long createdBy;
	@XmlElement
	private Long assignedTo;
	@XmlElement
	private String status;

	public static final TaskVO build(Task task) {
		if (task == null)
			return null;

		TaskVO vo = new TaskVO();
		if (task.getAssignedTo() != null)
			vo.assignedTo = task.getAssignedTo().getId();
		vo.createdAt = task.getCreatedAt();
		if (task.getCreatedBy() != null)
			vo.createdBy = task.getCreatedBy().getId();
		vo.description = task.getDescription();
		vo.dueDate = task.getDueDate();
		vo.id = task.getId();
		vo.status = task.getStatus();
		vo.subject = task.getSubject();

		return vo;
	}

	public Task toModel() {
		Task task = new Task();

		if (this.assignedTo != null)
			task.setAssignedTo(new User(this.assignedTo));
		task.setCreatedAt(this.createdAt);
		if (this.createdBy != null)
			task.setCreatedBy(new User(this.createdBy));
		task.setDescription(this.description);
		task.setDueDate(this.dueDate);
		task.setId(this.id);
		task.setStatus(this.status);
		task.setSubject(this.subject);

		return task;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(Long assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}