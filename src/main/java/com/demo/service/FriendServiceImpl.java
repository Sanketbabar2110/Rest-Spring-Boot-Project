package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.controller.MyRestController;
import com.demo.dao.FriendDao;
import com.demo.entity.Friend;
import com.demo.exception.NoSuchFrieneExistException;

@Service
public class FriendServiceImpl implements FriendService {

	@Autowired
	FriendDao friendDao;
	
	private static final Logger logger = LogManager.getLogger(MyRestController.class);

	public FriendServiceImpl(FriendDao dao) {
		this.friendDao=dao;
	}

	@Override
	public Friend saveFriend(Friend entity) {
		
		logger.info("Inside FriendServiceImpl save method!!!!");
		return friendDao.save(entity);
	}

	@Override
	public List<Friend> getAllFriends () {

		return friendDao.findAll();
	}

	@Override
	public Friend getFriendById(String Id) {

		return friendDao.findById(Id)
				.orElseThrow(() -> new NoSuchFrieneExistException("No Friend Present with Id :" + Id));
	}

	@Override
	public boolean updateFriend(Friend entity, String Id) {

		Optional<Friend> opt = friendDao.findById(Id);
		if (opt == null) {
			throw new NoSuchFrieneExistException("No friend found with Id " + Id + " to update Friend Details");
		} else {
			Friend fri = opt.get();
			fri.setMobileNum(entity.getMobileNum());
			fri.setCollege(entity.getCollege());
			fri.setName(entity.getName());
			friendDao.save(fri);
			return true;
		}
	}

	@Override
	public boolean deleteFriend(String Id) {

		Optional<Friend> opt = friendDao.findById(Id);

		if (opt.isPresent()) {
			friendDao.deleteById(Id);
			return true;
		} else {
			throw new NoSuchFrieneExistException("Friend not found to remove it from database!!!");
		}
	}
}
