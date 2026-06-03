class Funcionario{
    String nome;
    int matricula;
    final double SALARIOBASE = 2000;

    public Funcionario (String nome, int matricula){
        this.nome = nome;
        this.matricula = matricula;
    }
    public void exibirDados(){
        System.out.println("Nome: " + nome);
        System.out.println("Matricula: " + matricula);
        System.out.printf("Salario: %.2f", SALARIOBASE);
        System.out.println();
    }

}