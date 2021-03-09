package com.liss.helpers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FreightDto {


    private String infoVehicleId;
    private String vehicleSizeId;
    private ArrayList<String> additionalEquipments = new ArrayList<>();
    private ArrayList<String> vehicleTypes = new ArrayList<>();
    private ArrayList<String> chargingModes = new ArrayList<>();
    private ArrayList<String> tragets = new ArrayList<>();

    public String getInfoVehicleId() {
        return infoVehicleId;
    }

    public void setInfoVehicleId(String infoVehicleId) {
        this.infoVehicleId = infoVehicleId;
    }

    public String getVehicleSizeId() {
        return vehicleSizeId;
    }

    public void setVehicleSizeId(String vehicleSizeId) {
        this.vehicleSizeId = vehicleSizeId;
    }

    public ArrayList<String> getAdditionalEquipments() {
        return additionalEquipments;
    }

    public void setAdditionalEquipments(ArrayList<String> additionalEquipments) {
        this.additionalEquipments = additionalEquipments;
    }

    public ArrayList<String> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(ArrayList<String> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }

    public ArrayList<String> getChargingModes() {
        return chargingModes;
    }

    public void setChargingModes(ArrayList<String> chargingModes) {
        this.chargingModes = chargingModes;
    }

    public ArrayList<String> getTragets() {
        return tragets;
    }

    public void setTragets(ArrayList<String> tragets) {
        this.tragets = tragets;
    }
}
