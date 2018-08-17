const CUSTOMER_API_URL = 'http://10.0.0.182:8080/api/customer';

export function findCustomerById(customerId) {
    return fetch(CUSTOMER_API_URL + "/" + customerId)
        .then(function (response) {
            return response.json();
        });
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
    console.log(JSON.stringify(customer));
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
