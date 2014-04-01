package com.msz.ws.rs.vo;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.msz.model.Note;
import com.msz.model.Task;
import com.msz.model.User;

@XmlRootElement(name = "note")
@XmlAccessorType(XmlAccessType.NONE)
public class NoteVO implements Serializable {
	private static final long serialVersionUID = 8868599522093392422L;

	@XmlElement
	private Long id;
	@XmlElement
	private String note;
	@XmlElement
	private Date createdAt;
	@XmlElement
	private Long createdBy;
	@XmlElement
	private Long taskID;

	public static final NoteVO build(Note note) {
		if (note == null)
			return null;

		NoteVO vo = new NoteVO();
		vo.id = note.getId();
		vo.createdAt = note.getCreatedAt();
		if (note.getCreatedBy() != null)
			vo.createdBy = note.getCreatedBy().getId();
		vo.note = note.getNote();
		if (note.getTask() != null)
			vo.taskID = note.getTask().getId();
		return vo;
	}

	public Note toModel() {
		Note note = new Note();

		note.setCreatedAt(this.createdAt);
		if (this.createdBy != null)
			note.setCreatedBy(new User(this.createdBy));
		note.setId(this.id);
		note.setNote(this.note);
		if (this.taskID != null)
			note.setTask(new Task(this.taskID));

		return note;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getTaskID() {
		return taskID;
	}

	public void setTaskID(Long taskID) {
		this.taskID = taskID;
	}

}