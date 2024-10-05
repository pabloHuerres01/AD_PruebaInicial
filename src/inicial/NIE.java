
public class NIE extends Documentacion{
	
	private String numnero;
	private char letraInicial, letraFinal;
	
	//Getters Setters
	public String getNumnero() {
		return numnero;
	}
	public void setNumnero(String numnero) {
		this.numnero = numnero;
	}
	public char getLetraInicial() {
		return letraInicial;
	}
	public void setLetraInicial(char letraInicial) {
		this.letraInicial = letraInicial;
	}
	public char getLetraFinal() {
		return letraFinal;
	}
	public void setLetraFinal(char letraFinal) {
		this.letraFinal = letraFinal;
	}
	
	//Metodos del EXTENDS
	@Override
	public void validar() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		
	}
	
	//Contructores
	public NIE(String numnero, char letraInicial, char letraFinal) {
		super();
		this.numnero = numnero;
		this.letraInicial = letraInicial;
		this.letraFinal = letraFinal;
	} 
	
	public NIE ()
	{
		
	}
	
	//
	

}
