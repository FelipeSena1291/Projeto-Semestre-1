class FuncionarioProducao extends Funcionario {
    double valorDaPeca;
    int quantidadeDePecasVendidas;
    final double SALARIOBASE = 2000;

    public FuncionarioProducao(String nome, int matricula, int quantidadeDePecasVendidas, double valorDaPeca){
        super(nome, matricula);
        this.quantidadeDePecasVendidas = quantidadeDePecasVendidas;
        this.valorDaPeca = valorDaPeca;
    }
    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Quantidade de peças vendidas: " + quantidadeDePecasVendidas);
        System.out.println("Valor da peça: " + valorDaPeca);
        System.out.printf("Salario Final: %.2f", ( SALARIOBASE +(quantidadeDePecasVendidas * valorDaPeca)));
        System.out.println();
    }
}