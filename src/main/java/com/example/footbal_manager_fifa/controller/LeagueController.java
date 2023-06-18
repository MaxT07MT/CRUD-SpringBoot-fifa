package com.example.footbal_manager_fifa.controller;


import com.example.footbal_manager_fifa.exception.ValidationException;
import com.example.footbal_manager_fifa.service.LeagueService;
import com.example.footbal_manager_fifa.dto.LeagueDto;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/league")
@AllArgsConstructor
@Log
@CrossOrigin
public class LeagueController {

    private final LeagueService leagueService;

    @PostMapping("/save")
    public LeagueDto saveUsers(@RequestBody LeagueDto leagueDto) throws ValidationException {
        log.info("Handling save league: " + leagueDto);
        return leagueService.saveLeague(leagueDto);
    }

    @GetMapping("/findAll")
    public List<LeagueDto> findAllUsers() {
        log.info("Handling find all league request");
        return leagueService.findAll();
    }

    @GetMapping("/findByLogin")
    public LeagueDto findByName(@RequestParam String name) {
        log.info("Handling find by name request: " + name);
        return leagueService.findByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUsers(@PathVariable Integer id) {
        log.info("Handling delete user request: " + id);
        leagueService.deleteLeague(id);
        return ResponseEntity.ok().build();
    }
}
