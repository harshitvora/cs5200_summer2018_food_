const CUSTOMER_API_URL = 'https://10.110.250.81:8080/api/customer';

export function findCustomerById(customerId) {
    return fetch(CUSTOMER_API_URL + "/" + customerId)
        .then(function (response) {
            return response.json();
        });
}

export function findCustomerByEmailPassword(customerEmail, customerPassword) {
    console.log("email: " + JSON.stringify(customerEmail));
    console.log("password: " + JSON.stringify(customerPassword));
    return fetch(CUSTOMER_API_URL + "/" + customerEmail + "/" + customerPassword, {
        method: 'post'
    })
        .then(function (response) {
            if (!response.ok) {
                throw Error(response.statusText);
            }
            console.log("inside: " + response.json());
            return response.json();
        })
        .then(response => console.log("ok"))
        .catch(error => alert("User does not exist"));
}

export function deleteCustomer(customerId) {
    return fetch(CUSTOMER_API_URL + '/' + customerId, {
        method: 'delete'
    })
        .then(function (response) {
            return response;
        });
}

export function createCustomer(customer) {
    console.log("inside createCustomer of service" + JSON.stringify(customer));
    return fetch(CUSTOMER_API_URL, {
        method: 'POST',
        body: JSON.stringify(customer),
        headers: {
            'Content-type': 'application/json'
        }
    })
        .then(function (response) {
            if (!response.ok) {
                throw Error(response.statusText);
            }
            return response.json();
        })
        .then(response => console.log("ok"))
        .catch(error => console.log(error));
}

export function findAllCustomers() {
    return fetch(CUSTOMER_API_URL)
        .then(function (response) {
            return response.json();
        });
}
