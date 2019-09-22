package com.summerland.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.summerland.entities.Review;

public interface ReviewRepository  extends JpaRepository<Review, Long>{

}
