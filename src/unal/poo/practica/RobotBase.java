package unal.poo.practica;

import becker.robots.*;

/** 
 * Practica de los conceptos de Programacion Estructurada
 * @author Fabian Andres Giraldo */
public class RobotBase
{    
       //Declaracion de Variables -- Forma temporal - No es buena practica tener
       //variables estaticas
        public static City objetos;
        public static Robot estudiante;
        
        public static void creacionFuncion(int parametroEntrada){
            for (int i = 0; i < parametroEntrada; i++) 
                estudiante.move();
        }
	public static void main (String[] args){
            objetos = new City("Field.txt");
	    objetos.showThingCounts(true);

            estudiante = new Robot(objetos,0, 2, Direction.EAST,10);

            estudiante.move();
	}
        
        
}

