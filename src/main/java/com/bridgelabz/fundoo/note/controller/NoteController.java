package com.bridgelabz.fundoo.note.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundoo.note.dto.ColorDto;
import com.bridgelabz.fundoo.note.dto.NoteDto;
import com.bridgelabz.fundoo.note.dto.NoteDto;
import com.bridgelabz.fundoo.note.model.Note;

import com.bridgelabz.fundoo.note.service.NoteService;
import com.bridgelabz.fundoo.response.Response;

@RestController
@RequestMapping("/user/note")
public class NoteController 
{

	Logger logger = LoggerFactory.getLogger(NoteController.class);
	@Autowired
	private NoteService noteService;
	
	
	@PostMapping("/create")
	public ResponseEntity<Response> createNote(@RequestBody  NoteDto  notesDto,@RequestHeader String token){
		logger.info(notesDto.toString());
		Response responseStatus=noteService.createNote(notesDto, token);
		return new ResponseEntity<Response>(responseStatus,HttpStatus.OK);
		
	}
	@PutMapping("/update")
	public ResponseEntity<Response> updatingNote(@RequestBody NoteDto notesDto,@RequestHeader String token,@RequestParam Long noteId){
		//System.out.println("Hi Update note");
		logger.info(notesDto.toString());
		Response responseStatus=noteService.updateNote(notesDto, token, noteId);
		return new ResponseEntity<Response>(responseStatus,HttpStatus.OK);
	}
	@PutMapping("/delete")
	public ResponseEntity<Response>deleteNote(@RequestHeader String token,@RequestParam Long noteId){
		//logger.info(notesDto.toString());

		Response responseStatus=noteService.delete(token, noteId);
		return new ResponseEntity<Response>(responseStatus,HttpStatus.OK);
	}
	@DeleteMapping("/delete")
	public ResponseEntity<Response>deleteNoteFromDisk(@RequestHeader String token,@RequestParam Long noteId){
		//logger.info(notesDto.toString());
		Response responseStatus=noteService.deletePermanently(token, noteId);
		return new ResponseEntity<Response>(responseStatus,HttpStatus.OK);
	}
	@GetMapping("/getAllNotes")
	public List<Note>getAllNotes(@RequestHeader String token)
	{
		List<Note> listNotes=noteService.getAllNotes(token);
		return listNotes;
	}
	@GetMapping("/getAllArchive")
	public List<NoteDto> getAllArchive(@RequestHeader String token){
		List<NoteDto> listNotes=noteService.getAllArchive(token);
		return listNotes;
	}
	@PutMapping("/pin")
	public ResponseEntity<Response>pinAndUnpin(@RequestHeader String token,@RequestParam Long noteId){
		//logger.info(notesDto.toString());
		Response responseStatus=noteService.pinAndUnPin(token, noteId);
		return new ResponseEntity<Response>(responseStatus,HttpStatus.OK);
	}
	@PutMapping(value = "/archive")
	public ResponseEntity<Response>archiveAndUnarchive(@RequestHeader(value = "token")  String token,@RequestParam Long noteId){
		//logger.info(notesDto.toString());
		System.out.println("token-->"+token);
		Response responseStatus=noteService.archiveAndUnArchive(token, noteId);
		return new ResponseEntity<Response>(responseStatus,HttpStatus.OK);
	}
	
	@PutMapping(value = "/trash")
	public ResponseEntity<Response>trashAndUntrash(@RequestHeader(value="token") String token,@RequestParam Long noteId){
		//logger.info(notesDto.toString());
		Response responseStatus=noteService.trashAndUnTrash(token, noteId);
		
		return new ResponseEntity<Response>(responseStatus,HttpStatus.OK);
	}
	
	@PutMapping("/colour")
	public ResponseEntity<Response>noteColour(@RequestHeader String token,@RequestBody ColorDto colorDto){
		//logger.info(notesDto.toString());
		Response responseStatus=noteService.colourNote(token, colorDto);
		return new ResponseEntity<Response>(responseStatus,HttpStatus.OK);
	}
}
