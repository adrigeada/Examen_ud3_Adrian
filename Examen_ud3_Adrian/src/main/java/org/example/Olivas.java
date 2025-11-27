package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Olivas {
    static void main() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("BIENVENIDO AL OLIVERO");
        System.out.println("Introduce el tamaño de tu bancal");
       int ancho = 0;
       int alto = 0;

        do {
            System.out.println("Ancho: ");
            ancho = teclado.nextInt(); //j
            System.out.println("Alto: ");
            alto = teclado.nextInt(); //i

        }while (ancho != alto);

        int[][] bancal = new int[alto][ancho];
        teclado.nextLine();


        System.out.println("Introduce por hileras los kg por arbol de tu bancal");

        fuera:
        for (int i = 0; i < bancal.length; i++) {
            System.out.println("Fila" + (i+1));
            String fila = teclado.nextLine();
            String[] fila_vector = fila.split(" ");


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
        for (int i = 0; i < bancal.length; i++) {
            resultado_columna= 0;
            resultado_col_litro= 0;
            for (int j = 0; j < bancal[i].length; j++) {

                resultado_columna += bancal[j][i];

            }

            resultado_col_litro = (float) resultado_columna /8;

            System.out.println("Columna "+(i+1)+ ": " +resultado_col_litro + "L");

        }

        System.out.println("Olivos mas productivos");

        int aux = 0;

        for (int i = 0; i < bancal.length; i++) {
            for (int j = 0; j < bancal[i].length; j++) {

                if (bancal[i][j] > 35){
                    System.out.println("-En la posicion "+(i) +" "+(j)+" con "+ bancal[i][j]+ " kilos");
                }

                if (bancal[i][j] > aux){
                    aux = bancal[i][j];
                }

            }

        }

        System.out.println("El arbol mas productivo ha generado "+aux + "KG");









    }
}