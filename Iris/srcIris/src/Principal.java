import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Principal {
	public static void main(String[] args) {
		String meuArquivo = "C:/Users/ADM/Downloads/Giomar/Estruturas/iris.csv"; 
		
		//Criamos um objeto File
		File arquivo = new File(meuArquivo);
		try {
			if(!arquivo.exists())
				System.out.println("Arquivo não existe.");
	
			//Leitura do arquivo
			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);
			// enquanto houver linhas ler
			while(br.ready()) {
				String linha = br.readLine();
				String[] atributos = linha.split(",");
				//System.out.println(atributos[0]);
				double comp_sepala = Double.parseDouble(atributos[0]);
				double lar_sepala = Double.parseDouble(atributos[1]);
				double comp_petala = Double.parseDouble(atributos[2]);
				double lar_pelata = Double.parseDouble(atributos[3]);
				String tipo = atributos[4];
				
				Iris iris = new Iris(comp_sepala,lar_sepala,comp_petala, lar_pelata,tipo);
				System.out.println(iris);
			}
			fr.close();
			br.close();
		} catch (IOException e) {
			System.err.println("Houve um erro ao criar o arquivo..."+e.getMessage());
		}
	
	}
}
