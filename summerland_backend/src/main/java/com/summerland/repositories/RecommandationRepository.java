package com.summerland.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.summerland.entities.Recommandation;

public interface RecommandationRepository  extends JpaRepository<Recommandation, Long>{

}
