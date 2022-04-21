package utils;


import entities.Boat;
import entities.Owner;
import entities.Role;
import entities.User;
import facades.UserFacade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Generate {

    public static void main(String[] args) {

        //UserFacade facade = UserFacade.getUserFacade(EMF_Creator.createEntityManagerFactory());

        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        Owner owner1 = new Owner("Kurt","Gade1","12345678");
        Owner owner2 = new Owner("Lars","Gade2","87654321");

        Boat boat1 = new Boat("2000","WaterBoats","BoatBoat");
        Boat boat2 = new Boat("1000","WaterBoats","SailBoat");
        Boat boat3 = new Boat("BoatBrand","NotABoat","Boaty");
        Boat boat4 = new Boat("BoatBrand","ABoat","Boat");
        Boat boat5 = new Boat("2000","WaterBoats","TheBoat");


        em.getTransaction().begin();
        owner1.addBoat(boat1);
        owner1.addBoat(boat3);
        owner1.addBoat(boat5);
        owner2.addBoat(boat2);
        owner2.addBoat(boat4);

        em.persist(owner1);
        em.persist(owner2);
        em.persist(boat1);
        em.persist(boat2);
        em.persist(boat3);
        em.persist(boat4);
        em.persist(boat5);

        em.getTransaction().commit();

        //System.out.println(facade.getAllOwners());
        //facade.createBoat("newBrand","newMake","newName");

    }

}