import java.util.HashMap;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Map;

public class GerenciadorDeContatos {
  private HashMap<String, String> contatos = new HashMap<>();

  public void adicionarContato(String nome, String telefone) {
    contatos.put(nome, telefone);
  }

  public void removerContato(String nome) {
    contatos.remove(nome);
  }

  public void buscarContato(String nome) {
    String telefone = contatos.get(nome);
    if (telefone != null) {
      System.out.println(nome + ": " + telefone);
    } else {
      System.out.println("Contato não encontrado.");
    }
  }

  public void listarContatos() {
    for (Map.Entry<String, String> entry : contatos.entrySet()) {
      String nome = entry.getKey();
      String telefone = entry.getValue();
      System.out.println(nome + ": " + telefone);
    }
  }

  public void salvarContatos(String nomeArquivo) {
    try (FileOutputStream fileOut = new FileOutputStream(nomeArquivo);
         ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
      objectOut.writeObject(contatos);
      System.out.println("Contatos salvos com sucesso!");
    } catch (IOException e) {
      System.out.println("Erro ao salvar contatos: " + e.getMessage());
    }
  }

  public void carregarContatos(String nomeArquivo) {
    try (FileInputStream fileIn = new FileInputStream(nomeArquivo);
         ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
      contatos = (HashMap<String, String>) objectIn.readObject();
      System.out.println("Contatos carregados com sucesso!");
    } catch (FileNotFoundException e) {
      System.out.println("Arquivo de contatos não encontrado. Uma nova lista será criada.");
      contatos = new HashMap<>();
    } catch (IOException | ClassNotFoundException e) {
      System.out.println("Erro ao carregar contatos: " + e.getMessage());
    }
  }
}
