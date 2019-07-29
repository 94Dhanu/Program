package com.brigelabz.fundoo.Controller;


import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.UnavailableException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bridgelabz.fundoo.user.dto.EmailDTO;
import com.bridgelabz.fundoo.user.dto.LoginDTO;
import com.bridgelabz.fundoo.user.dto.UserDTO;
import com.bridgelabz.fundoo.user.model.User;
import com.bridgelabz.fundoo.user.repository.UserRepo;
import com.bridgelabz.fundoo.user.service.UserService;

import io.swagger.models.Response;

@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
@RequestMapping("/user")
public class UserController<ResponseToken> {
	@Autowired
	UserService userService;

	@Autowired
	UserRepo userRepo;
	
	@PostMapping("/register")
	public ResponseEntity<Response> register(@RequestBody UserDTO userDto)
			throws UserException, UnsupportedEncodingException, UnavailableException {
		Response response = userService.onRegister(userDto);
		System.out.println(response);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@PostMapping("/login")
	public ResponseEntity<ResponseToken> onLogin(@RequestBody LoginDTO loginDTO)
			throws UserException, UnsupportedEncodingException {
		ResponseToken response = null;
		try {
			response = (ResponseToken) userService.onLogin(loginDTO);
		} catch (UnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// to verify
	@GetMapping(value = "/{token}/valid")
	public ResponseEntity<Response> emailValidation(@PathVariable String token) throws UserException {

		Response response = null;
		try {
			response = userService.validateEmailId(token);
		} catch (UnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	// for forget password
	@PostMapping("/forgetpassword")
	public ResponseEntity<Response> forgotPassword(@RequestBody EmailDTO emailDto)
			throws UnsupportedEncodingException, UserException, MessagingException {
		System.out.println(emailDto);
		Response status = null;
		try {
			status = userService.forgetPassword(emailDto);
		} catch (UnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ResponseEntity<Response>(status, HttpStatus.OK);

	}

	@PutMapping(value = "/resetpassword")
	public ResponseEntity<?> resetPassword(@RequestParam String token, @RequestParam("password") String password)
			throws UserException {
		Response response=null;
		try {
			response = userService.resetPaswords(token, password);
		} catch (UnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}
	@GetMapping("/getallusers")
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	@GetMapping("/getprofilepic/{token}")
	public Resource getProfilePic(@PathVariable("token") String token){
		Resource resource=userService.getProfilePic(token);
		return resource;
	}
	@PutMapping(value="/uploadprofile",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> addProfile(@RequestHeader(value="token") String token, @RequestParam("File") MultipartFile picture)
			throws UserException {
		Response response=userService.uploadProfilePic(token, picture);
		
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}

}
