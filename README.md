Data Structures Grapher. 
-----------------------------------

### Uso/Usage:

Para inicializar el programa, debe ejecutar:
To initialize the program, you need to run:

```
$ mvn install
```

Para generar el código SVG es necesario ingresar el siguiente comando:
To generate the SVG code, you need to enter the following command:

```
$ java -jar target/proyecto2.jar path/to/file.txt 
```

El archivo .txt (puede tener cualquier otra extensión) debe contener el nombre de la estructura 
de datos y los elementos que se quieran almacenar en la misma, el programa omite los renglones que 
comienzan con #. Los elementos deben estar separados por espacios o por saltos de linea.

The .txt file (can have any other extension) must contain the name of the structure 
of data and the elements that you want to store in it, the program omits the lines that 
They start with #. Elements must be separated by spaces or line breaks.

Adicionalmente se puede guardar la salida del programa en algún archivo, de preferencia
.svg, aunque se guardará en cualquier extensión:

Additionally, you can save the program output in a file, preferably
.svg, although it will be saved in any extension:

```
$ java -jar target/proyecto2.jar path/to/file.txt > path/to/output.svg
```

Donde output.svg es el archivo destino donde se alojará la imagen de la estructura.
Where output.svg is the destination file where the data structure image will be stored.

