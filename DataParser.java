package com.example.helper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataParser {

    private HashMap<String, String> getSingleNearbyPlace(JSONObject googlePlaceJSON)
    {
        HashMap<String, String> googlePlaceMap = new HashMap<>();
        String NameofPlace = "-NA-";
        String Vicinity = "-NA-";
        String latitude = "";
        String longtiude = "";
        String reference = "";
        try {
            if(!googlePlaceJSON.isNull("name")) {
                NameofPlace = googlePlaceJSON.getString("name");
            }
            if(!googlePlaceJSON.isNull(" Vicinity")) {
                Vicinity= googlePlaceJSON.getString(" Vicinity");
            }
            latitude = googlePlaceJSON.getJSONObject("geometry").getJSONObject("location").getString("lat");
           longtiude = googlePlaceJSON.getJSONObject("geometry").getJSONObject("location").getString("lng");
           reference = googlePlaceJSON.getString("reference");

            googlePlaceMap.put("place_name" ,  NameofPlace);
            googlePlaceMap.put("Vicinity" ,  Vicinity);
            googlePlaceMap.put("lat" , latitude );
            googlePlaceMap.put("lng" ,  longtiude);
            googlePlaceMap.put("reference" , reference);

        }catch (JSONException e){
            e.printStackTrace();
        }
        return googlePlaceMap;
    }
    private List<HashMap<String, String>>  getAllNearbyPlaces(JSONArray jsonArray)
    {
        int counter = jsonArray.length();

        List<HashMap<String , String>> NearbyPlaceList = new ArrayList<>();

        HashMap<String , String > NearbyplaceMap = null;
         for (int i=0; i<counter; i++){
             try {
                 NearbyplaceMap = getSingleNearbyPlace((JSONObject) jsonArray.get(i));
                 NearbyPlaceList.add(NearbyplaceMap);
             } catch (JSONException e) {
                 e.printStackTrace();
             }

         }
         return NearbyPlaceList;
    }
    public List<HashMap<String , String>>parse(String jsoNdata){
        JSONArray jsonArray = null;
        JSONObject jsonObject;

        try {
            jsonObject = new JSONObject(jsoNdata);
            jsonArray = jsonObject.getJSONArray("results");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return getAllNearbyPlaces(jsonArray);
    }
}
