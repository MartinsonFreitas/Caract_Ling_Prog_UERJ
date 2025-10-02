
public class Contador {
	// Atributos estáticos
	public static int totalObjetos = 0;
	
	// Construtor
	public Contador() {
		totalObjetos++;
	}
	
	// Métodos
	/*public void mostrarContagem() {
		System.out.println("Total objetos criados: "+totalObjetos);
	}
	/**/
	public static void mostrarContagem() {
		System.out.println("Total objetos criados: "+totalObjetos);
	}
	/**/
}
