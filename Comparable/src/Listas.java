import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Listas {
	public static void main(String[] args) {
		List lista = new ArrayList();
		lista.add("Joao");
		lista.add(5);
		lista.add(true);
		
		Pessoa p = new Pessoa("Maria", 25);
		lista.add(p);
		
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}
		System.out.println();
		List<Pessoa> agenda = new ArrayList<>();
		
		agenda.add(new Pessoa("Carlos", 32));
		agenda.add(p);
		agenda.add(new Pessoa("Julia", 50));
		
		for (Iterator iterator = agenda.iterator(); iterator.hasNext();) {
			Pessoa pessoa = (Pessoa) iterator.next();
			System.out.println(pessoa.getNome());
		}
		
		List<Integer> numeros = new ArrayList<>();
		numeros.add(5);
		numeros.add(8);
		numeros.add(3);
		
		System.out.println(numeros);
		Collections.sort(numeros);
		System.out.println(numeros);
		
		
		System.out.println(agenda);
		Collections.sort(agenda);
		System.out.println(agenda);
		
		
	}
}
