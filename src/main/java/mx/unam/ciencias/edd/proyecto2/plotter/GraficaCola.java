package mx.unam.ciencias.edd.proyecto2.plotter;

import mx.unam.ciencias.edd.Lista;

/**
 * Clase para dibujar colas en SVG.
 * Extiende la clase SVG.
 * 
 * @author Luis
 */
public class GraficaCola extends SVG {

    Lista<Integer> listaElementos = new Lista<>();

    /**
     * Dibuja una cola en SVG.
     * 
     * @param elementos La cola de elementos a dibujar.
     * @return El código SVG que representa la cola.
     */
    public String dibujaCola(Lista<Integer> elementos) {
        int horizontal = 80;
        int vertical = 14;
        String inicio = inicioSVG();
        String lienzo = dimensiones(elementos.getElementos() * 73, 90);
        String s = "";
        boolean primerElemento = true;

        for (Integer i : elementos) {
            if (primerElemento) {
                // Agrega la flecha que indica la dirección de la cola.
                s += "<text fill='#717171' font-family='sans-serif' font-size='70' x='40' y='70' text-anchor='middle'>↦</text> \n";
                primerElemento = false;
            }

            s += rectanguloConTexto(horizontal, vertical, 60, 60, "#B7B7B7", "#717171", i, "#3E3E3E", 24, 54, 10, 10);  
            horizontal += 70;
        }
        String completa = inicioSVG() + lienzo + s + finalSVG();
        System.out.println(completa);
        return completa;
    }
}
