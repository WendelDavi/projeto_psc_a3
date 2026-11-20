/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto_psc_a3.model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author evert
 */
public class ConexaoBD {

    private static String host = "localhost";
    private static String porta = "3306";
    private static String db = "2022_consultas_hospitalares";
    private static String usuario = "root";
    private static String senha = "W22hh1so.";

    public static Connection obterConexao() throws Exception {
        String url = String.format(
                "jdbc:mysql://%s:%s/%s?useTimezone=true&serverTimezone=America/Sao_Paulo",
                host,
                porta,
                db
        );
        return DriverManager.getConnection(url, usuario, senha);
    }
}
