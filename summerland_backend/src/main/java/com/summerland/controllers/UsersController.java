package com.summerland.controllers;

import com.summerland.business.IBusinessCustomer;
import com.summerland.business.IBusinessOwner;
import com.summerland.entities.Customer;
import com.summerland.entities.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UsersController {

    @Autowired
    IBusinessCustomer customerTreatment;

    @Autowired
    IBusinessOwner ownerTreatment;



    @PostMapping(path = "/login")
    public HashMap<String,String> login (@RequestBody Customer customer) {
        String email=customer.getEmail();
        String password=customer.getPassword();
        HashMap<String, String> response = new HashMap<>();
        Customer customer1=customerTreatment.getCustomerByEmail(email);
        if(customer1!=null){
            if(customer1.getPassword().equals(password)){
                response.put("auth","yes");
                response.put("role","customer");
                response.put("user_name",customer1.getName());
                response.put("user_last_name",customer1.getLastname());
                response.put("user_id",String.valueOf(customer1.getId()));
                return response;
            }
            else {
                response.put("auth","No");
                return response;
            }
        }
        else
        {
            Owner owner=ownerTreatment.getOwnerByEmail(email);
            if(owner!=null){
                if(owner.getPassword().equals(password)){
                    response.put("auth","yes");
                    response.put("role","owner");
                    response.put("user_name",owner.getName());
                    response.put("user_last_name",owner.getLastname());
                    response.put("user_id",String.valueOf(owner.getId()));
                    return response;
                }
            }
            else {
                response.put("auth","No");
                return response;
            }
        }
        response.put("auth","No");
        return response;
    }

    @RequestMapping(value = "/saveowner", method = RequestMethod.POST)
    public void saveOwner(@ModelAttribute Owner owner) {
        System.out.println("saving owner ..");

        ownerTreatment.saveOwner(owner);
    }

    @RequestMapping(value = "/savecustomer", method = RequestMethod.POST)
    public void saveCustomer(@ModelAttribute Customer customer) {
        System.out.println("saving customer ..");

        customerTreatment.saveCustomer(customer);
    }




}
