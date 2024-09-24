package mx.unam.ciencias.edd.proyecto2.plotter;

import mx.unam.ciencias.edd.ArbolBinarioCompleto;
import mx.unam.ciencias.edd.VerticeArbolBinario;
import mx.unam.ciencias.edd.Lista;

/**
 * Clase para generar gráficas de montículos mínimos.
 * Extiende de la clase SVG para generar gráficos SVG.
 * @author Luis
 */
public class GraficaMM extends SVG {

    /** Radio de los círculos que representan los vértices del árbol. */
    int radio = 21;
    /** Espacio horizontal entre elementos en la gráfica. */
    int espacioHorizontal = 90;

    /**
     * Dibuja una gráfica de montículos mínimos.
     * @param elementos el árbol binario completo que representa la estructura.
     * @param arreglo la lista que representa el montículo mínimo.
     * @return una cadena que representa el gráfico SVG.
     */
    public String dibujaMM(ArbolBinarioCompleto<Integer> elementos, Lista<Integer> arreglo) {
        
        int alturaArbol = elementos.altura();
        int elementosLista = arreglo.getLongitud();
        int alto = 100 + alturaArbol * 110 + 100; 
        int anchuraArbol = (int) Math.pow(2, alturaArbol + 1) * espacioHorizontal;
        int anchuraLista = elementosLista * espacioHorizontal;
        int anchuraTotal = Math.max(anchuraArbol, anchuraLista); 
        String lienzo = dimensiones(anchuraTotal, alto);
        String s = "";

        int posicionInicial = (anchuraTotal - anchuraLista) / 2; 
        int xLista = posicionInicial;
        for (Integer entero : arreglo) {
            s += rectanguloConTexto(xLista, alto - 50, 90, 45, "white", "black", entero, "black", 18, 162, 0, 0);
            xLista += espacioHorizontal;
        }

        String arbol = vertices(elementos.raiz(), anchuraTotal / 2, 40, anchuraTotal / 4);
        String completa = inicioSVG() + lienzo + arbol + s + finalSVG();
        System.out.println(completa);
        return completa;
    }

    /**
     * Genera la representación de los vértices del árbol.
     * @param vertice el vértice a dibujar.
     * @param cx coordenada x del centro del vértice.
     * @param cy coordenada y del centro del vértice.
     * @param espacio el espacio horizontal entre vértices.
     * @return una cadena que representa la gráfica SVG de los vértices del árbol.
     */
    public String vertices(VerticeArbolBinario<Integer> vertice, int cx, int cy, int espacio) {
        String s = dibujaVertices(cx, cy, vertice.get());

        if (vertice.hayIzquierdo()) {
            int x = cx - espacio;
            int y = cy + 100;
            s += dibujaAristas(cx, cy, x, y);
            s += vertices(vertice.izquierdo(), x, y, espacio / 2);
        }

        if (vertice.hayDerecho()) {
            int x = cx + espacio;
            int y = cy + 100;
            s += dibujaAristas(cx, cy, x, y);
            s += vertices(vertice.derecho(), x, y, espacio / 2);
        }

        return s;
    }

    /**
     * Genera la representación de un vértice del árbol.
     * @param cx coordenada x del centro del vértice.
     * @param cy coordenada y del centro del vértice.
     * @param text el valor del vértice.
     * @return una cadena que representa la gráfica SVG de un vértice del árbol.
     */
    public String dibujaVertices(int cx, int cy, int text) {
        return circuloConTexto(cx, cy, radio, "black", 1, "white", "black", 15, text);
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

    @Override 
    public String rectanguloConTexto(int inicioEnX, int finEnY, int ancho, 
                                int alto, String rellenoRectangulo,
                                String colorBorde, int texto, String colorTexto,
                                int tamanoFuente, int centroEnY, int radioX, int radioY) {

        int centroEnX = inicioEnX + (ancho / 2);
        int coordenadaYTexto = finEnY + (alto/2) + 5; 

        String codigo = rectangulo(inicioEnX, finEnY, ancho, alto, radioX, radioY, rellenoRectangulo, colorBorde);
        codigo += texto(colorTexto, tamanoFuente, centroEnX, coordenadaYTexto, texto);
        return codigo;
    }

}
