import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Locale;

public class Main{
    public static void main (String [] args ){
        int opcao, contador = 0;

        Locale.setDefault(Locale.US);
        Scanner entrada = new Scanner(System.in);

        ArrayList<Funcionario> listarFuncionarios = new ArrayList<>();

        do {
            System.out.println();
            System.out.println("Sistema de Cadastramento Funcionarios");
            System.out.println("[1] - Cadastrar Funcionario Padrão");
            System.out.println("[2] - Cadastrar Funcionario Comissionado");
            System.out.println("[3] - Cadastrar Funcionario Produção");
            System.out.println("[4] - Gerar Folha ");
            System.out.println("[0] - Sair do Programa");
            System.out.println();

            try {
                opcao = entrada.nextInt();

                while (opcao < 0 || opcao > 4) {

                    System.out.print("Opção invalida, digite novamente a opção desejada: ");
                    opcao = entrada.nextInt();

                }
            } catch(InputMismatchException e) {

                System.out.println("Erro: Digite uma opção valida");
                entrada.nextLine();

                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    entrada.nextLine();

                    System.out.print("Digite o nome do funcionario :");
                    String nome = entrada.nextLine();

                    System.out.print("Informe a Matricula: ");
                    int matricula = entrada.nextInt();

                    System.out.print("Informe o Salario: ");
                    double salario = testarValoresNegativos(entrada);

                    contador++;

                    listarFuncionarios.add(new Funcionario(contador,nome,matricula,salario));
                    break;
                case 2:
                    entrada.nextLine();

                    System.out.print("Digite o nome do funcionario :");
                    String nomeComissao = entrada.nextLine();

                    System.out.print("Informe a Matricula: ");
                    int matriculaComissao = entrada.nextInt();

                    System.out.print("Informe o Salario: ");
                    double salarioComissao = testarValoresNegativos(entrada);

                    System.out.println("Informe o valor total de vendas R$: ");
                    double vendasTotal = testarValoresNegativos(entrada);

                    System.out.println("Valor da comissao (%): ");
                    int comissao = entrada.nextInt();
                    while (comissao < 0){
                        System.out.print("Informe um  valor valido");
                        comissao = entrada.nextInt();
                    }

                    entrada.nextLine();
                    contador++;

                    listarFuncionarios.add(new FuncionarioComisao(contador, nomeComissao, matriculaComissao,salarioComissao, vendasTotal, comissao));
                    break;
                case 3:
                    entrada.nextLine();

                    System.out.print("Digite o nome do funcionario :");
                    String nomeProducao = entrada.nextLine();

                    System.out.print("Informe a Matricula: ");
                    int matriculaProducao = entrada.nextInt();

                    System.out.print("Informe o Salario: ");
                    double salarioProducao = testarValoresNegativos(entrada);

                    System.out.println("Informe quantidade de peças produzidas: ");
                    int vendasProducao = entrada.nextInt();
                    while (vendasProducao < 0){
                        System.out.print("Informe um  valor valido");
                        vendasProducao = entrada.nextInt();
                    }

                    System.out.println("Valor por cada producao: ");
                    double Producao = testarValoresNegativos(entrada);

                    entrada.nextLine();
                    contador++;

                    listarFuncionarios.add(new FuncionarioProducao(contador, nomeProducao, matriculaProducao,salarioProducao, vendasProducao, Producao));

                    break;

                case 4:
                    for(Funcionario f: listarFuncionarios){
                        System.out.println("=======================");
                        f.exibirDados();

                    }
            }
        } while (opcao != 0);
        System.out.print("Obrigado por utilizar");


    }

    public static double testarValoresNegativos(Scanner entrada){
        double valor = entrada.nextDouble();

        while (valor <0) {
            System.out.print("Informe um valor valido");
            valor = entrada.nextDouble();
        }
        return valor;
    }

}
class Funcionario{
    String nome;
    int id, matricula;
    double salarioFinal;

    public Funcionario (int id,String nome, int matricula,double salarioFinal){
        this.nome = nome;
        this.id = id;
        this.matricula = matricula;
        this.salarioFinal = salarioFinal;
    }
    public void exibirDados(){
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Matricula: " + matricula);
        System.out.println("Salario: " + salarioFinal);
    }

}
class FuncionarioComisao extends Funcionario {
    double valorDeVendas ;
    int comissao;

    public FuncionarioComisao (int id, String nome,int matricula,double salarioFinal,double valorDeVendas,int comissao){
        super(id, nome,matricula,salarioFinal);
        this.valorDeVendas = valorDeVendas;
        this.comissao = comissao;
    }
    @Override
    public void exibirDados(){
        super.exibirDados();
        System.out.println("Valor de Venda: " + valorDeVendas);
        System.out.println("Valor da Comissão: " + comissao);
        System.out.println("Salario Final: " + ( salarioFinal+(valorDeVendas*comissao)/100));
    }

}
class FuncionarioProducao extends Funcionario {
    double valorDaPeca;
    int quantidadeDePecasVendidas;

    public FuncionarioProducao(int id, String nome, int matricula,double salarioFinal, int quantidadeDePecasVendidas, double valorDaPeca){
        super(id, nome, matricula, salarioFinal);
        this.quantidadeDePecasVendidas = quantidadeDePecasVendidas;
        this.valorDaPeca = valorDaPeca;
    }
    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.print("Quantidade de peças vendidas: " + quantidadeDePecasVendidas);
        System.out.println("Valor da peça: " + valorDaPeca);
        System.out.println("Salario Final: " + ( salarioFinal+(quantidadeDePecasVendidas * valorDaPeca)));
    }
}
