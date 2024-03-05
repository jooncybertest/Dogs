/*
 * Copyright (c) 2024. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * Created by Junsoo Kim on 2024.2.22
 * Copyright © 2024 Osman Balci All rights reserved.
 */

package edu.vt.controllers;

import edu.vt.globals.Methods;
import java.io.Serializable;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import org.primefaces.shaded.json.JSONObject;

@Named("randomDogPhotoController")
@SessionScoped

public class RandomDogPhotoController implements Serializable{

    /*
    ===============================
    Instance Variables (Properties)
    ===============================
     */
    private String randomDogPhotoResult;


    /*
    =========================
    Getter and Setter Methods
    =========================
     */

    public String getRandomDogPhotoResult() {
        return randomDogPhotoResult;
    }

    public void setRandomDogPhotoResult(String randomDogPhotoResult) {
        this.randomDogPhotoResult = randomDogPhotoResult;
    }

    /*
    ================
    Instance Methods
    ================
    */

    public void showRandomDogPhoto() {


        // Construct the API URL correctly with a slash before the breed name
        String apiUrl = "https://dog.ceo/api/breeds/image/random";

        try {
            // Obtain the JSON file from the apiUrl
            String jsonData = Methods.readUrlContent(apiUrl);

            // Convert the JSON data into a JSON object
            JSONObject jsonObject = new JSONObject(jsonData);

            // Extract the image URL from the JSON object
            randomDogPhotoResult = jsonObject.getString("message");


        } catch (Exception e) {
            Methods.showMessage("Fatal Error", "Unable to Obtain Random Dog Photo!",
                    "Error: " + e.getMessage());
        }

    }


}
