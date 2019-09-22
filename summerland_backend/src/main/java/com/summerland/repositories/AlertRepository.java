package com.summerland.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.summerland.entities.Alert;

public interface AlertRepository  extends JpaRepository<Alert, Long>{

}
