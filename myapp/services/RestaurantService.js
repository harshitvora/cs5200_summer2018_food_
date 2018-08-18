const RESTAURANT_API_URL = 'http://10.0.0.182:8080/api/restaurant';

export function findAllRestaurants() {
    return fetch(RESTAURANT_API_URL)
        .then(function (response) {
            return response.json();
        });
}
