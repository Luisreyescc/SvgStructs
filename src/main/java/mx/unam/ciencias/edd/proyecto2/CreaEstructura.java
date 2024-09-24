package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.proyecto2.plotter.*;
import mx.unam.ciencias.edd.*;

/**
 * Clase para crear estructuras de datos y generar su representación gráfica.
 * 
 * @author Luis
 */
public class CreaEstructura {
	
	/**
	 * Método para crear la estructura de datos especificada y generar su representación gráfica.
	 * 
	 * @param arreglo Arreglo de strings que contiene la información para crear la estructura.
	 */
	public static void estructura(String[] arreglo) {
		String s = LectorEntrada.tipoEstructura(arreglo).toUpperCase();	
		switch(s) {
			case "ARBOLAVL" :
				ArbolAVL<Integer> avl = LectorEntrada.avlElementos(arreglo);
				GraficaAVL gavl = new GraficaAVL();
				gavl.dibujaAVL(avl);
				break;

			case "ARBOLBINARIOCOMPLETO" :
				ArbolBinarioCompleto<Integer> abc = LectorEntrada.abcElementos(arreglo);
				GraficaABC gabc = new GraficaABC();
				gabc.dibujaABC(abc);
				break;

			case "ARBOLBINARIOORDENADO" :
				ArbolBinarioOrdenado<Integer> abo = LectorEntrada.aboElementos(arreglo);
				GraficaABO gabo = new GraficaABO();
				gabo.dibujaABO(abo);
				break;

			case "ARBOLROJINEGRO" :
				ArbolRojinegro<Integer> ar = LectorEntrada.arnElementos(arreglo);
				GraficaRojinegros gar = new GraficaRojinegros();
				gar.dibujaAR(ar);
				break;
			
			case "COLA" :
				Lista<Integer> cola = LectorEntrada.elementos(arreglo);
				GraficaCola gc = new GraficaCola();	
				gc.dibujaCola(cola);	
				break;

			case "GRAFICA" :
			
			case "LISTA" :
				Lista<Integer> lista = LectorEntrada.elementos(arreglo);
				GraficaListas gl = new GraficaListas();	
				gl.dibujaLista(lista);			
				break;

			case "MONTICULOMINIMO" :
				Lista<Integer> arr = LectorEntrada.elementos(arreglo);
				Lista<Integer> ord = arr.mergeSort(arr);

				ArbolBinarioCompleto<Integer> mm = new ArbolBinarioCompleto<>();

				for(Integer i : ord)
					mm.agrega(i);

				GraficaMM gmm = new GraficaMM();
				gmm.dibujaMM(mm, ord);
				break;

			case "PILA" :
				Lista<Integer> pila = LectorEntrada.elementos(arreglo);
				GraficaPila gp = new GraficaPila();	
				gp.dibujaPila(pila);	
				break;

			default :
				System.out.println("Estructura de datos inválida.\nPor favor ingrese una estructura válida.");
		}
	}
}
