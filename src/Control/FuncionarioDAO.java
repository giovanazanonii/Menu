package Control;

import BancoDados.ConexaoBanco;
import Model.FuncionarioDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FuncionarioDAO {
    private Connection conectar;
    public FuncionarioDAO(){
        conectar = new ConexaoBanco().getConnection();
    }

    //****************** ARRUMA DATA ******************
    public  String arrumaData(String data){
        String dia = data.substring(0,2);
        String mes = data.substring(3,5);
        String ano = data.substring(6);
        data = ano+"-"+mes+"-"+dia;
        return  data;
    }
    public  String DataMostrar(String data){
        String ano = data.substring(0,4);
        String mes = data.substring(5,7);
        String dia = data.substring(8);
        data = dia+"-"+mes+"-"+ano;
        return  data;
    }

    //******************  CADASTRO  ******************

    public void cadastrarFuncionario(FuncionarioDados dados){
        try {
            String sql= "INSERT INTO funcionarios(nome_func,datanasc_func,salario_func,sexo_func)VALUES"
                    +"(?,?,?,?)";
            String data = arrumaData(dados.getDatanasc_func());

            PreparedStatement inserir = conectar.prepareStatement(sql);
            inserir.setString(1,dados.getNome_func().toUpperCase());
            inserir.setString(2,data);
            inserir.setDouble(3,dados.getSalario_func());
            inserir.setString(4,dados.getSexo_func());
            inserir.execute();
            inserir.close();
            System.out.println("Cadastro com êxito");
        }catch (Exception erro){
            System.out.println("Erro no cadastro" + erro);
        }
    }

    //****************** LISTAR FUNCIONARIOS ***********
    public void listarFuncionarios(){
        try {
            String sql = "SELECT * FROM funcionarios";
            PreparedStatement declarar = conectar.prepareStatement(sql);
            ResultSet listar;
            listar = declarar.executeQuery();
            while (listar.next()){
                System.out.println(listar.getInt("id_func"));
                System.out.println("Nome Funcionario: " + listar.getString("nome_func"));
                System.out.println("Data Nascimento: "+ DataMostrar(listar.getString("datanasc_func")));
                System.out.println("Salario Funcionario: "+ listar.getDouble("salario_func"));
                System.out.println("Sexo do Funcionario: "+ listar.getString("sexo_func"));
            }
        }catch (Exception erro){
            System.out.println("Erro com dados "+ erro);
        }
    }
    //**************** LISTAR MASCULINOS ********************
    public void listarMasculinos(){
        try {
            String sql = "SELECT * FROM funcionarios WHERE sexo_func='M'";
            PreparedStatement declarar = conectar.prepareStatement(sql);
            ResultSet listar;
            listar = declarar.executeQuery();
            while (listar.next()){
                System.out.println(listar.getInt("id_func"));
                System.out.println("Nome Funcionario: " + listar.getString("nome_func"));
                System.out.println("Data Nascimento: "+ DataMostrar(listar.getString("datanasc_func")));
                System.out.println("Salario Funcionario: "+ listar.getDouble("salario_func"));
                System.out.println("Sexo do Funcionario: "+ listar.getString("sexo_func"));
            }
        }catch (Exception erro){
            System.out.println("Erro com dados "+ erro);
        }
    }
    //**************** SALARIOS MAIORES QUE 2500******************
    public void listarSalarios(){
        try {
            String sql = "SELECT * FROM funcionarios WHERE salario_func>=2500";
            PreparedStatement declarar = conectar.prepareStatement(sql);
            ResultSet listar;
            listar = declarar.executeQuery();
            while (listar.next()){
                System.out.println(listar.getInt("id_func"));
                System.out.println("Nome Funcionario: " + listar.getString("nome_func"));
                System.out.println("Data Nascimento: "+ DataMostrar(listar.getString("datanasc_func")));
                System.out.println("Salario Funcionario: "+ listar.getDouble("salario_func"));
                System.out.println("Sexo do Funcionario: "+ listar.getString("sexo_func"));
            }
        }catch (Exception erro){
            System.out.println("Erro com dados "+ erro);
        }
    }

}
