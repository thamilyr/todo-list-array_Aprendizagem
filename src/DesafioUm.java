import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class DesafioUm {
  
  public static void main(String[] args) {
//    ArrayList tarefas = new ArrayList();
    ArrayList<Tarefa> tarefas = new ArrayList<>();//Generics
    
    Tarefa minhaTarefa = new Tarefa("Enviar relatório", LocalDate.of(2025, 8, 5), false);
    tarefas.add(minhaTarefa);
    tarefas.add(new Tarefa("Revisar código", LocalDate.of(2025, 8, 20), false));
    tarefas.add(new Tarefa("Atualizar documentação", LocalDate.of(2025, 8, 15), true));
    tarefas.add(new Tarefa("Preparar apresentação", LocalDate.of(2025, 8, 10), true));
    tarefas.add(new Tarefa("Reunião de projeto", LocalDate.of(2025, 8, 1), false));
    
    //tarefas não-concluídas
    final var dateComparator = new Comparator<Tarefa>() {
      @Override
      public int compare(Tarefa o1, Tarefa o2) {
        return o1.data.compareTo(o2.data);
      }
    };
    TreeSet<Tarefa> tarefasNaoConcluidas = new TreeSet<>(dateComparator);
    for (Tarefa tarefa : tarefas) {//for enhanced
      if (!tarefa.concluida) {
        tarefasNaoConcluidas.add(tarefa);
      }
    }
    System.out.println("=== Tarefas não-concluídas");
    for (Tarefa tarefa : tarefasNaoConcluidas) {
      System.out.println(tarefa);
    }
    
    TreeSet<Tarefa> tarefasConcluidas = new TreeSet<>(dateComparator);
    for (Tarefa tarefa : tarefas) {
      if (tarefa.concluida) {
        tarefasConcluidas.add(tarefa);
      }
    }
    System.out.println("\n=== Tarefas concluídas");
    for (Tarefa tarefa : tarefasConcluidas) {
      System.out.println(tarefa);
    }
    
    //Buscar por titulo e data
    String buscaTitulo = "relatório";
    System.out.println("\n=== Buscar por titulo: " + buscaTitulo);
    for (Tarefa tarefa : tarefas) {
      if (tarefa.titulo.toLowerCase().contains(buscaTitulo)) {
        System.out.println(tarefa);
      }
    }
    
    LocalDate buscaDataInicio = LocalDate.now();
    LocalDate buscaDataFim = LocalDate.now().plusDays(3);
    System.out.println("\n=== Buscar por data: "+buscaDataInicio+" a "+buscaDataFim);
    for (Tarefa tarefa : tarefas) {
      if (tarefa.data.isAfter(buscaDataInicio) && tarefa.data.isBefore(buscaDataFim)) {
        System.out.println(tarefa);
      }
    }
    
    
    
  }
  
}
