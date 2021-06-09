package com.apside.apsgame.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.apside.apsgame.model.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {

	Optional<Score> findById(Long id);
	List<Score> findAll();
}
