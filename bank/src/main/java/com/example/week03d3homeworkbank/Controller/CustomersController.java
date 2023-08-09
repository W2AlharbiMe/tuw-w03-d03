package com.example.week03d3homeworkbank.Controller;

import com.example.week03d3homeworkbank.ApiResponse.ApiResponse;
import com.example.week03d3homeworkbank.Model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomersController {
    ArrayList<Customer> customers = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Customer> getCustomers() {
        return customers;
    }


    @PostMapping("/save")
    public ApiResponse postCustomer(@RequestBody Customer customer) {
        customer.setId(String.valueOf(customers.size() + 1));
        customers.add(customer);

        return (new ApiResponse("Customer: " + customer.getUsername() + " have been created.", 201));
    }


    @PutMapping("/{id}/update")
    public ApiResponse updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        try {
            Customer saved_customer = customers.get(id - 1);

            saved_customer.setUsername(customer.getUsername());
            saved_customer.setBalance(customer.getBalance());

            return (new ApiResponse("The customer with ID: " + id + " have been updated.", 200));
        } catch (IndexOutOfBoundsException e1) {
            return (new ApiResponse("No Customer Have Been Found With That ID.", 404));
        }
    }


    @DeleteMapping("/{id}/delete")
    public ApiResponse deleteCustomer(@PathVariable int id) {
        try {
            customers.remove(id - 1);

            // I need to update all indexes
            int counter = 1;
            for (Customer c: customers) {
                c.setId(String.valueOf(counter));
                counter += 1;
            }

            return (new ApiResponse("the customer with ID: "+ id + " have been deleted.", 200));
        } catch (IndexOutOfBoundsException e1) {
            return (new ApiResponse("No Customer Have Been Found With That ID.", 404));
        }
    }


    @PutMapping("/{id}/deposit")
    public ApiResponse customerDeposit(@PathVariable int id, @RequestBody Customer customer) {
        try {
            Customer saved_customer = customers.get(id - 1);

            double previous_balance = saved_customer.getBalance();
            double new_balance = previous_balance + customer.getBalance();

            saved_customer.setBalance(new_balance);

            return (new ApiResponse("The customer with ID: " + id + " have deposited: "+ customer.getBalance() +" SAR balance before deposit: " + previous_balance + " SAR balance after deposit: " + new_balance + " SAR", 200));
        } catch (IndexOutOfBoundsException e1) {
            return (new ApiResponse("No Customer Have Been Found With That ID.", 404));
        }
    }

    @PutMapping("/{id}/withdraw")
    public ApiResponse customerWithdraw(@PathVariable int id, @RequestBody Customer customer) {
        try {
            Customer saved_customer = customers.get(id - 1);

            double previous_balance = saved_customer.getBalance();
            double new_balance = previous_balance - customer.getBalance();

            saved_customer.setBalance(new_balance);

            return (new ApiResponse("The customer with ID: " + id + " withdraw: "+ customer.getBalance() +" SAR balance before withdraw: " + previous_balance + " SAR balance after withdraw: " + new_balance + " SAR", 200));
        } catch (IndexOutOfBoundsException e1) {
            return (new ApiResponse("No Customer Have Been Found With That ID.", 404));
        }
    }

}
