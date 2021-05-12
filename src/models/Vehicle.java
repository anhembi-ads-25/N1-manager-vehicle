package models;

import java.time.LocalDate;

public class Vehicle {
    LocalDate date = LocalDate.now();
    int currentYear = date.getYear();

    private String model;
    private String brand;
    private int yearManufacture;
    private double marketValue;
    private String plate;
    private String typeFuel;

    public Vehicle(String model, String brand, int yearManufacture, double marketValue, String plate, String typeFuel) {
        this.model = model;
        this.brand = brand;
        this.yearManufacture = yearManufacture;
        this.marketValue = marketValue;
        this.plate = plate;
        this.typeFuel = typeFuel;
    }

    public double taxCalculate(Vehicle vehicle) {
        int result = currentYear - vehicle.yearManufacture;
        double tax = 0;
        
        if (result < 20) {
            return 0;
        }

        if (vehicle.typeFuel.equals("gasolina") || vehicle.typeFuel.equals("diesel") || vehicle.typeFuel.equals("flex") ) {
            // 4% valor de mercado p aqueles que usam gasolina, diesel ou flex
            tax = (vehicle.marketValue / 100) * 4;

            return tax;
        } else {
            // 3% para outros combustiveis
            tax = (vehicle.marketValue / 100) * 3;
            
            return tax;
        }
    }

    public String print() {
        return "\nDados do veículo: " 
        + "\nModelo: " + this.model 
        + "\nMarca: " + this.brand 
        + "\nAno de Fabricação: " + this.yearManufacture
        + "\nValor de mercado: " + this.marketValue
        + "\nPlaca: " + this.plate
        + "\nCombustível: " + this.typeFuel;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public int getYearManufacture() {
        return yearManufacture;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }

    public double getMarketValue() {
        return marketValue;
    }

    public String getPlate() {
        return plate;
    }

    public String getTypeFuel() {
        return typeFuel;
    }

}
