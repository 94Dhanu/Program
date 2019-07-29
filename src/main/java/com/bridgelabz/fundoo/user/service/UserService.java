package com.bridgelabz.fundoo.user.service;

import java.io.UnsupportedEncodingException;
//import java.io.UnsupportedEncodingException;
//import java.io.UnsupportedEncodingException;
import java.util.Optional;

import javax.servlet.UnavailableException;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

//import com.bridgelabz.fundoo.exception.UserException;
//import com.bridgelabz.fundoo.response.Response;
//import com.bridgelabz.fundoo.response.ResponseToken;
import com.bridgelabz.fundoo.user.dto.EmailDTO;
import com.bridgelabz.fundoo.user.dto.LoginDTO;
import com.bridgelabz.fundoo.user.dto.UserDTO;
import com.bridgelabz.fundoo.user.model.User;

import io.swagger.models.RefResponse;
@Service
public interface UserService {
	RefResponse onRegister(UserDTO userDto) throws UnavailableException, UnsupportedEncodingException;

	ResponseBody onLogin(LoginDTO loginDto) throws UnavailableException, UnsupportedEncodingException;

	/**
	 * to verify valid emailId
	 */
	RefResponse validateEmailId(String token) throws UnavailableException;
	
	RefResponse addProfile(String token,String path) throws UnavailableException;
	
	String getProfile(String token) throws UnavailableException;
	
	public RefResponse uploadProfilePic(String token,MultipartFile picture);
	public Resource getProfilePic(String token);


	/**
	 * to send forget password link
	 */
	RefResponse forgetPassword(EmailDTO emailDto) throws UnavailableException, UnsupportedEncodingException;

	/**
	 * use to reset already register user password
	 * 
	 */
	public RefResponse resetPaswords(String token, String password) throws UnavailableException;

	ResponseBody authentication(Optional<User> user, String password)
			throws UnsupportedEncodingException, UnavailableException;

}
