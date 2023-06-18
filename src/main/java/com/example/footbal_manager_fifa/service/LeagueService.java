package com.example.footbal_manager_fifa.service;

import com.example.footbal_manager_fifa.dto.LeagueDto;
import com.example.footbal_manager_fifa.exception.ValidationException;

import java.util.List;


public interface LeagueService  {

    LeagueDto saveLeague(LeagueDto leagueDto) throws ValidationException;

    void deleteLeague(Integer leagueId);

    LeagueDto findByName(String name);

    List<LeagueDto> findAll();
}







