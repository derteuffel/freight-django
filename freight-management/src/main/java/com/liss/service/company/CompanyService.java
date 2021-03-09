package com.liss.service.company;


import com.liss.entities.compagny.CompanyEntity;
import com.liss.httpException.HttpServiceExceptionHandle;
import com.liss.repositories.company.CompanyRepository;
import com.liss.utils.HttpErrorCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional(rollbackFor = {HttpServiceExceptionHandle.class, SQLException.class }, noRollbackFor = EntityNotFoundException.class)
public class CompanyService {

    @Autowired CompanyRepository companyRep;



    /** afficher la liste des company **/

    public Map<String, Object> getAllCompany(String name, int page, int limit) {

        try{
            Map<String, Object> results = new HashMap<>();
            Pageable paging = PageRequest.of( page, limit);
            Page<CompanyEntity> companyEntities = null;
            if (name == null) companyEntities = companyRep.findAllCompany(paging);
            else companyEntities = companyRep.getAllCompanyByPram(paging, name);
            results.put("data", companyEntities.getContent());
            results.put("currentPage", companyEntities.getNumber());
            results.put("totalItems", companyEntities.getTotalElements());
            results.put("totalPages", companyEntities.getTotalPages());

            return results;
        }catch (HttpServiceExceptionHandle e) {
            HttpErrorCodes code = (e.getErrorCode() != null ? HttpErrorCodes.fromId(e.getErrorCode()) : HttpErrorCodes.INTERNAL_SERVER_ERROR);
            throw new HttpServiceExceptionHandle(e.getMessage(),code);
        }

    }


    /**ajout d'une compagnie **/

    public CompanyEntity addCompany(CompanyEntity company) {
       try {
           if (company == null) throw new HttpServiceExceptionHandle("la company envoyée est vide", HttpErrorCodes.INTERNAL_SERVER_ERROR);
           if(companyRep.findByName(company.getName()) != null) throw new HttpServiceExceptionHandle(" ce nom de company existe déjà", HttpErrorCodes.CONFLITS);
           if (companyRep.findByVat(company.getVat()) != null) throw new HttpServiceExceptionHandle("cette tva existe déjà", HttpErrorCodes.CONFLITS);
           return companyRep.save(company);
       }catch (HttpServiceExceptionHandle e) {
           HttpErrorCodes code = (e.getErrorCode() != null ? HttpErrorCodes.fromId(e.getErrorCode()) : HttpErrorCodes.INTERNAL_SERVER_ERROR);
           throw new HttpServiceExceptionHandle(e.getMessage(),code);
       }

    }

    /** modifier une company **/

    public CompanyEntity updateCompany(CompanyEntity comp) {
        try {

            if (comp.getId() == null)
                throw new HttpServiceExceptionHandle("company introuvable", HttpErrorCodes.INTERNAL_SERVER_ERROR);
            CompanyEntity company = companyRep.findByID(comp.getId());
            if (company == null)
                throw new HttpServiceExceptionHandle("company introuvable", HttpErrorCodes.INTERNAL_SERVER_ERROR);
            company.setName(comp.getName());
            company.setAddress(comp.getAddress());
            company.setCountry(comp.getCountry());
            company.setEmail(comp.getEmail());
            company.setCompanyType(comp.getCompanyType());
            company.setPostalCode(comp.getPostalCode());
            company.setPhone(comp.getPhone());
            company.setTown(comp.getTown());
            company.setVat(comp.getVat());
            return companyRep.save(company);

        } catch (HttpServiceExceptionHandle e) {
            HttpErrorCodes code = (e.getErrorCode() != null ? HttpErrorCodes.fromId(e.getErrorCode()) : HttpErrorCodes.INTERNAL_SERVER_ERROR);
            throw new HttpServiceExceptionHandle(e.getMessage(), code);
        }
    }



        /**  suppression d'une company**/

        public boolean deleteCompany(String id) {
            try {
                CompanyEntity company = companyRep.findByID(id);
                if(company == null) throw new HttpServiceExceptionHandle("Client introuvable",HttpErrorCodes.INTERNAL_SERVER_ERROR);
                if(company.getIsDeleted() == true) company.setIsDeleted(false);
                else company.setIsDeleted(true);
                companyRep.save(company);
                return true;
            }catch (HttpServiceExceptionHandle e) {
                HttpErrorCodes code = (e.getErrorCode() != null ? HttpErrorCodes.fromId(e.getErrorCode()) : HttpErrorCodes.INTERNAL_SERVER_ERROR);
                throw new HttpServiceExceptionHandle(e.getMessage(),code);
            }
        }

}
