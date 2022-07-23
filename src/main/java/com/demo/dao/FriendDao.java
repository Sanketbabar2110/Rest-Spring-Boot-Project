package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Friend;

@Repository
public interface FriendDao extends JpaRepository<Friend, String> {

}
