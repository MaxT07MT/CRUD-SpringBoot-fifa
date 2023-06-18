package com.example.footbal_manager_fifa.repository;

import com.example.footbal_manager_fifa.entity.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface LeagueRepository extends JpaRepository<League, Integer> {

    League findByName(String name);


}
