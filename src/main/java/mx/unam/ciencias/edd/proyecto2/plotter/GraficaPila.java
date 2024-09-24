package mx.unam.ciencias.edd.proyecto2.plotter;
import mx.unam.ciencias.edd.Lista;

public class GraficaPila extends SVG{

//Para graficar pilas usamos una lista, esto nos facilita el trabajo.
	public String dibujaPila(Lista<Integer> elementos){
		int horizontal = 60;
		int vertical = 100;
		String inicio = inicioSVG();
		String lienzo = dimensiones(240, elementos.getElementos() * 73);
		String s = "";
		Lista<Integer> rev = elementos.reversa();
		// Hacemos 30/2 ya que es el alto entre dos + el tamaño de la fuente entre 2 a esto le sumamos la coordenada vertical
		// y así conseguimos que el texto se encuentre centrado y dentro de los rectangulos.
		boolean primerElemento = true;
		for(Integer i : rev){

			if(primerElemento){
				s += "<text fill='#016b96' font-family='sans-serif' font-size='100' x='120' y='85' text-anchor='middle'>↘ ↙</text> \n";
				primerElemento = false;
			}

			s += rectanguloConTexto(horizontal, vertical, 120, 60, "#48BCEB", "#016B96", i, "#016B96", 40, vertical+(60/2)+(40/2), 7,7);  
			vertical += 70;
		}
		String completa = inicioSVG() + lienzo + s + finalSVG();
		System.out.println(completa);
		return completa;

	}
		
} 
