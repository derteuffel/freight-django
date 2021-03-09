package com.liss.controller.offers;

import com.liss.entities.offers.FreightEntity;
import com.liss.helpers.FreightDto;
import com.liss.httpException.HttpServiceExceptionHandle;
import com.liss.service.offers.FreightService;
import com.liss.utils.HttpErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("/freight")
public class FreightController {


    @Autowired
    FreightService service;


    @PostMapping("add")
    public ResponseEntity<?> saveFreight(@RequestBody FreightDto freight) {

        try{
            return new ResponseEntity<>(service.saveFreight(freight), HttpStatus.CREATED);
            //messagingTemplate.convertAndSend("/sec/topic/public/freights", res);
        }catch (HttpServiceExceptionHandle e) {
            return new ResponseEntity<>(new HttpErrorMessage(new Date(), e.getMessage()), HttpStatus.valueOf(e.getErrorCode()));
        }

    }

    /*** modifier un freight **/
    @PutMapping("update")
    public ResponseEntity<?> updateFreight(@RequestBody FreightDto freight, @PathVariable String reference, HttpServletRequest request) {

        try{
            return new ResponseEntity<>(service.updateFreight(freight,reference), HttpStatus.ACCEPTED);
            //messagingTemplate.convertAndSend("/sec/topic/public/freights", res);
        }catch (HttpServiceExceptionHandle e) {
            return new ResponseEntity<>(new HttpErrorMessage(new Date(), e.getMessage()), HttpStatus.valueOf(e.getErrorCode()));
        }
    }

    /*** afficher la liste des freights **/
    @GetMapping
    public  ResponseEntity<?> getAllFreight(
            @RequestParam(name="query", defaultValue="",required=false)String param,
            @RequestParam(name="active", defaultValue="",required=false)String active,
            @RequestParam(name="page",defaultValue="0",required=false)int page,
            @RequestParam(name="limit",defaultValue="100",required=false)int limit) {

        try {
            // messagingTemplate.convertAndSend("/sec/topic/freight", res);
            return new ResponseEntity<>(service.getAllFreight(page,limit), HttpStatus.OK);
        }catch (HttpServiceExceptionHandle e) {
            return new ResponseEntity<>(new HttpErrorMessage(new Date(), e.getMessage()), HttpStatus.valueOf(e.getErrorCode()));
        }



    }



}
