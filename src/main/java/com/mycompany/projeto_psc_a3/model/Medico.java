/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto_psc_a3.model;

/**
 *
 * @author evert
 */
public class Medico extends Usuario {

    public Medico(int idUsuario, String nome, String email, String senha) {
        super(idUsuario, nome, email, senha);
    }

    public Medico(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    public Medico(String email, String senha) {
        super(email, senha);
    }
}
