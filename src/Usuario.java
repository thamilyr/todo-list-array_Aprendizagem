public class Usuario {
  
  String nome;
  String email;
  
  public Usuario() {
  }
  
  public Usuario(String nome, String email) {
    this.nome = nome;
    this.email = email;
  }
  
  public Usuario(String nome) {
    if (nome == null || nome.isEmpty()) {
      throw new IllegalArgumentException("O nome não deve ser nulo ou vazio");
    }
    this.nome = nome;
  }
  
  @Override
  public String toString() {
    return "Usuario{" +
      "nome='" + nome + '\'' +
      ", email='" + email + '\'' +
      '}';
  }
}
