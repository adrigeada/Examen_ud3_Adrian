package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Olivas {
    static void main() {
        Scanner teclado = new Scanner(System.in);
        Random aleatorio = new Random();

        System.out.println("BIENVENIDO AL OLIVERO");
        System.out.println("Introduce el tamaño de tu bancal");
       int ancho = 0;
       int alto = 0;
       boolean repetir = false;

       do {
           repetir= false;
           try {
               System.out.println("Ancho: ");
               ancho = teclado.nextInt(); //j
               System.out.println("Alto: ");
               alto = teclado.nextInt(); //i

           } catch (Exception e) {
               System.out.println("Pon numeros");
               repetir= true;
               teclado.nextLine();
           }
       }while(repetir);





        int[][] bancal = new int[alto][ancho];
        teclado.nextLine();


        System.out.println("Introduce por hileras los kg por arbol de tu bancal");

        fuera:
        for (int i = 0; i < bancal.length; i++) {
            System.out.println("Fila" + (i+1));
            String fila = teclado.nextLine();
            String[] fila_vector = fila.split(" ");

            if (fila_vector.length == ancho){

                for (int j = 0; j < bancal[i].length; j++) {
                    if (fila_vector[j].matches("\\d{1,2}")){

                        bancal[i][j] = Integer.parseInt(fila_vector[j]);
                        if (bancal[i][j]< 1 || bancal[i][j]>50){
                            i--;
                            continue fuera;
                        }
                    }else {
                        i--;
                        continue fuera;
                    }



                }
            }else {
                System.out.println("La longitud de tu hilera tiene que ser igual a la de tu bancal");
                i--;
                continue fuera;
            }





        }

        System.out.println("=======================");
        System.out.println("Mapa tu bancal actual");
        for (int i = 0; i < bancal.length; i++) {
            for (int j = 0; j < bancal[i].length; j++) {

                System.out.print(bancal[i][j]+ " ");
            }
            System.out.println();
        }

        int resultado = 0;

        for (int i = 0; i < bancal.length; i++) {
            for (int j = 0; j < bancal[i].length; j++) {

                resultado += bancal[i][j];

            }

        }



        float litros = (float) resultado /8;
        System.out.println("Total de Kg generados "+resultado);
        System.out.println("Total de Litros generados: " +litros);

        int resultado_columna= 0;
        float resultado_col_litro= 0;
        for (int i = 0; i < bancal[0].length; i++) {
            resultado_columna= 0;
            resultado_col_litro= 0;
            for (int j = 0; j < bancal.length; j++) {

                resultado_columna += bancal[j][i];

            }

            resultado_col_litro = (float) resultado_columna /8;

            System.out.println("Columna "+(i+1)+ ": " +resultado_col_litro + "L");

        }

        System.out.println("Olivos mas productivos");

        int aux = 0;
        int aux1 = 0;
        int aux2  = 0;

        for (int i = 0; i < bancal.length; i++) {
            for (int j = 0; j < bancal[i].length; j++) {

                if (bancal[i][j] > 35){
                    System.out.println("-En la posicion "+(i) +" , "+(j)+" con "+ bancal[i][j]+ " kilos");
                }

                if (bancal[i][j] > aux){
                    aux = bancal[i][j];
                    aux1=i;
                    aux2=j;
                }

            }

        }

        System.out.println("El arbol mas productivo ha generado "+aux + "KG en la posicion ["+(aux1+1)+" , " + (aux2+1)+"]");



        int[][] replantar = new int[alto][ancho];

        for (int i = 0; i < bancal.length; i++) {
            for (int j = 0; j < bancal[i].length; j++) {

                replantar[i][j] = bancal[i][j];

            }

        }
        for (int i = 0; i < bancal.length; i++) {
            for (int j = 0; j < bancal[i].length; j++) {

                if (replantar[i][j] < 5 ){
                    replantar[i][j] = 1;

                }else {
                    replantar[i][j]= 0;
                }

            }

        }
        System.out.println("=====================");
        System.out.println("MAPA REPLANTAR (1 = REPLANTAR 0 = NO REPLANTAR)");
        for (int i = 0; i < bancal.length; i++) {
            for (int j = 0; j < bancal[i].length; j++) {

                System.out.print(replantar[i][j]+ " ");
            }
            System.out.println();
        }


        for (int i = 0; i < bancal.length; i++) {
            for (int j = 0; j < bancal[i].length; j++) {

                if (bancal[i][j]< 5){
                    bancal[i][j] = aleatorio.nextInt(21)+15;
                }

            }

        }


        System.out.println("=================");
        System.out.println("Mapa estimación despues de plantar:");
        for (int i = 0; i < bancal.length; i++) {
            for (int j = 0; j < bancal[i].length; j++) {

                System.out.print(bancal[i][j]+ " ");
            }
            System.out.println();
        }






    }
}