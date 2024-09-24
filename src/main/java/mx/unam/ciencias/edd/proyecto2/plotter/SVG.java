package mx.unam.ciencias.edd.proyecto2.plotter;

public abstract class SVG {

	/**
	 * @return la declaración XML del documento SVG.
	 */
	public String inicioSVG(){
		return "<?xml version='1.0' encoding='UTF-8'?>" + "\n";
	}

	/**
	 * Retorna la declaración de las dimensiones del lienzo SVG.
	 * 
	 * @param ancho el ancho del lienzo SVG.
	 * @param alto  el alto del lienzo SVG.
	 * @return la declaración de las dimensiones del lienzo SVG.
	 */
	public String dimensiones(int ancho, int alto){
		return String.format("<svg width='%d' height='%d'><g>" + "\n", ancho, alto);
	}
	
	/**
	 * Retorna el cierre del documento SVG.
	 * 
	 * @return el cierre del documento SVG.
	 */
	public String finalSVG(){
		return "</g></svg>";
	}
	
	/**
	 * Retorna la representación SVG de una línea.
	 * 
	 * @param x1      la coordenada x del primer punto de la línea.
	 * @param y1      la coordenada y del primer punto de la línea.
	 * @param x2      la coordenada x del segundo punto de la línea.
	 * @param y2      la coordenada y del segundo punto de la línea.
	 * @param color   el color de la línea.
	 * @param ancho   el ancho de la línea.
	 * @return la representación SVG de una línea.
	 */
	public String linea(int x1, int y1, int x2, int y2, 
						String color, int ancho){
		
		return String.format("<line x1='%d' y1='%d' x2='%d' y2='%d' stroke='%s' stroke-width='%d' /> \n", 
				x1, y1, x2, y2, color, ancho);
	}	

    /**
     * Genera la representación SVG de un texto.
     * 
     * @param colorTexto    el color del texto.
     * @param tamanoFuente  el tamaño de la fuente del texto.
     * @param x             la coordenada x del texto.
     * @param y             la coordenada y del texto.
     * @param texto         el texto a ser mostrado.
     * @return la representación SVG de un texto.
     */
	public String texto(String colorTexto, int tamanoFuente, 
						int x, int y, int text){
		
		return String.format("<text fill='%s' font-family='sans-serif' font-size='%d' x='%d' y='%d' text-anchor='middle'>%d</text> \n", 
				colorTexto, tamanoFuente, x, y, text);
	}

	/**
	 * Retorna la representación SVG de un círculo.
	 * 
	 * @param cx      la coordenada x del centro del círculo.
	 * @param cy      la coordenada y del centro del círculo.
	 * @param radio   el radio del círculo.
	 * @param color   el color del círculo.
	 * @param ancho   el ancho del borde del círculo.
	 * @param relleno el color de relleno del círculo.
	 * @return la representación SVG de un círculo.
	 */
	public String circulo(int cx, int cy, int radio, 
						String colorBorde, int anchoBorde, String relleno){
		
		return String.format("<circle cx='%d' cy='%d' r='%d' stroke='%s' stroke-width='%d' fill='%s' /> \n", 
				cx, cy, radio, colorBorde, anchoBorde, relleno);
	}

    /**
     * Genera la representación SVG de un círculo con texto dentro.
     * 
     * @param cx            la coordenada x del centro del círculo.
     * @param cy            la coordenada y del centro del círculo.
     * @param radio         el radio del círculo.
     * @param colorBorde    el color del borde del círculo.
     * @param anchoBorde    el ancho del borde del círculo.
     * @param colorRelleno  el color de relleno del círculo.
     * @param colorTexto    el color del texto dentro del círculo.
     * @param tamanoFuente  el tamaño de la fuente del texto.
     * @param text         el texto a ser mostrado dentro del círculo.
     * @return la representación SVG de un círculo con texto dentro.
     */
	public String circuloConTexto(int cx, int cy, int radio, 
								String colorBorde, int anchoBorde, 
								String colorRelleno,
								String colorTexto, int tamanoFuente, 
								int text){

		String codigo = circulo(cx, cy, radio, colorBorde, 
				anchoBorde, colorRelleno);
		codigo += texto(colorTexto, tamanoFuente, cx, cy, text);
		return codigo;
	}

	/**
     * Genera la representación SVG de un rectángulo.
     * 
     * @param x             la coordenada x del vértice superior izquierdo del rectángulo.
     * @param y             la coordenada y del vértice superior izquierdo del rectángulo.
     * @param ancho         el ancho del rectángulo.
     * @param alto          el alto del rectángulo.
     * @param color         el color de relleno del rectángulo.
     * @param colorborde    el color del borde del rectángulo.
     * @return la representación SVG de un rectángulo.
     */
//	public String rectangulo(int x, int y, int ancho, 
//			int alto, String color, String colorborde){;
//		return String.format("<rect x='%d' y='%d' width='%d' height='%d' fill='%s' stroke='%s'/> \n", 
//				x, y, ancho, alto, color, colorborde);
//	}

	public String rectangulo(int x, int y, int ancho, int alto, 
							int radioX, int radioY, String color, 
							String colorborde) {
		
		return String.format("<rect x='%d' y='%d' width='%d' height='%d' rx='%d' ry='%d' fill='%s' stroke='%s'/> \n", 
			                 x, y, ancho, alto, radioX, radioY, color, colorborde);
	}

    /**
     * Genera la representación SVG de un rectángulo con texto dentro.
     * 
     * @param inicioEnX         la coordenada x del vértice superior izquierdo del rectángulo.
     * @param finEnY            la coordenada y del vértice superior izquierdo del rectángulo.
     * @param ancho             el ancho del rectángulo.
     * @param alto              el alto del rectángulo.
     * @param rellenoRectangulo el color de relleno del rectángulo.
     * @param colorBorde        el color del borde del rectángulo.
     * @param texto             el texto a ser mostrado dentro del rectángulo.
     * @param colorTexto        el color del texto dentro del rectángulo.
     * @param tamanoFuente      el tamaño de la fuente del texto.
     * @return la representación SVG de un rectángulo con texto dentro.
     */
//	public String rectanguloConTexto(int inicioEnX, 
//			int finEnY, int ancho, int alto, String rellenoRectangulo,
//			String colorBorde, int texto, String colorTexto, 
//			int tamanoFuente, int centroEnY){
//
//		int centroEnX = inicioEnX + (ancho / 2);
//
//		String codigo = rectangulo(inicioEnX, finEnY, ancho,
//				alto, rellenoRectangulo, colorBorde);
//		codigo += texto(colorTexto, tamanoFuente, centroEnX, 
//				centroEnY, texto);
//		return codigo;
//	}

	public String rectanguloConTexto(int inicioEnX, int finEnY, int ancho, 
									int alto, String rellenoRectangulo,
									String colorBorde, int texto, String colorTexto,
									int tamanoFuente, int centroEnY, int radioX, int radioY) {

		int centroEnX = inicioEnX + (ancho / 2);

		String codigo = rectangulo(inicioEnX, finEnY, ancho, alto, radioX, radioY, rellenoRectangulo, colorBorde);
		codigo += texto(colorTexto, tamanoFuente, centroEnX, centroEnY, texto);
		return codigo;
	
	}

}
