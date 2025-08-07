import java.time.LocalDate;
import java.util.ArrayList;

public class Aplicacao {
  
  public static void main(String[] args) {
    //ir à academia
    //limpar a casa
    //fazer café
    //estudar Java
    /*
    String[] todoList = new String[10];
    //adicionar cada tarefa ao array
    todoList[0] = "ir à academia";
    todoList[1] = "limpar a casa";
    todoList[2] = "fazer café";
    todoList[3] = "estudar Java";
    //laço para exibir no console (println) de todos os elementos
    for (int i=0; i < todoList.length; i++) {
      if (todoList[i] != null) {
        System.out.println(todoList[i]);
      }
    }
     */
    /*
    ArrayList todoList = new ArrayList();
    todoList.add("ir à academia");
    todoList.add("limpar a casa");
    todoList.add("fazer café");
    todoList.add("estudar Java");
    for (int i=0; i< todoList.size(); i++) {
      System.out.println(todoList.get(i));
    }
    */
    
    //TAREFA 25/7
    //Adicione para cada tarefa a data do evento e um booleano se está concluído
//    ArrayList todoList = new ArrayList();
//    Tarefa minhaTarefa = new Tarefa();
//    minhaTarefa.titulo = "ir à academia";
//    minhaTarefa.data = LocalDate.of(2025, 7,26);
//    minhaTarefa.concluida = false;
//    todoList.add(minhaTarefa);
//    minhaTarefa = new Tarefa();
//    minhaTarefa.titulo = "limpar a casa";
//    minhaTarefa.data = LocalDate.now();
//    minhaTarefa.concluida = true;
//    minhaTarefa = new Tarefa("limpar a casa", LocalDate.now(), true);
//    todoList.add(minhaTarefa);
//    for (int i=0; i< todoList.size(); i++) {
//      System.out.println(todoList.get(i));
//    }
    //DESAFIO 1
    //Liste todos as Tarefas ordenados por data e agrupados por conclusão.
    //Busque por titulo e data
    
    //TAREFA 30/7
    //Crie uma classe Usuario com os atributos: nome, email. Cada Tarefa deve estar associada a um Usuario.
    //Faça os ajustes na classe Tarefa, se necessário, e adicione uma funcionalidade para listar todas as Tarefas de um Usuario
    ArrayList<Tarefa> tarefas = new ArrayList<>();
    
    Usuario usuario = new Usuario("João", "joao@email.com");
    Usuario usuario2 = new Usuario("Pedro", "pedro@email.com");
    Usuario usuario3 = new Usuario("Ana", "ana@email.com");
    
    Tarefa tarefa1 = new Tarefa("Reunião de equipe", LocalDate.of(2025, 8, 1), false);
    tarefa1.usuario = usuario;
    tarefas.add(tarefa1);
    
    Tarefa tarefa2 = new Tarefa("Entrega do projeto", LocalDate.of(2025, 8, 15), false);
    tarefa2.usuario = usuario2;
    tarefas.add(tarefa2);
    
    Tarefa tarefa3 = new Tarefa("Revisão de código", LocalDate.of(2025, 8, 5), true);
    tarefa3.usuario = usuario3;
    tarefas.add(tarefa3);
    
    for (Tarefa tarefa : tarefas) {
        System.out.println(tarefa);
    }
    
    //DESAFIO 2
    //Além do Usuario "dono" da Tarefa, permita adicionar convidados à Tarefa, ou seja, outros Usuario
    //Verifique se há conflitos na agenda do Usuario principal ou dos convidados. Caso haja, lance uma exceção, mas sem encerrar o programa.
    
  }
  
}
