package com.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Friend;
import com.demo.service.FriendService;

@RestController
@RequestMapping("/friends")
public class MyRestController {
	
	private static final Logger logger = LogManager.getLogger(MyRestController.class);
	
	@Autowired
	FriendService service;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Friend entity){
		
		logger.trace("Request body from request : "+entity);
		Friend saveFriend = service.saveFriend(entity);
		
		logger.info("The entity saved successfully to the database : "+saveFriend);
		return ResponseEntity.ok(saveFriend);
		
	}
	
	@GetMapping("/{Id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Friend getById(@PathVariable("Id")String Id){
		
		return service.getFriendById(Id);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(service.getAllFriends());
	}
	
	@PutMapping("/{Id}")
	public ResponseEntity<?> update(@RequestBody Friend entity, @PathVariable("Id") String Id){
		if(service.updateFriend(entity, Id))
			return ResponseEntity.ok("Friend details updated in database Successfully!!!");
		else
			return ResponseEntity.ok("Failed to update Friend Details into database!!!");
	}
	
	@DeleteMapping("{Id}")
	public ResponseEntity<?> delete(@PathVariable("Id") String Id){
		
		if(service.deleteFriend(Id))
			return ResponseEntity.ok("Friend details deleted Successfully!!!");
		else
			return ResponseEntity.ok("Failed to remove friend details!!!");
	}
}
