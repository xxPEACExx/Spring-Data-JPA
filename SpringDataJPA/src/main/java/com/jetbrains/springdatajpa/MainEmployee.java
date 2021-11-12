package com.jetbrains.springdatajpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class MainEmployee {


    private static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("example-unit");

    public static void main(String[] args) {


    }



    public static void persistEmployees() {


        Employee employee1 = Employee.create("Rose", 3500, "Admin");
//        Employee employee3 = Employee.create("Denise", 2500, "Admin");
//        Employee employee4 = Employee.create("Mike", 4000, "IT");
//        Employee employee5 = Employee.create("Linda", 4500, "Sales");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(employee1);
//        em.persist(employee2);
//        em.persist(employee3);
//        em.persist(employee4);
//        em.persist(employee5);
        em.getTransaction().commit();
        em.close();
    }

    private static void findAllEmployees() {

        System.out.println("-- All employees");
        EntityManager em = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        Root<Employee> employee = query.from(Employee.class);
        query.select(employee).where();
        TypedQuery<Employee> typedQuery = em.createQuery(query);
        typedQuery.getResultList()
                .forEach(System.out::println);
        em.close();
    }

    private static void findAdmins() {
        System.out.println("-- All employees with Pari Players --");
        EntityManager em = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<FootballPlayer> query = cb.createQuery(FootballPlayer.class);
        Root<FootballPlayer> employee = query.from(FootballPlayer.class);
        query.select(employee)
                .where(cb.equal(employee.get("teamPlayFor"), "Paris Saint-Germain"));
        TypedQuery<FootballPlayer> typedQuery = em.createQuery(query);
        typedQuery.getResultList()
                .forEach(System.out::println);
        em.close();
    }
}