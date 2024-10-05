package ej800;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main806 {
	public Main806()
	{
		String rutaArchivo = solicitaRutaArchivo(); // Obtener la ruta del archivo

        double suma = 0.0;
        double maximo = Double.NEGATIVE_INFINITY;
        double minimo = Double.POSITIVE_INFINITY;
        int contador = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                double numero = Double.parseDouble(linea.trim()); // Convertir la línea a double
                suma += numero; // Sumar al total
                contador++; // Contar los números

                // Encontrar el valor máximo
                if (numero > maximo) {
                    maximo = numero;
                }

                // Encontrar el valor mínimo
                if (numero < minimo) {
                    minimo = numero;
                }
            }

            // Calcular la media si hay números
            double media = (contador > 0) ? (suma / contador) : 0;

            // Mostrar resultados
            System.out.println("Número total de datos: " + contador);
            System.out.println("La suma de los valores es: " + suma);
            System.out.println("La media de los valores es: " + media);
            System.out.println("El valor más alto es: " + maximo);
            System.out.println("El valor más bajo es: " + minimo);

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir un número: " + e.getMessage());
        }
    }

    // Método para solicitar al usuario la ruta y nombre del archivo
    public static String solicitaRutaArchivo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce la unidad (por ejemplo, 'metálico', 'plástico', etc.): ");
        String unidad = scanner.nextLine();
        
        System.out.print("Introduce la ruta y el nombre del fichero (ejemplo: C:\\ruta\\datos806.dat): ");
        String rutaArchivo = scanner.nextLine();

        // Aquí podrías usar 'unidad' si necesitas hacer algo con ella, 
        // por ahora solo la solicitamos.
        return rutaArchivo;
    }

	

	public static void main(String[] args) {
		Main806 main = new Main806();

	}

}
