package com.example.footbal_manager_fifa.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeagueDto {

    private Integer id;
    private String name;
    private String continent;
    private String country;


}
