package Inventario;

public class Auto implements Activable{
    /**
     * Atributos
     */
    private static int id_automerado = 1;
    private String modelo;
    private int nroAsientos;
    private double velocidadMaxima;
    private boolean activado;
    public int id;

    /**
     * Constructor
     */
    public Auto(){
        this("",0,0);

    }

    /**
     * Constructor Auto
     * @param modelo
     * @param nroAsientos
     * @param velocidadMaxima
     */
    public Auto(String modelo, int nroAsientos, double velocidadMaxima) {
        this.id = id_automerado++;
        this.modelo = modelo;
        this.nroAsientos = nroAsientos;
        this.velocidadMaxima = velocidadMaxima;
        this.activado=false;
    }

    /**
     * Getters & Setters
     * @return
     */
    public int getId() {
        return id;
    }

    public static int getId_automerado() {
        return id_automerado;
    }

    public static void setId_automerado(int id_automerado) {
        Auto.id_automerado = id_automerado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNroAsientos() {
        return nroAsientos;
    }

    public void setNroAsientos(int nroAsientos) {
        this.nroAsientos = nroAsientos;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    //Overrides
    @Override
    public boolean isActivado() {
        return activado;
    }

    @Override
    public void setActivado(boolean value) {
        this.activado=value;
    }


    @Override
    public boolean equals(Object u) {
        if (this == u) return true;
        if (u == null || getClass() != u.getClass()) return false;
        Auto that = (Auto) u;
        return id == that.id;
    }

    @Override
    public String toString() {
        return "Auto con id " + this.id + ": "+
                "modelo " + modelo +
                ", con " + nroAsientos + " asientos"+
                ", y una velocidad maxima de " + velocidadMaxima +
                " km/h.";
    }
}

