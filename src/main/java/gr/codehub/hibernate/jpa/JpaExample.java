package gr.codehub.hibernate.jpa;

import gr.codehub.hibernate.jpa.jpa.JpaUtil;
import gr.codehub.hibernate.jpa.scenario.Scenario;

import javax.persistence.EntityManager;

public class JpaExample {
    public static void main(String[] args) {


        EntityManager em   =JpaUtil.getEntityManager();
         Scenario scenario =  new Scenario(em);
         scenario.useCaseCreateInventory();
         scenario.useCaseCreateCustomers();
         scenario.useCaseCreatePurchase();

         scenario.showData();

         em.close();
        JpaUtil.shutdown();
        System.out.println("end");

    }

}