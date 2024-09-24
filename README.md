# Data Structures Grapher

Data Structures Grapher is a tool to generate graphical representations of data structures in SVG format. The program takes as input a file with the name of the data structure and the elements it contains, producing an SVG image with the structure visualization.

### Features

Support for multiple data structures: Lists, Binary Trees, AVL Trees, Red-Black Trees, and more.
Output in SVG format: Ideal for embedding visualizations in web documents or graphics.
Flexible input processing: Allows text files with any extension.

---

## Prerequisites

Make sure you have the following installed:

[Java](https://www.java.com/) (JDK 8 or higher)
[Apache Maven](https://maven.apache.org/)

---

## Usage

### 1. Initialize the project

To compile and install the project, run:

```bash
$ mvn install
```

### 2. Generate SVG code 
To generate the SVG representation of a data structure, use the following command:

```bash
$ java -jar target/proyecto2.jar path/to/file.txt
```
### 3. Input file format
The input file should contain:

- The name of the data structure on the first line.
- The elements of the structure, separated by spaces or line breaks.
- Lines starting with # will be ignored.

**Example of input file (file.txt):**

```bash
ArbolAVL
4 2 7 1 3 6 8
```
This file will generate an AVL Tree with the elements 4 2 7 1 3 6 8.

### 4. Save SVG to file
To save the output to an .svg file (or any other extension), use output redirection:
```bash
$ java -jar target/proyecto2.jar path/to/file.txt > path/to/output.svg
```
Where output.svg is the file where the data structure image will be saved.









