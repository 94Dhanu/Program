package com.bridgelabz.fundoo.note.model;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.bridgelabz.fundoo.user.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import aj.org.objectweb.asm.Label;
import lombok.Data;
@Data
@Entity
@Table
public class Note implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "noteId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long noteId;
	
	@Column(name = "userId")
	private Long userId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name="created")
	private LocalDateTime created ;
	
	
	
	public void setNoteId(Long noteId) {
		this.noteId = noteId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	public void setModified(LocalDateTime now) {
		// TODO Auto-generated method stub
		
	}


	
}
	

