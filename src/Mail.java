import java.util.Date;

public class Mail extends Notificacion{
	
	private String direccion;
	
	
	//Getters Setters
	public String getDireccion() {
		return direccion;
	}

	public Mail(long Id, Date fecha, String mensaje,String direccion) {
		super(Id, fecha, mensaje);
		this.direccion = direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
