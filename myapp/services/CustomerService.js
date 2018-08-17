let _singleton = Symbol();
class CustomerService {
    CUSTOMER_API_URL = 'http://localhost:8080/api/customer';

    findCustomerById(customerId) {
        return fetch(this.CUSTOMER_API_URL + "/" + customerId)
            .then(function(response){
                return response.json();
            });
    }

    deleteCustomer(customerId) {
        return fetch(this.CUSTOMER_API_URL + '/' + customerId, {
            method: 'delete'
        })
            .then(function(response){
                return response;
            });
    }
    createCustomer(customer) {
        console.log(customer);
        return fetch(this.CUSTOMER_API_URL, {
            method: 'post',
            body: JSON.stringify(customer),
            headers: {
                'content-type': 'application/json'
            }
        })
            .then(function(response){
                return response.json();
            });
    }

    findAllCustomers() {
        return fetch(this.CUSTOMER_API_URL)
            .then(function(response){
                return response.json();
            });
    }

    constructor(singletonToken) {
        if (_singleton !== singletonToken)
            throw new Error('Cannot instantiate directly.');
    }
    static get instance() {
        if(!this[_singleton])
            this[_singleton] = new CustomerService(_singleton);
        return this[_singleton]
    }
}
export default CustomerService;