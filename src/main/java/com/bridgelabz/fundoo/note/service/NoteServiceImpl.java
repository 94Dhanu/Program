package com.bridgelabz.fundoo.note.service;

import com.bridgelabz.fundoo.note.dto.NoteDto;
import com.bridgelabz.fundoo.note.dto.NoteDto;
import com.bridgelabz.fundoo.response.Response;


	
	import java.time.LocalDateTime;
	import java.time.format.DateTimeFormatter;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Optional;

	import org.modelmapper.ModelMapper;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.PropertySource;
	import org.springframework.core.env.Environment;
	import org.springframework.stereotype.Service;

	import com.bridgelabz.fundoo.exception.UserException;
	

	import com.bridgelabz.fundoo.note.model.Note;
	import com.bridgelabz.fundoo.note.repository.NotesRepository;

	import com.bridgelabz.fundoo.user.model.User;
	import com.bridgelabz.fundoo.user.repository.UserRepo;
	import com.bridgelabz.fundoo.utility.ResponseHelper;
	import com.bridgelabz.fundoo.utility.TokenGenerator;
	import com.bridgelabz.fundoo.utility.Utility;

	@PropertySource("classpath:message.properties")
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
			//user.get().getNotes().add(notes);
			notesRepository.save(notes);
			//userRepository.save(user.get());
			
			
			Response response=ResponseHelper.statusResponse(200, environment.getProperty("status.notes.createdSuccessfull"));
			return response;
			
			
			
		}
		@Override
		public Response updateNote(NoteDto notesDto, String token, Long noteId) {
			System.out.println("Hi Update note");
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
				notesRepository.save(notes);
				Response response=ResponseHelper.statusResponse(200, environment.getProperty("status.note.trashed"));
			
			return response;
		}

		@Override
		public List<Note> getAllNotes(String token) {
			// TODO Auto-generated method stub
			return null;
		}


	}
	


