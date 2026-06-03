import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Locale;

public class Main{
    public static void main (String [] args ){
        int opcao = 0;

        Locale.setDefault(Locale.US);
        Scanner entrada = new Scanner(System.in);

        ArrayList<Funcionario> listarFuncionarios = new ArrayList<>();

        do {
            System.out.println();
            System.out.println("+==============================================+");
            System.out.println("|       Sistema de Cadastro Funcionários       |");
            System.out.println("|                                              |");
            System.out.println("| Digite a opção correspondente:               |");
            System.out.println("|                                              |");
            System.out.println("| [1] - Cadastrar Funcionário Padrão           |");
            System.out.println("| [2] - Cadastrar Funcionário Comissionado     |");
            System.out.println("| [3] - Cadastrar Funcionário Produção         |");
            System.out.println("| [4] - Gerar Folha                            |");
            System.out.println("| [0] - Sair do Programa                       |");
            System.out.println("+==============================================+");
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

                    listarFuncionarios.add(new Funcionario(nome,matricula));
                    break;
                case 2:
                    entrada.nextLine();

                    System.out.print("Digite o nome do funcionario :");
                    String nomeComissao = entrada.nextLine();

                    System.out.print("Informe a Matricula: ");
                    int matriculaComissao = entrada.nextInt();

                    System.out.println("Informe o valor total de vendas R$: ");
                    double vendasTotal = testarValoresNegativos(entrada);

                    System.out.println("Valor da comissao (%): ");
                    int comissao = entrada.nextInt();
                    while (comissao < 0){
                        System.out.print("Informe um  valor valido");
                        comissao = entrada.nextInt();
                    }

                    entrada.nextLine();

                    listarFuncionarios.add(new FuncionarioComisao(nomeComissao, matriculaComissao,vendasTotal, comissao));
                    break;
                case 3:
                    entrada.nextLine();

                    System.out.print("Digite o nome do funcionario :");
                    String nomeProducao = entrada.nextLine();

                    System.out.print("Informe a Matricula: ");
                    int matriculaProducao = entrada.nextInt();

                    System.out.println("Informe quantidade de peças produzidas: ");
                    int vendasProducao = entrada.nextInt();
                    while (vendasProducao < 0){
                        System.out.print("Informe um  valor valido");
                        vendasProducao = entrada.nextInt();
                    }

                    System.out.println("Valor por cada producao: ");
                    double Producao = testarValoresNegativos(entrada);

                    entrada.nextLine();

                    listarFuncionarios.add(new FuncionarioProducao(nomeProducao, matriculaProducao, vendasProducao, Producao));

                    break;

                case 4:
                    for(Funcionario i: listarFuncionarios){
                        System.out.println("=======================");
                        i.exibirDados();

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

