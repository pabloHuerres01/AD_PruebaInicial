package ej800;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class Main807 {
	public static void main(String[] args) {
        int[] numeros = new int[20]; // Array para almacenar hasta 20 números enteros
        String rutaArchivoEntrada = "datos807.dat"; // Ruta del archivo de entrada
        String rutaArchivoSalida = "datos807_salida.dat"; // Ruta del archivo de salida
        
        // Leer los números desde el archivo
        int contador = leerNumerosDesdeArchivo(rutaArchivoEntrada, numeros);
        
        // Ordenar el array
        Arrays.sort(numeros, 0, contador); // Solo ordenar los elementos leídos

        // Mostrar el array ordenado por pantalla
        System.out.println("Array ordenado:");
        for (int i = 0; i < contador; i++) {
            System.out.println(numeros[i]);
        }

        // Elegir la opción de salida
        // Cambia a true para guardar en formato binario o false para serialización
        boolean opcionA = true; // Opción A: guardar como binario, Opción B: serialización

        if (opcionA) {
            guardarComoBinario(rutaArchivoSalida, numeros, contador);
        } else {
            guardarComoSerializacion(rutaArchivoSalida, numeros, contador);
        }
    }

    // Método para leer números desde un archivo
    private static int leerNumerosDesdeArchivo(String rutaArchivo, int[] numeros) {
        int contador = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;

            while (contador < 20 && (linea = br.readLine()) != null) {
                numeros[contador] = Integer.parseInt(linea.trim()); // Convertir a entero
                contador++;
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        return contador; // Retornar cuántos números se han leído
    }

    // Método para guardar el array en formato binario
    private static void guardarComoBinario(String rutaArchivo, int[] numeros, int cantidad) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(rutaArchivo))) {
            for (int i = 0; i < cantidad; i++) {
                dos.writeInt(numeros[i]);
            }
            System.out.println("Datos guardados en formato binario en: " + rutaArchivo);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    // Método para guardar el array usando serialización
    private static void guardarComoSerializacion(String rutaArchivo, int[] numeros, int cantidad) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(Arrays.copyOf(numeros, cantidad)); // Guardar solo los elementos leídos
            System.out.println("Datos guardados mediante serialización en: " + rutaArchivo);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}