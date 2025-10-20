
public class Quadrado implements ObjetoGeometrico{
	//atributos da classee
	private double lado;
	
	//métodos getter e setters
	public double getLado(){
		return this.lado;
	}
	
	public void setLado(double lado){
		this.lado = lado;
	}

	@Override
	public double CalcularArea() {
		return lado*lado;
	}

	@Override
	public double CalcularPerimetro() {
		return 4*lado;
	}

}
