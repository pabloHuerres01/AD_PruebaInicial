import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Cliente {
	//private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	static Scanner t = new Scanner(System.in);
	
	/*
	 * Variables de Cliente
	 */
	private String nombre, direccion, telefono;
	private boolean suscripcion = false;
	private TipoPago pagoPref = TipoPago.E;
	private Date fechaNac;
	private Documentacion id;
	
	//Metodos
	
	public static Cliente nuevocliente()
	{
		Cliente nuevoCliente = new Cliente();
		System.out.println("Introduce NIE o NIF dependiendo de lo que ingreses");
		switch(t.nextLine()) {
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
		System.out.println("Introduce Tipo Pegado");
		nuevoCliente.setPagoPref(TipoPago.valueOf(t.nextLine().toUpperCase()));
		
		//Cosas para setear la fecha
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Introduce una fecha nacimiento (dd/MM/yyyy): ");
		try {
			nuevoCliente.setFechaNac(formato.parse(t.nextLine()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nuevoCliente;
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
	
	//
	
	
	
}
