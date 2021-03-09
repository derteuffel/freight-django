package com.liss.service.offers;

import com.liss.entities.management.UserEntity;
import com.liss.entities.offers.FreightEntity;
import com.liss.entities.offers.InfoVehicleEntity;
import com.liss.entities.staticclass.VehicleSizeEntity;
import com.liss.helpers.FreightDto;
import com.liss.httpException.HttpServiceExceptionHandle;
import com.liss.repositories.mangement.UserRepository;
import com.liss.repositories.offers.DestinationRepository;
import com.liss.repositories.offers.FreightRepository;
import com.liss.repositories.offers.InfoVehicleRepository;
import com.liss.repositories.staticclass.AdditionalEquipmentRepository;
import com.liss.repositories.staticclass.ChargingModeRepository;
import com.liss.repositories.staticclass.VehicleSizeRepository;
import com.liss.repositories.staticclass.VehicleTypeRepository;
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
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = {HttpServiceExceptionHandle.class, SQLException.class }, noRollbackFor = EntityNotFoundException.class)
public class FreightService {

    @Autowired
    FreightRepository freightRep;

    @Autowired
    UserRepository userRep;
    @Autowired
    InfoVehicleRepository infoRep;

    @Autowired
    VehicleSizeRepository vehicleSizeRep;

    @Autowired
    AdditionalEquipmentRepository addRep;

    @Autowired
    VehicleTypeRepository vehicleTypeRep;

    @Autowired
    ChargingModeRepository chargingModeRep;

    @Autowired
    DestinationRepository destinationRepository;


    /** ajout d'un freight **/
    public FreightEntity addFreight(FreightEntity entity) {
        try {
               if (entity == null) throw new HttpServiceExceptionHandle("Impossible de sauvegarder ce freight", HttpErrorCodes.BAD_FORMAT_DATA);
               UserEntity user = userRep.getOne(entity.getUser().getId());
               if(user == null)throw new HttpServiceExceptionHandle("Le user pour lequel vous essayer d'enregistrer un freight n'existe pas", HttpErrorCodes.BAD_FORMAT_DATA);
               InfoVehicleEntity info = infoRep.getInfoVehicleById(entity.getInfoVehicle().getId());
               if (info == null) throw  new HttpServiceExceptionHandle("Les infos pour lequel vous essayer d'enregistrer un freight n'existe pas", HttpErrorCodes.BAD_FORMAT_DATA);
               VehicleSizeEntity vehicleSize = vehicleSizeRep.getOne(entity.getVehicleSize().getId());
               if (vehicleSize == null) throw new HttpServiceExceptionHandle("Les vehicle size pour lequel vous essayer d'enregistrer un freight n'existe pas", HttpErrorCodes.BAD_FORMAT_DATA);
               FreightEntity freight = freightRep.getFreightById(entity.getId());
               if (entity.getCharging_modes() != null)freight.setCharging_modes(entity.getCharging_modes().stream().map(item -> {

                   return chargingModeRep.getOne(item.getId());

               }).collect(Collectors.toList()));

               if (entity.getAdditional_equipments() != null)freight.setAdditional_equipments(entity.getAdditional_equipments().stream().map(item -> {

                    return addRep.getOne(item.getId());

                }).collect(Collectors.toList()));

               if (entity.getVehicle_types() != null)freight.setVehicle_types(entity.getVehicle_types().stream().map(item -> {

                   return vehicleTypeRep.getOne(item.getId());

               }).collect(Collectors.toList()));

                return freightRep.save(freight);
        }catch (HttpServiceExceptionHandle e) {
            HttpErrorCodes code = (e.getErrorCode() != null ? HttpErrorCodes.fromId(e.getErrorCode()) : HttpErrorCodes.INTERNAL_SERVER_ERROR);
            throw new HttpServiceExceptionHandle(e.getMessage(),code);
        }
    }

    /** ajout d'un freight **/
    public FreightEntity saveFreight(FreightDto entity) {
        try {

            FreightEntity freightEntity = new FreightEntity();
            InfoVehicleEntity info = infoRep.getInfoVehicleById(entity.getInfoVehicleId());
            if (info == null){
                throw  new HttpServiceExceptionHandle("Les infos pour lequel vous essayer d'enregistrer un freight n'existe pas", HttpErrorCodes.BAD_FORMAT_DATA);
            }else {
                freightEntity.setInfoVehicle(info);
            }
            VehicleSizeEntity vehicleSize = vehicleSizeRep.getOne(entity.getVehicleSizeId());
            if (vehicleSize == null){
                throw new HttpServiceExceptionHandle("Les vehicle size pour lequel vous essayer d'enregistrer un freight n'existe pas", HttpErrorCodes.BAD_FORMAT_DATA);
            }else {
                freightEntity.setVehicleSize(vehicleSize);
            }
            if (!(entity.getChargingModes().isEmpty())){
                freightEntity.setCharging_modes(entity.getChargingModes().stream().map(item -> {

                    return chargingModeRep.getOne(item.getId());

                }).collect(Collectors.toList()));
            }

            if (!(entity.getTragets().isEmpty())){
                freightEntity.setTrajet(entity.getTragets().stream().map(item -> {

                    return destinationRepository.getOne(item.getId());

                }).collect(Collectors.toList()));
            }

            if (!(entity.getAdditionalEquipments().isEmpty())){
                freightEntity.setAdditional_equipments(entity.getAdditionalEquipments().stream().map(item -> {

                    return addRep.getOne(item.getId());

                }).collect(Collectors.toList()));
            }

            if (!(entity.getVehicleTypes().isEmpty())){
                freightEntity.setVehicle_types(entity.getVehicleTypes().stream().map(item -> {

                    return vehicleTypeRep.getOne(item.getId());

                }).collect(Collectors.toList()));
            }

            return freightRep.save(freightEntity);
        }catch (HttpServiceExceptionHandle e) {
            HttpErrorCodes code = (e.getErrorCode() != null ? HttpErrorCodes.fromId(e.getErrorCode()) : HttpErrorCodes.INTERNAL_SERVER_ERROR);
            throw new HttpServiceExceptionHandle(e.getMessage(),code);
        }
    }


    /** modifier un freight **/

    public FreightEntity updateFreight(FreightDto freight, String id) {
        try {

            InfoVehicleEntity info = infoRep.getInfoVehicleById(freight.getInfoVehicleId());
            FreightEntity freightEntity = freightRep.getOne(id);
            if (info == null){
                throw  new HttpServiceExceptionHandle("Les infos pour lequel vous essayer d'enregistrer un freight n'existe pas", HttpErrorCodes.BAD_FORMAT_DATA);
            }else {
                freightEntity.setInfoVehicle(info);
            }
            VehicleSizeEntity vehicleSize = vehicleSizeRep.getOne(freight.getVehicleSizeId());
            if (vehicleSize == null){
                throw new HttpServiceExceptionHandle("Les vehicle size pour lequel vous essayer d'enregistrer un freight n'existe pas", HttpErrorCodes.BAD_FORMAT_DATA);
            }else {
                freightEntity.setVehicleSize(vehicleSize);
            }
            if (!(freight.getChargingModes().isEmpty())){
                freightEntity.setCharging_modes(freight.getChargingModes().stream().map(item -> {

                    return chargingModeRep.getOne(item.getId());

                }).collect(Collectors.toList()));
            }

            if (!(freight.getTragets().isEmpty())){
                freightEntity.setTrajet(freight.getTragets().stream().map(item -> {

                    return destinationRepository.getOne(item.getId());

                }).collect(Collectors.toList()));
            }

            if (!(freight.getAdditionalEquipments().isEmpty())){
                freightEntity.setAdditional_equipments(freight.getAdditionalEquipments().stream().map(item -> {

                    return addRep.getOne(item.getId());

                }).collect(Collectors.toList()));
            }

            if (!(freight.getVehicleTypes().isEmpty())){
                freightEntity.setVehicle_types(freight.getVehicleTypes().stream().map(item -> {

                    return vehicleTypeRep.getOne(item.getId());

                }).collect(Collectors.toList()));
            }

            return freightRep.save(freightEntity);
        }catch (HttpServiceExceptionHandle e) {
            HttpErrorCodes code = (e.getErrorCode() != null ? HttpErrorCodes.fromId(e.getErrorCode()) : HttpErrorCodes.INTERNAL_SERVER_ERROR);
            throw new HttpServiceExceptionHandle(e.getMessage(),code);
        }

    }


    /*public Map<String, Object> getAllFreight(String param, String active, int page, int limit) {

        try {
            Map<String, Object> params = new HashMap<>();
            return null;
        }catch (HttpServiceExceptionHandle e) {
            HttpErrorCodes code = (e.getErrorCode() != null ? HttpErrorCodes.fromId(e.getErrorCode()) : HttpErrorCodes.INTERNAL_SERVER_ERROR);
            throw new HttpServiceExceptionHandle(e.getMessage(),code);
        }

    }*/

    public Page<FreightEntity> getAllFreight( int page, int limit) {

        try {
            Page<FreightEntity> params = freightRep.findAllFreight(new PageRequest(limit,page));
            return params;
        }catch (HttpServiceExceptionHandle e) {
            HttpErrorCodes code = (e.getErrorCode() != null ? HttpErrorCodes.fromId(e.getErrorCode()) : HttpErrorCodes.INTERNAL_SERVER_ERROR);
            throw new HttpServiceExceptionHandle(e.getMessage(),code);
        }

    }


    public Boolean disabledFreight(String reference) {
        try {
            FreightEntity freightEntity = freightRep.getOne(reference);
            freightEntity.setEnable(false);
            freightRep.save(freightEntity);
            return true;
        }catch (HttpServiceExceptionHandle e) {
            HttpErrorCodes code = (e.getErrorCode() != null ? HttpErrorCodes.fromId(e.getErrorCode()) : HttpErrorCodes.INTERNAL_SERVER_ERROR);
            throw new HttpServiceExceptionHandle(e.getMessage(),code);
        }
    }

    public FreightEntity getFreightById(String ref) {
        try {
            FreightEntity freightEntity = freightRep.getFreightById(ref);
            if (freightEntity != null){
                return freightEntity;
            }else {
                throw  new HttpServiceExceptionHandle("Il n'existe aucun freight avec la reference : "+ ref, HttpErrorCodes.NO_CONTENT_DATA);
            }
        }catch (HttpServiceExceptionHandle e) {
            HttpErrorCodes code = (e.getErrorCode() != null ? HttpErrorCodes.fromId(e.getErrorCode()) : HttpErrorCodes.INTERNAL_SERVER_ERROR);
            throw new HttpServiceExceptionHandle(e.getMessage(),code);
        }


    }


    public Boolean removeLocationToFreight(String freightId, String locationId) {
        try {
            return false;
        }catch (HttpServiceExceptionHandle e) {
            HttpErrorCodes code = (e.getErrorCode() != null ? HttpErrorCodes.fromId(e.getErrorCode()) : HttpErrorCodes.INTERNAL_SERVER_ERROR);
            throw new HttpServiceExceptionHandle(e.getMessage(),code);
        }

    }



}
