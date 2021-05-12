package types;

public enum Fuel {

    ALCOOL("álcool"),
    GASOLINA("gasolina"),
    FLEX("flex"),
    GNV("GNV"),
    DIESEL("diesel");

    private String typeFuel;

    Fuel(String typeFuel) {
        this.typeFuel = typeFuel;
    }

    public String getTypeFuel() {
        return this.typeFuel;
    }
}