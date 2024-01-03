package View;

import Model.FuncionarioDados;

import java.util.Scanner;

public class Menu {
        public static void main(String[] args) {

            boolean continua = true;
            int opcao;
            Scanner tc = new Scanner(System.in);

            while(continua){
                System.out.println("1 - CADASTRAR   ");
                System.out.println("2 - LISTAR FUNCIONARIOS");
                System.out.println("3 - LISTAR SEXO MASCULINO ");
                System.out.println("4 - LISTAR SALARIO MAIOR QUE 2500");
                System.out.println("0 - SAIR        ");
                System.out.print("Digite a opção: ");
                opcao = tc.nextInt();
                if(opcao == 0){
                    continua = false;
                } else if (opcao ==1) {
                    System.out.println();
                    FuncDigitacao.Cadastro();

                } else if (opcao ==2) {
                System.out.println();
                FuncionarioDados.listarFuncionarios();

                } else if (opcao ==3) {
                System.out.println();
                FuncionarioDados.listarMasculinos();
                }
                else if (opcao ==4) {
                    System.out.println();
                    FuncionarioDados.listarSalarios();
                }
            }
        }
    }
