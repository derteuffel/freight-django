package com.liss.controller.offers;

import com.liss.entities.compagny.CompanyEntity;
import com.liss.entities.offers.DestinationEntity;
import com.liss.httpException.HttpServiceExceptionHandle;
import com.liss.service.offers.DestinationService;
import com.liss.utils.HttpErrorCodes;
import com.liss.utils.HttpErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("/destination")
public class DestinationController {

    @Autowired
    DestinationService destinationService;

    /** ajouter une destination **/
    @PostMapping
    public ResponseEntity<?> addDestination(@RequestBody DestinationEntity des){
        try{

            if(des == null) throw new HttpServiceExceptionHandle("Contenue vide !!", HttpErrorCodes.BAD_FORMAT_DATA);

            return new ResponseEntity<>(destinationService.addDestination(des), HttpStatus.OK);
        }catch (HttpServiceExceptionHandle e) {
            return new ResponseEntity<>(new HttpErrorMessage(new Date(), e.getMessage()), HttpStatus.valueOf(e.getErrorCode()));
        }
    }
    /** modifier  une destination**/
    @PutMapping
    public ResponseEntity<?> updateDestination(@RequestBody DestinationEntity des){
        try{
            if(des == null) throw new HttpServiceExceptionHandle("Contenue vide !!", HttpErrorCodes.BAD_FORMAT_DATA);
            return new ResponseEntity<>(destinationService.updateDestination(des), HttpStatus.OK);
        }catch (HttpServiceExceptionHandle e) {
            return new ResponseEntity<>(new HttpErrorMessage(new Date(), e.getMessage()), HttpStatus.valueOf(e.getErrorCode()));
        }

    }

    @GetMapping("delete")
    public ResponseEntity<?> deleteDestination(HttpServletRequest request, @RequestParam(value = "DestinationID", required = true) String param){
        try{
            return new ResponseEntity<>(destinationService.deleteDestination(param), HttpStatus.OK);
        }catch (HttpServiceExceptionHandle e) {
            return new ResponseEntity<>(new HttpErrorMessage(new Date(), e.getMessage()), HttpStatus.valueOf(e.getErrorCode()));
        }
    }
}
