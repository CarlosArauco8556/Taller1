package cl.ucn.disc.pa.stdlib.examples;

import edu.princeton.cs.stdlib.StdDraw;

import java.awt.*;

/**
 * En esta clase se programara un protector de pantalla
 *
 * @author Carlos Arauco
 */
public class Main {
    public static void main(String[] args) {
        double min = -1.0;  //Se define (min) y (max), los cuales seran el rango de nuestro dibujo
        double max = 1.0;

        StdDraw.setXscale(min, max);  //Se define la escala para el lienzo en donde podremos dibujar
        StdDraw.setYscale(min, max);

        StdDraw.enableDoubleBuffering();  //Funcion para evitar el parpadeo de la pantalla

        Color[] colores = {Color.red, Color.BLUE, Color.BLACK, Color.GREEN, Color.magenta, Color.CYAN, Color.ORANGE};
        //Se crea una lista con los colores para nuestras lineas

        double x0 = min + (max - min) * Math.random(); //Se definen la ubicaion de los puntos (x0,y0) y (x1,y1 ) aleatoriamente
        if (1.0 < x0) {    //Se crea una condición para que el numero no sobrepase el rango del lienzo
            while (1.0 < x0) {   //Se crea un while para que se genere un nuevo numero hasta que cumpla con la condicion
                x0 = min + (max - min) * Math.random();
            }
        }
        double y0 = min + (max - min) * Math.random();
        if (1.0 < y0) {
            while (1.0 < y0) {
                y0 = min + (max - min) * Math.random();
            }
        }
        double x1 = min + (max - min) * Math.random();
        if (1.0 < x1) {
            while (1.0 < x1) {
                x1 = min + (max - min) * Math.random();
            }
        }
        double y1 = min + (max - min) * Math.random();
        if (1.0 < y1) {
            while (1.0 < y1) {
                y1 = min + (max - min) * Math.random();
            }
        }

        for (int i = 0; i < 6; i = i + 1) {  //Se crea un for con rango 6, para crear las lineas iniciales
            StdDraw.setPenColor(colores[i]);  //Se le otorga a cada linea un color

            x0 = x0 + 0.02 * i;   //Se crea una suma aritmetica para que las primera lineas puedan ser paralelas
            y0 = y0 + 0.02 * i;
            x1 = x1 + 0.02 * i;
            y1 = y1 + 0.02 * i;
            if (1.0 < x0 | 1.0 < y0 | 1.0 < x1 | 1.0 < y1) { //Se crea una condicion en caso de que alguno de los extremos de la linea sobrepase el rango de dibujo
                x0 = x0 - 0.02 * i; //En caso de que no se cumple la condicion las lineas se generan en la direccion contraria para que esten dentro del rango del lienzo
                y0 = y0 - 0.02 * i;
                x1 = x1 - 0.02 * i;
                y1 = y1 - 0.02 * i;
            }
            StdDraw.line(x0, y0, x1, y1); //Se crea la linea con los puntos generados aleatoriamente
            StdDraw.show(); //Se muestra la linea en pantalla
            StdDraw.pause(200);  //Se establece un tiempo en el que apareceran las lineas
        }


        double vx0 = 0.03; //Se establecen las velocidades de los puntos
        double vx1 = 0.03;
        double vy0 = 0.04;
        double vy1 = 0.04;

        while (true) {   //Se crea un while infinito para generar movimiento de las lineas

            StdDraw.clear();  //Se limpia el linezo
            double radio0 = 0.01;  //se establece el radio de los puntos que seran los extremos
            double radio1 = 0.01;

            for (int i = 0; i < 6; i = i + 1) {  //Se crea un for para generar las lineas
                StdDraw.setPenColor(colores[i]);  //Se le otorga un color
                if (Math.abs(x0 + vx0) > 1.0 - radio0) {  //Se crea una condicion en caso de que un punto choque con el limite del lienzo
                    vx0 = -vx0;  //Se cambia la direccion para que no se genere fuera de el lienzo
                }
                if (Math.abs(y0 + vy0) > 1.0 - radio0) {
                    vy0 = -vy0;


                }
                if (Math.abs(x1 + vx1) > 1.0 - radio1) {
                    vx1 = -vx1;

                }
                if (Math.abs(y1 + vy1) > 1.0 - radio1) {
                    vy1 = -vy1;


                }

                x0 = x0 + vx0; //Se le suma las velocidades a los puntos para generar el movimiento
                y0 = y0 + vy0;
                x1 = x1 + vx1;
                y1 = y1 + vy1;

                StdDraw.filledCircle(x0, y0, radio0); //Se dibuja los puntos
                StdDraw.filledCircle(x1, y1, radio1);
                StdDraw.line(x0, y0, x1, y1); //Se crea la linea tomando como extremo los puntos
                StdDraw.show();  //Se muestra la linea creada
                StdDraw.pause(70);
            }
        }
    }
}
