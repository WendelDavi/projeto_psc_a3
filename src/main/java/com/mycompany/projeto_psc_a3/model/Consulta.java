/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto_psc_a3.model;

import java.text.ParseException;

/**
 *
 * @author evert
 */
public class Consulta {

    private int idConsulta;
    private double valor;
    private String dataHora;
    private String data;
    private String hora;
    private String especialidade;

    public Consulta() {
    }

    public Consulta(String data, String hora, String espConsulta, String sValorConsulta) throws ParseException {
        this.data = data;
        this.hora = hora;
        this.especialidade = espConsulta;
        this.valor = Double.parseDouble(sValorConsulta);
    }

    public Consulta(int idConsulta, double valorConsulta, String dataConsulta, String horaConsulta, String espConsulta) {
        this.idConsulta = idConsulta;
        this.valor = valorConsulta;
        this.data = dataConsulta;
        this.hora = horaConsulta;
        this.especialidade = espConsulta;
    }

    public Consulta(String especialidade, double valor) {
        this.valor = valor;
        this.especialidade = especialidade;
    }

    public Consulta(String dataConsulta, String horaConsulta) {
        this.data = dataConsulta;
        this.hora = horaConsulta;
    }
    
    public Consulta(String dataHora) {
        this.dataHora = dataHora;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public double getValor() {
        return valor;
    }

    public String getValor(String sValor) {
        sValor = Double.toString(valor);
        return sValor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String dataConsulta) {
        this.data = dataConsulta;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String horaConsulta) {
        this.hora = horaConsulta;
    }

    public String getHoraConsulta() {
        return hora;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String espConsulta) {
        this.especialidade = espConsulta;
    }
    
        public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return especialidade;
    }
}
