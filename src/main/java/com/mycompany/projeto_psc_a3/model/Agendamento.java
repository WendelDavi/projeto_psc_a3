/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto_psc_a3.model;

import java.text.ParseException;
import java.sql.Timestamp;

/**
 *
 * @author evert
 */
public class Agendamento extends Consulta {

    private int idPaciente;
    private String cpfPaciente;
    private Timestamp dataHoraAgendamento;

    public Agendamento(String sDataConsulta, String sHoraConsulta, String espConsulta, String sValorConsulta) throws ParseException {
        super(sDataConsulta, sHoraConsulta, espConsulta, sValorConsulta);
    }

    public Agendamento(int idConsulta, String dataConsulta, String horaConsulta, String espConsulta, double valorConsulta) {
        super(idConsulta, valorConsulta, dataConsulta, horaConsulta, espConsulta);
    }

    public Agendamento(String dataConsulta, String horaConsulta) {
        super(dataConsulta, horaConsulta);
    }

    public Agendamento(int idConsulta, double valor, String data, String hora, String especialidade, String cpfPaciente) {
        super(idConsulta, valor, data, hora, especialidade);
        this.cpfPaciente = cpfPaciente;
    }

    public Agendamento(String especialidade, Timestamp dataHora, double valor, int idPaciente) throws ParseException {
        super(especialidade, valor);
        this.dataHoraAgendamento = dataHora;
        this.idPaciente = idPaciente;
    }

    public Agendamento(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
    }

    public Timestamp getDataHoraAgendamento() {
        return dataHoraAgendamento;
    }

    public void setDataHoraAgendamento(Timestamp dataHora) {
        this.dataHoraAgendamento = dataHora;
    }

    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public void setCpfPaciente(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
    }
    
        public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
    

    @Override
    public String toString() {
        return super.toString() + " - " + this.cpfPaciente + " - " + this.dataHoraAgendamento;
    }

}
