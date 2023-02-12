package Inventario;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author martin.grasselli
 *
 */
public class Inventario {
    //Arreglo de producto
    static ArrayList<Producto> productos = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line argument
     */
    public static void main(String[] args) {
        //TODO code aplication logic here
        leerProducto();
        mostrarProducto();
    }

    private static void leerProducto() {
        int contador;
        String nombreP, marcaP;
        int cantidadP;
        double precioP;
        Producto aux; //auxiliar de producto para almacenar atributos

        do{
            System.out.println("Ingresa la cantidad de productos: ");
            contador = sc.nextInt();
        }while(contador <=0);

            //Pedir y guardar los atributos del producto
        for (int i = 0; i < contador; i++) {
            sc.nextLine();
            System.out.println("Ingresar producto: " + i);
            System.out.print("Ingresar nombre: ");
            nombreP = sc.nextLine();
            System.out.print("Ingresar marca: ");
            marcaP = sc.nextLine();
            System.out.print("Ingresar stock: ");
            cantidadP = sc.nextInt();
            System.out.print("Ingresar precio: ");
            precioP = sc.nextDouble();

            aux = new Producto(); //inicializamos el objeto

            aux.setID(i);
            aux.setNombre(nombreP);
            aux.setMarca(marcaP);
            aux.setCantidad(cantidadP);
            aux.setPrecio(precioP);
            productos.add(aux); //ingresamos por teclado lo que leemos al array de producto
            mostrarProducto();
        }

    }

    private static void mostrarProducto() { //mostrar productos
        //se muestra todo lo que ingresamos previamente
        for (int i = 0; i < productos.size(); i++) {
            System.out.println(productos.get(i));
        }
    }
    private static void seleccionarProducto(){
        
    }
}
