import java.time.LocalDate;

public class Tarefa {
  
  String titulo;
  LocalDate data;
  boolean concluida;
  Usuario usuario;
  
  Tarefa() {
  
  }
  
  Tarefa(String titulo, LocalDate data, boolean concluida) {
    this.titulo = titulo;
    this.data = data;
    this.concluida = concluida;
  }
  
  @Override
  public String toString() {
    return "Tarefa{" +
      "titulo='" + titulo + '\'' +
      ", data=" + data +
      ", concluida=" + concluida +
      ", usuario=" + usuario +
      '}';
  }
}
