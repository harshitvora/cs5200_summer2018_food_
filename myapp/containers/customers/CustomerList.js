import React from 'react';
import CustomerRow from './CustomerRow'
import CustomerService from '../../services/CustomerService';

class CustomerList extends React.Component {
    constructor() {
        super();
        this.customerService = CustomerService.instance;
        this.state = {
            newCustomer: {},
            customers: []
        };

    }

    componentDidMount() {
        this.customerService.findAllCustomers()
            .then(customers => {
                this.setState({customers: customers});
            });
    }

    formChanged = (event) => {
        console.log(event.target.value);
        this.setState({newCustomer: {
                title: event.target.value
            }})
    };

    deleteCustomer = (customerId) => {
        this.customerService.deleteCustomer(customerId)
            .then(() => this.customerService.findAllCustomers())
            .then(customers => this.setState({customers: customers}))
    };

    createCustomer = () => {
        this.customerService.createCustomer(this.state.newCustomer)
            .then(customer  => this.customerService.findAllCustomers())
            .then(customers => this.setState({customers: customers}))
    };

    render()
    {
        return (
            <div>
                <h2>Customer List</h2>
                <table className="table">
                    <thead>
                    <tr>
                        <th>Title</th>
                    </tr>
                    <tr>
                        <th><input onChange={this.formChanged} className="form-control"/> </th>
                        <th><button onClick={this.createCustomer} className="btn btn-primary">Add</button> </th>
                    </tr>
                    </thead>
                    <tbody>
                    {this.state.customers.map((customer, index) =>
                        <CustomerRow key={index}
                                   deleteCustomer={this.deleteCustomer}
                                   customer={customer}/>)}
                    </tbody>
                </table>
            </div>
        )
    }
}
export default CustomerList;