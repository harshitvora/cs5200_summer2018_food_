package edu.neu.cs5200.dao;

import edu.neu.cs5200.entity.Restaurant;
import edu.neu.cs5200.repository.RestaurantRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

@Component
public class RestaurantDao {

    private String API_KEY = "8ba55b6038a3bc12b9d4a30c883964ec";
    
    @Autowired
    RestaurantRepository restaurantRepository;

    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public Restaurant updateRestaurant(int id, Restaurant newRestaurant) {
        Optional<Restaurant> optional = restaurantRepository.findById(id);
        if (optional.isPresent()) {
            Restaurant restaurant = optional.get();
            restaurant.set(newRestaurant);
            return restaurantRepository.save(restaurant);
        }
        return null;
    }

    public void deleteRestaurant(int id) {
        restaurantRepository.deleteById(id);
    }

    public void deleteAllRestaurantes() {
        restaurantRepository.deleteAll();
    }

    public List<Restaurant> findAllRestaurants() {
        return (List<Restaurant>) restaurantRepository.findAll();
    }

    public Optional<Restaurant> findRestaurantById(int id) {
        return restaurantRepository.findById(id);
    }

    public Optional<Restaurant> findRestaurantByManagerId(int managedId){
        return restaurantRepository.findByManagerId(managedId);
    }

    public Restaurant searchRestaurantByZomatoId(Integer restaurantZomatoId){
        String jsonOutput = "";
        String apiUrl = "https://developers.zomato.com/api/v2.1/restaurant?res_id=" + restaurantZomatoId;
        Restaurant restaurant = new Restaurant();

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("user-key", " "+ API_KEY);
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output;
            while ((output = br.readLine()) != null) {
                jsonOutput += output;
            }
            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            JSONObject jsonObject = new JSONObject(jsonOutput);
            int res_id = jsonObject.getJSONObject("R").getInt("res_id");
            int averageCostForTwo = jsonObject.getInt("average_cost_for_two");
            Double aggregateRating = jsonObject.getJSONObject("user_rating").getDouble("aggregate_rating");
            JSONObject location = jsonObject.getJSONObject("location");
            Double latitude = location.getDouble("latitude");
            Double longitude = location.getDouble("longitude");
            String restaurantName = jsonObject.getString("name");
            String imageUrl = jsonObject.getString("featured_image");
            restaurant.setId(res_id);
            restaurant.setAvgCostForTwo(averageCostForTwo);
            restaurant.setAggregateRating(aggregateRating);
            restaurant.setName(restaurantName);
            restaurant.setLatitude(latitude);
            restaurant.setLongitude(longitude);
            restaurant.setImageUrl(imageUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restaurant;
    }
}
