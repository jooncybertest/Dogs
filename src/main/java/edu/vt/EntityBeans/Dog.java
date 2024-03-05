/*
 * Created by Osman Balci, Junsoo Kim on 2024.2.8
 * Copyright © 2024 Osman Balci. All rights reserved.
 */
package edu.vt.EntityBeans;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/*
The @Entity annotation designates this class as a JPA Entity POJO class
representing the Movie table in the MoviesDB database.
 */
@Entity

// Name of the database table represented
@Table(name = "Dog")

@NamedQueries({
        // This named query is used in DogFacade
        @NamedQuery(name = "Dog.findByName", query = "SELECT d FROM Dog d WHERE d.name = :name")

})

public class Dog implements Serializable {
    /*
    ========================================================
    Instance variables representing the attributes (columns)
    of the Movie table in the MoviesDB database.

    CREATE TABLE Movie
    (
        id INT UNSIGNED NOT NULL AUTO_INCREMENT,
        title VARCHAR(255) NOT NULL,
        youtube_trailer_id VARCHAR(32) NOT NULL,
        genres VARCHAR(128) NOT NULL,
        release_date DATE NOT NULL,
        director VARCHAR(128) NOT NULL,
        stars VARCHAR(255) NOT NULL,
        film_rating VARCHAR(8) NOT NULL,
        percent_liked VARCHAR(8) NOT NULL,
        PRIMARY KEY (id)
    );

    ========================================================
     */
    private static final long serialVersionUID = 1L;

    // id INT UNSIGNED NOT NULL AUTO_INCREMENT
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @NotNull
    @Column(name = "description")
    private String description;

    @Basic(optional = false)
    @NotNull
    @Column(name = "face_photo_url")
    private String face_photo_url;

    @Basic(optional = false)
    @NotNull
    @Column(name = "full_photo_url")
    private String full_photo_url;

    @Basic(optional = false)
    @NotNull
    @Column(name = "website_url")
    private String website_url;

    // Updated data types for life expectancy fields
    @Basic(optional = false)
    @NotNull
    @Column(name = "min_life_expectancy")
    private Integer min_life_expectancy;

    @Basic(optional = false)
    @NotNull
    @Column(name = "max_life_expectancy")
    private Integer max_life_expectancy;

    @Basic(optional = false)
    @NotNull
    @Column(name = "origin")
    private String origin;

    // Updated data types for weight fields
    @Basic(optional = false)
    @NotNull
    @Column(name = "min_weight_female")
    private Integer min_weight_female;

    @Basic(optional = false)
    @NotNull
    @Column(name = "max_weight_female")
    private Integer max_weight_female;

    @Basic(optional = false)
    @NotNull
    @Column(name = "min_weight_male")
    private Integer min_weight_male;

    @Basic(optional = false)
    @NotNull
    @Column(name = "max_weight_male")
    private Integer max_weight_male;

    // Updated data types for height fields
    @Basic(optional = false)
    @NotNull
    @Column(name = "min_height_female")
    private Integer min_height_female;

    @Basic(optional = false)
    @NotNull
    @Column(name = "max_height_female")
    private Integer max_height_female;

    @Basic(optional = false)
    @NotNull
    @Column(name = "min_height_male")
    private Integer min_height_male;

    @Basic(optional = false)
    @NotNull
    @Column(name = "max_height_male")
    private Integer max_height_male;

    @Basic(optional = false)
    @NotNull
    @Column(name = "colors")
    private String colors;

    @Basic(optional = false)
    @NotNull
    @Column(name = "temperament")
    private String temperament;

    /*
    =============================================================
    Class constructors for instantiating a Dog entity object to
    represent a row in the User table in the DogDB database.
    =============================================================
     */
    // Used in PrepareCreate method in MovieController
    public Dog() {
    }

    // Not used but kept for potential future use
    public Dog(Integer id) {
        this.id = id;
    }

    // Not used but kept for potential future use
    public Dog(Integer id, String title, String description, String face_photo_url, String full_photo_url, String website_url, Integer min_life_expectancy,
                Integer max_life_expectancy, String origin, Integer min_weight_female, Integer max_weight_female, Integer min_weight_male, Integer max_weight_male,
                Integer min_height_female, Integer max_height_female, Integer min_height_male, Integer max_height_male, String colors, String temperament) {
        this.id = id;
        this.name = title;
        this.description = description;
        this.face_photo_url = face_photo_url;
        this.full_photo_url = full_photo_url;
        this.website_url = website_url;
        this.min_life_expectancy = min_life_expectancy;
        this.max_life_expectancy = max_life_expectancy;
        this.origin = origin;
        this.min_weight_female = min_weight_female;
        this.max_weight_female = max_weight_female;
        this.min_weight_male = min_weight_male;
        this.max_weight_male = max_weight_male;
        this.min_height_female = min_height_female;
        this.max_height_female = max_height_female;
        this.min_height_male = min_height_male;
        this.max_height_male = max_height_male;
        this.colors = colors;
        this.temperament = temperament;
    }

    /*
    ======================================================
    Getter and Setter methods for the attributes (columns)
    of the Movie table in the MoviesDB database.
    ======================================================
     */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFace_photo_url() {
        return face_photo_url;
    }

    public void setFace_photo_url(String face_photo_url) {
        this.face_photo_url = face_photo_url;
    }

    public String getFull_photo_url() {
        return full_photo_url;
    }

    public void setFull_photo_url(String full_photo_url) {
        this.full_photo_url = full_photo_url;
    }

    public String getWebsite_url() {
        return website_url;
    }

    public void setWebsite_url(String website_url) {
        this.website_url = website_url;
    }

    public Integer getMin_life_expectancy() {
        return min_life_expectancy;
    }

    public void setMin_life_expectancy(Integer min_life_expectancy) {
        this.min_life_expectancy = min_life_expectancy;
    }

    public Integer getMax_life_expectancy() {
        return max_life_expectancy;
    }

    public void setMax_life_expectancy(Integer max_life_expectancy) {
        this.max_life_expectancy = max_life_expectancy;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Integer getMin_weight_female() {
        return min_weight_female;
    }

    public void setMin_weight_female(Integer min_weight_female) {
        this.min_weight_female = min_weight_female;
    }

    public Integer getMax_weight_female() {
        return max_weight_female;
    }

    public void setMax_weight_female(Integer max_weight_female) {
        this.max_weight_female = max_weight_female;
    }

    public Integer getMin_weight_male() {
        return min_weight_male;
    }

    public void setMin_weight_male(Integer min_weight_male) {
        this.min_weight_male = min_weight_male;
    }

    public Integer getMax_weight_male() {
        return max_weight_male;
    }

    public void setMax_weight_male(Integer max_weight_male) {
        this.max_weight_male = max_weight_male;
    }

    public Integer getMin_height_female() {
        return min_height_female;
    }

    public void setMin_height_female(Integer min_height_female) {
        this.min_height_female = min_height_female;
    }

    public Integer getMax_height_female() {
        return max_height_female;
    }

    public void setMax_height_female(Integer max_height_female) {
        this.max_height_female = max_height_female;
    }

    public Integer getMin_height_male() {
        return min_height_male;
    }

    public void setMin_height_male(Integer min_height_male) {
        this.min_height_male = min_height_male;
    }

    public Integer getMax_height_male() {
        return max_height_male;
    }

    public void setMax_height_male(Integer max_height_male) {
        this.max_height_male = max_height_male;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }
    /*
    ================================
    Instance Methods Used Internally
    ================================
     */

    // Generate and return a hash code value for the object with database primary key id
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /*
     Checks if the Dog object identified by 'object' is the same as the Dog object identified by 'id'
     Parameter object = Dog object identified by 'object'
     Returns True if the Dog 'object' and 'id' are the same; otherwise, return False
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Dog)) {
            return false;
        }
        Dog other = (Dog) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    // Return String representation of database primary key id
    @Override
    public String toString() {
        return id.toString();
    }


}

