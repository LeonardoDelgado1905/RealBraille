package unal.poo.practica;

import becker.robots.*;

/** 
 * Practica de los conceptos de Programacion Estructurada
 * @author Fabian Andres Giraldo */
public class Ejercicio3
{    
       //Declaracion de Variables -- Forma temporal - No es buena practica tener
       //variables estaticas
        public static City objetos;
        public static Robot estudiante;
        
        public static void turnRight(){
            for(int i = 0; i < 3; i++) estudiante.turnLeft();
        }
        public static void movimiento(int x){
            for(int i = 0; i < x; i++){
                estudiante.move();
                if(estudiante.canPickThing())estudiante.pickThing();
            }
            turnRight();
        }
	public static void main (String[] args){
            objetos = new City("Field_3.txt");
	    objetos.showThingCounts(true);

            estudiante = new Robot(objetos,1, 0, Direction.EAST,10);
            int n = 5;
            while(n > 0){
                for(int i = 0; i < 2; i++) movimiento(n);
                n--;
            }
            
	}
        
        
}

