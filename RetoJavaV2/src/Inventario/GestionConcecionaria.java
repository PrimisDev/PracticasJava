package Inventario;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 * Practicas Java,  sistema de invetario de concecionarias y automoviles
 * @author martin.grasselli
 */

public class GestionConcecionaria {
    /**
     * @param args
     */
    public static void main(String[] args) {
        /**
         * Variables finales
         */
        final int MAX_CONCECIONARIAS = 10;
        final int MAX_AUTOS = 5;
        final int AUTO_ACTIVO=1;
        final int AUTO_INACTIVO=2;
        /**
         * Scanners
         */
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        sc.useLocale(Locale.US);

        /**
         * Atributos
         */
        Concecionaria concecionaria[]=new Concecionaria[MAX_CONCECIONARIAS];
        int nroConcecionarias=0;
        Concecionaria concecionariaAux;
        Auto autoAux;

        Auto auto[]=new Auto[MAX_AUTOS];
        int nroAutos=0;

        boolean salir = false;
        int opcion, anioInaguracion, capacidad, eleccionActivo, nroAsientos, idConcecionaria;
        String nombre, direccion;
        double velMaxima;
        /**
         * metodo while para la seleccion de opciones
         */
        while(!salir){ //while para ingresar opciones
            System.out.println("1. Añadir Concecionaria");
            System.out.println("2. Añadir Auto");
            System.out.println("3. Mostrar info de Concecionaria");
            System.out.println("4. Eliminar Concecionaria");
            System.out.println("5. Salir");
            try{
                System.out.println("Escribe una de las opciones");
                opcion=sc.nextInt();
                /**
                 * Metodo switch para el manejo de errores
                 * Caso1: agregar concecionaria
                 * Caso2: agregar un auto a la concecionaria
                 * Caso3: mostrar informacion de las concecionarias
                 * Caso4: Eliminar concecionaria (no pude encontrar una forma de eliminar autos)
                 * Caso5: detener ejecucion del programa
                 */
                switch (opcion){
                    case 1:
                        if(nroConcecionarias > MAX_CONCECIONARIAS){
                            System.out.println("No se pueden agregar mas Concecionarias");
                        }else{
                            System.out.println("Escribe el Nombre de una Concecionaria");
                            nombre = sc.next();
                            System.out.println("Escribe la direccion de la Concecionaria");
                            direccion = sc.next();
                            System.out.println("Escribe el Año de inaguracion de la Concecionaria");
                            anioInaguracion = validaNumero(0, Integer.MAX_VALUE);
                            System.out.println("Escribe la cantidad de empleados de la Concecionaria");
                            capacidad = validaNumero(0, Integer.MAX_VALUE);

                            concecionariaAux=new Concecionaria(nombre, direccion, anioInaguracion, capacidad) {
                                @Override
                                public void gananciasTotales(double cantidad) {

                                }
                            };
                            concecionaria[nroConcecionarias] = concecionariaAux;
                            nroConcecionarias++;

                        }
                        break;
                    case 2:
                        if(nroConcecionarias == 0){
                            System.out.println("No hay Concecionarias");
                        }else{
                            System.out.println("Escribe el modelo del Auto ");
                            nombre=sc.next();
                            System.out.println("Escribe el numero de asientos del Auto ");
                            nroAsientos=validaNumero(0, Integer.MAX_VALUE);
                            System.out.println("Escribe la velocidad maxima del Auto ");
                            velMaxima = sc.nextDouble();
                            System.out.println("El Auto esta a la venta?" +"\n"+"1.Si / 2.No");
                            eleccionActivo=validaNumero(1, 2);

                            autoAux=new Auto(nombre, nroAsientos,velMaxima);
                            if(eleccionActivo == AUTO_ACTIVO){
                                autoAux.setActivado(true);
                            }
                            System.out.println("Elige una concecionaria para guardar el auto, seleccione un numero entre 1 y " + nroConcecionarias);
                            mostrarConcecionaria(concecionaria, nroConcecionarias);

                            idConcecionaria = sc.nextInt();

                            concecionariaAux = seleccionarConcecionaria(concecionaria, nroConcecionarias, idConcecionaria);
                            if(concecionariaAux != null){
                                concecionariaAux.aniadirAuto(autoAux);
                            }else{
                                System.out.println("No existe concecionaria, auto descartado."+"\n");
                            }
                        }
                        break;
                    case 3:
                        if(nroConcecionarias != 0){
                            System.out.println("Actualmente tienes " + nroConcecionarias + " concecionarias." + "\n" + "Ingresar un valor entre 1 y "+nroConcecionarias+ " para consultar:");
                            mostrarConcecionaria(concecionaria, nroConcecionarias);
                            idConcecionaria = sc.nextInt();
                            concecionariaAux = seleccionarConcecionaria(concecionaria, nroConcecionarias, idConcecionaria);
                            if(concecionariaAux != null){
                                System.out.println(concecionariaAux);
                            }else{
                                System.out.println("No existe concecionaria"+"\n");
                        }
                        }else{
                                System.out.println("Todavia no existen concecionarias"+"\n");
                            }
                        break;
                    case 4:
                        if(nroConcecionarias !=0){
                            System.out.println("Elige una concecionaria para eliminar, tienes "+nroConcecionarias+ "\n");
                            mostrarConcecionaria(concecionaria, nroConcecionarias);
                            idConcecionaria = sc.nextInt();
                            concecionariaAux = seleccionarConcecionaria(concecionaria, nroConcecionarias, idConcecionaria);
                            if(concecionariaAux !=null){
                                concecionaria[nroConcecionarias] = concecionariaAux;
                                nroConcecionarias--;
                                System.out.println("Concecionaria eliminada, te quedan: "+nroConcecionarias+ " concecionarias"+"\n");

                            }else{
                                System.out.println("No existe la concecionaria"+"\n");
                            }
                        }else{
                            System.out.println("Todavia no existen concecionarias"+"\n");
                        }
                        break;
                    case 5:
                        System.out.println("Bay Bay!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Solo numeros entre 1 y 5"+"\n");
                }
            }catch (InputMismatchException e){
                System.out.println("Debes ingresar un numero"+"\n");
                sc.next();
            }
        }
    }

    /**
     * Funcion para validar numeros
     * @param minimo
     * @param maximo
     * @return
     */
    public static int validaNumero(int minimo, int maximo){ //Funcion para validar numeros
        Scanner sc = new Scanner(System.in);
        if(minimo>maximo){
            int aux = minimo;
            minimo=maximo;
            maximo=aux;
        }
        int numero;
        do{
            System.out.println("Escrie un numero");
            numero=sc.nextInt();
            if(!(numero>=minimo&&numero<=maximo)){
                System.out.println("Debes escribir un numero entre "+minimo+" y "+maximo+"\n");
            }
        }while(!(numero>=minimo&&numero<=maximo));
        return numero;
    }

    /**
     * Funcion para contar concecionarias
     * @param concecionarias
     * @param nroConcecionarias
     */
    public static void mostrarConcecionaria(Concecionaria[] concecionarias, int nroConcecionarias){
        for(int i=0; i<nroConcecionarias; i++){
        }

    }

    /**
     * Funcion para contar autos
     * @param autos
     * @param nroAutos
     */
    public static void mostrarAutos(Auto[] autos, int nroAutos){
        for(int j=0;j<nroAutos;j++){}
        //Funcion para mostrar informacion de autos (no usada)
    }

    /**
     * Funcion para seleccionar concecionaria
     * @param concecionarias
     * @param nroConcecionarias
     * @param idConcecionaria
     * @return
     */
    public static Concecionaria seleccionarConcecionaria(Concecionaria[] concecionarias, int nroConcecionarias, int idConcecionaria){
        for(int i=0; i<nroConcecionarias; i++){
            if(concecionarias[i].getId()==idConcecionaria){
                return concecionarias[i];
                //Funcion para seleccionar una concecionaria
            }
        }
        return null;
    }

    /**
     * Funcion para selecionar autos
     * @param autos
     * @param nroAutos
     * @param idAuto
     * @return
     */
    public static Auto seleccionarAuto(Auto[] autos, int nroAutos, int idAuto){
        for(int j=0; j<nroAutos; j++){
            if(autos[j].getId()==idAuto){
                return autos[j];
                //Funcion para seleciconar un auto (no usada)
            }
        }
        return null;
    }
}

