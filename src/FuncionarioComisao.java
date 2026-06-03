class FuncionarioComisao extends Funcionario {
    double valorDeVendas ;
    int comissao;
    final double SALARIOBASE = 2000;

    public FuncionarioComisao (String nome,int matricula,double valorDeVendas,int comissao){
        super(nome,matricula);
        this.valorDeVendas = valorDeVendas;
        this.comissao = comissao;
    }
    @Override
    public void exibirDados(){
        super.exibirDados();
        System.out.println("Valor de Venda: " + valorDeVendas);
        System.out.println("Valor da Comissão: " + comissao);
        System.out.printf( "Salario Final: %.2f", ( SALARIOBASE +(valorDeVendas*comissao)/100));
        System.out.println();
    }

}