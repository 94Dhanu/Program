package com.bridgelabz.fundoo.user.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.Files;
import java.util.Optional;
import java.util.UUID;

import javax.tools.JavaFileManager.Location;

//import org.aspectj.apache.bcel.classfile.Utility;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bridgelabz.fundoo.exception.UserException;
import com.bridgelabz.fundoo.response.Response;
import com.bridgelabz.fundoo.response.ResponseToken;
import com.bridgelabz.fundoo.user.dto.Maildto;
import com.bridgelabz.fundoo.user.dto.Logindto;
import com.bridgelabz.fundoo.user.dto.Userdto;
import com.bridgelabz.fundoo.user.model.User;
import com.bridgelabz.fundoo.user.repository.UserRepo;
import com.bridgelabz.fundoo.utility.ResponseHelper;
import com.bridgelabz.fundoo.utility.TokenGenerator;
import com.bridgelabz.fundoo.utility.Utility;




@Component
@SuppressWarnings("unused")
@PropertySource("classpath:message.properties")
@Service("userService")
public  class UserServiceImpl implements UserService {
	//Path location=Paths.get("/home/admin1/Desktop/Dj.png");
	//String location="/home/admin1/Desktop/Dj.png";

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private TokenGenerator tokenUtil;

	@Autowired
	private Response statusResponse;
	@Autowired
	Utility utility;

	@Autowired
	private Environment environment;
	
	@Override
	public Response onRegister(Userdto userDto) {

		String emailid = userDto.getEmailId();

		User user = modelMapper.map(userDto, User.class);
		Optional<User> alreadyPresent = userRepo.findByEmailId(user.getEmailId());
		if (alreadyPresent.isPresent()) {
			throw new UserException(environment.getProperty("status.register.emailExistError"));
		}
		// encode user password
		String password = passwordEncoder.encode(userDto.getPassword());
	
		user.setPassword(password);
		user = userRepo.save(user);
		Long userId = user.getUserId();
		 System.out.println(emailid + " " + userId);
		//Utility.send(emailid, "confirmation mail", Utility.getUrl(userId) + "/valid");
		utility.send(emailid, "confirmation mail",userId);
		statusResponse = ResponseHelper.statusResponse(200, "register successfully");
		return statusResponse;

	}

	
	
	public ResponseToken onLogin(Logindto loginDto) {
		// extract user details by using emailid
		//long userId = tokenUtil.decodeToken(token);
		Optional<User> user = userRepo.findByEmailId(loginDto.getEmailId());
		System.out.println(user);
		ResponseToken response = new ResponseToken();
		if (user.isPresent()) {
			System.out.println("password..." + (loginDto.getPassword()));
			
		return authentication(user, loginDto.getPassword());

		}
		
		return response;

	}
	
	
	
	
	@Override
	public ResponseToken authentication(Optional<User> user, String password) {

		ResponseToken response = new ResponseToken();
		if (user.get().isVerify()) {
			boolean status = passwordEncoder.matches(password, user.get().getPassword());
			System.out.println("status"+status);
			if (status == true) {
				System.out.println("logged in");
				String token = tokenUtil.createToken(user.get().getUserId());
				System.out.println(token);
				response.setToken(token);
				response.setStatusCode(200);
				response.setStatusMessage(environment.getProperty("user.login"));
				return response;
			}
			throw new UserException(401, environment.getProperty("user.login.password"));
		}
		throw new UserException(401, environment.getProperty("user.login.verification"));
	}

	@Override
	public Response validateEmailId(String token) {
		System.out.println("Hi");
		Long id = tokenUtil.decodeToken(token);
		User user = userRepo.findById(id)
				.orElseThrow(() -> new UserException(404, environment.getProperty("user.validation.email")));
		user.setVerify(true);
		userRepo.save(user);
		statusResponse = ResponseHelper.statusResponse(200, environment.getProperty("user.validation"));
		return statusResponse;
	}



	@Override
	public Response forgetPassword(Maildto emailDto) throws UserException, UnsupportedEncodingException {
		Optional<User> alreadyPresent=userRepo.findByEmailId(emailDto.getEmailId());
		String emailid = emailDto.getEmailId();
		if(!alreadyPresent.isPresent()) {
			throw new UserException(401,environment.getProperty("user.forgetPassword.emailId"));
	}
		long id=alreadyPresent.get().getUserId();
		System.out.println("Hi Forgot");
		Utility.send(emailid, "confirmation mail",id);
		//utility.send(emailDto.getEmailId(), "password reset mail", Utility.getUrl(id));
		return ResponseHelper.statusResponse(200, environment.getProperty("user.forgetpassword.link"));
	}



	@Override
	public Response resetPaswords(String token, String password) throws UserException {
		long id=tokenUtil.decodeToken(token);
		User user=userRepo.findById(id).orElseThrow(()-> new UserException(404,environment.getProperty("user.resetpassword.user")));
		String encodedPasword=passwordEncoder.encode(password);
		user.setPassword(encodedPasword);
		userRepo.save(user);
		
		return ResponseHelper.statusResponse(200, "password successfully reset");
	}



	

	@Override
	public Response uploadProfilePic(String token, MultipartFile picture) {
		long userId=tokenUtil.decodeToken(token);
		User user=userRepo.findById(userId).orElseThrow(()-> new UserException(404,"user is not found"));
		UUID uuid=UUID.randomUUID();
		String id=uuid.toString();
		try {
			//Files.copy(picture.getInputStream(), location.resolve(id),StandardCopyOption.REPLACE_EXISTING);
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		user.setProfile(id);
		userRepo.save(user);
		return ResponseHelper.statusResponse(200, "profile updated successfully");
	}



	@Override
	public Resource getProfilePic(String token) {
		long userId=tokenUtil.decodeToken(token);
		User user=userRepo.findById(userId).orElseThrow(()-> new UserException(404,"user is not found"));
		//Path url=location.resolve(user.getProfile());
//		try {
//			
//			//Resource resource=new UrlResource(url.toUri());
//			return null;
//		}
//		catch(MalformedURLException e){
//			e.printStackTrace();
//			
//		}
		return null;
	}
	
}
