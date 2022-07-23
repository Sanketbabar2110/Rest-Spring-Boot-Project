package com.demo.service;

import java.util.List;

import com.demo.entity.Friend;

public interface FriendService {

	public Friend saveFriend(Friend entity);
	
	public List<Friend> getAllFriends();
	
	public Friend getFriendById(String Id);
	
	public boolean updateFriend(Friend entity, String Id);
	
	public boolean deleteFriend(String Id);
}
