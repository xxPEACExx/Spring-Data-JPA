package com.jetbrains.springdatajpa;


import org.springframework.boot.SpringApplication;
import java.util.Collections;
import java.util.Scanner;

public class FootballPlayerMethods extends FootballPlayer {



    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);




    }


    public static void insertFromCommand(FootballPlayerRepository repository){

        int age = 0;
        String gender  = "";
        String f = "F";
        String m = "M";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Players name : ");
        String name = scanner.next();

        System.out.println("Enter Players lastname : ");
        String lastName = scanner.next();



            try {

                System.out.println("Enter Players age : ");
                age = scanner.nextInt();

                while (age <= 18 || age >= 100) {
                    System.out.println("Please Enter Age beetwen 18 and 80");
                    age = scanner.nextInt();

                }
            }
             catch (Exception e){
            System.out.println(e);
            }


        System.out.println("Enter Players Gender : ");
        gender = scanner.next();


        System.out.println("Enter Players Nationality : ");
        String nationality = scanner.next();

        System.out.println("Enter Player Team That you Play For : ");
        String  team = scanner.next();

        System.out.println("Enter Player Number : ");
        int number = scanner.nextInt();

        repository.save(new FootballPlayer(name,lastName,age,gender,nationality,team,number));


    }

    public static void insertFromCommand1Squad(FootballPlayerRepository repository){

        for (int i =0; i < 2;i++) {

            Scanner scanner = new Scanner(System.in);


            System.out.println("Enter Players name : ["+i+"]");
            String name = scanner.next();

            System.out.println("Enter Players lastname :  ["+i+"]");
            String lastName = scanner.next();

            System.out.println("Enter Players age : ["+i+"]");
            int age = scanner.nextInt();

            System.out.println("Enter Players gender ( 'M' Or 'F' ) : ["+i+"]");
            String gender = scanner.next();

            System.out.println("Enter Players Nationality : ["+i+"]");
            String nationality = scanner.next();

            System.out.println("Enter Player Team That you Play For : ["+i+"]");
            String team = scanner.next();

            System.out.println("Enter Player Number : ["+i+"]");
            int number = scanner.nextInt();


            repository.save(new FootballPlayer(name, lastName, age, gender, nationality, team, number));
        }


    }

    public static void deleteFromTableFootballPlayerWithId(FootballPlayerRepository repository,Long id){

        repository.deleteById(id);
        System.out.println("The id [" + id + "] Was Successfully Deleted");

    }

    public  static void deleteFromTableFootballPlayerFrom_to(FootballPlayerRepository repository,Long i,Long eos){

        for (i = i; i <= eos; i++){

            repository.deleteAllById(Collections.singleton(i));
            System.out.println("The id [" + i + "] Was Successfully Deleted");

        }

    }


    public static void countTheRowsOfTheTable(FootballPlayerRepository repository){

        System.out.println("The size of Table FootballPlayers is : " + repository.count());

    }





}
