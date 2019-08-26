package com.bridgelabz.fundoo.note.service;

//import com.bridgelabz.fundoo.note.controller.DeleteMapping;
import com.bridgelabz.fundoo.note.dto.ColorDto;
import com.bridgelabz.fundoo.note.dto.NoteDto;
//import com.bridgelabz.fundoo.note.dto.NoteDto;
import com.bridgelabz.fundoo.response.Response;


	
	import java.time.LocalDateTime;
	import java.time.format.DateTimeFormatter;
	import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
	import java.util.Optional;

	import org.modelmapper.ModelMapper;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.PropertySource;
	import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.bridgelabz.fundoo.exception.UserException;
	

	import com.bridgelabz.fundoo.note.model.Note;
	import com.bridgelabz.fundoo.note.repository.NotesRepository;

	import com.bridgelabz.fundoo.user.model.User;
	import com.bridgelabz.fundoo.user.repository.UserRepo;
	import com.bridgelabz.fundoo.utility.ResponseHelper;
	import com.bridgelabz.fundoo.utility.TokenGenerator;
	import com.bridgelabz.fundoo.utility.Utility;

	//@PropertySource("classpath:message.properties")
	@Service("noteService")
	public  class NoteServiceImpl implements NoteService 
	{
		Logger logger = LoggerFactory.getLogger(NoteServiceImpl.class);

		@Autowired
		private TokenGenerator userToken;

		@Autowired
		private ModelMapper modelMapper;

		@Autowired
		private UserRepo userRepository;

		@Autowired
		private NotesRepository notesRepository;

		@Autowired
		private Environment environment;

		@Override

		public Response createNote(NoteDto notesDto, String token)
		{
			//System.out.println("Hi note");
			long id = userToken.decodeToken(token);
			logger.info(notesDto.toString());
			if (notesDto.getTitle().isEmpty() && notesDto.getDescription().isEmpty()) {

				throw new UserException(-5, "Title and description are empty");

			}
			Note notes = modelMapper.map(notesDto, Note.class);
			Optional<User> user = userRepository.findById(id);
			notes.setUserId(id);
			notes.setCreated(LocalDateTime.now());
			notes.setModified(LocalDateTime.now());
			((List<Note>) user.get().getNotes()).add(notes);
			notesRepository.save(notes);
		
			userRepository.save(user.get());
			
			
			Response response=ResponseHelper.statusResponse(200, environment.getProperty("status.notes.createdSuccessfull"));
			return response;
			
			
			
		}
		@Override
		public Response updateNote(NoteDto notesDto, String token, Long noteId) {
			//System.out.println("Hi Update note");
			if(notesDto.getTitle().isEmpty() && notesDto.getDescription().isEmpty()) {
				throw new UserException(-5,"Title and discriptions are empty");
			}
			long id=userToken.decodeToken(token);
			Note notes=notesRepository.findBynoteIdAndUserId(noteId, id);
			notes.setTitle(notesDto.getTitle());
			notes.setDescription(notesDto.getDescription());
			notes.setModified(LocalDateTime.now());
			notesRepository.save(notes);
			Response response=ResponseHelper.statusResponse(200, environment.getProperty("status.notes.updated"));
			return response;
		}

		@Override
		public Response delete(String token, Long noteId) {
			long id=userToken.decodeToken(token);
			Note notes=notesRepository.findBynoteIdAndUserId(noteId, id);
			if(notes==null) {
				throw new UserException(-5,"Invalid input");
			}
			
				notes.setModified(LocalDateTime.now());
				notesRepository.delete(notes);
				Response response=ResponseHelper.statusResponse(200, environment.getProperty("status.note.trashed"));
			
			return response;
		}
		@Override
		public Response deletePermanently(String token, Long noteId) {
			long id =userToken.decodeToken(token);
			Optional<User> user=userRepository.findById(id);
			//orElseThrow method will return value only if it’s present. Otherwise, it’ll throw an exception created by a provided supplier.


			Note note=notesRepository.findById(noteId).orElseThrow();
			System.out.println(note);
			if(note.isTrash()==true) {
				((List<Note>) user.get().getNotes()).remove(note);
				userRepository.save(user.get());
				notesRepository.delete(note);
				Response response=ResponseHelper.statusResponse(200, environment.getProperty("status.note.deleted"));
				return response;
			}else {
			Response response=ResponseHelper.statusResponse(100, environment.getProperty("status.note.notdeleted"));
			return response;
			}
		}

		@Override
		public  List<Note> getAllNotes(String token) {
			long id =userToken.decodeToken(token);
			User user =userRepository.findById(id).get();

			return (List<Note>) user.getNotes();
		}
		@Override
		public Response pinAndUnPin(String token, Long noteId) {
			long id =userToken.decodeToken(token);
			Note notes=notesRepository.findBynoteIdAndUserId(noteId, id);
			if(notes==null) {
				throw new UserException(-5,"Invalid input");
			}
			if(notes.isPined()==false) {
				notes.setPined(true);
				notes.setModified(LocalDateTime.now());
				notesRepository.save(notes);
				Response response=ResponseHelper.statusResponse(200, environment.getProperty("statu.note.pinned"));
				return response;
			}else {
				notes.setPined(false);
				notes.setModified(LocalDateTime.now());
				notesRepository.save(notes);
				Response response=ResponseHelper.statusResponse(200, environment.getProperty("status.note.unpinned"));
				return response;
			
			}
		}
	           
		@Override
		
		public Response archiveAndUnArchive(String token, Long noteId) {
			long id =userToken.decodeToken(token);
			Note notes=notesRepository.findBynoteIdAndUserId(noteId, id);
			if(notes==null) {
				throw new UserException(-5,"Invalid input");
			}
			if(notes.isArchived()==false) {
				notes.setArchived(true);
				notes.setModified(LocalDateTime.now());
				notesRepository.save(notes);
				Response response=ResponseHelper.statusResponse(200, environment.getProperty("status.note.archieved"));
				return response;
			}else {
				notes.setArchived(false);
				notes.setModified(LocalDateTime.now());
				notesRepository.save(notes);
				Response response=ResponseHelper.statusResponse(200, environment.getProperty("status.note.unarchieved"));
				return response;
			
			}
		}

		@Override
		public Response trashAndUnTrash(String token, Long noteId) {
			System.out.println(token+"......"+noteId);
			long id =userToken.decodeToken(token);
			Note notes=notesRepository.findBynoteIdAndUserId(noteId, id);
			if(notes==null) {
				throw new UserException(-5,"Invalid input");
			}
			if(notes.isTrash()==false) {
				notes.setTrash(true);
				notes.setModified(LocalDateTime.now());
				notesRepository.save(notes);
				Response response=ResponseHelper.statusResponse(200, environment.getProperty("status.note.trashed"));
				return response;
			}else {
				notes.setTrash(false);
				notes.setModified(LocalDateTime.now());
				notesRepository.save(notes);
				Response response=ResponseHelper.statusResponse(200, environment.getProperty("status.note.untrashed"));
				return response;
			
			}
		}


		@Override
		public Response colourNote(String token,ColorDto colorDto) {
			long id =userToken.decodeToken(token);
			Note notes=notesRepository.findBynoteIdAndUserId(colorDto.getNoteId(), id);
			notes.setColour(colorDto.getColor());
			notesRepository.save(notes);
			Response response=ResponseHelper.statusResponse(200, environment.getProperty("status.notes.colour"));
			return response;
		}
		@Override
		public Response addCollabrator(String token, String email, Long noteId) {
			long userId=userToken.decodeToken(token);
			System.out.println("userId"+userId);
			Optional<User> mainUser=userRepository.findById(userId);
			Optional<User> user=userRepository.findByEmailId(email);
			System.out.println(user);
			System.out.println(mainUser);
			if(!user.isPresent()) {
				throw  new UserException(-4,"No user exit");
		}
			Note note=notesRepository.findBynoteIdAndUserId(noteId, userId);
			Note note1 = notesRepository.findByUserIdAndNoteId(userId, noteId);
			System.out.println("note is"+note1);
			if(note==null) {
				throw new UserException(-5,"No note exist");
			}
			if(user.get().getCollabaratedNotes().contains(note)) {
				throw new UserException(-5,"Note is already collabrated");
			}
			
			user.get().getCollabaratedNotes().add(note);
			note.getCollaboratedUser().add(note);
			userRepository.save(user.get());
			notesRepository.save(note);
			Utility.send(email, "Collaborated Note", note.getUserId());
			Response response=ResponseHelper.statusResponse(200, environment.getProperty("status.note.collaborated"));
			return response;
		}
		@Override
		public Response removeCollabrator(String token, String email, Long noteId) {
			long userId=userToken.decodeToken(token);
			Optional<User> mainUser=userRepository.findById(userId);
			Optional<User> user=userRepository.findByEmailId(email);
			if(!user.isPresent()) {
				throw  new UserException(-4,"No user exit");
			}
			Note note=notesRepository.findBynoteIdAndUserId(userId, noteId);
			if(note==null) {
				throw new UserException(-5,"No note exist");
			}
			if(user.get().getCollabaratedNotes().contains(note)) {
				throw new UserException(-5,"Note is already collabrated");
			}
			
			user.get().getCollabaratedNotes().remove(note);
			note.getCollaboratedUser().remove(user.get());
			userRepository.save(user.get());
			notesRepository.save(note);
			
			Response response=ResponseHelper.statusResponse(200, environment.getProperty("status.note.removecollaborated"));
			return response;
		}


		@Override
		public List<NoteDto> getAllArchive(String token) {

			long id =userToken.decodeToken(token);
			List<Note> notes=(List<Note>)notesRepository.findByUserId(id);

			List<NoteDto> listNotes=new ArrayList<NoteDto>();
			for(Note userNotes:notes) {
				NoteDto noteDto=modelMapper.map(userNotes,NoteDto.class);
				if(userNotes.isArchived()==true && userNotes.isTrash()==false) {
					listNotes.add(noteDto);
				}
			
		}


			return listNotes;
		}


	}
	


