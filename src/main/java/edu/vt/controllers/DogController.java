/*
 * Created by Osman Balci, Junsoo Kim on 2024.2.8
 * Copyright © 2024 Osman Balci. All rights reserved.
 */
package edu.vt.controllers;

import edu.vt.EntityBeans.Dog;
import edu.vt.FacadeBeans.DogFacade;
import edu.vt.controllers.util.JsfUtil;
import edu.vt.controllers.util.JsfUtil.PersistAction;
import edu.vt.globals.Methods;
import jakarta.ejb.EJB;
import jakarta.ejb.EJBException;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;


import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named("dogController")
@SessionScoped
public class DogController implements Serializable {

    /*
    The @EJB annotation directs the EJB Container Manager to inject (store) the object reference of the
    DogFacade bean into the instance variable 'DogFacade' after it is instantiated at runtime.
     */
    @EJB
    private DogFacade DogFacade;

    /*
    ===============================
    Instance Variables (Properties)
    ===============================
     */
    private List<Dog> listOfDogs = null;
    private Dog selected;
    private Boolean dogDataChanged;

    // searchItems = List of object references of Dog objects found in the search
    private List<Dog> searchItems = null;
    private String searchCategory;

    // searchString contains the character string the user entered for searching the selected searchCategory
    private String searchString;

    private Integer searchType;

    // Search Query Variables (Q = Query)
    private Integer minLifeExpectancyLowestQ;
    private Integer minLifeExpectancyHighestQ;

    private Integer maxLifeExpectancyLowestQ;
    private Integer maxLifeExpectancyHighestQ;

    private String originQ;
    private String colorQ;
    private String temperamentQ;

    private Integer femaleMinWeightQ;
    private Integer femaleMaxWeightQ;

    private Integer maleMinWeightQ;
    private Integer maleMaxWeightQ;

    private Integer femaleMinHeightQ;
    private Integer femaleMaxHeightQ;

    private Integer maleMinHeightQ;
    private Integer maleMaxHeightQ;

    private String website_url;



    /*
    =========================
    Getter and Setter Methods
    =========================
     */
    public List<Dog> getListOfDogs() {
        if (listOfDogs == null) {
            listOfDogs = DogFacade.findAll();

            // Sort the List of Country objects with respect to nameCommon property in alphabetical order
            listOfDogs.sort(Comparator.comparing(Dog::getName));
        }
        return listOfDogs;
    }

    public Dog getSelected() {
        return selected;
    }

    public void setSelected(Dog selected) {
        this.selected = selected;
    }

    public Boolean getDogDataChanged() {
        return dogDataChanged;
    }

    public void setDogDataChanged(Boolean dogDataChanged) {
        this.dogDataChanged = dogDataChanged;
    }

    public Integer getMinLifeExpectancyLowestQ() {
        return minLifeExpectancyLowestQ;
    }

    public void setMinLifeExpectancyLowestQ(Integer minLifeExpectancyLowestQ) {
        this.minLifeExpectancyLowestQ = minLifeExpectancyLowestQ;
    }

    public Integer getMinLifeExpectancyHighestQ() {
        return minLifeExpectancyHighestQ;
    }

    public void setMinLifeExpectancyHighestQ(Integer minLifeExpectancyHighestQ) {
        this.minLifeExpectancyHighestQ = minLifeExpectancyHighestQ;
    }

    public Integer getMaxLifeExpectancyLowestQ() {
        return maxLifeExpectancyLowestQ;
    }

    public void setMaxLifeExpectancyLowestQ(Integer maxLifeExpectancyLowestQ) {
        this.maxLifeExpectancyLowestQ = maxLifeExpectancyLowestQ;
    }

    public Integer getMaxLifeExpectancyHighestQ() {
        return maxLifeExpectancyHighestQ;
    }

    public void setMaxLifeExpectancyHighestQ(Integer maxLifeExpectancyHighestQ) {
        this.maxLifeExpectancyHighestQ = maxLifeExpectancyHighestQ;
    }

    public String getOriginQ() {
        return originQ;
    }

    public void setOriginQ(String originQ) {
        this.originQ = originQ;
    }

    public String getColorQ() {
        return colorQ;
    }

    public void setColorQ(String colorQ) {
        this.colorQ = colorQ;
    }

    public String getTemperamentQ() {
        return temperamentQ;
    }

    public void setTemperamentQ(String temperamentQ) {
        this.temperamentQ = temperamentQ;
    }

    public Integer getFemaleMinWeightQ() {
        return femaleMinWeightQ;
    }

    public void setFemaleMinWeightQ(Integer femaleMinWeightQ) {
        this.femaleMinWeightQ = femaleMinWeightQ;
    }

    public Integer getFemaleMaxWeightQ() {
        return femaleMaxWeightQ;
    }

    public void setFemaleMaxWeightQ(Integer femaleMaxWeightQ) {
        this.femaleMaxWeightQ = femaleMaxWeightQ;
    }

    public Integer getMaleMinWeightQ() {
        return maleMinWeightQ;
    }

    public void setMaleMinWeightQ(Integer maleMinWeightQ) {
        this.maleMinWeightQ = maleMinWeightQ;
    }

    public Integer getMaleMaxWeightQ() {
        return maleMaxWeightQ;
    }

    public void setMaleMaxWeightQ(Integer maleMaxWeightQ) {
        this.maleMaxWeightQ = maleMaxWeightQ;
    }

    public Integer getFemaleMinHeightQ() {
        return femaleMinHeightQ;
    }

    public void setFemaleMinHeightQ(Integer femaleMinHeightQ) {
        this.femaleMinHeightQ = femaleMinHeightQ;
    }

    public Integer getFemaleMaxHeightQ() {
        return femaleMaxHeightQ;
    }

    public void setFemaleMaxHeightQ(Integer femaleMaxHeightQ) {
        this.femaleMaxHeightQ = femaleMaxHeightQ;
    }

    public Integer getMaleMinHeightQ() {
        return maleMinHeightQ;
    }

    public void setMaleMinHeightQ(Integer maleMinHeightQ) {
        this.maleMinHeightQ = maleMinHeightQ;
    }

    public Integer getMaleMaxHeightQ() {
        return maleMaxHeightQ;
    }

    public void setMaleMaxHeightQ(Integer maleMaxHeightQ) {
        this.maleMaxHeightQ = maleMaxHeightQ;
    }

    public String getSearchCategory() {
        return searchCategory;
    }

    public void setSearchCategory(String searchCategory) {
        this.searchCategory = searchCategory;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public Integer getSearchType() {
        return searchType;
    }

    public void setSearchType(Integer searchType) {
        this.searchType = searchType;
    }

    /*
    ================
    Instance Methods
    ================
    */

    /*
     **************************************
     *   Unselect Selected Dog Object   *
     **************************************
     */
    public void unselect() {
        selected = null;
    }

    /*
     *************************************
     *   Cancel and Display List.xhtml   *
     *************************************
     */
    public String cancel() {
        // Unselect previously selected Dog object if any
        selected = null;
        return "/favoriteDogBreeds/List?faces-redirect=true";
    }

    /*
    *****************************
    Prepare to Create a New Dog
    *****************************
    */
    public void prepareCreate() {
        /*
        Instantiate a new Dog object and store its object reference into
        instance variable 'selected'. The Dog class is defined in Dog.java
         */
        selected = new Dog();
    }

    /*
    An enum is a special Java type used to define a group of constants.
    The constants CREATE, DELETE and UPDATE are defined as follows in JsfUtil.java

            public enum PersistAction {
                CREATE,
                DELETE,
                UPDATE
            }
     */
    // remove white space in dogName so that it can be used to show corresponding dog images in view page.
    public String removeWhiteSpaceFromDogName(String dogName){
        if (dogName == null){
            return null;
        }
        return dogName.replaceAll("\\s", "");
    }

    // remove white space in dogName so that it can be used to show corresponding dog images in view page.
    public String changeSpaceToDash(String dogName){
        if (dogName == null){
            return null;
        }
        return dogName.replaceAll("\\s", "-");
    }

    /*
     ***********************************
     *   Create New Dog If Valid   *
     ***********************************
     */
    public void createAfterValidation() throws Exception {


        //---------------------------------------------------
        // Validation is successful to create the new Dog
        //---------------------------------------------------

        create();
    }

    /*
    **********************************
    CREATE a New Dog in the Database
    **********************************
     */
    public void create() {
        Methods.preserveMessages();

        persist(PersistAction.CREATE,"Dog was Successfully Created!");

        if (!JsfUtil.isValidationFailed()) {
            // No JSF validation error. The CREATE operation is successfully performed.
            selected = null;        // Remove selection
            listOfDogs = null;    // Invalidate listOfMovies to trigger re-query.
        }
    }

    /*
    *************************************
    UPDATE Selected Movie in the Database
    *************************************
     */
    public void update() {
        Methods.preserveMessages();

        persist(PersistAction.UPDATE,"Dog was Successfully Updated!");

        if (!JsfUtil.isValidationFailed()) {
            // No JSF validation error. The UPDATE operation is successfully performed.
           selected = null;
           listOfDogs = null;
           dogDataChanged = true;
        }
    }

    /*
    ***************************************
    DELETE Selected Movie from the Database
    ***************************************
     */
    public void destroy() {
        Methods.preserveMessages();

        persist(PersistAction.DELETE,"Dog was Successfully Deleted!");

        if (!JsfUtil.isValidationFailed()) {
            // No JSF validation error. The DELETE operation is successfully performed.
            selected = null;        // Remove selection
            listOfDogs = null;    // Invalidate listOfMovies to trigger re-query.
        }
    }

    /*
     **********************************************************************************************
     *   Perform CREATE, UPDATE (EDIT), and DELETE (DESTROY, REMOVE) Operations in the Database   *
     **********************************************************************************************
     */
    /**
     * @param persistAction refers to CREATE, UPDATE (Edit) or DELETE action
     * @param successMessage displayed to inform the user about the result
     */
    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            try {
                if (persistAction != PersistAction.DELETE) {
                    /*
                     -------------------------------------------------
                     Perform CREATE or EDIT operation in the database.
                     -------------------------------------------------
                     The edit(selected) method performs the SAVE (STORE) operation of the "selected"
                     object in the database regardless of whether the object is a newly
                     created object (CREATE) or an edited (updated) object (EDIT or UPDATE).
                    
                     DogFacade inherits the edit(selected) method from the AbstractFacade class.
                     */
                    DogFacade.edit(selected);
                } else {
                    /*
                     -----------------------------------------
                     Perform DELETE operation in the database.
                     -----------------------------------------
                     The remove(selected) method performs the DELETE operation of the "selected"
                     object in the database.
                    
                     MovieFacade inherits the remove(selected) method from the AbstractFacade class.
                     */
                    DogFacade.remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex,"A persistence error occurred.");
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex,"A persistence error occurred.");
            }
        }
    }

    /*
     *****************************************
     *   Display the Search Results JF Page  *
     *****************************************
     */
    public String search(Integer type) {
        // Set search type given as input parameter
        searchType = type;

        // Unselect previously selected country if any before showing the search results
        selected = null;

        // Invalidate list of search items to trigger re-query.
        searchItems = null;

        return "/favoriteDogBreedsSearch/SearchResults?faces-redirect=true";
    }

    /*
     ****************************************************************************************************
     *   Return the list of object references of all those dogs that satisfy the search criteria   *
     ****************************************************************************************************
     */
    // This is the Getter method for the instance variable searchItems

    public List<Dog> getSearchItems() {
        /*
        =============================================================================================
        You must construct and return the search results List "searchItems" ONLY IF the List is null.
        Any List provided to p:dataTable to display must be returned ONLY IF the List is null
        ===> in order for the column-sort to work. <===
        =============================================================================================
         */
        if (searchItems == null) {
            switch (searchType) {
                case 1: // Search Type 1
                    switch (searchCategory) {
                        case "Name":
                            searchItems = DogFacade.nameQuery(searchString);
                            break;
                        case "Description":
                            searchItems = DogFacade.descriptionQuery(searchString);
                            break;
                        case "Origin":
                            searchItems = DogFacade.originQuery(searchString);
                            break;
                        case "Color":
                            searchItems = DogFacade.colorQuery(searchString);
                            break;
                        case "Temperament":
                            searchItems = DogFacade.temperamentQuery(searchString);
                            break;
                        default:
                            searchItems = DogFacade.allQuery(searchString);
                    }
                    break;
                case 2: // Search Type 2
                    searchItems = DogFacade.type2SearchQuery(minLifeExpectancyLowestQ, minLifeExpectancyHighestQ, maxLifeExpectancyLowestQ, maxLifeExpectancyHighestQ);
                    break;
                case 3: // Search Type 3
                    searchItems = DogFacade.type3SearchQuery(originQ, colorQ, temperamentQ);
                    break;
                case 4: // Search Type 4
                    searchItems = DogFacade.type4SearchQuery(femaleMinWeightQ, femaleMaxWeightQ);
                    break;
                case 5: // Search Type 5
                    searchItems = DogFacade.type5SearchQuery(maleMinWeightQ, maleMaxWeightQ);
                    break;
                case 6: // Search Type 6
                    searchItems = DogFacade.type6SearchQuery(femaleMinHeightQ, femaleMaxHeightQ);
                    break;
                case 7: // Search Type 7
                    searchItems = DogFacade.type7SearchQuery(maleMinHeightQ, maleMaxHeightQ);
                    break;
                default:
                    Methods.showMessage("Fatal Error", "Search Type is Out of Range!",
                            "");
            }
        }
        return searchItems;
    }

}
