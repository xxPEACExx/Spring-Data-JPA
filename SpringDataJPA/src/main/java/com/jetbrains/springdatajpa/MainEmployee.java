package com.jetbrains.springdatajpa;

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
        try {
            persistEmployees();
            findAllEmployees();
            findAdmins();
        } finally {
            entityManagerFactory.close();
        }
    }

    public static void persistEmployees() {

        Employee employee1 = Employee.create("Diana", 2000, "IT");
        Employee employee2 = Employee.create("Rose", 3500, "Admin");
        Employee employee3 = Employee.create("Denise", 2500, "Admin");
        Employee employee4 = Employee.create("Mike", 4000, "IT");
        Employee employee5 = Employee.create("Linda", 4500, "Sales");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(employee1);
        em.persist(employee2);
        em.persist(employee3);
        em.persist(employee4);
        em.persist(employee5);
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
        System.out.println("-- All employees with 'Admin' dept --");
        EntityManager em = entityManagerFactory.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        Root<Employee> employee = query.from(Employee.class);
        query.select(employee)
                .where(cb.equal(employee.get("dept"), "Admin"));
        TypedQuery<Employee> typedQuery = em.createQuery(query);
        typedQuery.getResultList()
                .forEach(System.out::println);
        em.close();
    }
}