import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DesafioDois {
  
  public static void main(String[] args) {
    Usuario usuario1 = new Usuario("João", "joao@email.com");
    Usuario usuario2 = new Usuario("Maria", "maria@email.com");
    Usuario usuario3 = new Usuario("Pedro", "pedro@email.com");
    Usuario usuario4 = new Usuario("Jesse", "jesse@email.com");
    
    Tarefa tarefa1 = new Tarefa("Reunião 1", LocalDate.of(2025, 8, 5), false);
    Tarefa tarefa2 = new Tarefa("Reunião 2", LocalDate.of(2025, 8, 5), false);
    Tarefa tarefa3 = new Tarefa("Reunião 3", LocalDate.of(2025, 8, 6), false);
    
    try {
      System.out.println("# Criando tarefa1 do usuario1...");
      usuario1.adicionarTarefa(tarefa1);
      System.out.printf("Tarefas atuais do usuário %s%n", usuario1);
      System.out.println("# Convidando usuario2 para a tarefa1...");
      tarefa1.adicionarConvidado(usuario2);
      System.out.printf("Tarefas atuais do usuário %s%n", usuario2);
    } catch (ConflitoTarefaException e) {
      System.out.println(">> Erro: "+ e.getMessage());
    }
    
    System.out.println("-----------------------");
    
    try {
      System.out.println("# Criando tarefa2 do usuario2...");
      usuario2.adicionarTarefa(tarefa2);
      System.out.printf("Tarefas atuais do usuário %s%n", usuario2);
    } catch (ConflitoTarefaException e) {
      System.out.println(">> Erro: "+ e.getMessage());
    }
    
    System.out.println("-----------------------");
    
    try {
      System.out.println("# Criando tarefa3 do usuario3...");
      usuario3.adicionarTarefa(tarefa3);
      System.out.printf("Tarefas atuais do usuário %s%n", usuario3);
      System.out.println("# Convidando usuario1 para tarefa3...");
      tarefa3.adicionarConvidado(usuario1);
      System.out.printf("Tarefas atuais do usuário %s%n", usuario1);
    } catch (ConflitoTarefaException e) {
      System.out.println(">> Erro: "+ e.getMessage());
    }
    
    System.out.println("-----------------------");
    try {
      System.out.println("# Criando tarefa2 do usuario4...");
      usuario4.adicionarTarefa(tarefa2);
      System.out.printf("Tarefas atuais do usuário %s%n", usuario4);
      System.out.println("# Convidando usuario1 para tarefa2...");
      tarefa2.adicionarConvidado(usuario1);
    } catch (ConflitoTarefaException e) {
      System.out.println(">> Erro: " + e.getMessage());
    }
    
  }
  
  private static class Tarefa {
    
    String titulo;
    LocalDate data;
    boolean concluida;
    List<Usuario> convidados = new ArrayList<>();
    
    public Tarefa(String titulo, LocalDate data, boolean concluida) {
      this.titulo = titulo;
      this.data = data;
      this.concluida = concluida;
    }
    
    void adicionarConvidado(Usuario convidado) {
      this.convidados.add(convidado);
      convidado.adicionarTarefa(this);
      System.out.println("Convidado adicionado com sucesso! " + convidado);
    }
    
    @Override
    public String toString() {
      return "Tarefa{" +
        "titulo='" + titulo + '\'' +
        ", data=" + data +
        ", concluida=" + concluida +
        ", convidados=" + convidados +
        '}';
    }
  }
  
  private static class Usuario {
    
    String nome;
    String email;
    List<Tarefa> tarefasList = new ArrayList<>();
    
    public Usuario(String nome, String email) {
      this.nome = nome;
      this.email = email;
    }
    
    void adicionarTarefa(Tarefa novaTarefa) {
      for (var tarefa : tarefasList) {
        if (!tarefa.concluida && !novaTarefa.concluida && tarefa.data.isEqual(novaTarefa.data)) {
          if (novaTarefa.convidados.contains((this))) {
            novaTarefa.convidados.remove(this);
            System.out.println("Convidado removido por conflito");
          }
          throw new ConflitoTarefaException("Conflito nas tarefas do usuário %s. Entre %s não concluída e nova tarefa %s".formatted(this, tarefa, novaTarefa));
        }
      }
      tarefasList.add(novaTarefa);
      System.out.println("Tarefa adicionada com sucesso! " + novaTarefa);
    }
    
    @Override
    public String toString() {
      return "Usuario{" +
        "nome='" + nome + '\'' +
        ", email='" + email + '\'' +
        '}';
    }
  }
  
  private static class ConflitoTarefaException extends RuntimeException {
    
    public ConflitoTarefaException(String mensagemFormatada) {
      super(mensagemFormatada);
    }
  }
}
