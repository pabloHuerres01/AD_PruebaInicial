package ej800;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main805 {
	public Scanner t = new Scanner(System.in);
	
	public Main805 ()
	{
		ej805();
	}
	
	 public void ej805() {
	        String contenido = recogePalabras(); // Método para recoger los números en forma de String
	        String[] numerosStr = contenido.split("\n"); // Dividir la entrada en líneas
	        int suma = 0;
	        
	        for (String numStr : numerosStr) {
	            // Convertir cada línea en un entero y sumarlo
	            suma += Integer.parseInt(numStr.trim());
	        }
	        
	        double media = (double) suma / numerosStr.length; // Calcular la media
	        System.out.println("La suma es = " + suma);
	        System.out.println("La media es = " + media);
	    }
	
	public String recogePalabras()
	{
		String contenido = "", ruta, fichero;
		
		/*
		 *Pedimos el archivo y el documetno  
		 */
		System.out.println("introduce la ruta");
		ruta = t.nextLine();
		System.out.println("introduce EL FICHERO + EXTENSION");
		fichero = t.nextLine();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(ruta+"\\"+fichero)));
			String linea;
			while ((linea  = reader.readLine()) != null) {
                System.out.println(linea); //Mostrar la línea leída
                contenido =contenido +linea +"\n";            }
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return contenido;
		
	}

	public static void main(String[] args) {
		Main805 main =new Main805();

	}

}
