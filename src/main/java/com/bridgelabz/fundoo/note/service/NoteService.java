package com.bridgelabz.fundoo.note.service;

import java.util.List;

import com.bridgelabz.fundoo.note.dto.NoteDto;
import com.bridgelabz.fundoo.note.dto.NoteDto;
import com.bridgelabz.fundoo.note.model.Note;
import com.bridgelabz.fundoo.response.Response;

public interface NoteService {

	public Response createNote(NoteDto notesDto, String token);
	public Response updateNote(NoteDto notesDto, String token, Long noteId);

	public Response delete(String token, Long noteId);

	public List<Note> getAllNotes(String token);
}
