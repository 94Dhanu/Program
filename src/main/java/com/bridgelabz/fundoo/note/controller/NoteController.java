package com.bridgelabz.fundoo.note.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.fundoo.note.dto.NoteDto;

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
}
