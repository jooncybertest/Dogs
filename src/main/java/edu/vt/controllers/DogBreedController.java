/*
 * Created by Junsoo Kim on 2024.2.8
 * Copyright © 2024 Osman Balci. All rights reserved.
 */
package edu.vt.controllers;

import edu.vt.globals.Methods;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import org.primefaces.shaded.json.JSONObject;

@Named("dogBreedController")
@SessionScoped

public class DogBreedController implements Serializable {
    /*
    ===============================
    Instance Variables (Properties)
    ===============================
     */
    // Provided by the user
    private String dogBreed;


    // Computed in this class
    private String dogBreedResult;

    private String randomDogPhoto;

    private String randomDogPhotoResult;

    // Used for processing
    /*
     The following list of currencies with IDs is obtained from the CurrencyLayer API.
     It is provided as a constant list to prevent unnecessary API access.
     */
    //
    private final List<String> listOfDogBreedNames = Arrays.asList("affenpinscher","african","airedale","akita","appenzeller","australian/shepherd","basenji","beagle","bluetick","borzoi","bouvier","boxer","brabancon","briard","buhund/norwegian","bulldog/boston","bulldog/english","bulldog/french","bullterrier/staffordshire","cattledog/australian","chihuahua","chow","clumber","cockapoo","collie/border","coonhound","corgi/cardigan","cotondetulear","dachshund","dalmatian","dane/great","deerhound/scottish","dhole","dingo","doberman","elkhound/norwegian","entlebucher","eskimo","finnish/lapphund","frise/bichon","germanshepherd","greyhound/italian","groenendael","havanese","hound/afghan","hound/basset","hound/blood","hound/english","hound/ibizan","hound/plott","hound/walker","husky","keeshond","kelpie","komondor","kuvasz","labradoodle","labrador","leonberg","lhasa","malamute","malinois","maltese","mastiff/bull","mastiff/english","mastiff/tibetan","mexicanhairless","mix","mountain/bernese","mountain/swiss","newfoundland","otterhound","ovcharka/caucasian","papillon","pekinese","pembroke","pinscher/miniature","pitbull","pointer/german","pointer/germanlonghair","pomeranian","poodle/medium","poodle/miniature","poodle/standard","poodle/toy","pug","puggle","pyrenees","redbone","retriever/chesapeake","retriever/curly","retriever/flatcoated","retriever/golden","ridgeback/rhodesian","rottweiler","saluki","samoyed","schipperke","schnauzer/giant","schnauzer/miniature","setter/english","setter/gordon","setter/irish","sharpei","sheepdog/english","sheepdog/shetland","shiba","shihtzu","spaniel/blenheim","spaniel/brittany","spaniel/cocker","spaniel/irish","spaniel/japanese","spaniel/sussex","spaniel/welsh","springer/english","stbernard","terrier/american","terrier/australian","terrier/bedlington","terrier/border","terrier/cairn","terrier/dandie","terrier/fox","terrier/irish","terrier/kerryblue","terrier/lakeland","terrier/norfolk","terrier/norwich","terrier/patterdale","terrier/russell","terrier/scottish","terrier/sealyham","terrier/silky","terrier/tibetan","terrier/toy","terrier/welsh","terrier/westhighland","terrier/wheaten","terrier/yorkshire","tervuren","vizsla","waterdog/spanish","weimaraner","whippet","wolfhound/irish");

    /*
    =========================
    Getter and Setter Methods
    =========================
     */

    public String getDogBreed() {
        return dogBreed;
    }

    public void setDogBreed(String dogBreed) {
        this.dogBreed = dogBreed;
    }

    public String getDogBreedResult() {
        return dogBreedResult;
    }

    public void setDogBreedResult(String dogBreedResult) {
        this.dogBreedResult = dogBreedResult;
    }

    public List<String> getListOfDogBreedNames() {
        return listOfDogBreedNames;
    }

    /*
    ===============
    Instance Methods
    ===============
    */
    public void showRandomDogBreedPhoto() {

        String breedName = dogBreed.toLowerCase().trim();

        breedName = breedName.replaceAll("\\s+", "-");

        // Construct the API URL correctly with a slash before the breed name
        String apiUrl = "https://dog.ceo/api/breed/" + breedName + "/images/random";

        try {
            // Obtain the JSON file from the apiUrl
            String jsonData = Methods.readUrlContent(apiUrl);

            // Convert the JSON data into a JSON object
            JSONObject jsonObject = new JSONObject(jsonData);

            // Extract the image URL from the JSON object
            dogBreedResult = jsonObject.getString("message");


        } catch (Exception e) {
            Methods.showMessage("Fatal Error", "Unable to Obtain Random Dog Breed Photo!",
                    "Error: " + e.getMessage());
        }

    }









}
