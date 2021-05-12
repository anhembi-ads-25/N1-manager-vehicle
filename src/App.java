import java.time.LocalDate;
import java.util.Scanner;

import models.Vehicle;
import service.Manager;

public class App {
    public static void main(String[] args) throws Exception {
        Manager manager = new Manager();

        do {
            switch (selectOperation()) {
                case 1:
                    System.out.println(storeVehicleOperation(manager));
                    break;

                case 2:
                    System.out.println(deleteVehicleOperation(manager));
                    break;

                case 3:
                    System.out.println(getVehicleByPlate(manager));
                    break;

                case 4:
                    System.out.println(listAllsVehicle(manager));
                    break;

                case 5:
                    System.out.println(getValueTaxByVehicle(manager));
                    break;

                case 6:
                    System.out.println(listVehicleByFuel(manager));
                    break;

                case 7:
                    System.out.println("\nAté logo!");
                    break;

                default:
                    System.out.println("\nInvalid option!");
                    break;
            }
        } while (selectOperation() != 7);
    }

    public static int selectOperation() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Bem-vindo de volta!");
        System.out.println("Selecione o tipo de operação que deseja fazer:");

        System.out.println("\n1 - Adicionar carro");
        System.out.println("2 - Remover carro");
        System.out.println("3 - Buscar veículo");
        System.out.println("4 - Listar todos os veículo");
        System.out.println("5 - Valor do imposto por veículo");
        System.out.println("6 - Listar veículo por tipo de combustível");
        System.out.println("7 - Sair");

        int operations = keyboard.nextInt();

        return operations;
    }

    public static String storeVehicleOperation(Manager manager) {
        Scanner keyboard = new Scanner(System.in);

        LocalDate date = LocalDate.now();

        System.out.println("\nModelo do carro:");
        String model = keyboard.nextLine();

        while (model.length() < 3) {
            System.out.println("Por favor, digite um modelo de carro válido.");
            model = keyboard.nextLine();
        }

        System.out.println("\nMarca do carro:");
        String brand = keyboard.nextLine();

        while (brand.length() < 3) {
            System.out.println("Por favor, digite uma marca de carro válida.");
            brand = keyboard.nextLine();
        }

        System.out.println("\nAno de fabricação do carro:");
        int yearManufacture = keyboard.nextInt();

        while (yearManufacture < 1900 && yearManufacture > date.getYear()) {
            System.out.println("Por favor, digite um ano válido de fabricação do carro.");
            yearManufacture = keyboard.nextInt();
        }

        System.out.println("\nValor no mercado do carro:");
        double marketValue = keyboard.nextDouble();

        while (marketValue <= 0) {
            System.out.println("Por favor, digite o valor do carro.");
            marketValue = keyboard.nextDouble();
        }

        System.out.println("\nPlaca do carro:");
        String plate = keyboard.nextLine();

        while (plate.length() < 7 || plate.length() > 7) {
            System.out.println("Por favor, digite uma placa válida.");
            plate = keyboard.nextLine();
        }

        System.out.println("\nTipo de combustível do carro (álcool, gasolina, flex, GNV ou diesel): ");
        String typeFuel = keyboard.nextLine();

        while (typeFuel.length() < 3) {
            System.out.println("Por favor, digite um tipo de combustível válido.");
            typeFuel = keyboard.nextLine();
        }

        Vehicle vehicle = new Vehicle(model, brand, yearManufacture, marketValue, plate, typeFuel);

        manager.addVehicle(vehicle);

        return "\n";
    }

    public static String deleteVehicleOperation(Manager manager) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("\nPara deletar um veículo, por favor, digite a placa:");
        String plate = keyboard.nextLine();

        while (plate.length() < 7 || plate.length() > 7) {
            System.out.println("Por favor, digite a placa do carro.");
            plate = keyboard.nextLine();
        }

        if (manager.removeVehicleByPlate(plate)) {
            return "\nVeículo deletado com sucesso!";
        }

        return "\nOcorreu um erro de operação!";

    }

    public static String getVehicleByPlate(Manager manager) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("\nPara localizar um veículo, por favor, digite a placa:");
        String plate = keyboard.nextLine();

        while (plate.length() < 7 || plate.length() > 7) {
            System.out.println("Por favor, digite a placa do carro.");
            plate = keyboard.nextLine();
        }

        return "\nVeículo localizado! " + manager.searchVehicleByPlate(plate);

    }

    public static String listAllsVehicle(Manager manager) {
        return manager.listAllsVehicle();
    }

    public static String getValueTaxByVehicle(Manager manager) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("\nPara verificar o imposto de um veículo, por favor, digite a placa:");
        String plate = keyboard.nextLine();

        while (plate.length() < 7 || plate.length() > 7) {
            System.out.println("Por favor, digite a placa do carro.");
            plate = keyboard.nextLine();
        }

        double valueTax = manager.getValueTaxVehicleByPlate(plate);

        return "\nO imposto a ser pago pelo veículo é de: R$" + valueTax;
    }

    public static String listVehicleByFuel(Manager manager) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println(
                "\nSelecione o tipo de combustível para filtrar os veículos (álcool, gasolina, flex, GNV ou diesel): ");

        String typeFuel = keyboard.nextLine();

        while (typeFuel.length() < 3) {
            System.out.println("Por favor, digite um tipo de combustível.");
            typeFuel = keyboard.nextLine();
        }

        return manager.listVehicleByFuel(typeFuel);
    }
}