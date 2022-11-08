package com.example.demo.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.data.entity.Player;

public interface PlayerRepository extends CrudRepository<Player, Long> {

	@Query("select p from Player p where p.team.teamId = :teamId")
	List<Player> findAllByTeamId(@Param("teamId") long teamId);
}
