package com.nagarro.backendApp.reviewApp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.backendApp.reviewApp.model.UserAuth;
import com.nagarro.backendApp.reviewApp.repository.UserAuthRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserAuthController {

	@Autowired
	UserAuthRepo userAuthRepo;
	
	
	@GetMapping("/userAuth")
	public ResponseEntity<List<UserAuth>> userStats(){
		List<UserAuth> users = new ArrayList<UserAuth>();
		userAuthRepo.findAll().forEach(users::add);
		
		if(users.size()==0)
		{
			return new ResponseEntity<>(null, HttpStatus.OK);
		}
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	
	@GetMapping("/userAuth/{userName}")
	public ResponseEntity<UserAuth> getDataByUserId(@PathVariable("userName") String userName)
	{
		List<UserAuth> data = new ArrayList<UserAuth>();
		userAuthRepo.findAll().forEach(data::add);
		
		for(UserAuth user: data )
		{
			if(user.getUserName().equals(userName))
			{
				return new ResponseEntity<>(user, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	
	@GetMapping("/userAuth/{userName}/{userPassword}")
	public ResponseEntity<Boolean> getDataById(@PathVariable("userName")String userName, @PathVariable("userPassword") String pass)
	{
		List<UserAuth> data = new ArrayList<UserAuth>();
		userAuthRepo.findAll().forEach(data::add);
		for(UserAuth users : data)
		{
			System.out.print(users.getUserName());
			if(users.getUserName().equals(userName) && users.getUserPassword().equals(pass))
			{
				return new ResponseEntity<>(true,HttpStatus.OK);
			}
		}
		return new ResponseEntity<Boolean>(false,HttpStatus.OK);	    
	}
	
	
	
	@PostMapping("/userAuth")
	public ResponseEntity<Boolean> registerUser(@RequestBody UserAuth userData)
	{
		UserAuth data = new UserAuth(userData.getUserName(),userData.getUserPassword(),
				  userData.getUserFirstName(), userData.getUserLastName(), userData.getUserEmail()) ;
		
		userAuthRepo.save(data);
		return new ResponseEntity<>(true, HttpStatus.CREATED);
	}
}
