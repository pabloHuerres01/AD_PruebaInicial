import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Cliente {
	//private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	static Scanner t = new Scanner(System.in);
	
	/*
	 * Variables de Cliente
	 */
	private String nombre, direccion, telefono;
	private boolean suscripcion = false;
	private TipoPago pagoPref = TipoPago.EFECTIVO;
	private Date fechaNac;
	private Documentacion id;
	public static ArrayList<Notificacion> listaNotificaciones = new ArrayList<>();
	private final SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
	
	//Metodos
	
	public Cliente nuevocliente()
	{
		Cliente nuevoCliente = new Cliente();
		System.out.println("Introduce NIE o NIF dependiendo de lo que ingreses");
		switch(t.nextLine()) 
		{
			case"NIF":
				System.out.println("Introduce el Numero");
				String numero = t.nextLine();
				System.out.println("Introduce la letra");
				char letra = t.next().charAt(0);
				
				//Añadimos el valor 
				
				nuevoCliente.setId(new NIF(numero, letra));
				break;
				
			case "NIE":
				
				System.out.println("Introduce el Numero");
				String num = t.nextLine();
				System.out.println("Introduce la letra Inicial");
				char letra1 = t.next().charAt(0);
				System.out.println("Introduce la letra Final");
				char letra2 = t.next().charAt(0);
				
				//Añadimos el valor 
				
				nuevoCliente.setId(new NIE(num, letra1, letra2));
				break;
		}
		System.out.println("Introduce Nombre");
		nuevoCliente.setNombre(t.nextLine());
		System.out.println("Introduce Direccion");
		nuevoCliente.setDireccion(t.nextLine());
		System.out.println("Introduce TLFN");
		nuevoCliente.setTelefono(t.nextLine());
		System.out.println("Introduce Suscripcion (true / false)");
		nuevoCliente.setSuscripcion(t.nextBoolean());
		System.out.println("Introduce Tipo Pago");
		nuevoCliente.setPagoPref(TipoPago.valueOf(t.nextLine().toUpperCase()));
		System.out.println("Introduce el numero de notificaciones");
		int numNoti = t.nextInt();
		for (int i = 0; i<numNoti; i++)
		{
			System.out.println("Introduce el id");
			long id = t.nextLong();
			Date fecha = fechaValida("Fecha de Notificacion");
			
			/*
			System.out.println("Introduce la decha");
			Date fecha = null;			
			boolean fechaValida = false; // Bandera para controlar si la fecha es válida

	        // Bucle hasta que la fecha introducida sea válida
	        while (!fechaValida) {
	            System.out.println("Introduce una fecha en formato dd/MM/yyyy:");
	            String fechaInput = t.nextLine();

	            try {
	                fecha = formato.parse(fechaInput); // Intentar parsear la fecha
	                fechaValida = true; // Si no hay excepción, la fecha es válida
	                System.out.println("Fecha válida: " + fecha); // Mostrar la fecha
	            } catch (ParseException e) {
	                System.out.println("Fecha no válida. Por favor, introduce una fecha correcta.");
	            }
	        }
			*?
			/*
			try {
				fecha = formato.parse( t.nextLine());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			System.out.println("Introduce el mensaje");
			String mensaje = t.nextLine();
			System.out.println("Escribe Tlfn o Mail,"
					+ " dependiendo del tipo de Notificacion que crees");
			switch(t.nextLine())
			{
				case "Tlfn":
					System.out.println("Introduce num");
					String numTlfn =t.nextLine();
					listaNotificaciones.add(new NTelefonico(id, fecha, mensaje, numTlfn));
					break;
					
				case"Mail":
					System.out.println("Introduce la Direccion");
					String direccion = t.nextLine();
					listaNotificaciones.add(new NTelefonico(id, fecha, mensaje, direccion));
				break;				
			}
			
		}
		
		
		nuevoCliente.setFechaNac(fechaValida("Ano de nacimiento"));
		
		return nuevoCliente;
	}
	
	public Date fechaValida(String fechaPara) {

		Date fecha = null;			
		boolean fechaValida = false;
		// Bucle hasta que la fecha introducida sea válida
        while (!fechaValida) {
            System.out.println("Introduce una fecha"+fechaPara+" en formato dd/MM/yyyy:");
            String fechaInput = t.nextLine();

            try {
                fecha = formato.parse(fechaInput); // Intentar parsear la fecha
                fechaValida = true; // Si no hay excepción, la fecha es válida
                System.out.println("Fecha válida: " + fecha); // Mostrar la fecha
            } catch (ParseException e) {
                System.out.println("Fecha no válida. Por favor, introduce una fecha correcta.");
            }
        }
		return fecha;
	}
	
	public void infoClientes(List <Cliente> lista)
	{
		for(Cliente cliente: lista)
		{
			escribirEnArchivo("Clientes", cliente.toString());
		}
	}
	// Método para escribir en un archivo
    public  void escribirEnArchivo(String ruta, String contenido) {
        // Usamos try-with-resources para asegurar que se cierren los recursos automáticamente
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta))) {
            writer.write(contenido);
            writer.newLine(); // Para escribir una nueva línea
            writer.write("Otra línea de texto.");
            System.out.println("Contenido escrito en el archivo con éxito.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    
    /*
    public Vector<Integer> notificacionesEn()
    {
    	Vector<Integer> vector = new Vector<>(12);
    	return vector;
    	
    }
	*/
    
    public static int[] notificacionesEn(List<Notificacion> notificaciones, int year) {
        int[] conteoPorMes = new int[12]; // Array que almacena el número de notificaciones por mes

        // Recorrer todas las notificaciones
        for (Notificacion notificacion : listaNotificaciones) {
            Date fechaNotificacion = notificacion.getFecha(); // Obtener la fecha de la notificación
            Calendar cal = Calendar.getInstance();
            cal.setTime(fechaNotificacion); // Establecer la fecha de la notificación en el Calendar

            int yearNotificacion = cal.get(Calendar.YEAR); // Obtener el año de la notificación
            int mesNotificacion = cal.get(Calendar.MONTH); // Obtener el mes (0 para enero, 11 para diciembre)

            // Si la notificación pertenece al año pasado como parámetro
            if (yearNotificacion == year) {
                conteoPorMes[mesNotificacion]++; // Incrementar el conteo para el mes correspondiente
            }
        }

        return conteoPorMes; // Retornar el array con el conteo de notificaciones por mes
    }
    
	//Getters y Setters
	public String getNombre() {
		return nombre;
	}
	public Documentacion getId() {
		return id;
	}

	public void setId(Documentacion id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public boolean isSuscripcion() {
		return suscripcion;
	}
	public void setSuscripcion(boolean suscripcion) {
		this.suscripcion = suscripcion;
	}
	public TipoPago getPagoPref() {
		return pagoPref;
	}
	public void setPagoPref(TipoPago pagoPref) {
		this.pagoPref = pagoPref;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", suscripcion="
				+ suscripcion + ", pagoPref=" + pagoPref + ", fechaNac=" + fechaNac + ", id=" + id + "]";
	}
	
	//Constructores
	public Cliente(String nombre, String direccion, String telefono, boolean suscripcion, TipoPago pagoPref,
			Date fechaNac, Documentacion id) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.suscripcion = suscripcion;
		this.pagoPref = pagoPref;
		this.fechaNac = fechaNac;
		this.id = id;
	}
	public Cliente()
	{
		
	}
	
	
	
	
	
	
	
	
}
