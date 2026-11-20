/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto_psc_a3.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 *
 * @author evert
 */
public class DAO {

    public Paciente existePaciente(Paciente usuario) throws Exception {
        String sql = "SELECT * FROM paciente WHERE emailPaciente = ? AND senhaPaciente = ?";
        try (Connection conn = ConexaoBD.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getSenha());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuario.setCpf(rs.getString("cpfPaciente"));
                    return usuario;
                } else {
                    return null;
                }
            }
        }
    }

    public boolean existeAdm(Administrador uAdm) throws Exception {
        String sql = "SELECT * FROM administrador WHERE emailAdministrador = ? AND senhaAdministrador = ?;";
        try (Connection conn = ConexaoBD.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, uAdm.getEmail());
            ps.setString(2, uAdm.getSenha());
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    public boolean existeMedico(Medico usuario) throws Exception {
        String sql = "SELECT * FROM medico WHERE emailMedico = ? AND senhaMedico = ?";
        try (Connection conn = ConexaoBD.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getSenha());
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    public boolean existeRecepcionista(Recepcionista usuario) throws Exception {
        String sql = "SELECT * FROM recepcionista WHERE emailRecepcionista = ? AND senhaRecepcionista = ?";
        try (Connection conn = ConexaoBD.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getSenha());
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    public void cadastroUsuario(Paciente usuario) throws Exception {
        String sql = "INSERT INTO paciente(nomePaciente, emailPaciente, cpfPaciente, telefonePaciente, enderecoPaciente, idadePaciente, senhaPaciente, cepPaciente) VALUES (?,?,?,?,?,?,?,?)";
        try (Connection conn = ConexaoBD.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getCpf());
            ps.setString(4, usuario.getTelefone());
            ps.setString(5, usuario.getEndereco());
            ps.setInt(6, usuario.getIdade());
            ps.setString(7, usuario.getSenha());
            ps.setString(8, usuario.getCep());
            ps.execute();
        }
    }

    public void adicionarAgendamento(Agendamento agendamento) throws Exception {
        String sql = "INSERT INTO sistema_agendamento(especialidadeAgendamento, dataHoraAgendamento, valorAgendamento, fk_paciente) VALUES (?,?,?,?)";
        try (Connection conn = ConexaoBD.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, agendamento.getEspecialidade());
            ps.setTimestamp(2, agendamento.getDataHoraAgendamento());
            ps.setDouble(3, agendamento.getValor());
            ps.setInt(4, agendamento.getIdPaciente());
            ps.execute();
        }
    }

    public void removerAgendamento(Agendamento agendamento) throws Exception {
        String sql = "DELETE FROM sistema_agendamento WHERE fk_paciente = ?";
        try (Connection conn = ConexaoBD.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, agendamento.getCpfPaciente());
            ps.execute();
        }
    }

    public void removerConsulta(Consulta consulta) throws Exception {
        String sql = "DELETE FROM consulta WHERE dataHora = ?";
        try (Connection conn = ConexaoBD.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, consulta.getDataHora());
            System.out.print(consulta.getDataHora());
            ps.execute();
        }
    }

    public Consulta[] obterConsultas() throws Exception {
        String sql = "SELECT * FROM consulta";
        try (Connection conn = ConexaoBD.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY); ResultSet rs = ps.executeQuery()) {

            int totalConsultas = rs.last() ? rs.getRow() : 0;
            Consulta[] consulta = new Consulta[totalConsultas];
            rs.beforeFirst();
            int contador = 0;

            while (rs.next()) {
                int id = rs.getInt("idConsulta");

                Timestamp timestampConsulta = rs.getTimestamp("dataHora");
                SimpleDateFormat dataFormato = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat horaFormato = new SimpleDateFormat("HH:mm");

                String dataConsulta = dataFormato.format(timestampConsulta);
                String horaConsulta = horaFormato.format(timestampConsulta);

                String especialidade = rs.getString("nomeEspecialidade");
                Double valorConsulta = rs.getDouble("valorConsulta");
                consulta[contador++] = new Consulta(id, valorConsulta, dataConsulta, horaConsulta, especialidade);
            }
            return consulta;
        }
    }

    public void cadastroAdm(Administrador uAdm) throws Exception {
        String sql = "INSERT INTO administrador(emailAdministrador, senhaAdministrador) VALUES (?,?)";
        try (Connection conn = ConexaoBD.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, uAdm.getEmail());
            ps.setString(2, uAdm.getSenha());
            ps.execute();
        }
    }

    public void removerAdm(Administrador uAdm) throws Exception {
        String sql = "DELETE FROM administrador WHERE emailAdministrador = ?";
        try (Connection conn = ConexaoBD.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, uAdm.getEmail());
            ps.execute();
        }
    }

    public void removerUsuario(Paciente u) throws Exception {
        String sql = "DELETE FROM paciente WHERE emailPaciente = ?";
        try (Connection conn = ConexaoBD.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, u.getEmail());
            ps.execute();
        }
    }

    public Paciente[] buscarUsuario() throws Exception {
        String sql = "SELECT * FROM paciente";
        try (Connection conn = ConexaoBD.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY); ResultSet rs = ps.executeQuery()) {
            int totalUsuarios = rs.last() ? rs.getRow() : 0;
            Paciente[] usuario = new Paciente[totalUsuarios];
            rs.beforeFirst();
            int contador = 0;
            while (rs.next()) {
                int id = rs.getInt("idPaciente");
                String nome = rs.getString("nomePaciente");
                String cpf = rs.getString("cpfPaciente");
                String telefone = rs.getString("telefonePaciente");
                String cep = rs.getString("cepPaciente");
                String endereco = rs.getString("enderecoPaciente");
                int idade = rs.getInt("idadePaciente");
                String email = rs.getString("emailPaciente");
                String senha = rs.getString("senhaPaciente");
                usuario[contador++] = new Paciente(id, nome, cpf, telefone, cep, endereco, idade, email, senha);
            }
            return usuario;
        }
    }

    public void adicionarConsulta(Consulta consulta) throws Exception {
        String sql = "INSERT INTO consulta(nomeEspecialidade, dataConsulta, horaConsulta, valorConsulta) VALUES (?,?,?,?)";
        try (Connection conn = ConexaoBD.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, consulta.getEspecialidade());
            ps.setString(2, consulta.getData());
            ps.setString(3, consulta.getHora());
            ps.setDouble(4, consulta.getValor());
            ps.execute();
        }
    }

    public Agendamento[] obterAgendamentos() throws Exception {
        String sql = "SELECT * FROM sistema_agendamento";
        try (Connection conn = ConexaoBD.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY); ResultSet rs = ps.executeQuery()) {
            int totalAgendamentos = rs.last() ? rs.getRow() : 0;
            Agendamento[] agendamento = new Agendamento[totalAgendamentos];
            rs.beforeFirst();
            int contador = 0;
            while (rs.next()) {
                int id = rs.getInt("idAgendamento");

                Timestamp timestampConsulta = rs.getTimestamp("dataHoraAgendamento");
                SimpleDateFormat dataFormato = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat horaFormato = new SimpleDateFormat("HH:mm");

                String dataAgendamento = dataFormato.format(timestampConsulta);
                String horaAgendamento = horaFormato.format(timestampConsulta);
                String especialidade = rs.getString("especialidadeAgendamento");
                Double valorConsulta = rs.getDouble("valorAgendamento");
                String cpfPaciente = rs.getString("fk_paciente");
                agendamento[contador++] = new Agendamento(id, valorConsulta, dataAgendamento, horaAgendamento, especialidade, cpfPaciente);
            }
            return agendamento;
        }
    }

    public int obterIdPacientePorCpf(String cpf) throws SQLException, Exception {
        String sql = "SELECT idPaciente FROM paciente WHERE cpfPaciente = ?";
        try (Connection conn = ConexaoBD.obterConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cpf);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("idPaciente");
                } else {
                    throw new SQLException("Paciente não encontrado com o CPF: " + cpf);
                }
            }
        }
    }
}
