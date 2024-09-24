import java.util.Date;

public class Notificacion {

	
	/*
	 * Variables internas de Noti
	 */
	private long id;
	private Date fecha = new Date();
	private String mensaje;
	
	//Getters Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
	
}
