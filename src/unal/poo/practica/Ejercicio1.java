package unal.poo.practica;

import becker.robots.*;

/** 
 * Practica de los conceptos de Programacion Estructurada
 * @author Fabian Andres Giraldo */
public class Ejercicio1
{    
       //Declaracion de Variables -- Forma temporal - No es buena practica tener
       //variables estaticas
        public static City objetos;
        public static Robot estudiante;
        
        public static void turnRight(){
            for(int i = 0; i < 3; i++) estudiante.turnLeft();
        }
        public static void manecillas(){
            turnRight();
            for(int i = 0; i < 3; i++) estudiante.move();            
        }
        public static void posicionar(){
            for(int i = 0; i < 2; i++) estudiante.turnLeft();
            estudiante.move();
        }
	public static void main (String[] args){
            objetos = new City("Field_1.txt");
	    objetos.showThingCounts(true);

            estudiante = new Robot(objetos,0, 2, Direction.WEST,10);
            posicionar();           
            for(int i = 0; i < 4; i++) manecillas();
            posicionar();
	}
        
        
}

