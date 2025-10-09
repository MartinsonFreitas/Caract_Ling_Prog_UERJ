import java.io.BufferedWriter;
import java.io.File; // input , output
import java.io.FileWriter;
import java.io.IOException;

public class TesteArquivo {

	public static void main(String[] args) {
		String meuArquivo = "arquivo.txt"; // "c:/arvuivo.txt"
		
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
			//File[] arquivos = arquivo.listFiles();
			
			// Escrever no arquivo
			FileWriter fw = new FileWriter(arquivo);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Texto de Exemplo");
			bw.newLine();
			bw.write("Outra linha");
			fw.close();
			bw.close();
			
		} catch (IOException e) {
			System.err.println("Houve um erro ao criar o arquivo... "+e.getMessage());
		}

	}

}
