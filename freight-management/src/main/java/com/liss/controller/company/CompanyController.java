package com.liss.controller.company;

import com.liss.entities.compagny.CompanyEntity;
import com.liss.httpException.HttpServiceExceptionHandle;
import com.liss.service.company.CompanyService;
import com.liss.utils.HttpErrorCodes;
import com.liss.utils.HttpErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("/company")
public class CompanyController {


    @Autowired CompanyService companySer;


    /** afficher tous les company **/
    @GetMapping
    public ResponseEntity<?> getCompanies(HttpServletRequest request, @RequestParam(value = "name", required = false) String query,
                                          @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                          @RequestParam(value = "limit", required = false, defaultValue = "100") int limit){
        try{
            return new ResponseEntity<>(companySer.getAllCompany(query, page, limit), HttpStatus.OK);
        }catch (HttpServiceExceptionHandle e) {
            return new ResponseEntity<>(new HttpErrorMessage(new Date(), e.getMessage()), HttpStatus.valueOf(e.getErrorCode()));
        }

    }

    /** ajouter une company **/
    @PostMapping
    public ResponseEntity<?> addCompany(@RequestBody CompanyEntity company){
        try{

            if(company == null) throw new HttpServiceExceptionHandle("Contenue vide !!", HttpErrorCodes.BAD_FORMAT_DATA);

            return new ResponseEntity<>(companySer.addCompany(company), HttpStatus.OK);
        }catch (HttpServiceExceptionHandle e) {
            return new ResponseEntity<>(new HttpErrorMessage(new Date(), e.getMessage()), HttpStatus.valueOf(e.getErrorCode()));
        }
    }
    /** modifier  une company**/
    @PutMapping
    public ResponseEntity<?> updateCompany(@RequestBody CompanyEntity company){
        try{
            if(company == null) throw new HttpServiceExceptionHandle("Contenue vide !!", HttpErrorCodes.BAD_FORMAT_DATA);
            return new ResponseEntity<>(companySer.updateCompany(company), HttpStatus.OK);
        }catch (HttpServiceExceptionHandle e) {
            return new ResponseEntity<>(new HttpErrorMessage(new Date(), e.getMessage()), HttpStatus.valueOf(e.getErrorCode()));
        }

    }

    @GetMapping("delete")
    public ResponseEntity<?> deleteCompany(HttpServletRequest request, @RequestParam(value = "companyID", required = true) String param){
        try{
            return new ResponseEntity<>(companySer.deleteCompany(param), HttpStatus.OK);
        }catch (HttpServiceExceptionHandle e) {
            return new ResponseEntity<>(new HttpErrorMessage(new Date(), e.getMessage()), HttpStatus.valueOf(e.getErrorCode()));
        }
    }
}
