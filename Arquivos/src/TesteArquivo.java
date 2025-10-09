import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File; // input , output
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TesteArquivo {

	public static void main(String[] args) {
		String meuArquivo = "arquivo.txt"; // "c:/arquivo.txt"
		//String meuDiretorio = "/Arquivos";
		
		// Criamos um objeto File
		File arquivo = new File(meuArquivo);
		
		// Se arquivo não existe, cria
		try {
			if (!arquivo.exists()) {
				
				// cria um arquivo (vazio)
				arquivo.createNewFile();
				System.out.println("Arquivo criado com sucesso!");
				
			} else {
				
				System.out.println("Arquivo já existe!");
				
			}
			
			// Listar aquivos de um diretório
			File[] arquivos = arquivo.listFiles();
			
			// Escrever no arquivo
			FileWriter fw = new FileWriter(arquivo, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Texto de Exemplo a ser escrito no txt...");
			bw.newLine();
			bw.write("Outra linha...");
			bw.newLine();
			
			bw.close(); 
			fw.close(); 
			
			// Faz a leitura do arquivo
			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);
			
			// Enquanto houver mais linhas
			while (br.ready()) {
				// lê próxima linha
				String linha = br.readLine();
				// Faz algo com a linha
				System.out.println(linha);
			}
			
			// fecha BufferedReader e FileReader
			// na ordem inversa da abertura
			br.close();
			fr.close();
						
		} catch (IOException e) {
			
			System.err.println("Houve um erro ao criar o arquivo... "+e.getMessage());
		
		}
	}
}
