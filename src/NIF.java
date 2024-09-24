
public class NIF extends Documentacion {
	private String numero; 
	private char letraFinal;
	
	//Getters Setters
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public char getLetraFinal() {
		return letraFinal;
	}
	public void setLetraFinal(char letraFinal) {
		this.letraFinal = letraFinal;
	}
	
	//metodos del extend
	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		
	}
	
	//Constructor
	public NIF(String numero, char letraFinal) {
		super();
		this.numero = numero;
		this.letraFinal = letraFinal;
	}
	

}
