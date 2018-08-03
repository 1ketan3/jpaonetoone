package com.ketan.onetoonejpa.controller;

import com.ketan.onetoonejpa.domain.Bill;
import com.ketan.onetoonejpa.repository.BillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BillController
{
    @Autowired
    private BillRepo billRepo;

   @PostMapping(value="/saveBill")
    public ResponseEntity<?> saveBill(@RequestBody Bill bill)
   {
       Map<String,Object> map = new HashMap<>();
       ResponseEntity<Map<Bill,Object>> entity=null;

       billRepo.save(bill);

       map.put("msg",bill);
       map.put("status","success");
       entity=new ResponseEntity(map,HttpStatus.OK);

       return entity;
   }


   //--------------------------delete bill by id

    @GetMapping(value="/deletebillById")
    public ResponseEntity<?> deletebillById(@RequestParam Integer id)
    {
        Map<String,Object> map = new HashMap<>();
        ResponseEntity<Map<String,Object>> entity=null;

        billRepo.delete(id);

        map.put("msg",id);
        map.put("status","success");

        entity=new ResponseEntity(map,HttpStatus.OK);

        return entity;
    }

}
