package br.edu.unicid.model;


import java.util.Date;

public class Leitor {

	private int RGM;
	private String Nome;
	private String CPF;
	private String DataNasc;
	private String Email;
	private String Endereco;
	private String Municipio;
	private String UF;
	private String Celular;
	private String Curso;
	private String Campus;
	private String Periodo;
	private String Disciplina;
	private String Semestre;
	private float Nota;
	private int Faltas;



	public Leitor() {
	}

	public Leitor(int RGM, 
				  String Nome, 
				  String CPF,
				  String DataNasc,
				  String Email,
				  String Endereco,
				  String Municipio,
				  String UF,
				  String Celular,
				  String Curso,
				  String Campus,
				  String Periodo,
				  String Disciplina,
				  String Semestre,
				  float Nota,
				  int Faltas) {
		super();
		this.RGM = RGM;
		this.Nome = Nome;
		this.CPF = CPF;
		this.DataNasc = DataNasc;
		this.Email = Email;
		this.Endereco = Endereco;
		this.Municipio = Municipio;
		this.UF = UF;
		this.Celular = Celular;
		this.Curso = Curso;
		this.Campus = Campus;
		this.Periodo = Periodo;
		this.Disciplina = Disciplina;
		this.Semestre = Semestre;
		this.Nota = Nota;
		this.Faltas = Faltas;
	}

	public int getRGM() {
		return RGM;
	}

	public void setRGM(int RGM) {
		this.RGM = RGM;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String Nome) {
		this.Nome = Nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}
	public String getDataNasc() {
		return DataNasc;
	}

	public void setDataNasc(String dataNasc) {
		DataNasc = dataNasc;
	}
	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String Endereco) {
		this.Endereco = Endereco;
	}

	public String getMunicipio() {
		return Municipio;
	}

	public void setMunicipio(String Municipio) {
		this.Municipio = Municipio;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String UF) {
		this.UF = UF;
	}

	public String getCelular() {
		return Celular;
	}

	public void setCelular(String Celular) {
		this.Celular = Celular;
	}

	public String getCurso() {
		return Curso;
	}

	public void setCurso(String Curso) {
		this.Curso = Curso;
	}

	public String getCampus() {
		return Campus;
	}

	public void setCampus(String Campus) {
		this.Campus = Campus;
	}

	public String getPeriodo() {
		return Periodo;
	}

	public void setPeriodo(String Periodo) {
		this.Periodo = Periodo;
	}

	public String getDisciplina() {
		return Disciplina;
	}

	public void setDisciplina(String Disciplina) {
		this.Disciplina = Disciplina;
	}

	public String getSemestre() {
		return Semestre;
	}

	public void setSemestre(String Semestre) {
		this.Semestre = Semestre;
	}

	public float getNota() {
		return Nota;
	}

	public void setNota(float Nota) {
		this.Nota = Nota;
	}

	public int getFaltas() {
		return Faltas;
	}

	public void setFaltas(int Faltas) {
		this.Faltas = Faltas;
	}

}
