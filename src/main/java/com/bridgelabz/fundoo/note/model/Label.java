package com.bridgelabz.fundoo.note.model;


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
import javax.validation.constraints.NotNull;


import lombok.Data;
@Data
@Entity
@Table
public class Label {
	@Id
	@Column(name = "labelId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long labelId;
	
	@NotEmpty(message = "labelName should not be empty")
	@NotNull(message = "labelName should not be null")
	@Column(name = "labelName")
	private String labelName;
	
	@Column(name="createdDate")
	private LocalDateTime createdDate;
	
	@Column(name="modifiedDate")
	private LocalDateTime modifiedDate;
	
	@Column(name="userId")
	private long userId;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Note> notes;
	public void setLabelId(Long labelId) {
		this.labelId = labelId;
	}
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	public List<Label> getNotes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
	
	
	
}
