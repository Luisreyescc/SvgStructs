package mx.unam.ciencias.edd.proyecto2.plotter;

import mx.unam.ciencias.edd.Lista;

/**
 * Clase para dibujar listas en SVG.
 * Extiende la clase SVG.
 * 
 * @author Luis
 */
public class GraficaListas extends SVG {

    /**
     * Dibuja una lista en SVG.
     * 
     * @param elementos La lista de elementos a dibujar.
     * @return El código SVG que representa la lista.
     */
    public String dibujaLista(Lista<Integer> elementos) {
        int horizontal = 45;
        int vertical = 90;
        String inicio = inicioSVG();
        String lienzo = dimensiones(elementos.getElementos() * 310, 270);
        StringBuilder s = new StringBuilder();
        int contador = 0;
        for (Integer elemento : elementos) {
            s.append(rectanguloConTexto(horizontal, vertical, 180, 90, "white", "black", elemento, "black", 72, 162, 0, 0));  
            horizontal += 200;
            contador++;
            if (contador < elementos.getElementos()) {
                // Pone una flecha después de cada rectángulo, excepto después del último
                s.append(flechaHorizontal(horizontal, vertical + 45, 90, "black"));
                horizontal += 110; // Espacio entre la flecha y el próximo rectángulo
            }
        }
        String completa = inicioSVG() + lienzo + s.toString() + finalSVG();
        System.out.println(completa);
        return completa;
    }

    /**
     * Genera el código SVG para una flecha horizontal.
     * 
     * @param inicioEnX La coordenada x de inicio de la flecha.
     * @param inicioEnY La coordenada y de inicio de la flecha.
     * @param longitud La longitud de la flecha.
     * @param color El color de la flecha.
     * @return El código SVG de la flecha.
     */
    public String flechaHorizontal(int inicioEnX, int inicioEnY, int longitud, String color) {
        // Código SVG para una flecha horizontal con cabezas en ambos extremos
        return "<line x1='" + inicioEnX + "' y1='" + inicioEnY + "' x2='" + (inicioEnX + longitud) +
            "' y2='" + inicioEnY + "' stroke='" + color + "' marker-start='url(#arrowhead-start)' marker-end='url(#arrowhead-end)'/>" +
            "<marker id='arrowhead-start' markerWidth='13' markerHeight='10' refX='0' refY='3.5' orient='auto' transfom=''>" +
            "<polygon points='0 0, 10 3.5, 0 7' fill='" + color + "' transform='scale(-1,1)'/></marker>" +
            "<marker id='arrowhead-end' markerWidth='13' markerHeight='10' refX='0' refY='3.5' orient='auto'>" +
            "<polygon points='0 0, 10 3.5, 0 7' fill='" + color + "'/></marker>";
    }
}
