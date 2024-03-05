/*
 * Created by Osman Balci, Junsoo Kim on 2024.2.8
 * Copyright © 2024 Osman Balci. All rights reserved.
 */
package edu.vt.FacadeBeans;

import edu.vt.EntityBeans.Dog;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

// @Stateless annotation implies that the conversational state with the client shall not be maintained.
@Stateless
public class DogFacade extends AbstractFacade<Dog> {
    /*
    ---------------------------------------------------------------------------------------------
    The EntityManager is an API that enables database CRUD (Create Read Update Delete) operations
    and complex database searches. An EntityManager instance is created to manage entities
    that are defined by a persistence unit. The @PersistenceContext annotation below associates
    the entityManager instance with the persistence unitName identified below.
    ---------------------------------------------------------------------------------------------
     */
    @PersistenceContext(unitName = "Dogs-JunsooPU")
    private EntityManager entityManager;

    // Obtain the object reference of the EntityManager instance in charge of
    // managing the entities in the persistence context identified above.
    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    /*
    This constructor method invokes its parent AbstractFacade's constructor method,
    which in turn initializes its entity class type T and entityClass instance variable.
     */
    public DogFacade() {
        super(Dog.class);
    }

    /*
     *********************
     *   Other Methods   *
     *********************
     */

    // Returns the object reference of the Dog object whose name is dog_name
    public Dog findByDogName(String dog_name) {
        /*
        The following @NamedQuery definition is given in Dog.java entity class file:
        @NamedQuery(name = "Dog.findByName", query = "SELECT d FROM Dog d WHERE d.name = :name")
         */

        if (entityManager.createNamedQuery("Dog.findByName")
                .setParameter("name", dog_name)
                .getResultList().isEmpty()) {

            // Return null if no country object exists by the name of dog_name
            return null;

        } else {

            // Return the Object reference of the country object whose name is country_name
            return (Dog) (entityManager.createNamedQuery("Dog.findByName")
                    .setParameter("name", dog_name)
                    .getSingleResult());
        }
    }

    /*
     ***************************
     *   Search Query Type 1   *
     ***************************
     */

    /*
    -----------------------------
    Search Category: DOG NAME
    -----------------------------
     */
    // Searches DogsDB for dogs where Dog name contains the searchString entered by the user.
    public List nameQuery(String searchString) {
        // Place the % wildcard before and after the search string to search for it anywhere in the Dog name
        searchString = "%" + searchString + "%";
        // Conduct the search in a case-insensitive manner and return the results in a list.
        return getEntityManager().createQuery(
                        "SELECT d FROM Dog d WHERE d.name LIKE :searchString")
                .setParameter("searchString", searchString)
                .getResultList();
    }

    /*
    -----------------------------
    Search Category: DESCRIPTION
    -----------------------------
     */
    // Searches DogsDB for dogs where Dogs' description contains the searchString entered by the user.
    public List descriptionQuery(String searchString) {
        // Place the % wildcard before and after the search string to search for it anywhere in the capital city name
        searchString = "%" + searchString + "%";
        // Conduct the search in a case-insensitive manner and return the results in a list.
        return getEntityManager().createQuery(
                        "SELECT d FROM Dog d WHERE d.description LIKE :searchString")
                .setParameter("searchString", searchString)
                .getResultList();
    }

    /*
    -------------------------
    Search Category: ORIGIN
    -------------------------
     */
    // Searches DogsDB for dogs where origin contains the searchString entered by the user.
    public List originQuery(String searchString) {
        // Place the % wildcard before and after the search string to search for it anywhere in the language name
        searchString = "%" + searchString + "%";
        // Conduct the search in a case-insensitive manner and return the results in a list.
        return getEntityManager().createQuery(
                        "SELECT d FROM Dog d WHERE d.origin LIKE :searchString")
                .setParameter("searchString", searchString)
                .getResultList();
    }

    /*
    -------------------------
    Search Category: Color
    -------------------------
     */
    // Searches DogsDB for dogs where color contains the searchString entered by the user.
    public List colorQuery(String searchString) {
        // Place the % wildcard before and after the search string to search for it anywhere in the currency name
        searchString = "%" + searchString + "%";
        // Conduct the search in a case-insensitive manner and return the results in a list.
        return getEntityManager().createQuery(
                        "SELECT d FROM Dog d WHERE d.colors LIKE :searchString")
                .setParameter("searchString", searchString)
                .getResultList();
    }

    /*
    --------------------
    Search Category: TEMPERAMENT
    --------------------
     */
    // Searches DogsDB for dogs where temperament contains the searchString entered by the user.
    public List temperamentQuery(String searchString) {
        // Place the % wildcard before and after the search string to search for it anywhere in the currency name
        searchString = "%" + searchString + "%";
        // Conduct the search in a case-insensitive manner and return the results in a list.
        return getEntityManager().createQuery(
                        "SELECT d FROM Dog d WHERE d.temperament LIKE :searchString")
                .setParameter("searchString", searchString)
                .getResultList();
    }

    /*
    --------------------
    Search Category: ALL
    --------------------
     */
    // Searches DogsDB for dogs where Dog name OR Description OR Origin OR Color Or Temperament contains the searchString entered by the user.
    public List allQuery(String searchString) {
        // Place the % wildcard before and after the search string to search for it anywhere in each attribute name
        searchString = "%" + searchString + "%";
        // Conduct the search in a case-insensitive manner and return the results in a list.
        return getEntityManager().createQuery(
                        "SELECT d FROM Dog d WHERE d.name LIKE :searchString OR d.description LIKE :searchString OR d.origin LIKE :searchString OR d.colors LIKE :searchString OR d.temperament LIKE :searchString")
                .setParameter("searchString", searchString)
                .getResultList();
    }

    /*
     ***************************
     *   Search Query Type 2   *
     ***************************
     */
    public List type2SearchQuery(Integer minLifeExpectancyLowestQ, Integer minLifeExpectancyHighestQ, Integer maxLifeExpectancyLowestQ, Integer maxLifeExpectancyHighestQ ) {

        return getEntityManager().createQuery(
                        "SELECT d FROM Dog d WHERE d.min_life_expectancy BETWEEN :minLifeExpectancyLowestQ AND :minLifeExpectancyHighestQ AND d.max_life_expectancy BETWEEN :maxLifeExpectancyLowestQ AND :maxLifeExpectancyHighestQ")
                .setParameter("minLifeExpectancyLowestQ", minLifeExpectancyLowestQ)
                .setParameter("minLifeExpectancyHighestQ", minLifeExpectancyHighestQ)
                .setParameter("maxLifeExpectancyLowestQ", maxLifeExpectancyLowestQ)
                .setParameter("maxLifeExpectancyHighestQ", maxLifeExpectancyHighestQ)
                .getResultList();
    }

    /*
     ***************************
     *   Search Query Type 3   *
     ***************************
     */
    public List type3SearchQuery(String originQ, String colorQ, String temperamentQ) {

        return getEntityManager().createQuery(
                        "SELECT d FROM Dog d WHERE d.origin LIKE CONCAT('%', :originQ, '%') AND d.colors LIKE CONCAT('%', :colorQ, '%') AND d.temperament LIKE CONCAT('%', :temperamentQ, '%')"
                )
                .setParameter("originQ", originQ)
                .setParameter("colorQ", colorQ)
                .setParameter("temperamentQ", temperamentQ)
                .getResultList();
    }

    /*
     ***************************
     *   Search Query Type 4   *
     ***************************
     */
    public List type4SearchQuery(Integer femaleMinWeightQ, Integer femaleMaxWeightQ) {

        return getEntityManager().createQuery(
                        "SELECT d FROM Dog d WHERE d.min_weight_female >= :femaleMinWeightQ AND d.max_weight_female <= :femaleMaxWeightQ")
                .setParameter("femaleMinWeightQ", femaleMinWeightQ)
                .setParameter("femaleMaxWeightQ", femaleMaxWeightQ)
                .getResultList();
    }

    /*
     ***************************
     *   Search Query Type 5   *
     ***************************
     */
    public List type5SearchQuery(Integer maleMinWeightQ, Integer maleMaxWeightQ) {

        return getEntityManager().createQuery(
                        "SELECT d FROM Dog d WHERE d.min_weight_male >= :maleMinWeightQ AND d.max_weight_male <= :maleMaxWeightQ")
                .setParameter("maleMinWeightQ", maleMinWeightQ)
                .setParameter("maleMaxWeightQ", maleMaxWeightQ)
                .getResultList();
    }

    /*
     ***************************
     *   Search Query Type 6   *
     ***************************
     */
    public List type6SearchQuery(Integer femaleMinHeightQ, Integer femaleMaxHeightQ) {

        return getEntityManager().createQuery(
                        "SELECT d FROM Dog d WHERE d.min_height_female >= :femaleMinHeightQ AND d.max_height_female <= :femaleMaxHeightQ")
                .setParameter("femaleMinHeightQ", femaleMinHeightQ)
                .setParameter("femaleMaxHeightQ", femaleMaxHeightQ)
                .getResultList();
    }

    /*
     ***************************
     *   Search Query Type 7   *
     ***************************
     */
    public List type7SearchQuery(Integer maleMinHeightQ, Integer maleMaxHeightQ) {

        return getEntityManager().createQuery(
                        "SELECT d FROM Dog d WHERE d.min_height_male >= :maleMinHeightQ AND d.max_height_male <= :maleMaxHeightQ")
                .setParameter("maleMinHeightQ", maleMinHeightQ)
                .setParameter("maleMaxHeightQ", maleMaxHeightQ)
                .getResultList();
    }

}
