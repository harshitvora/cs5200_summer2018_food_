package edu.neu.cs5200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import edu.neu.cs5200.entity.Restaurant;

// https://developers.zomato.com/documentation#!/

public class ZomatoApp{

	// TODO
	// create a config file for key
	String API_KEY = "8ba55b6038a3bc12b9d4a30c883964ec";
	// Boston = 289
//    "latitude": 42.358028,
//    "longitude": -71.060417,
	// NYC = 280
//	  "latitude": "40.742051",
//	  "longitude": "-74.004821",


	public String getCategories(){

//		Implementation Notes
//		Get a list of categories.
//		List of all restaurants categorized under a
//		particular restaurant type can be obtained using
//		/Search API with Category ID as inputs

		String api_url = "https://developers.zomato.com/api/v2.1/categories";
		String json_output = "";
		JSONObject jsonObject = new JSONObject();
		try {
			URL url = new URL(api_url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("user-key", " "+ API_KEY);

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output;
			// System.out.println("Output from API .... \n");
			while ((output = br.readLine()) != null) {
				// System.out.println(output);
				json_output += output;
			}

			conn.disconnect();

		  } catch (MalformedURLException e) {
			e.printStackTrace();
		  } catch (IOException e) {
			e.printStackTrace();
		  }

		return json_output;
	}

public String getCityDetails(String city){

//	Implementation Notes
//	Find the Zomato ID and other details for a city .
//	You can obtain the Zomato City ID in one of the following ways:
//
//	City Name in the Search Query - Returns list of cities matching the query
//	Using coordinates - Identifies the city details based on the coordinates of
//	any location inside a city
//	If you already know the Zomato City ID, this API can be used to get
//	other details of the city.

		String json_output = "";
		String api_url = "https://developers.zomato.com/api/v2.1/cities?q=" + city + "&count=1";

		try {
			URL url = new URL(api_url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("user-key", " "+ API_KEY);

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output;
			// System.out.println("Output from API .... \n");
			while ((output = br.readLine()) != null) {
				// System.out.println(output);
				json_output += output;
			}

			conn.disconnect();

		  } catch (MalformedURLException e) {
			e.printStackTrace();
		  } catch (IOException e) {
			e.printStackTrace();
		  }

		return json_output;
	}

public String getCuisinesinCity(Integer cityId){

//	Implementation Notes
//	Get a list of all cuisines of restaurants listed in a city.
//	The location/city input can be provided in the following ways -
//
//	Using Zomato City ID
//	Using coordinates of any location within a city
//	List of all restaurants serving a particular cuisine can be
//	obtained using '/search' API with cuisine ID and location details

		String json_output = "";
		String api_url = "https://developers.zomato.com/api/v2.1/cuisines?city_id=" + cityId;

		try {
			URL url = new URL(api_url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("user-key", " "+ API_KEY);

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output;
			// System.out.println("Output from API .... \n");
			while ((output = br.readLine()) != null) {
				// System.out.println(output);
				json_output += output;
			}

			conn.disconnect();

		  } catch (MalformedURLException e) {
			e.printStackTrace();
		  } catch (IOException e) {
			e.printStackTrace();
		  }

		return json_output;
	}

public String getEstablishmentsinCity(Integer cityId){

//	Implementation Notes
//	Get a list of restaurant types in a city.
//	The location/City input can be provided in the following ways -
//
//	Using Zomato City ID
//	Using coordinates of any location within a city
//	List of all restaurants categorized under a particular restaurant
//	type can obtained using /Search API with Establishment ID and
//	location details as inputs

		String json_output = "";
		String api_url = "https://developers.zomato.com/api/v2.1/establishments?city_id=" + cityId;

		try {
			URL url = new URL(api_url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("user-key", " "+ API_KEY);

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output;
			// System.out.println("Output from API .... \n");
			while ((output = br.readLine()) != null) {
				// System.out.println(output);
				json_output += output;
			}

			conn.disconnect();

		  } catch (MalformedURLException e) {
			e.printStackTrace();
		  } catch (IOException e) {
			e.printStackTrace();
		  }

		return json_output;
	}

public String getLocation(String city){

//	Implementation Notes
//	Search for Zomato locations by keyword.
//	Provide coordinates to get better search results

	// TODO
	// handle cities with spaces = e.g. New York City
	// https://developers.zomato.com/api/v2.1/locations?query=New%20York

		String json_output = "";
		String api_url = "https://developers.zomato.com/api/v2.1/locations?query=" + city;

		try {
			URL url = new URL(api_url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("user-key", " "+ API_KEY);

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output;
			// System.out.println("Output from API .... \n");
			while ((output = br.readLine()) != null) {
				// System.out.println(output);
				json_output += output;
			}

			conn.disconnect();

		  } catch (MalformedURLException e) {
			e.printStackTrace();
		  } catch (IOException e) {
			e.printStackTrace();
		  }

		return json_output;
	}

public String getRestaurantInformation(Integer restaurantId){

//	Implementation Notes
//	Get detailed restaurant information using Zomato restaurant ID.
//	Partner Access is required to access photos and reviews.

	// e.g. restaurantId = 16774318

		String json_output = "";
		String api_url = "https://developers.zomato.com/api/v2.1/restaurant?res_id=" + restaurantId;

		try {
			URL url = new URL(api_url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("user-key", " "+ API_KEY);

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output;
			// System.out.println("Output from API .... \n");
			while ((output = br.readLine()) != null) {
				// System.out.println(output);
				json_output += output;
			}

			conn.disconnect();

		  } catch (MalformedURLException e) {
			e.printStackTrace();
		  } catch (IOException e) {
			e.printStackTrace();
		  }

		return json_output;
	}

public String getRestaurantReviews(Integer restaurantId) throws JSONException{

//	Implementation Notes
//	Get restaurant reviews using the Zomato restaurant ID.
//	Only 5 latest reviews are available under the Basic API plan.


	// e.g. restaurantId = 16774318

		String json_output = "";
		String api_url = "https://developers.zomato.com/api/v2.1/reviews?res_id=" + restaurantId;

		try {
			URL url = new URL(api_url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("user-key", " "+ API_KEY);

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output;
			// System.out.println("Output from API .... \n");
			while ((output = br.readLine()) != null) {
				// System.out.println(output);
				json_output += output;
			}

			conn.disconnect();

		  } catch (MalformedURLException e) {
			e.printStackTrace();
		  } catch (IOException e) {
			e.printStackTrace();
		  }




		JSONObject obj;
		try {
			obj = new JSONObject(json_output);
			Integer n = obj.getInt("reviews_count");
			System.out.println(n);
//			obj.getJSONArray("user_reviews")
//		    .getJSONObject("review")
//		    .getJSONArray("entry");

//			NBAPlayers players = new NBAPlayers();
//		    JSONObject League = obj.getJSONObject("league");
//		    JSONObject standard =League.getJSONObject("standard");
//		    JSONObject firstName = standard.getJSONObject("firstName");

			JSONArray user_reviews = obj.getJSONArray("user_reviews");

			int length = user_reviews.length();

			//loop to get all json objects from data json array
			for(int i=0; i<length; i++){
			    JSONObject jObj = user_reviews.getJSONObject(i);
			    // System.out.println(jObj);

			    JSONObject tmp = new JSONObject();
			    tmp = jObj.getJSONObject("review");


//			    JSONObject rename = new JSONObject();
//			    rename = tmp.getJSONObject("rating_text");
			    System.out.println(i);
			    System.out.println(tmp.getString("review_text"));


			}

			System.out.println(user_reviews);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return json_output;
	}

// TODO
// figure out how restaurant/search will be used.
// can have multiple use cases.

public String searchforRestaurants(Integer restaurantId){

//	Implementation Notes
//	The location input can be specified using Zomato location ID or coordinates.
//	Cuisine / Establishment / Collection IDs can be obtained from respective api calls.
//	Get up to 100 restaurants by changing the 'start' and 'count' parameters
//	with the maximum value of count being 20. Partner Access is required to access
//	photos and reviews.
//	Examples:
//
//	To search for 'Italian' restaurants in 'Manhattan, New York City', set cuisines = 55, entity_id = 94741 and entity_type = zone
//	To search for 'cafes' in 'Manhattan, New York City', set establishment_type = 1, entity_type = zone and entity_id = 94741
//	Get list of all restaurants in 'Trending this Week' collection in 'New York City' by using entity_id = 280, entity_type = city and collection_id = 1


	// e.g. restaurantId = 16774318

		String json_output = "";
		String api_url = "https://developers.zomato.com/api/v2.1/reviews?res_id=" + restaurantId;

		try {
			URL url = new URL(api_url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("user-key", " "+ API_KEY);

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output;
			// System.out.println("Output from API .... \n");
			while ((output = br.readLine()) != null) {
				// System.out.println(output);
				json_output += output;
			}

			conn.disconnect();

		  } catch (MalformedURLException e) {
			e.printStackTrace();
		  } catch (IOException e) {
			e.printStackTrace();
		  }

		return json_output;
	}








// Sunday August 13, 2018

//https://developers.zomato.com/api/v2.1/cuisines?lat=42.35&lon=-71.06

public List<String> getCuisinesinCitybyLatLong(double latitude, double longitude){

//	Implementation Notes
//	Get a list of all cuisines of restaurants listed in a city.
//	The location/city input can be provided in the following ways -
//
//	Using Zomato City ID or lat and long
//	Using coordinates of any location within a city
//	List of all restaurants serving a particular cuisine can be
//	obtained using '/search' API with cuisine ID and location details

		String json_output = "";
		String api_url = "https://developers.zomato.com/api/v2.1/cuisines?lat="
				+ latitude + "&lon=" + longitude;

		List<String> cuisines_list = new ArrayList<>();

		try {
			URL url = new URL(api_url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("user-key", " "+ API_KEY);

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output;
			// System.out.println("Output from API .... \n");
			while ((output = br.readLine()) != null) {
				// System.out.println(output);
				json_output += output;
			}

			conn.disconnect();

		  } catch (MalformedURLException e) {
			e.printStackTrace();
		  } catch (IOException e) {
			e.printStackTrace();
		  }

		JSONObject obj;
		//{"cuisines":[{"cuisine":{"cuisine_id":6,"cuisine_name":"Afghani"}},{"cuisine":{"cuisine_id":152,"cuisine_name":"African"}},{"cuisine":{"cuisine_id":1,"cuisine_name":"American"}},{"cuisine":{"cuisine_id":151,"cuisine_name":"Argentine"}},{"cuisine":{"cuisine_id":175,"cuisine_name":"Armenian"}},{"cuisine":{"cuisine_id":3,"cuisine_name":"Asian"}},{"cuisine":{"cuisine_id":131,"cuisine_name":"Australian"}},{"cuisine":{"cuisine_id":193,"cuisine_name":"BBQ"}},{"cuisine":{"cuisine_id":955,"cuisine_name":"Bagels"}},{"cuisine":{"cuisine_id":5,"cuisine_name":"Bakery"}},{"cuisine":{"cuisine_id":227,"cuisine_name":"Bar Food"}},{"cuisine":{"cuisine_id":270,"cuisine_name":"Beverages"}},{"cuisine":{"cuisine_id":159,"cuisine_name":"Brazilian"}},{"cuisine":{"cuisine_id":182,"cuisine_name":"Breakfast"}},{"cuisine":{"cuisine_id":133,"cuisine_name":"British"}},{"cuisine":{"cuisine_id":247,"cuisine_name":"Bubble Tea"}},{"cuisine":{"cuisine_id":168,"cuisine_name":"Burger"}},{"cuisine":{"cuisine_id":22,"cuisine_name":"Burmese"}},{"cuisine":{"cuisine_id":30,"cuisine_name":"Cafe"}},{"cuisine":{"cuisine_id":491,"cuisine_name":"Cajun"}},{"cuisine":{"cuisine_id":956,"cuisine_name":"California"}},{"cuisine":{"cuisine_id":111,"cuisine_name":"Cambodian"}},{"cuisine":{"cuisine_id":121,"cuisine_name":"Cantonese"}},{"cuisine":{"cuisine_id":158,"cuisine_name":"Caribbean"}},{"cuisine":{"cuisine_id":229,"cuisine_name":"Chilean"}},{"cuisine":{"cuisine_id":25,"cuisine_name":"Chinese"}},{"cuisine":{"cuisine_id":161,"cuisine_name":"Coffee and Tea"}},{"cuisine":{"cuisine_id":287,"cuisine_name":"Colombian"}},{"cuisine":{"cuisine_id":928,"cuisine_name":"Creole"}},{"cuisine":{"cuisine_id":881,"cuisine_name":"Crepes"}},{"cuisine":{"cuisine_id":153,"cuisine_name":"Cuban"}},{"cuisine":{"cuisine_id":192,"cuisine_name":"Deli"}},{"cuisine":{"cuisine_id":100,"cuisine_name":"Desserts"}},{"cuisine":{"cuisine_id":411,"cuisine_name":"Dim Sum"}},{"cuisine":{"cuisine_id":541,"cuisine_name":"Diner"}},{"cuisine":{"cuisine_id":958,"cuisine_name":"Dominican"}},{"cuisine":{"cuisine_id":959,"cuisine_name":"Donuts"}},{"cuisine":{"cuisine_id":268,"cuisine_name":"Drinks Only"}},{"cuisine":{"cuisine_id":651,"cuisine_name":"Eastern European"}},{"cuisine":{"cuisine_id":316,"cuisine_name":"Ecuadorian"}},{"cuisine":{"cuisine_id":149,"cuisine_name":"Ethiopian"}},{"cuisine":{"cuisine_id":38,"cuisine_name":"European"}},{"cuisine":{"cuisine_id":40,"cuisine_name":"Fast Food"}},{"cuisine":{"cuisine_id":112,"cuisine_name":"Filipino"}},{"cuisine":{"cuisine_id":45,"cuisine_name":"French"}},{"cuisine":{"cuisine_id":501,"cuisine_name":"Frozen Yogurt"}},{"cuisine":{"cuisine_id":274,"cuisine_name":"Fusion"}},{"cuisine":{"cuisine_id":134,"cuisine_name":"German"}},{"cuisine":{"cuisine_id":156,"cuisine_name":"Greek"}},{"cuisine":{"cuisine_id":521,"cuisine_name":"Hawaiian"}},{"cuisine":{"cuisine_id":143,"cuisine_name":"Healthy Food"}},{"cuisine":{"cuisine_id":233,"cuisine_name":"Ice Cream"}},{"cuisine":{"cuisine_id":148,"cuisine_name":"Indian"}},{"cuisine":{"cuisine_id":114,"cuisine_name":"Indonesian"}},{"cuisine":{"cuisine_id":154,"cuisine_name":"International"}},{"cuisine":{"cuisine_id":140,"cuisine_name":"Iranian"}},{"cuisine":{"cuisine_id":135,"cuisine_name":"Irish"}},{"cuisine":{"cuisine_id":55,"cuisine_name":"Italian"}},{"cuisine":{"cuisine_id":207,"cuisine_name":"Jamaican"}},{"cuisine":{"cuisine_id":60,"cuisine_name":"Japanese"}},{"cuisine":{"cuisine_id":265,"cuisine_name":"Jewish"}},{"cuisine":{"cuisine_id":164,"cuisine_name":"Juices"}},{"cuisine":{"cuisine_id":178,"cuisine_name":"Kebab"}},{"cuisine":{"cuisine_id":67,"cuisine_name":"Korean"}},{"cuisine":{"cuisine_id":136,"cuisine_name":"Latin American"}},{"cuisine":{"cuisine_id":66,"cuisine_name":"Lebanese"}},{"cuisine":{"cuisine_id":69,"cuisine_name":"Malaysian"}},{"cuisine":{"cuisine_id":70,"cuisine_name":"Mediterranean"}},{"cuisine":{"cuisine_id":73,"cuisine_name":"Mexican"}},{"cuisine":{"cuisine_id":137,"cuisine_name":"Middle Eastern"}},{"cuisine":{"cuisine_id":147,"cuisine_name":"Moroccan"}},{"cuisine":{"cuisine_id":117,"cuisine_name":"Nepalese"}},{"cuisine":{"cuisine_id":996,"cuisine_name":"New American"}},{"cuisine":{"cuisine_id":321,"cuisine_name":"Pacific"}},{"cuisine":{"cuisine_id":139,"cuisine_name":"Pakistani"}},{"cuisine":{"cuisine_id":209,"cuisine_name":"Pan Asian"}},{"cuisine":{"cuisine_id":162,"cuisine_name":"Peruvian"}},{"cuisine":{"cuisine_id":82,"cuisine_name":"Pizza"}},{"cuisine":{"cuisine_id":219,"cuisine_name":"Polish"}},{"cuisine":{"cuisine_id":87,"cuisine_name":"Portuguese"}},{"cuisine":{"cuisine_id":983,"cuisine_name":"Pub Food"}},{"cuisine":{"cuisine_id":361,"cuisine_name":"Puerto Rican"}},{"cuisine":{"cuisine_id":320,"cuisine_name":"Ramen"}},{"cuisine":{"cuisine_id":84,"cuisine_name":"Russian"}},{"cuisine":{"cuisine_id":998,"cuisine_name":"Salad"}},{"cuisine":{"cuisine_id":601,"cuisine_name":"Salvadorean"}},{"cuisine":{"cuisine_id":304,"cuisine_name":"Sandwich"}},{"cuisine":{"cuisine_id":210,"cuisine_name":"Scottish"}},{"cuisine":{"cuisine_id":83,"cuisine_name":"Seafood"}},{"cuisine":{"cuisine_id":128,"cuisine_name":"Sichuan"}},{"cuisine":{"cuisine_id":461,"cuisine_name":"Soul Food"}},{"cuisine":{"cuisine_id":972,"cuisine_name":"South American"}},{"cuisine":{"cuisine_id":471,"cuisine_name":"Southern"}},{"cuisine":{"cuisine_id":966,"cuisine_name":"Southwestern"}},{"cuisine":{"cuisine_id":89,"cuisine_name":"Spanish"}},{"cuisine":{"cuisine_id":86,"cuisine_name":"Sri Lankan"}},{"cuisine":{"cuisine_id":141,"cuisine_name":"Steak"}},{"cuisine":{"cuisine_id":177,"cuisine_name":"Sushi"}},{"cuisine":{"cuisine_id":997,"cuisine_name":"Taco"}},{"cuisine":{"cuisine_id":190,"cuisine_name":"Taiwanese"}},{"cuisine":{"cuisine_id":179,"cuisine_name":"Tapas"}},{"cuisine":{"cuisine_id":163,"cuisine_name":"Tea"}},{"cuisine":{"cuisine_id":964,"cuisine_name":"Teriyaki"}},{"cuisine":{"cuisine_id":150,"cuisine_name":"Tex-Mex"}},{"cuisine":{"cuisine_id":95,"cuisine_name":"Thai"}},{"cuisine":{"cuisine_id":93,"cuisine_name":"Tibetan"}},{"cuisine":{"cuisine_id":142,"cuisine_name":"Turkish"}},{"cuisine":{"cuisine_id":308,"cuisine_name":"Vegetarian"}},{"cuisine":{"cuisine_id":641,"cuisine_name":"Venezuelan"}},{"cuisine":{"cuisine_id":99,"cuisine_name":"Vietnamese"}}]}";

		try {
			obj = new JSONObject(json_output);

			JSONArray cuisines = obj.getJSONArray("cuisines");

			int length = cuisines.length();

			for(int i=0; i<length; i++){

				JSONObject cuisine = cuisines.getJSONObject(i);

			    JSONObject inner_cuisine = cuisine.getJSONObject("cuisine");

			    String cuisine_name = inner_cuisine.getString("cuisine_name");

			    cuisines_list.add(cuisine_name);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cuisines_list;
	}



public HashMap<String, Integer> setCuisineIdMap(double latitude, double longitude){

//	Implementation Notes
//	Get a list of all cuisines of restaurants listed in a city.
//	The location/city input can be provided in the following ways -
//
//	Using Zomato City ID or lat and long
//	Using coordinates of any location within a city
//	List of all restaurants serving a particular cuisine can be
//	obtained using '/search' API with cuisine ID and location details

		String json_output = "";
		String api_url = "https://developers.zomato.com/api/v2.1/cuisines?lat="
				+ latitude + "&lon=" + longitude;

		//List<String> cuisines_list = new ArrayList<>();
		HashMap<String, Integer> cuisine_idMap = new HashMap<String, Integer>();

		try {
			URL url = new URL(api_url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("user-key", " "+ API_KEY);

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output;
			// System.out.println("Output from API .... \n");
			while ((output = br.readLine()) != null) {
				// System.out.println(output);
				json_output += output;
			}

			conn.disconnect();

		  } catch (MalformedURLException e) {
			e.printStackTrace();
		  } catch (IOException e) {
			e.printStackTrace();
		  }

		JSONObject obj;

		try {
			obj = new JSONObject(json_output);

			JSONArray cuisines = obj.getJSONArray("cuisines");

			int length = cuisines.length();

			for(int i=0; i<length; i++){

				JSONObject cuisine = cuisines.getJSONObject(i);

			    JSONObject inner_cuisine = cuisine.getJSONObject("cuisine");

			    String cuisine_name = inner_cuisine.getString("cuisine_name");

			    int cuisineId = inner_cuisine.getInt("cuisine_id");

			    cuisine_idMap.put(cuisine_name, cuisineId);

//			    cuisines_list.add(cuisine_name);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return cuisine_idMap;
	}

public List<Restaurant> getRestaurantInfo(double latitude, double longitude, Integer cuisineId){

	//https://developers.zomato.com/api/v2.1/search?lat=42.35&lon=-71.06&cuisines=148
		String json_output = "";
		String api_url = "https://developers.zomato.com/api/v2.1/search?lat="
				+ latitude + "&lon=" + longitude + "&cuisines=" + cuisineId;

		//List<HashMap<String, String>> restaurantInfoList = new ArrayList<>();

		List<Restaurant> restaurantInfoList = new ArrayList<>();

		try {
			URL url = new URL(api_url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("user-key", " "+ API_KEY);

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output;
			// System.out.println("Output from API .... \n");
			while ((output = br.readLine()) != null) {
				// System.out.println(output);
				json_output += output;
			}

			conn.disconnect();

		  } catch (MalformedURLException e) {
			e.printStackTrace();
		  } catch (IOException e) {
			e.printStackTrace();
		  }

		JSONObject obj;
		//{"cuisines":[{"cuisine":{"cuisine_id":6,"cuisine_name":"Afghani"}},{"cuisine":{"cuisine_id":152,"cuisine_name":"African"}},{"cuisine":{"cuisine_id":1,"cuisine_name":"American"}},{"cuisine":{"cuisine_id":151,"cuisine_name":"Argentine"}},{"cuisine":{"cuisine_id":175,"cuisine_name":"Armenian"}},{"cuisine":{"cuisine_id":3,"cuisine_name":"Asian"}},{"cuisine":{"cuisine_id":131,"cuisine_name":"Australian"}},{"cuisine":{"cuisine_id":193,"cuisine_name":"BBQ"}},{"cuisine":{"cuisine_id":955,"cuisine_name":"Bagels"}},{"cuisine":{"cuisine_id":5,"cuisine_name":"Bakery"}},{"cuisine":{"cuisine_id":227,"cuisine_name":"Bar Food"}},{"cuisine":{"cuisine_id":270,"cuisine_name":"Beverages"}},{"cuisine":{"cuisine_id":159,"cuisine_name":"Brazilian"}},{"cuisine":{"cuisine_id":182,"cuisine_name":"Breakfast"}},{"cuisine":{"cuisine_id":133,"cuisine_name":"British"}},{"cuisine":{"cuisine_id":247,"cuisine_name":"Bubble Tea"}},{"cuisine":{"cuisine_id":168,"cuisine_name":"Burger"}},{"cuisine":{"cuisine_id":22,"cuisine_name":"Burmese"}},{"cuisine":{"cuisine_id":30,"cuisine_name":"Cafe"}},{"cuisine":{"cuisine_id":491,"cuisine_name":"Cajun"}},{"cuisine":{"cuisine_id":956,"cuisine_name":"California"}},{"cuisine":{"cuisine_id":111,"cuisine_name":"Cambodian"}},{"cuisine":{"cuisine_id":121,"cuisine_name":"Cantonese"}},{"cuisine":{"cuisine_id":158,"cuisine_name":"Caribbean"}},{"cuisine":{"cuisine_id":229,"cuisine_name":"Chilean"}},{"cuisine":{"cuisine_id":25,"cuisine_name":"Chinese"}},{"cuisine":{"cuisine_id":161,"cuisine_name":"Coffee and Tea"}},{"cuisine":{"cuisine_id":287,"cuisine_name":"Colombian"}},{"cuisine":{"cuisine_id":928,"cuisine_name":"Creole"}},{"cuisine":{"cuisine_id":881,"cuisine_name":"Crepes"}},{"cuisine":{"cuisine_id":153,"cuisine_name":"Cuban"}},{"cuisine":{"cuisine_id":192,"cuisine_name":"Deli"}},{"cuisine":{"cuisine_id":100,"cuisine_name":"Desserts"}},{"cuisine":{"cuisine_id":411,"cuisine_name":"Dim Sum"}},{"cuisine":{"cuisine_id":541,"cuisine_name":"Diner"}},{"cuisine":{"cuisine_id":958,"cuisine_name":"Dominican"}},{"cuisine":{"cuisine_id":959,"cuisine_name":"Donuts"}},{"cuisine":{"cuisine_id":268,"cuisine_name":"Drinks Only"}},{"cuisine":{"cuisine_id":651,"cuisine_name":"Eastern European"}},{"cuisine":{"cuisine_id":316,"cuisine_name":"Ecuadorian"}},{"cuisine":{"cuisine_id":149,"cuisine_name":"Ethiopian"}},{"cuisine":{"cuisine_id":38,"cuisine_name":"European"}},{"cuisine":{"cuisine_id":40,"cuisine_name":"Fast Food"}},{"cuisine":{"cuisine_id":112,"cuisine_name":"Filipino"}},{"cuisine":{"cuisine_id":45,"cuisine_name":"French"}},{"cuisine":{"cuisine_id":501,"cuisine_name":"Frozen Yogurt"}},{"cuisine":{"cuisine_id":274,"cuisine_name":"Fusion"}},{"cuisine":{"cuisine_id":134,"cuisine_name":"German"}},{"cuisine":{"cuisine_id":156,"cuisine_name":"Greek"}},{"cuisine":{"cuisine_id":521,"cuisine_name":"Hawaiian"}},{"cuisine":{"cuisine_id":143,"cuisine_name":"Healthy Food"}},{"cuisine":{"cuisine_id":233,"cuisine_name":"Ice Cream"}},{"cuisine":{"cuisine_id":148,"cuisine_name":"Indian"}},{"cuisine":{"cuisine_id":114,"cuisine_name":"Indonesian"}},{"cuisine":{"cuisine_id":154,"cuisine_name":"International"}},{"cuisine":{"cuisine_id":140,"cuisine_name":"Iranian"}},{"cuisine":{"cuisine_id":135,"cuisine_name":"Irish"}},{"cuisine":{"cuisine_id":55,"cuisine_name":"Italian"}},{"cuisine":{"cuisine_id":207,"cuisine_name":"Jamaican"}},{"cuisine":{"cuisine_id":60,"cuisine_name":"Japanese"}},{"cuisine":{"cuisine_id":265,"cuisine_name":"Jewish"}},{"cuisine":{"cuisine_id":164,"cuisine_name":"Juices"}},{"cuisine":{"cuisine_id":178,"cuisine_name":"Kebab"}},{"cuisine":{"cuisine_id":67,"cuisine_name":"Korean"}},{"cuisine":{"cuisine_id":136,"cuisine_name":"Latin American"}},{"cuisine":{"cuisine_id":66,"cuisine_name":"Lebanese"}},{"cuisine":{"cuisine_id":69,"cuisine_name":"Malaysian"}},{"cuisine":{"cuisine_id":70,"cuisine_name":"Mediterranean"}},{"cuisine":{"cuisine_id":73,"cuisine_name":"Mexican"}},{"cuisine":{"cuisine_id":137,"cuisine_name":"Middle Eastern"}},{"cuisine":{"cuisine_id":147,"cuisine_name":"Moroccan"}},{"cuisine":{"cuisine_id":117,"cuisine_name":"Nepalese"}},{"cuisine":{"cuisine_id":996,"cuisine_name":"New American"}},{"cuisine":{"cuisine_id":321,"cuisine_name":"Pacific"}},{"cuisine":{"cuisine_id":139,"cuisine_name":"Pakistani"}},{"cuisine":{"cuisine_id":209,"cuisine_name":"Pan Asian"}},{"cuisine":{"cuisine_id":162,"cuisine_name":"Peruvian"}},{"cuisine":{"cuisine_id":82,"cuisine_name":"Pizza"}},{"cuisine":{"cuisine_id":219,"cuisine_name":"Polish"}},{"cuisine":{"cuisine_id":87,"cuisine_name":"Portuguese"}},{"cuisine":{"cuisine_id":983,"cuisine_name":"Pub Food"}},{"cuisine":{"cuisine_id":361,"cuisine_name":"Puerto Rican"}},{"cuisine":{"cuisine_id":320,"cuisine_name":"Ramen"}},{"cuisine":{"cuisine_id":84,"cuisine_name":"Russian"}},{"cuisine":{"cuisine_id":998,"cuisine_name":"Salad"}},{"cuisine":{"cuisine_id":601,"cuisine_name":"Salvadorean"}},{"cuisine":{"cuisine_id":304,"cuisine_name":"Sandwich"}},{"cuisine":{"cuisine_id":210,"cuisine_name":"Scottish"}},{"cuisine":{"cuisine_id":83,"cuisine_name":"Seafood"}},{"cuisine":{"cuisine_id":128,"cuisine_name":"Sichuan"}},{"cuisine":{"cuisine_id":461,"cuisine_name":"Soul Food"}},{"cuisine":{"cuisine_id":972,"cuisine_name":"South American"}},{"cuisine":{"cuisine_id":471,"cuisine_name":"Southern"}},{"cuisine":{"cuisine_id":966,"cuisine_name":"Southwestern"}},{"cuisine":{"cuisine_id":89,"cuisine_name":"Spanish"}},{"cuisine":{"cuisine_id":86,"cuisine_name":"Sri Lankan"}},{"cuisine":{"cuisine_id":141,"cuisine_name":"Steak"}},{"cuisine":{"cuisine_id":177,"cuisine_name":"Sushi"}},{"cuisine":{"cuisine_id":997,"cuisine_name":"Taco"}},{"cuisine":{"cuisine_id":190,"cuisine_name":"Taiwanese"}},{"cuisine":{"cuisine_id":179,"cuisine_name":"Tapas"}},{"cuisine":{"cuisine_id":163,"cuisine_name":"Tea"}},{"cuisine":{"cuisine_id":964,"cuisine_name":"Teriyaki"}},{"cuisine":{"cuisine_id":150,"cuisine_name":"Tex-Mex"}},{"cuisine":{"cuisine_id":95,"cuisine_name":"Thai"}},{"cuisine":{"cuisine_id":93,"cuisine_name":"Tibetan"}},{"cuisine":{"cuisine_id":142,"cuisine_name":"Turkish"}},{"cuisine":{"cuisine_id":308,"cuisine_name":"Vegetarian"}},{"cuisine":{"cuisine_id":641,"cuisine_name":"Venezuelan"}},{"cuisine":{"cuisine_id":99,"cuisine_name":"Vietnamese"}}]}";

		try {
			obj = new JSONObject(json_output);

			JSONArray restaurants = obj.getJSONArray("restaurants");

			int length = restaurants.length();

			for(int i=0; i<length; i++){

				HashMap<String, String> restaurantInfo = new HashMap<String, String>();

				JSONObject restaurant = restaurants.getJSONObject(i);
				JSONObject restaurantInner = restaurant.getJSONObject("restaurant");

				JSONObject R = restaurantInner.getJSONObject("R");

			    Integer res_id = R.getInt("res_id");

			    Integer average_cost_for_two = restaurantInner.getInt("average_cost_for_two");

			    JSONObject user_rating = restaurantInner.getJSONObject("user_rating");

			    Double aggregate_rating = user_rating.getDouble("aggregate_rating");

			    String cuisines = restaurantInner.getString("cuisines");

			    String restaurant_name = restaurantInner.getString("name");

//              no longer needed
//			    restaurantInfo.put("res_id", res_id.toString());
//			    restaurantInfo.put("average_cost_for_two", average_cost_for_two.toString());
//			    restaurantInfo.put("aggregate_rating", aggregate_rating.toString());
//			    restaurantInfo.put("cuisines", cuisines);



			    //System.out.println(res_id + " " + average_cost_for_two + "aggregate" + aggregate_rating);
			    //cuisines_list.add(cuisine_name);

                Restaurant restaurant_object = new Restaurant();

                restaurant_object.setId(res_id);
                restaurant_object.setAvgCostForTwo(average_cost_for_two);
                restaurant_object.setAggregateRating(aggregate_rating);
                restaurant_object.setName(restaurant_name);

                restaurantInfoList.add(restaurant_object);



			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return restaurantInfoList;
	}


	public List<Restaurant> searchRestaurantByName(String restaurantName){

        //https://developers.zomato.com/api/v2.1/search?lat=42.35&lon=-71.06&cuisines=148
        String json_output = "";
//        String api_url = "https://developers.zomato.com/api/v2.1/search?lat="
//                + latitude + "&lon=" + longitude + "&cuisines=" + cuisineId;

        try {
            restaurantName = URLEncoder.encode(restaurantName, "UTF-8");
        } catch (UnsupportedEncodingException ignored) {
            // Can be safely ignored because UTF-8 is always supported
        }

        String api_url = "https://developers.zomato.com/api/v2.1/search?q=" + restaurantName;

        //List<HashMap<String, String>> restaurantInfoList = new ArrayList<>();

        List<Restaurant> restaurantInfoList = new ArrayList<>();

        try {
            URL url = new URL(api_url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("user-key", " "+ API_KEY);

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            // System.out.println("Output from API .... \n");
            while ((output = br.readLine()) != null) {
                // System.out.println(output);
                json_output += output;
            }

            conn.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject obj;
        //{"cuisines":[{"cuisine":{"cuisine_id":6,"cuisine_name":"Afghani"}},{"cuisine":{"cuisine_id":152,"cuisine_name":"African"}},{"cuisine":{"cuisine_id":1,"cuisine_name":"American"}},{"cuisine":{"cuisine_id":151,"cuisine_name":"Argentine"}},{"cuisine":{"cuisine_id":175,"cuisine_name":"Armenian"}},{"cuisine":{"cuisine_id":3,"cuisine_name":"Asian"}},{"cuisine":{"cuisine_id":131,"cuisine_name":"Australian"}},{"cuisine":{"cuisine_id":193,"cuisine_name":"BBQ"}},{"cuisine":{"cuisine_id":955,"cuisine_name":"Bagels"}},{"cuisine":{"cuisine_id":5,"cuisine_name":"Bakery"}},{"cuisine":{"cuisine_id":227,"cuisine_name":"Bar Food"}},{"cuisine":{"cuisine_id":270,"cuisine_name":"Beverages"}},{"cuisine":{"cuisine_id":159,"cuisine_name":"Brazilian"}},{"cuisine":{"cuisine_id":182,"cuisine_name":"Breakfast"}},{"cuisine":{"cuisine_id":133,"cuisine_name":"British"}},{"cuisine":{"cuisine_id":247,"cuisine_name":"Bubble Tea"}},{"cuisine":{"cuisine_id":168,"cuisine_name":"Burger"}},{"cuisine":{"cuisine_id":22,"cuisine_name":"Burmese"}},{"cuisine":{"cuisine_id":30,"cuisine_name":"Cafe"}},{"cuisine":{"cuisine_id":491,"cuisine_name":"Cajun"}},{"cuisine":{"cuisine_id":956,"cuisine_name":"California"}},{"cuisine":{"cuisine_id":111,"cuisine_name":"Cambodian"}},{"cuisine":{"cuisine_id":121,"cuisine_name":"Cantonese"}},{"cuisine":{"cuisine_id":158,"cuisine_name":"Caribbean"}},{"cuisine":{"cuisine_id":229,"cuisine_name":"Chilean"}},{"cuisine":{"cuisine_id":25,"cuisine_name":"Chinese"}},{"cuisine":{"cuisine_id":161,"cuisine_name":"Coffee and Tea"}},{"cuisine":{"cuisine_id":287,"cuisine_name":"Colombian"}},{"cuisine":{"cuisine_id":928,"cuisine_name":"Creole"}},{"cuisine":{"cuisine_id":881,"cuisine_name":"Crepes"}},{"cuisine":{"cuisine_id":153,"cuisine_name":"Cuban"}},{"cuisine":{"cuisine_id":192,"cuisine_name":"Deli"}},{"cuisine":{"cuisine_id":100,"cuisine_name":"Desserts"}},{"cuisine":{"cuisine_id":411,"cuisine_name":"Dim Sum"}},{"cuisine":{"cuisine_id":541,"cuisine_name":"Diner"}},{"cuisine":{"cuisine_id":958,"cuisine_name":"Dominican"}},{"cuisine":{"cuisine_id":959,"cuisine_name":"Donuts"}},{"cuisine":{"cuisine_id":268,"cuisine_name":"Drinks Only"}},{"cuisine":{"cuisine_id":651,"cuisine_name":"Eastern European"}},{"cuisine":{"cuisine_id":316,"cuisine_name":"Ecuadorian"}},{"cuisine":{"cuisine_id":149,"cuisine_name":"Ethiopian"}},{"cuisine":{"cuisine_id":38,"cuisine_name":"European"}},{"cuisine":{"cuisine_id":40,"cuisine_name":"Fast Food"}},{"cuisine":{"cuisine_id":112,"cuisine_name":"Filipino"}},{"cuisine":{"cuisine_id":45,"cuisine_name":"French"}},{"cuisine":{"cuisine_id":501,"cuisine_name":"Frozen Yogurt"}},{"cuisine":{"cuisine_id":274,"cuisine_name":"Fusion"}},{"cuisine":{"cuisine_id":134,"cuisine_name":"German"}},{"cuisine":{"cuisine_id":156,"cuisine_name":"Greek"}},{"cuisine":{"cuisine_id":521,"cuisine_name":"Hawaiian"}},{"cuisine":{"cuisine_id":143,"cuisine_name":"Healthy Food"}},{"cuisine":{"cuisine_id":233,"cuisine_name":"Ice Cream"}},{"cuisine":{"cuisine_id":148,"cuisine_name":"Indian"}},{"cuisine":{"cuisine_id":114,"cuisine_name":"Indonesian"}},{"cuisine":{"cuisine_id":154,"cuisine_name":"International"}},{"cuisine":{"cuisine_id":140,"cuisine_name":"Iranian"}},{"cuisine":{"cuisine_id":135,"cuisine_name":"Irish"}},{"cuisine":{"cuisine_id":55,"cuisine_name":"Italian"}},{"cuisine":{"cuisine_id":207,"cuisine_name":"Jamaican"}},{"cuisine":{"cuisine_id":60,"cuisine_name":"Japanese"}},{"cuisine":{"cuisine_id":265,"cuisine_name":"Jewish"}},{"cuisine":{"cuisine_id":164,"cuisine_name":"Juices"}},{"cuisine":{"cuisine_id":178,"cuisine_name":"Kebab"}},{"cuisine":{"cuisine_id":67,"cuisine_name":"Korean"}},{"cuisine":{"cuisine_id":136,"cuisine_name":"Latin American"}},{"cuisine":{"cuisine_id":66,"cuisine_name":"Lebanese"}},{"cuisine":{"cuisine_id":69,"cuisine_name":"Malaysian"}},{"cuisine":{"cuisine_id":70,"cuisine_name":"Mediterranean"}},{"cuisine":{"cuisine_id":73,"cuisine_name":"Mexican"}},{"cuisine":{"cuisine_id":137,"cuisine_name":"Middle Eastern"}},{"cuisine":{"cuisine_id":147,"cuisine_name":"Moroccan"}},{"cuisine":{"cuisine_id":117,"cuisine_name":"Nepalese"}},{"cuisine":{"cuisine_id":996,"cuisine_name":"New American"}},{"cuisine":{"cuisine_id":321,"cuisine_name":"Pacific"}},{"cuisine":{"cuisine_id":139,"cuisine_name":"Pakistani"}},{"cuisine":{"cuisine_id":209,"cuisine_name":"Pan Asian"}},{"cuisine":{"cuisine_id":162,"cuisine_name":"Peruvian"}},{"cuisine":{"cuisine_id":82,"cuisine_name":"Pizza"}},{"cuisine":{"cuisine_id":219,"cuisine_name":"Polish"}},{"cuisine":{"cuisine_id":87,"cuisine_name":"Portuguese"}},{"cuisine":{"cuisine_id":983,"cuisine_name":"Pub Food"}},{"cuisine":{"cuisine_id":361,"cuisine_name":"Puerto Rican"}},{"cuisine":{"cuisine_id":320,"cuisine_name":"Ramen"}},{"cuisine":{"cuisine_id":84,"cuisine_name":"Russian"}},{"cuisine":{"cuisine_id":998,"cuisine_name":"Salad"}},{"cuisine":{"cuisine_id":601,"cuisine_name":"Salvadorean"}},{"cuisine":{"cuisine_id":304,"cuisine_name":"Sandwich"}},{"cuisine":{"cuisine_id":210,"cuisine_name":"Scottish"}},{"cuisine":{"cuisine_id":83,"cuisine_name":"Seafood"}},{"cuisine":{"cuisine_id":128,"cuisine_name":"Sichuan"}},{"cuisine":{"cuisine_id":461,"cuisine_name":"Soul Food"}},{"cuisine":{"cuisine_id":972,"cuisine_name":"South American"}},{"cuisine":{"cuisine_id":471,"cuisine_name":"Southern"}},{"cuisine":{"cuisine_id":966,"cuisine_name":"Southwestern"}},{"cuisine":{"cuisine_id":89,"cuisine_name":"Spanish"}},{"cuisine":{"cuisine_id":86,"cuisine_name":"Sri Lankan"}},{"cuisine":{"cuisine_id":141,"cuisine_name":"Steak"}},{"cuisine":{"cuisine_id":177,"cuisine_name":"Sushi"}},{"cuisine":{"cuisine_id":997,"cuisine_name":"Taco"}},{"cuisine":{"cuisine_id":190,"cuisine_name":"Taiwanese"}},{"cuisine":{"cuisine_id":179,"cuisine_name":"Tapas"}},{"cuisine":{"cuisine_id":163,"cuisine_name":"Tea"}},{"cuisine":{"cuisine_id":964,"cuisine_name":"Teriyaki"}},{"cuisine":{"cuisine_id":150,"cuisine_name":"Tex-Mex"}},{"cuisine":{"cuisine_id":95,"cuisine_name":"Thai"}},{"cuisine":{"cuisine_id":93,"cuisine_name":"Tibetan"}},{"cuisine":{"cuisine_id":142,"cuisine_name":"Turkish"}},{"cuisine":{"cuisine_id":308,"cuisine_name":"Vegetarian"}},{"cuisine":{"cuisine_id":641,"cuisine_name":"Venezuelan"}},{"cuisine":{"cuisine_id":99,"cuisine_name":"Vietnamese"}}]}";

        try {
            obj = new JSONObject(json_output);

            JSONArray restaurants = obj.getJSONArray("restaurants");

            int length = restaurants.length();

            for(int i=0; i<length; i++){

                if(i == 5){
                    break;
                }

                HashMap<String, String> restaurantInfo = new HashMap<String, String>();

                JSONObject restaurant = restaurants.getJSONObject(i);
                JSONObject restaurantInner = restaurant.getJSONObject("restaurant");

                JSONObject R = restaurantInner.getJSONObject("R");

                Integer res_id = R.getInt("res_id");

                Integer average_cost_for_two = restaurantInner.getInt("average_cost_for_two");

                JSONObject user_rating = restaurantInner.getJSONObject("user_rating");

                Double aggregate_rating = user_rating.getDouble("aggregate_rating");

                String cuisines = restaurantInner.getString("cuisines");

                String restaurant_name = restaurantInner.getString("name");

//              no longer needed
//			    restaurantInfo.put("res_id", res_id.toString());
//			    restaurantInfo.put("average_cost_for_two", average_cost_for_two.toString());
//			    restaurantInfo.put("aggregate_rating", aggregate_rating.toString());
//			    restaurantInfo.put("cuisines", cuisines);



                //System.out.println(res_id + " " + average_cost_for_two + "aggregate" + aggregate_rating);
                //cuisines_list.add(cuisine_name);

                Restaurant restaurant_object = new Restaurant();

                restaurant_object.setId(res_id);
                restaurant_object.setAvgCostForTwo(average_cost_for_two);
                restaurant_object.setAggregateRating(aggregate_rating);
                restaurant_object.setName(restaurant_name);

                restaurantInfoList.add(restaurant_object);



            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return restaurantInfoList;
    }


    public Restaurant searchRestaurantById(Integer restaurantZomatoId){

        //https://developers.zomato.com/api/v2.1/search?lat=42.35&lon=-71.06&cuisines=148
        String json_output = "";


        String api_url = "https://developers.zomato.com/api/v2.1/restaurant?res_id=" + restaurantZomatoId;

        //List<HashMap<String, String>> restaurantInfoList = new ArrayList<>();

        Restaurant restaurant_object = new Restaurant();

        try {
            URL url = new URL(api_url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("user-key", " "+ API_KEY);

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            // System.out.println("Output from API .... \n");
            while ((output = br.readLine()) != null) {
                // System.out.println(output);
                json_output += output;
            }

            conn.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject obj;

        try {
            obj = new JSONObject(json_output);

            JSONObject R = obj.getJSONObject("R");

            Integer res_id = R.getInt("res_id");

            Integer average_cost_for_two = obj.getInt("average_cost_for_two");

            JSONObject user_rating = obj.getJSONObject("user_rating");

            JSONObject location = obj.getJSONObject("location");

            Double aggregate_rating = user_rating.getDouble("aggregate_rating");

			Double latitude = location.getDouble("latitude");

			Double longitude = location.getDouble("longitude");

            String cuisines = obj.getString("cuisines");

            String restaurant_name = obj.getString("name");

			String imageUrl = obj.getString("featured_image");

			restaurant_object.setId(res_id);
            restaurant_object.setAvgCostForTwo(average_cost_for_two);
            restaurant_object.setAggregateRating(aggregate_rating);
            restaurant_object.setName(restaurant_name);
            restaurant_object.setLatitude(latitude);
            restaurant_object.setLongitude(longitude);
			restaurant_object.setImageUrl(imageUrl);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return restaurant_object;
    }


	// http://localhost:8080/RESTfulExample/json/product/get
	public static void main(String[] args) {

//		// String API_KEY = "";
//
//
//
////		String test;
////		try {
////			test = zomatomethod.getRestaurantReviews(16774318);
////			System.out.println(test);
////		} catch (JSONException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//
//		double latitude = 42.358028;
//		double longitude = -71.060417;
//
//		List<String> test2 = zomatomethod.getCuisinesinCitybyLatLong(latitude, longitude);
//
//		//	test for getCuisinesinCitybyLatLong
////		for(String cuisine : test2) {
////            System.out.println(cuisine);
////        }
//
//		//System.out.println(test2);
//
//		HashMap<String, Integer> cuisineIdMap = zomatomethod.setCuisineIdMap(latitude, longitude);
//
////		Set set = cuisineIdMap.entrySet();
////	      Iterator iterator = set.iterator();
////	      while(iterator.hasNext()) {
////	         Map.Entry mentry = (Map.Entry)iterator.next();
////	         System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
////	         System.out.println(mentry.getValue());
////	      }
////
////	      Integer var= cuisineIdMap.get("Indian");
////	      System.out.println("cuisineId of Indian "+var);
//
////		HashMap<String, Integer> cuisineIdMap = zomatomethod.setCuisineIdMap(latitude, longitude);
//
////		List<Restaurant> test3 = zomatomethod.searchRestaurant("Boston Shawarma");
////
////        for(Restaurant restaurant : test3) {
////          System.out.println(restaurant.getName());
////        }
////		System.out.println(test3.get(i).getName());
//
////        Restaurant rest = zomatomethod.searchRestaurantById(16774318);
////        System.out.println(rest.getName());

	}


}
