package com.example.footbal_manager_fifa.service;

import com.example.footbal_manager_fifa.entity.League;
import com.example.footbal_manager_fifa.dto.LeagueDto;
import org.springframework.stereotype.Component;

@Component
public class LeagueConverter {
    public League fromLeagueDtoToLeague(LeagueDto leagueDto) {
        League league = new League();
        league.setId(leagueDto.getId());
        league.setName(leagueDto.getName());
        league.setContinent(leagueDto.getContinent());
        league.setCountry(leagueDto.getCountry());
        return league;
    }

    public LeagueDto fromLeagueToLeagueDto(League league) {
        return LeagueDto.builder()
                .id(league.getId())
                .name(league.getName())
                .continent(league.getContinent())
                .country(league.getCountry())
                .build();
    }
}
