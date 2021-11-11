package com.jetbrains.springdatajpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);


    }

    @Bean
    public CommandLineRunner run(FootballPlayerRepository repository){

        return (args -> {



            repository.toString();


//                repository.deleteAll();






        });

    }

    private void insertJavaAdvocates(FootballPlayerRepository repository){

        repository.save(new FootballPlayer("Cristiano","Ronaldo dos Santos Aveiro",36,'M',"Portuguese","Mancester United",7));
        repository.save(new FootballPlayer("Lionel","Andres Messi",34,'M',"Argentine","Paris Saint-Germain",30));
        repository.save(new FootballPlayer("Kylian","Mbappé",22,'M',"French","Paris Saint-Germain",7));
        repository.save(new FootballPlayer("Neymar","da Silva Santos Júnior",29,'M',"Brazilian","Paris Saint-Germain",10));
        repository.save(new FootballPlayer("Gianluigi","Donnarumma",22,'M',"Italian","Paris Saint-Germain",50));
        repository.save(new FootballPlayer("Sergio","Ramos Garcia",35,'M',"Spanish","Paris Saint-Germain",4));
        repository.save(new FootballPlayer("Anchraf Hakimi","Mouh",23,'M',"Marocco","Paris Saint-Germain",2));
        repository.save(new FootballPlayer("Mauro Emanuel","Icardi",28,'M',"Argentine","Paris Saint-Germain",9));
        repository.delete(new FootballPlayer());

    }


}
