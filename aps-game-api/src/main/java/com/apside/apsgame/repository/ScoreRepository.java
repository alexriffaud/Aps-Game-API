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
	List<Score> findByUser(Long id);
	
	
//	@Query(value = "SELECT apsgame.score.id, apsgame.score.score, apsgame.score.date, apsgame.user.id, apsgame.user.login apsgame.user.id FROM apsgame.score LEFT JOIN apsgame.user ON apsgame.user.id = apsgame.score.user WHERE user = ?1", nativeQuery = true)
//	List<Score> findByUser(Long id);
	
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO apsgame.score (score, user, date) " 
			+ "VALUES ( :score , :user, :date ) ", nativeQuery = true)
	void insertScore(@Param("score") Long score,
					@Param("user") Long user,
					@Param("date") LocalDateTime date);
}
