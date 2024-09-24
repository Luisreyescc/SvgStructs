package mx.unam.ciencias.edd.proyecto2;

import mx.unam.ciencias.edd.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.Normalizer;
import java.io.InputStreamReader;

/**
 * Clase para leer la entrada de datos.
 * 
 * @author Luis Reyes
 */
public class LectorEntrada {
    String[] argumentos;
    String[] arreglo;  
    String s = "";
    String cadena;

    /**
     * Constructor de la clase LectorEntrada.
     * 
     * @param args Argumentos pasados al programa.
     */
    public LectorEntrada(String args[]) {
        argumentos = args;
    }

    /**
     * Lee un archivo o la entrada estándar y retorna su contenido como un arreglo de strings.
     * 
     * @param archivo El nombre del archivo a leer, o una cadena vacía para la entrada estándar.
     * @return Un arreglo de strings con el contenido del archivo o de la entrada estándar.
     */
    public static String[] reader(String archivo) {
        String[] arr = null;
        BufferedReader bf = null;
        try {
            String cadenaLimpia = "";
            if (!archivo.isEmpty()) {
                bf = new BufferedReader(new FileReader(archivo));
            } else {
                bf = new BufferedReader(new InputStreamReader(System.in));
            }
            String renglon;
            // Leemos cada línea del archivo y la agregamos al array.
            while ((renglon = bf.readLine()) != null) {
                String a = renglon.trim();
                if (a.startsWith("#") || a.isEmpty())
                continue;
                cadenaLimpia += renglon.trim() + " ";
            }
            arr = cadenaLimpia.split("\\s+");
            bf.close();
        } catch (IOException e) {
            System.err.println("\nAlgo salió mal: \n");
        }
        return arr;
    }

    /**
     * Convierte un arreglo de strings en una lista de enteros.
     * 
     * @param arr Arreglo de strings a convertir en lista.
     * @return Lista de enteros creada a partir del arreglo.
     */
    public static Lista<Integer> elementos(String[] arr) {
        Lista<Integer> l = new Lista<>();
        for(int i = 1; i < arr.length; i++) {
            l.agrega(Integer.parseInt(arr[i]));
        }
        return l;
    }

    /**
     * Convierte un arreglo de strings en un árbol binario ordenado de enteros.
     * 
     * @param arr Arreglo de strings a convertir en árbol binario ordenado.
     * @return Árbol binario ordenado creado a partir del arreglo.
     */
    public static ArbolBinarioOrdenado<Integer> aboElementos(String[] arr) {
        ArbolBinarioOrdenado<Integer> a = new ArbolBinarioOrdenado<>();
        for(int i = 1; i < arr.length; i++) {
            a.agrega(Integer.parseInt(arr[i]));
        }
        return a;
    }

    /**
     * Convierte un arreglo de strings en un árbol binario completo de enteros.
     * 
     * @param arr Arreglo de strings a convertir en árbol binario completo.
     * @return Árbol binario completo creado a partir del arreglo.
     */
    public static ArbolBinarioCompleto<Integer> abcElementos(String[] arr) {
        ArbolBinarioCompleto<Integer> a = new ArbolBinarioCompleto<>();
        for(int i = 1; i < arr.length; i++) {
            a.agrega(Integer.parseInt(arr[i]));
        }
        return a;
    }

    /**
     * Convierte un arreglo de strings en un árbol rojinegro de enteros.
     * 
     * @param arr Arreglo de strings a convertir en árbol rojinegro.
     * @return Árbol rojinegro creado a partir del arreglo.
     */
    public static ArbolRojinegro<Integer> arnElementos(String[] arr) {
        ArbolRojinegro<Integer> a = new ArbolRojinegro<>();
        for(int i = 1; i < arr.length; i++) {
            a.agrega(Integer.parseInt(arr[i]));
        }
        return a;
    }

    /**
     * Convierte un arreglo de strings en un árbol AVL de enteros.
     * 
     * @param arr Arreglo de strings a convertir en árbol AVL.
     * @return Árbol AVL creado a partir del arreglo.
     */
    public static ArbolAVL<Integer> avlElementos(String[] arr) {
        ArbolAVL<Integer> a = new ArbolAVL<>();
        for(int i = 1; i < arr.length; i++) {
            a.agrega(Integer.parseInt(arr[i]));
        }
        return a;
    }

    /**
     * Devuelve el tipo de estructura de datos especificado en el arreglo de entrada.
     * 
     * @param a Arreglo de strings con la entrada de datos.
     * @return El tipo de estructura de datos especificado en la entrada.
     */
    public static String tipoEstructura(String[] a) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("El arreglo de entrada no puede ser nulo o vacío.");
        }
        return a[0];
    }
}
