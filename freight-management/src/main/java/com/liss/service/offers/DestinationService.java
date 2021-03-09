package com.liss.service.offers;


import com.liss.entities.offers.DestinationEntity;
import com.liss.entities.offers.FreightEntity;
import com.liss.entities.offers.VehicleEntity;
import com.liss.httpException.HttpServiceExceptionHandle;
import com.liss.repositories.offers.DestinationRepository;
import com.liss.repositories.offers.FreightRepository;
import com.liss.repositories.offers.VehicleRepository;
import com.liss.utils.HttpErrorCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLException;

@Service
@Transactional(rollbackFor = {HttpServiceExceptionHandle.class, SQLException.class }, noRollbackFor = EntityNotFoundException.class)
public class DestinationService {

    @Autowired
    DestinationRepository destinationRep;
    @Autowired
    FreightRepository freightRep;
    @Autowired
    VehicleRepository vehicleRep;


    /** ajouter une destination **/

    public DestinationEntity addDestination(DestinationEntity des) {
        try {

                if(des == null ) throw  new HttpServiceExceptionHandle("destination vide", HttpErrorCodes.BAD_FORMAT_DATA);
                FreightEntity freight = freightRep.getOne(des.getFreight().getId());
                if (freight == null) throw new HttpServiceExceptionHandle("Le freight pour lequel vous essayer d'enregistrer un destination n'existe pas", HttpErrorCodes.BAD_FORMAT_DATA);
                VehicleEntity vehicle = vehicleRep.getOne(des.getVehicle().getId());
                if (vehicle == null) throw new HttpServiceExceptionHandle("Le vehicle pour lequel vous essayer d'enregistrer un destination n'existe pas", HttpErrorCodes.BAD_FORMAT_DATA);
                des.setFreight(freight);
                des.setVehicle(vehicle);
                des.setCity(des.getCity());
                des.setCountry(des.getCountry());
                des.setLatitude(des.getLatitude());
                des.setLongitude(des.getLongitude());
                des.setNumber(des.getNumber());
                des.setPostalCode(des.getPostalCode());
                des.setIsLoading(false);
            return destinationRep.save(des);

        }catch (HttpServiceExceptionHandle e) {
            HttpErrorCodes code = (e.getErrorCode() != null ? HttpErrorCodes.fromId(e.getErrorCode()) : HttpErrorCodes.INTERNAL_SERVER_ERROR);
            throw new HttpServiceExceptionHandle(e.getMessage(),code);
        }
    }


    /** update destination **/
    public DestinationEntity updateDestination(DestinationEntity entity) {
        try {
            DestinationEntity des = destinationRep.getDestinationById(entity.getId());
            if(des == null) throw new HttpServiceExceptionHandle("Cette destination n'est pas dans le systeme !!", HttpErrorCodes.NO_CONTENT_DATA);
            FreightEntity freight = freightRep.getOne(des.getFreight().getId());
            if(freight == null) throw new HttpServiceExceptionHandle("Le freight pour lequel vous essayez de modifier une commande n'existe pas", HttpErrorCodes.BAD_FORMAT_DATA);
            des.setFreight(entity.getFreight());
            VehicleEntity vehicle = vehicleRep.getOne(des.getVehicle().getId());
            if(vehicle == null) throw new HttpServiceExceptionHandle("Le vehicle pour lequel vous essayez de modifier une commande n'existe pas", HttpErrorCodes.BAD_FORMAT_DATA);
            des.setVehicle(entity.getVehicle());
            des.setCity(entity.getCity());
            des.setCountry(entity.getCountry());
            des.setLatitude(entity.getLatitude());
            des.setLongitude(entity.getLongitude());
            des.setNumber(entity.getNumber());
            des.setPostalCode(entity.getPostalCode());
            return destinationRep.save(des);
        }catch (HttpServiceExceptionHandle e) {
            HttpErrorCodes code = (e.getErrorCode() != null ? HttpErrorCodes.fromId(e.getErrorCode()) : HttpErrorCodes.INTERNAL_SERVER_ERROR);
            throw new HttpServiceExceptionHandle(e.getMessage(),code);
        }
    }

    /**  suppression d'une destination **/
    public Boolean deleteDestination(String id) {
        try {
            DestinationEntity entity = destinationRep.getDestinationById(id);
            if(entity.getIsDeleted() != true) {
                entity.setIsDeleted(true);
            }else {
                entity.setIsDeleted(false);
            }
            return true;
        }catch (HttpServiceExceptionHandle e) {
            HttpErrorCodes code = (e.getErrorCode() != null ? HttpErrorCodes.fromId(e.getErrorCode()) : HttpErrorCodes.INTERNAL_SERVER_ERROR);
            throw new HttpServiceExceptionHandle(e.getMessage(),code);
        }
    }

}
