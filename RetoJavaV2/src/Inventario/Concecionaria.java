package Inventario;

import java.util.Calendar;

public abstract class Concecionaria implements Comparable<Concecionaria>{
    /**
     * Atributos
     */
    private static int id_automerado = 1;
    private final int MAX_AUTOS = 5;
    //ATRIBUTOS
    public int id;
    private String nombre;
    private String direccion;
    private int anioInaguracion;
    private int capacidad;
    private Auto[] autos;
    private int numeroAutos;

    /**
     * Constructor
     */
    public Concecionaria(){
        this.id = id_automerado++;
        autos = new Auto[MAX_AUTOS];
        this.numeroAutos=0;
    }

    /**
     * Contrcutor Concecionaria
     * @param nombre
     * @param direccion
     * @param anioInaguracion
     * @param capacidad
     */
    public Concecionaria(String nombre, String direccion, int anioInaguracion, int capacidad) {
        this.id = id_automerado++;
        this.nombre = nombre;
        this.direccion = direccion;
        this.anioInaguracion = anioInaguracion;
        this.capacidad = capacidad;
        this.autos = new Auto[MAX_AUTOS];
        this.numeroAutos=0;
    }
    /**
     * Getters & Setters
     */

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getAnioInaguracion() {
        return anioInaguracion;
    }

    public void setAnioInaguracion(int anioInaguracion) {
        this.anioInaguracion = anioInaguracion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    //Funciones
    public final int aniosAbierto(){
        int anioActual = Calendar.getInstance().get(Calendar.YEAR);
        return anioActual-anioInaguracion;
    }

    public int getNumeroAutos() {
        return numeroAutos;
    }

    public void aniadirAuto(Auto a){
        if(numeroAutos<MAX_AUTOS){
            this.autos[numeroAutos] = a;
            numeroAutos++;
        }else{
            System.out.println("No puedes meter mas autos");
        }
    }
    private String mostrarAutos(){
        String autosCadena = "";
        for (int i =0; i<numeroAutos; i++){
            if(this.autos[i].isActivado()){
                autosCadena += this.autos[i].toString()+"\n";
            }
        }
        return autosCadena;
    }

    public abstract void gananciasTotales(double cantidad);

    //Overrides
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Concecionaria that = (Concecionaria) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public int compareTo(Concecionaria o) {
        if(this.anioInaguracion<o.getAnioInaguracion()){
            return -1;
        }else if(this.anioInaguracion>o.getAnioInaguracion()){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Concecionaria con id " +this.id+ ": " + nombre +
                " en la direccion " + this.direccion  +
                ", que se inauguro en: " + anioInaguracion +
                " y tiene " + capacidad + " empleados." +'\n'+
                " Cuenta con los siguientes autos: \n"+ mostrarAutos();
    }
}

