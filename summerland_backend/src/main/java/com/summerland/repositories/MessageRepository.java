package com.summerland.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.summerland.entities.Message;

public interface MessageRepository  extends JpaRepository<Message, Long>{

}
