package service;

import models.Vehicle;

import java.util.ArrayList;

public class Manager {
    ArrayList<Vehicle> arrayVehicle = new ArrayList<>();

    Vehicle[] array = {};

    public void addVehicle(Vehicle vehicle) {
        arrayVehicle.add(vehicle);
    }

    public boolean removeVehicle(String plate) {
        for (Vehicle vehicle : arrayVehicle) {
            if(vehicle.getPlate().equals(plate)) {
                arrayVehicle.remove(plate);

                return true;
            }
        }
        return false;
    }

    public Vehicle searchPlate(String plate) {
        for (Vehicle vehicle : arrayVehicle) {
            if (vehicle.getPlate().equals(plate)) {
                return vehicle;
            }
        }
        return null;
    } 

    public String listAllsVehicle() {
        return "Lista de veiculos: " + arrayVehicle;
    }

    public double getValueTax(String plate) {
        for (Vehicle vehicle : arrayVehicle) {
            if (vehicle.getPlate().equals(plate)) {
                return vehicle.taxCalculate(vehicle);
            }
        }
        return -1;
    }

    public String listVehicleByFuel(String typeFuel) {
        array = new Vehicle[arrayVehicle.size()];
        int i = 0;

        for(Vehicle vehicle : arrayVehicle) {
            if (vehicle.getTypeFuel().equals(typeFuel)) {
                array[i] = vehicle;
                i++;
            }
        }

        return "Lista de veículos: " + array;
    }
}