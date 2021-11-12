package com.jetbrains.springdatajpa;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;


public interface FootballPlayerRepository extends CrudRepository<FootballPlayer, Long> {




    List<FootballPlayer> findEmployeeByLastNameContaining(String str);

    List<FootballPlayer> findByLastName(String lastName);

    List<FootballPlayer> findFootballPlayerByAge(int age);

    Optional<FootballPlayer> findById(Long aLong);



    @Query("SELECT u FROM FootballPlayer u where u.nationality = 'Spanish' ")
    List<FootballPlayer> findAllByNationalitySpanish();

    @Query("SELECT f from FootballPlayer f")
    List<FootballPlayer> selectAll();

    @Query("SELECT f FROM FootballPlayer f order by f.age desc ")
    List<FootballPlayer> allAgesOrderByDesc();

    @Query("select f.age FROM FootballPlayer f")
    List<FootballPlayer> allAges();



}
