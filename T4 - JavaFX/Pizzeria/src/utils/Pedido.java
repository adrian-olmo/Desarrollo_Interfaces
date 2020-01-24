package utils;

public class Pedido{

    int idPedido, telefono;
    String nombre, pizza;
    boolean entregado;

    public Pedido(int idPedido, int telefono, String nombre, String pizza, boolean entregado) {
        this.idPedido = idPedido;
        this.telefono = telefono;
        this.nombre = nombre;
        this.pizza = pizza;
        this.entregado = entregado;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPizza() {
        return pizza;
    }

    public boolean isEntregado() {
        return entregado;
    }
}
