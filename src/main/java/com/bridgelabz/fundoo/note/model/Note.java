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
	
	@Column(name="isTrash")
	private boolean isTrash;
	
	@Column(name = "isPined")
	private boolean isPined;
	
	@Column(name = "isArchived")
	private boolean isArchived;
	
	@Column(name="colour")
	private String colour;
	
	
	@Column(name = "image")
	private String image;
	
	@Column(name="created")
	private LocalDateTime created ;
	
	@Column(name="modified")
	private LocalDateTime modified;
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Label> listLabel;
	public Long getNoteId() {
		return noteId;
	}
	public void setNoteId(Long noteId) {
		this.noteId = noteId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isTrash() {
		return isTrash;
	}
	public void setTrash(boolean isTrash) {
		this.isTrash = isTrash;
	}
	public boolean isPined() {
		return isPined;
	}
	public void setPined(boolean isPined) {
		this.isPined = isPined;
	}
	public boolean isArchived() {
		return isArchived;
	}
	public void setArchived(boolean isArchived) {
		this.isArchived = isArchived;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	public LocalDateTime getModified() {
		return modified;
	}
	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}
	public List<Label> getListLabel() {
		return listLabel;
	}
	public void setListLabel(List<Label> listLabel) {
		this.listLabel = listLabel;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
}
	

