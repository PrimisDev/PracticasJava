package Inventario;

/**
 * @author martin.grasselli
 */

public class Producto {
    int ID, cantidad;
    double precio;
    String nombre, marca;


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    @Override
    public String toString() {
        return "Inventario{" +
                "ID: " + ID +
                ", cantidad: " + cantidad +
                ", precio: " +"$"+ precio +
                ", nombre: '" + nombre + '\'' +
                ", marca: '" + marca + '\'' +
                '}';
    }
}
