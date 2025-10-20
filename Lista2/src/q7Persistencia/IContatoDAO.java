package q7Persistencia;


import q7Negocio.Contato;
import java.util.List;

// Interface //
public interface IContatoDAO {
    public void salvar(Contato c);
    public void atualizar(Contato c);
    public void deletar(int id);
    public Contato getById(int id);
    public List<Contato> getAll();
}