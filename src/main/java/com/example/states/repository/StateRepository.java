package com.example.states.repository;

import com.example.states.entity.StateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<StateEntity, String> {
}
