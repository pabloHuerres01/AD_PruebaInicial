import java.util.Date;

public class NTelefonico extends Notificacion{
	private String numero;

	public NTelefonico(long id, Date fecha, String mensaje, String numero) {
		super(id, fecha, mensaje);
		this.numero = numero;
	}

	//Getters Setters
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
