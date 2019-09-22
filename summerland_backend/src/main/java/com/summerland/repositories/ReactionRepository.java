package com.summerland.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.summerland.entities.Reaction;

public interface ReactionRepository  extends JpaRepository<Reaction, Long>{

}
