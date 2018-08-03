package com.ketan.onetoonejpa.controller;

import com.ketan.onetoonejpa.domain.Customer;
import com.ketan.onetoonejpa.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CustomerController
{
    @Autowired
    private CustomerRepo customerRepo;

    //----------------------------------save customer

    @PostMapping(value="/customersave")
    public ResponseEntity<?> Customersave(@RequestBody Customer customer)
    {
        Map<String,Object> map =new HashMap<>();
        ResponseEntity<Map<Customer,Object>> entity=null;

        customerRepo.save(customer);

        map.put("msg",customer);
        map.put("status","success");

        entity= new ResponseEntity(map,HttpStatus.OK);
        return entity;
    }

    //-----------------------------display all customer
    @GetMapping(value = "/getallcustomer")
    public ResponseEntity<?> getallcustomer()
    {
        Map<String,Object> map = new HashMap<>();
        ResponseEntity<Map<List<Customer>,Object>> entity=null;

        List<Customer> customers= customerRepo.findAll();

        map.put("msg",customers);
        map.put("status","success");

        entity=new ResponseEntity(map,HttpStatus.OK);
        return entity;

    }

    //---------------------------find by id

    @GetMapping(value = "/findcustById")
    public ResponseEntity<?> findcustById(@RequestParam Integer id)
    {
        Map<String,Object> map =new HashMap<>();
        ResponseEntity<Map<Customer,Object>> entity=null;

        Customer customer=customerRepo.findOne(id);

        map.put("msg",customer);
        map.put("status","success");

        entity=new ResponseEntity(map,HttpStatus.OK);

        return entity;
    }

    @GetMapping(value="/updatecustbyId")
    public ResponseEntity<?> updatecustbyId(@RequestParam Integer id,@RequestParam Long mobileno)
    {
        Map<String,Object> map =new HashMap<>();
        ResponseEntity<Map<Customer,Object>> entity=null;

        Customer customer=customerRepo.findOne(id);
        customer.setMobileno(mobileno);

        customerRepo.save(customer);

        map.put("msg",customer);
        map.put("status","success");

        entity=new ResponseEntity(map,HttpStatus.OK);

        return entity;
    }

    //-------------------delete customer by id

    @GetMapping(value="/deletecustById")
    public ResponseEntity<?> deletecustById(@RequestParam Integer id)
    {
        Map<String,Object> map = new HashMap<>();
        ResponseEntity<Map<String,Object>> entity=null;

        customerRepo.delete(id);

        map.put("msg",id);
        map.put("status","success");

        entity=new ResponseEntity(map,HttpStatus.OK);

        return entity;
    }

    //---------------------------------getlist of customers

    @GetMapping(value = "/getallcustnames")
    public ResponseEntity<?> getallcustnames()
    {
        Map<String,Object> map = new HashMap<>();
        ResponseEntity<Map<List<String>,Object>> entity=null;

        List<Customer> customers=customerRepo.findAll();

        List<String> custnames = new ArrayList<>();

        for(Customer c: customers)
        {
            custnames.add(c.getName());
        }


        map.put("msg",custnames);
        map.put("status","success");

        entity=new ResponseEntity(map,HttpStatus.OK);

        return entity;
    }

    //----------------------------------------displaying more than one column using @Query


    @GetMapping(value="/getnameandmobile")
    public ResponseEntity<?> getnameanmobile()
    {
        Map<String,Object> map = new HashMap<>();
        ResponseEntity<Map<List<Object>,Object>> entity=null;


        List<Object> customerList=customerRepo.getnameandmobile();

        map.put("msg",customerList);
        map.put("status","success");

        entity=new ResponseEntity(map,HttpStatus.OK);

        return entity;

    }


    //----------------------------------------displaying more than one column


    @GetMapping(value="/getnamemobile")
    public ResponseEntity<?> getnamemobile()
    {
        Map<String,Object> map = new HashMap<>();
        ResponseEntity<Map<List<Object>,Object>> entity=null;

        List<Customer> customers=customerRepo.findAll();

        List<Object> customerList=new ArrayList<>();

        Customer c = new Customer();
        for(Customer cust:customers)
        {

            customerList.add(cust.getName());
            customerList.add(cust.getMobileno());

        }


        map.put("msg",customerList);
        map.put("status","success");

        entity=new ResponseEntity(map,HttpStatus.OK);

        return entity;

    }


}
