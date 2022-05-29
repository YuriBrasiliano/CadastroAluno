package br.edu.unicid.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.unicid.model.Leitor;
import br.edu.unicid.util.ConnectionFactory;

public class LeitorDAO {

	private Leitor leitor;
	private Connection conn; // conecta com o banco de dados
	private PreparedStatement ps; // permite executar querys
	private ResultSet rs; // tabela

	public LeitorDAO() throws Exception {
		try {
			conn = ConnectionFactory.getConnection();

		} catch (Exception erro) {
			throw new Exception("Erro " + erro.getMessage());
		}
	}

	public void salvar(Leitor leitor) throws Exception {
		try {
			String sql = "INSERT INTO Leitor(RGM, Nome, CPF, DataNasc, Email, Endereco, Municipio, UF, Celular, Curso, Campus, Periodo)" 
								  + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, leitor.getRGM());
			ps.setString(2, leitor.getNome());
			ps.setString(3, leitor.getCPF());
			ps.setString(4, leitor.getDataNasc());
			ps.setString(5, leitor.getEmail());
			ps.setString(6, leitor.getEndereco());
			ps.setString(7, leitor.getMunicipio());
			ps.setString(8, leitor.getUF());
			ps.setString(9, leitor.getCelular());
			ps.setString(10, leitor.getCurso());
			ps.setString(11, leitor.getCampus());
			ps.setString(12, leitor.getPeriodo());
			ps.executeUpdate();
		} catch (Exception erro) {
			throw new Exception("Erro " + erro.getMessage());
		}
	}

	public void alterar(Leitor leitor) throws Exception {
		try {
			String sql = "UPDATE Leitor SET Nome=?, CPF=?, DataNasc=?, Email=?, Endereco=?, Municipio=?, UF=?, Celular=?, Curso=?, Campus=?, Periodo=? " 
						+ "WHERE RGM=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, leitor.getNome());
			ps.setString(2, leitor.getCPF());
			ps.setString(3, leitor.getDataNasc());
			ps.setString(4, leitor.getEmail());
			ps.setString(5, leitor.getEndereco());
			ps.setString(6, leitor.getMunicipio());
			ps.setString(7, leitor.getUF());
			ps.setString(8, leitor.getCelular());
			ps.setString(9, leitor.getCurso());
			ps.setString(10, leitor.getCampus());
			ps.setString(11, leitor.getPeriodo());
			ps.setInt(12, leitor.getRGM());
			ps.executeUpdate();
		} catch (Exception erro) {
			throw new Exception("Erro " + erro.getMessage());
		}
	}

	public void excluir(int RGM) throws Exception {
		try {
			String sql = "DELETE FROM Leitor " + "WHERE RGM=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, RGM);
			ps.executeUpdate();
		} catch (Exception erro) {
			throw new Exception("Erro " + erro.getMessage());
		}

	}

	
	public Leitor consultar(int RGM) throws Exception {

		try {

			leitor = new Leitor();

			String sql = "SELECT * FROM Leitor WHERE RGM=?";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, RGM);
			rs = ps.executeQuery();

			while (rs.next()) {
				leitor = new Leitor();
				leitor.setRGM(rs.getInt(1));
				leitor.setNome(rs.getString(2));
				leitor.setCPF(rs.getString(3));
				leitor.setDataNasc(rs.getString(4));
				leitor.setEmail(rs.getString(5));
				leitor.setEndereco(rs.getString(6));
				leitor.setMunicipio(rs.getString(7));
				leitor.setUF(rs.getString(8));
				leitor.setCelular(rs.getString(9));
				leitor.setCurso(rs.getString(10));
				leitor.setCampus(rs.getString(11));
				leitor.setPeriodo(rs.getString(12));

			}

			return leitor;

		} catch (Exception e) {
			throw new Exception("Erro: " + e.getMessage());
		}

	}
	public void salvarnotasefaltas(Leitor leitor) throws Exception {
		try {
			String sql = "INSERT INTO notasfaltas(RGM, Disciplina, Semestre, Nota, Faltas)" 
								  + "values (?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, leitor.getRGM());
			ps.setString(2, leitor.getDisciplina());
			ps.setString(3, leitor.getSemestre());
			ps.setFloat(4, leitor.getNota());
			ps.setInt(5, leitor.getFaltas());
			
			ps.executeUpdate();
		} catch (Exception erro) {
			throw new Exception("Erro " + erro.getMessage());
		}
	}

	public void alterarnotasefaltas(Leitor leitor) throws Exception {
		try {
			String sql = "UPDATE notasfaltas SET Nota = ?, Faltas = ? " 
						+ "WHERE RGM = ? AND DISCIPLINA = ? AND SEMESTRE = ? ";
			ps = conn.prepareStatement(sql);
			ps.setFloat(1, leitor.getNota());
			ps.setInt(2, leitor.getFaltas());
			ps.setInt(3, leitor.getRGM());
			ps.setString(5, leitor.getSemestre());
			ps.setString(4, leitor.getDisciplina());
			ps.executeUpdate();
		} catch (Exception erro) {
			throw new Exception("Erro " + erro.getMessage());
		}
	}

	public void excluirnotasefaltas(int RGM) throws Exception {
		try {
			String sql = "DELETE FROM notasfaltas " + "WHERE RGM=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, RGM);
			ps.executeUpdate();
		} catch (Exception erro) {
			throw new Exception("Erro " + erro.getMessage());
		}

	}
	public Leitor consultarnotasefaltas(int RGMNotaseFaltas) throws Exception {

		try {

			leitor = new Leitor();

			String sql = "SELECT * FROM Leitor WHERE RGM=?";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, RGMNotaseFaltas);
			rs = ps.executeQuery();

			while (rs.next()) {
				leitor = new Leitor();
				leitor.setRGM(rs.getInt(1));
				leitor.setNome(rs.getString(2));				
				leitor.setCurso(rs.getString(10));

			}

			return leitor;

		} catch (Exception e) {
			throw new Exception("Erro: " + e.getMessage());
		}

	}
	public Leitor consultarboletim(int RGMBoletim, String DisciplinaBoletim, String SemestreBoletim) throws Exception {

		try {

			leitor = new Leitor();

			String sql = "SELECT no.Nota, no.Faltas, le.Nome, le.Curso FROM notasfaltas no JOIN leitor le ON le.RGM = no.RGM"
					+ " WHERE no.RGM=? AND no.DISCIPLINA = ? AND no.SEMESTRE = ? ";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, RGMBoletim);
			ps.setString(2, DisciplinaBoletim);
			ps.setString(3, SemestreBoletim);
			
			rs = ps.executeQuery();

			while (rs.next()) {
				leitor = new Leitor();
				leitor.setNota(rs.getFloat(1));
				leitor.setFaltas(rs.getInt(2));
				leitor.setNome(rs.getString(3));
				leitor.setCurso(rs.getString(4));
				leitor.setRGM(rs.getInt(1));
				leitor.setDisciplina(rs.getString(2));
				leitor.setSemestre(rs.getString(3));				
			}

			return leitor;

		} catch (Exception e) {
			throw new Exception("Erro: " + e.getMessage());
		}

	}

	}

