package View;

import Model.FuncionarioDados;

import java.util.Scanner;

public class FuncDigitacao {

    public static void Cadastro(){
        boolean continua = true;
        char opcao = 'S';
        while (continua){
            Scanner tc = new Scanner(System.in);
            FuncionarioDados dados = new FuncionarioDados();

            System.out.print("Digite o nome do funcionário: ");
            dados.setNome_func(tc.nextLine());
            System.out.print("Digite a data de nascimento: ");
            dados.setDatanasc_func(tc.nextLine());
            System.out.print("Digite o salario do funcionário: ");
            dados.setSalario_func(tc.nextDouble());
            tc.nextLine();
            System.out.print("Digite o sexo do funcionário(F/M): ");
            dados.setSexo_func(tc.nextLine());

            FuncionarioDados.enviarDados(dados);

            System.out.print("Deseja continuar(S/N)? ");

            opcao = tc.next().toUpperCase().charAt(0);
            if (opcao == 'N') {
                continua = false;
            }
     }
    }
}
