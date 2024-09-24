package mx.unam.ciencias.edd.proyecto2.plotter;

import mx.unam.ciencias.edd.ArbolRojinegro;
import mx.unam.ciencias.edd.VerticeArbolBinario;
import mx.unam.ciencias.edd.Color;

/**
 * Clase para generar gráficas de árboles rojinegros.
 * Extiende de la clase SVG para generar gráficos SVG.
 * @author Luis
 */
public class GraficaRojinegros extends SVG {

    /** Radio de los círculos que representan los vértices del árbol. */
    int radio = 20;
    /** Margen de la gráfica. */
    int margen = 50; 

    /**
     * Dibuja una gráfica de árbol rojinegro.
     * @param elementos el árbol rojinegro que se desea graficar.
     * @return una cadena que representa el gráfico SVG.
     */
    public String dibujaAR(ArbolRojinegro<Integer> elementos) {
        int alturaArbol = elementos.altura();
        int alto = 250 + alturaArbol * 110 + margen * 2;
        int anchura = alturaArbol * 400 + margen * 2;
        String lienzo = dimensiones(anchura, alto);

        String completa = inicioSVG() + lienzo + vertices(elementos.raiz(), anchura / 2, 40 + margen, anchura / 4, margen, anchura - margen, elementos) + finalSVG();
        System.out.println(completa);
        return completa;
    }

    /**
     * Genera la representación de los vértices del árbol.
     * @param vertice el vértice a dibujar.
     * @param cx coordenada x del centro del vértice.
     * @param cy coordenada y del centro del vértice.
     * @param espacio el espacio horizontal entre vértices.
     * @param margenIzquierdo el margen izquierdo de la gráfica.
     * @param margenDerecho el margen derecho de la gráfica.
     * @param arn el árbol rojinegro.
     * @return una cadena que representa la gráfica SVG de los vértices del árbol.
     */
    public String vertices(VerticeArbolBinario<Integer> vertice, int cx, int cy, int espacio, 
       int margenIzquierdo, int margenDerecho, ArbolRojinegro<Integer> arn) {
        
        String s = dibujaVertices(cx, cy, vertice.get(), dameColor(arn, vertice));
        
        if (vertice.hayIzquierdo()) {
            int x = cx - espacio;
            int y = cy + 150;
            x = Math.max(x, margenIzquierdo);
            s += dibujaAristas(cx, cy, x, y); 
            s += vertices(vertice.izquierdo(), x, y, espacio * 1/2, margenIzquierdo, margenDerecho, arn);
        }

        if (vertice.hayDerecho()) {
            int x = cx + espacio;
            int y = cy + 150;
            x = Math.min(x, margenDerecho); 
            s += dibujaAristas(cx, cy, x, y); 
            s += vertices(vertice.derecho(), x, y, espacio * 1/2, margenIzquierdo, margenDerecho, arn);
        }

        return s;
    }

    /**
     * Obtiene el color de un vértice en el árbol rojinegro.
     * @param rojinegro el árbol rojinegro.
     * @param v el vértice del cual se desea obtener el color.
     * @return el color del vértice.
     */
    public String dameColor(ArbolRojinegro<Integer> rojinegro, VerticeArbolBinario<Integer> v){
        String c = "";

        if(rojinegro.getColor(v) == Color.ROJO)
            c = "red";
        if(rojinegro.getColor(v) == Color.NEGRO)
            c = "black";
        
        return c;
    }   
    
    /**
     * Genera la representación de un vértice del árbol.
     * @param cx coordenada x del centro del vértice.
     * @param cy coordenada y del centro del vértice.
     * @param text el valor del vértice.
     * @param color el color del vértice.
     * @return una cadena que representa la gráfica SVG de un vértice del árbol.
     */
    public String dibujaVertices(int cx, int cy, int text, String color) {
        return circuloConTexto(cx, cy, radio, "black", 1, color, "white", 19, text);
    }

    /**
     * Genera la representación de una arista entre dos vértices.
     * @param x1 coordenada x del primer vértice.
     * @param y1 coordenada y del primer vértice.
     * @param x2 coordenada x del segundo vértice.
     * @param y2 coordenada y del segundo vértice.
     * @return una cadena que representa la gráfica SVG de una arista entre dos vértices.
     */
    public String dibujaAristas(int x1, int y1, int x2, int y2) {
        return String.format("<line x1='%d' y1='%d' x2='%d' y2='%d' stroke='black' stroke-width='1'/>\n", x1, y1 + radio, x2, y2);
    }
}
