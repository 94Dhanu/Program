package com.bridgelabz.fundoo.note.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestHeader;

import com.bridgelabz.fundoo.note.dto.ColorDto;
import com.bridgelabz.fundoo.note.dto.NoteDto;
import com.bridgelabz.fundoo.note.dto.NoteDto;
import com.bridgelabz.fundoo.note.model.Note;
import com.bridgelabz.fundoo.response.Response;

public interface NoteService {

	public Response createNote(NoteDto notesDto, String token);
	public Response updateNote(NoteDto notesDto, String token, Long noteId);

	public Response delete(String token, Long noteId);
	public Response deletePermanently(String token, Long noteId);
	public List<Note> getAllNotes(String token);
	public List<NoteDto> getAllArchive( String token);
	public Response pinAndUnPin(String token, Long noteId);
	public Response archiveAndUnArchive(String token, Long noteId);
	public Response trashAndUnTrash(String token, Long noteId);
	public Response colourNote(String token, ColorDto colorDto);
	Response addCollabrator(String token, String email, Long noteId);
	public Response removeCollabrator(String token, String email, Long noteId);
	
	
}
