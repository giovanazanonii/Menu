package Model;

import Control.FuncionarioDAO;

public class FuncionarioDados {
    private String nome_func;
    private String datanasc_func;
    private double salario_func;
    private String sexo_func;

    public String getNome_func() {
        return nome_func;
    }

    public void setNome_func(String nome_func) {
        this.nome_func = nome_func;
    }

    public String getDatanasc_func() {
        return datanasc_func;
    }

    public void setDatanasc_func(String datanasc_func) {
        this.datanasc_func = datanasc_func;
    }

    public double getSalario_func() {
        return salario_func;
    }
    public void setSalario_func(double salario_func) {
        this.salario_func = salario_func;
    }

    public String getSexo_func() {
        return sexo_func;
    }

    public void setSexo_func(String sexo_func) {
        this.sexo_func = sexo_func;
    }
    public static void enviarDados(FuncionarioDados dados){
        FuncionarioDAO enviar = new FuncionarioDAO();
        enviar.cadastrarFuncionario(dados);
    }
    public static void listarFuncionarios(){
        FuncionarioDAO listar = new FuncionarioDAO();
        listar.listarFuncionarios();
    }
    public static void listarMasculinos(){
        FuncionarioDAO listar = new FuncionarioDAO();
        listar.listarMasculinos();
    }
    public static void listarSalarios(){
        FuncionarioDAO listar = new FuncionarioDAO();
        listar.listarSalarios();
    }
}