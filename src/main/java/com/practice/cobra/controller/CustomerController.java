package com.practice.cobra.controller;

import com.practice.cobra.entity.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerController
{
     Map<Long, Customer> customers = new HashMap<>();

     @GetMapping
     public List<Customer> getAllCustomers(){
          return new ArrayList<>(customers.values());
     }

     @PostMapping
     public String addCustomer(@RequestBody Customer customer){
          customers.put(customer.getId(), customer);
          return "Customer added Successfully";
     }

     @GetMapping("/id/{customerId}")
     public Customer getCustomerById(@PathVariable Long customerId){
          return customers.get(customerId);
     }

     @DeleteMapping("/id/{customerId}")
     public Customer deleteCustomerById(@PathVariable Long customerId){
          return customers.remove(customerId);
     }

     @PutMapping("/id/{customerId}")
     public String updateCustomer(@PathVariable Long customerId,@RequestBody Customer customer){
          customers.put(customerId,customer);
          return "Customer Updated Successfully";
     }
}
