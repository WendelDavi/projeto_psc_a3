/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto_psc_a3.model;

/**
 *
 * @author evert
 */
public class Paciente extends Usuario {

    private String cpf;
    private String telefone;
    private String endereco;
    private String cep;
    private int idade;
    private String ano;

    public Paciente(String email, String senha) {
        super(email, senha);
    }

    public Paciente(int idUsuario, String nome, String cpf, String telefone, String cep, String endereco, int idade, String email, String senha) {
        super(idUsuario, nome, email, senha);
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cep = cep;
        this.idade = idade;
    }

    public Paciente(String nome, String cpf, String telefone, String cep, String endereco, int idade, String email, String senha) {
        super(nome, email, senha);
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cep = cep;
        this.idade = idade;
    }

    public Paciente(String email) {
        super(email);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}
