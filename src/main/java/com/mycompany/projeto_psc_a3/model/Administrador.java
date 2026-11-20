/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto_psc_a3.model;

/**
 *
 * @author evert
 */
public class Administrador extends Usuario {
    
    public Administrador(int idUsuario, String nome, String email, String senha) {
        super(idUsuario, nome, email, senha);
    }

    public Administrador(String email) {
        super(email);
    }

    public Administrador(String email, String senha) {
        super(email, senha);
    }
}
