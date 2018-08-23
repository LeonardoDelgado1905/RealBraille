package unal.poo.practica;

import becker.robots.*;
import java.util.Scanner;

/** 
 * Practica de los conceptos de Programacion Estructurada
 * @author Fabian Andres Giraldo */
public class RobotBase
{    
       //Declaracion de Variables -- Forma temporal - No es buena practica tener
       //variables estaticas
        public static City objetos;
        public static Robot estudiante;
        
        
        
        public static void Mundo(){
            for(int j = 0; j < 40; j += 2){
                for(int i = 1; i < 4; i++){
                    Wall x = new Wall(objetos, i, j, Direction.WEST);
                 }
            }
        }
        
	public static void main (String[] args){
            char[][] Braille = new char [2][61];
            Braille[0][1] = 'a';
            Braille[1][1] = '1';
            Braille[0][3] = 'c';
            Braille[1][3] = '3';
            Braille[0][4] = '1';
            Braille[0][5] = 'b';
            Braille[1][5] = '2';
            Braille[0][6] = 'i';
            Braille[1][6] = '9';
            Braille[0][7] = 'f';
            Braille[1][7] = '6';
            Braille[0][9] = 'e';
            Braille[1][9] = '5';
            Braille[0][11] = 'd';
            Braille[1][11] = '4';
            Braille[0][12] = '3';
            Braille[1][12] = '3';
            Braille[0][13] = 'h';
            Braille[1][13] = '8';
            Braille[0][14] = 'j';
            Braille[1][14] = '0';
            Braille[0][15] = 'g';
            Braille[1][15] = '7';
            Braille[0][17] = 'k';
            Braille[0][19] = 'm';
            Braille[0][20] = '2';
            Braille[1][20] = '2';
            Braille[0][21] = 'l';
            Braille[0][22] = 's';
            Braille[0][23] = 'p';
            Braille[0][24] = 'q';
            Braille[0][25] = 'o';
            Braille[0][27] = 'n';
            Braille[0][28] = '6';
            Braille[1][28] = '6';
            Braille[0][29] = 'r';
            Braille[0][30] = 't';
            Braille[0][31] = 'q';
            Braille[0][36] = '5';
            Braille[1][36] = '5';
            Braille[0][44] = '4';
            Braille[1][44] = '4';
            Braille[0][46] = 'w';
            Braille[0][49] = 'u';
            Braille[0][51] = 'x';
            Braille[0][52] = '8';
            Braille[1][52] = '8';
            Braille[0][53] = 'v';
            Braille[0][56] = '0';
            Braille[1][56] = '0';
            Braille[0][57] = 'z';
            Braille[0][58] = '#';
            Braille[0][59] = 'y';
            Braille[0][60] = '7';
            Braille[1][60] = '7';
                   
            objetos = new City("Field.txt");
            estudiante = new Robot(objetos,1, 0, Direction.EAST, 200);
            Scanner bf = new Scanner(System.in);
            Mundo();
            int opcion;
            do{
                System.out.println("1. Escribir");
                System.out.println("2. Leer");
                System.out.println("0. Salir");
                opcion = bf.nextInt();
                int numero = 0;
                if(opcion == 1){
                    limpiar();
                    reiniciar();
                    System.out.println("Escriba lo que quiere traducir: ");
                    String palabra = bf.next();
                    boolean prov;
                    for(int l = 0; l < palabra.length(); l++){
                        int let = 0;
                        while(Braille[numero][let] != palabra.charAt(l))let++;
                        escribir(let);
                        if(palabra.charAt(l) == '#') numero = 1 - numero;
                        prov = fin();
                        if(l == palabra.length() - 1) estudiante.putThing();
                        posicionar();
                    }
                }
                else if(opcion == 2){
                    System.out.println("Lo que usted escribió en braille fue: ");
                    boolean terminado = false;
                    
                    while(!terminado){
                        int letra = leerLetra();                        
                        System.out.print(Braille[numero][letra]);  
                        if(Braille[numero][letra] == '#') numero = 1 - numero;
                        terminado = fin();
                        posicionar();                
                    }
                    System.out.println("\n");
                }
                reiniciar();
            }while(opcion != 0);
            
            
            
        }
        public static void turnRight(){
            for(int i = 0; i < 3; i++) estudiante.turnLeft();
        }
        
        public static void reiniciar(){
            estudiante.turnLeft();
            estudiante.move();
            estudiante.turnLeft();
            while(estudiante.getAvenue() != 0) estudiante.move();
            estudiante.turnLeft();
            estudiante.move(); 
            estudiante.turnLeft();
        }
        public static void limpiar(){
            
            for(int l = 0; l < 20; l++){
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 2; j++){
                        if(estudiante.canPickThing()) estudiante.pickThing();
                        if(j != 1)estudiante.move();
                    }
                    if(i != 2) saltoDeLinea();
                }
                boolean prov = fin();
                if(estudiante.canPickThing()) estudiante.pickThing();
                posicionar();
            }            
        }
        public static void escribir(int letra){
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 2; j++){
                    if(letra % 2 != 0){
                        estudiante.putThing();                        
                    }                    
                    if(j != 1)estudiante.move();
                    letra /= 2;
                }
                if(i != 2) saltoDeLinea();
            }
            
        }
        public static int leerLetra(){
            int[][] costo = new int[3][2];
            costo[0][0] = 1;
            costo[0][1] = 2;
            costo[1][0] = 4;
            costo[1][1] = 8;
            costo[2][0] = 16;
            costo[2][1] = 32; 
            int s = 0;
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 2; j++){
                    if(estudiante.canPickThing()) s += costo[i][j];
                    if(j != 1)estudiante.move();
                }
                if(i != 2)saltoDeLinea();
            }
            return s;
        }
        public static boolean fin(){
            estudiante.turnLeft();
            for(int i = 0; i < 3; i++) estudiante.move();
            turnRight(); estudiante.move();
            return estudiante.canPickThing();
        }
        public static void posicionar(){
            turnRight(); estudiante.move(); estudiante.turnLeft();
        }
        public static void saltoDeLinea(){
            for(int i = 0; i < 2; i++) estudiante.turnLeft();
            for(int j = 0; j < 2; j++){
                estudiante.move();
                estudiante.turnLeft();                
            }
        }
        
}

