public class Main {
 public static void main(String[] args) {
  GerenciadorDeContatos gerenciador = new GerenciadorDeContatos();

  // Carregar contatos existentes do disco
  gerenciador.carregarContatos("contatos.dat");

  gerenciador.adicionarContato("Glauco", "123456789");
  gerenciador.adicionarContato("Maria", "987654321");

  gerenciador.buscarContato("Maria");
  gerenciador.listarContatos();

  // Salvar contatos no disco
  gerenciador.salvarContatos("contatos.dat");
 }
}

