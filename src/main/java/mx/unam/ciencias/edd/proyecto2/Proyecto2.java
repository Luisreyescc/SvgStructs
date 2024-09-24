package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.proyecto2.plotter.*;
import mx.unam.ciencias.edd.Lista;

/**
 * Clase principal del proyecto.
 * 
 * @author Luis
 */
public class Proyecto2 {
    /**
     * Método principal.
     * 
     * @param args Argumentos de la línea de comandos.
     */
	public static void main(String args[]) {
		String[] arreglo;
		if(args.length == 0)
			arreglo = LectorEntrada.reader("");
		else
			arreglo = LectorEntrada.reader(args[0]);
	
		CreaEstructura.estructura(arreglo);
		
	}
}
