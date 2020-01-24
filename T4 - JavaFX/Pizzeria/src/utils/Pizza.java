package utils;

public class Pizza {

    String nombre, ingrediente1, ingrediente2, ingrediente3;


    public Pizza(String nombre, String ingrediente1, String ingrediente2, String ingrediente3, boolean entregado) {
        this.nombre = nombre;
        this.ingrediente1 = ingrediente1;
        this.ingrediente2 = ingrediente2;
        this.ingrediente3 = ingrediente3;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIngrediente1() {
        return ingrediente1;
    }

    public String getIngrediente2() {
        return ingrediente2;
    }

    public String getIngrediente3() {
        return ingrediente3;
    }

}
