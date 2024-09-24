package mx.unam.ciencias.edd.proyecto2.plotter;
import mx.unam.ciencias.edd.ArbolAVL;
import mx.unam.ciencias.edd.VerticeArbolBinario;

public class GraficaAVL extends SVG {
    int radio = 21;
    int margen = 50; 

    public String dibujaAVL(ArbolAVL<Integer> elementos) {
        int alturaArbol = elementos.altura();
        int alto = 100 + alturaArbol * 110 + margen * 2;
        int anchura = alturaArbol * 200 + margen * 2;
        String lienzo = dimensiones(anchura, alto);

        String completa = inicioSVG() + lienzo + vertices(elementos.raiz(), anchura / 2, 40 + margen, anchura / 4, margen, anchura - margen) + finalSVG();
		System.out.println(completa);
        return completa;
    }

	public String vertices(VerticeArbolBinario<Integer> vertice, int cx, int cy, int espacio, int margenIzquierdo, int margenDerecho) {
		String s = dibujaVertices(cx, cy, vertice.get());

	    s += balanceAltura(cx + 30, cy + 30, alturaVertice(vertice), balanceVertice(vertice));

		if (vertice.hayIzquierdo()) {
			int x = cx - espacio;
			int y = cy + 100;
			x = Math.max(x, margenIzquierdo);
			s += dibujaAristas(cx, cy, x, y);
			s += vertices(vertice.izquierdo(), x, y, espacio / 2, margenIzquierdo, margenDerecho);
		}

		if (vertice.hayDerecho()) {
			int x = cx + espacio;
			int y = cy + 110;
			x = Math.min(x, margenDerecho);
			s += dibujaAristas(cx, cy, x, y);
			s += vertices(vertice.derecho(), x, y, espacio / 2, margenIzquierdo, margenDerecho);
		}

		return s;
	}

	public int alturaVertice(VerticeArbolBinario<Integer> v){
		return v == null? -1: v.altura();
	}

	public int balanceVertice(VerticeArbolBinario<Integer> v){
		if(v.hayIzquierdo() && v.hayDerecho())
			return alturaVertice(v.izquierdo()) - alturaVertice(v.derecho());

		if(!v.hayIzquierdo() && v.hayDerecho())
			return alturaVertice(v.derecho()) - 1;

		if(v.hayIzquierdo() && !v.hayDerecho())
			return alturaVertice(v.izquierdo()) - 1;
	
		return 0;
	}

	public String balanceAltura(int x, int y, int text, int text2){
		
		return String.format("<text fill='black' font-family='sans-serif' font-size='12' x='%d' y='%d' text-anchor='middle'>%d</text> \n", x, y, text) +
			String.format("<text fill='black' font-family='sans-serif' font-size='12' x='%d' y='%d' text-anchor='middle'>/</text> \n", x + 6, y) +
			String.format("<text fill='black' font-family='sans-serif' font-size='12' x='%d' y='%d' text-anchor='middle'>%d</text> \n", x + 12, y, text2);
	}

    public String dibujaVertices(int cx, int cy, int text) {
        return circuloConTexto(cx, cy, radio, "black", 1, "white", "black", 15, text);
    }

    public String dibujaAristas(int x1, int y1, int x2, int y2) {
        return String.format("<line x1='%d' y1='%d' x2='%d' y2='%d' stroke='black' stroke-width='1'/>\n", x1, y1 + radio, x2, y2);
    }
}
