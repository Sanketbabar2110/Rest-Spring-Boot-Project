package com.demo;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.dao.FriendDao;
import com.demo.entity.Friend;
import com.demo.service.FriendService;
import com.demo.service.FriendServiceImpl;

//@ExtendWith(MockitoExtension.class)
@SpringBootTest
@RunWith(SpringRunner.class)
class RestSpringBootProjectApplicationTests {

	@Autowired
	FriendService service;
	
	//@Mock
	@MockBean
	FriendDao dao;
	
	@Autowired
	Friend entity;
	
	@Test
	public void testGetFriendById() {
		String s = "vinu";
		entity = new Friend("vinu", "Vinit", 9637175558l, "Sanjeevan");
		when(dao.findById(s)).thenReturn(Optional.of(entity));
		
		Assert.assertEquals(entity, service.getFriendById("vinu"));
	}
	
	@Test
	public void testGetAllFriends() {
		service.getAllFriends();
		verify(dao).findAll();
	}
	
//	@BeforeEach
//	public void setUp() {
//		this.service = new FriendServiceImpl(this.dao);
//	}
	
}
