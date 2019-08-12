package com.bridgelabz.fundoo.note.dto;

import lombok.Data;

@Data
public class ColorDto {
	private long noteId;
	private String color;
	public String getColor() {
		// TODO Auto-generated method stub
		return color;
	}
	public long getNoteId() {
		// TODO Auto-generated method stub
		return noteId;
	}

}
