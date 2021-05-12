package service;

import models.Vehicle;

import java.util.ArrayList;

public class Manager {
    private ArrayList<Vehicle> arrayVehicle;
    private Vehicle[] array = {};

    public Manager () {
        arrayVehicle = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        arrayVehicle.add(vehicle);
    }

    public boolean removeVehicleByPlate(String plate) {
        for (Vehicle vehicle : arrayVehicle) {
            if(vehicle.getPlate().equalsIgnoreCase(plate)) {
                arrayVehicle.remove(vehicle);

                return true;
            }
        }
        return false;
    }

    public Vehicle searchVehicleByPlate(String plate) {
        for (Vehicle vehicle : arrayVehicle) {
            if (vehicle.getPlate().equalsIgnoreCase(plate)) {
                return vehicle;
            }
        }
        return null;
    } 

    public String listAllsVehicle() {
        return "\nLista de todos os veiculos: " + arrayVehicle + "\n";
    }

    public double getValueTaxVehicleByPlate(String plate) {
        for (Vehicle vehicle : arrayVehicle) {
            if (vehicle.getPlate().equalsIgnoreCase(plate)) {
                return vehicle.taxCalculate(vehicle);
            }
        }
        return -1;
    }

    public String listVehicleByFuel(String typeFuel) {
        array = new Vehicle[arrayVehicle.size()];
        int i = 0;

        for(Vehicle vehicle : arrayVehicle) {
            if (vehicle.getTypeFuel().equalsIgnoreCase(typeFuel)) {
                array[i] = vehicle;
                i++;
            }
        }

        return "\nLista de veículos: " + array;
    }
}