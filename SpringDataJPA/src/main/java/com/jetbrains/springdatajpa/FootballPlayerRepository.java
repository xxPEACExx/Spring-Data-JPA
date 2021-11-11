package com.jetbrains.springdatajpa;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface FootballPlayerRepository extends CrudRepository<FootballPlayer, Long> {


    List<FootballPlayer> findEmployeeByLastNameContaining(String str);
    List<FootballPlayer> countFootballPlayersById(long id);




}
