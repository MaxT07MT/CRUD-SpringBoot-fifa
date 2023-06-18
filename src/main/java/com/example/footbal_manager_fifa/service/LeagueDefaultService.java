package com.example.footbal_manager_fifa.service;

import com.example.footbal_manager_fifa.entity.League;
import com.example.footbal_manager_fifa.exception.ValidationException;
import com.example.footbal_manager_fifa.repository.LeagueRepository;
import com.example.footbal_manager_fifa.dto.LeagueDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class LeagueDefaultService implements LeagueService {

    private final LeagueRepository leagueRepository;
    private final LeagueConverter leagueConverter;


    @Override
    public LeagueDto saveLeague(LeagueDto leagueDto) throws ValidationException {
        validateLeagueDto(leagueDto);
        League savedLeague = leagueRepository.save(leagueConverter.fromLeagueDtoToLeague(leagueDto));
        return leagueConverter.fromLeagueToLeagueDto(savedLeague);
    }

    private void validateLeagueDto(LeagueDto leagueDto) throws ValidationException {
        if (isNull(leagueDto)) {
            throw new ValidationException("Object league is null");
        }
        if (isNull(leagueDto.getName()) || leagueDto.getName().isEmpty()) {
            throw new ValidationException("Name is empty");
        }
    }

    @Override
    public void deleteLeague(Integer leagueId) {
        leagueRepository.deleteById(leagueId);
    }

    @Override
    public LeagueDto findByName(String name) {
        League league= leagueRepository.findByName(name);
        if (league != null) {
            return leagueConverter.fromLeagueToLeagueDto(league);
        }
        return null;
    }

    @Override
    public List<LeagueDto> findAll() {
        return leagueRepository.findAll()
                .stream()
                .map(leagueConverter::fromLeagueToLeagueDto)
                .collect(Collectors.toList());
    }
}
