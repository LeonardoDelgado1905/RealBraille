package unal.poo.practica;

import becker.robots.*;

/** 
 * Practica de los conceptos de Programacion Estructurada
 * @author Fabian Andres Giraldo */
public class Ejercicio4
{    
       //Declaracion de Variables -- Forma temporal - No es buena practica tener
       //variables estaticas
        public static City objetos;
        public static Robot estudiante;
        
        public static void turnRight(){
            for(int i = 0; i < 3; i++) estudiante.turnLeft();
        }
        public static void recorrido(int x){
            estudiante.turnLeft();
            for(int i = 0; i < x; i++){
                estudiante.putThing();
                estudiante.move();
            }
            for(int i = 0; i < 2; i++) estudiante.turnLeft();
            for(int i = 0; i < x; i++) estudiante.move();
            estudiante.turnLeft();
        }
	public static void main (String[] args){
            objetos = new City("Field_4.txt");
	    objetos.showThingCounts(true);

            estudiante = new Robot(objetos,0, 1, Direction.SOUTH, 0);
            
            for(int i = 0; i < 10; i++){                
                int cant = 0;
                while(estudiante.canPickThing()){
                    estudiante.pickThing();
                    cant++;
                }
                if(cant > 0) recorrido(cant);
                estudiante.move();
            }
            
            
	}
        
        
}

