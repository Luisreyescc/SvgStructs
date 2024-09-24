package mx.unam.ciencias.edd.proyecto2.plotter;

import mx.unam.ciencias.edd.ArbolBinarioOrdenado;
import mx.unam.ciencias.edd.VerticeArbolBinario;

/**
 * Clase para dibujar árboles binarios ordenados en SVG.
 * Extiende la clase SVG.
 * 
 * @author Luis
 */
public class GraficaABO extends SVG {

    int radio = 21;
    int margen = 50; 

    /**
     * Dibuja un árbol binario ordenado en SVG.
     * 
     * @param elementos El árbol binario ordenado a dibujar.
     * @return El código SVG que representa el árbol binario ordenado.
     */
    public String dibujaABO(ArbolBinarioOrdenado<Integer> elementos) {
        int alturaArbol = elementos.altura();
        int alto = 100 + alturaArbol * 110 + margen * 2;
        int anchura = alturaArbol * 400 + margen * 2;
        String lienzo = dimensiones(anchura, alto);

        String completa = inicioSVG() + lienzo + vertices(elementos.raiz(), anchura / 2, 40 + margen, anchura / 4, margen, anchura - margen) + finalSVG();
        System.out.println(completa);
        return completa;
    }

    /**
     * Genera el código SVG para dibujar los vértices del árbol binario ordenado y sus aristas.
     * 
     * @param vertice El vértice actual a dibujar.
     * @param cx La coordenada x del centro del vértice.
     * @param cy La coordenada y del centro del vértice.
     * @param espacio El espacio horizontal entre vértices.
     * @param margenIzquierdo El margen izquierdo del lienzo.
     * @param margenDerecho El margen derecho del lienzo.
     * @return El código SVG para los vértices y aristas del árbol binario ordenado.
     */
    public String vertices(VerticeArbolBinario<Integer> vertice, int cx, int cy, int espacio, int margenIzquierdo, int margenDerecho) {
        String s = dibujaVertices(cx, cy, vertice.get());

        if (vertice.hayIzquierdo()) {
            int x = cx - espacio;
            int y = cy + 100;
            x = Math.max(x, margenIzquierdo);
            s += dibujaAristas(cx, cy, x, y); 
            s += vertices(vertice.izquierdo(), x, y, espacio / 2, margenIzquierdo, margenDerecho);
        }

        if (vertice.hayDerecho()) {
            int x = cx + espacio;
            int y = cy + 100;
            x = Math.min(x, margenDerecho); 
            s += dibujaAristas(cx, cy, x, y); 
            s += vertices(vertice.derecho(), x, y, espacio / 2, margenIzquierdo, margenDerecho);
        }

        return s;
    }

    /**
     * Genera el código SVG para dibujar un vértice del árbol binario ordenado.
     * 
     * @param cx La coordenada x del centro del vértice.
     * @param cy La coordenada y del centro del vértice.
     * @param text El valor del vértice.
     * @return El código SVG para el vértice.
     */
    public String dibujaVertices(int cx, int cy, int text) {
        return circuloConTexto(cx, cy, radio, "black", 1, "white", "black", 15, text);
    }

    /**
     * Genera el código SVG para dibujar una arista entre dos vértices del árbol binario ordenado.
     * 
     * @param x1 La coordenada x del punto inicial de la arista.
     * @param y1 La coordenada y del punto inicial de la arista.
     * @param x2 La coordenada x del punto final de la arista.
     * @param y2 La coordenada y del punto final de la arista.
     * @return El código SVG para la arista.
     */
    public String dibujaAristas(int x1, int y1, int x2, int y2) {
        return String.format("<line x1='%d' y1='%d' x2='%d' y2='%d' stroke='black' stroke-width='1'/>\n", x1, y1 + radio, x2, y2);
    }
}
