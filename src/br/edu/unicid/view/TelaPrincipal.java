package br.edu.unicid.view;

import java.awt.EventQueue;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.sql.Date;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import br.edu.unicid.dao.LeitorDAO;
import br.edu.unicid.model.Leitor;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnAluno;
	private JMenu mnNotasFaltas;
	private JMenu mnAjuda;
	private JMenuItem AluAlterar;
	private JMenuItem AluSair;
	private JMenuItem AluSalvar;
	private JSeparator separator;
	private JMenuItem AluConsultar;
	private JMenuItem AluExcluir;
	private JMenuItem NFSalvar;
	private JMenuItem NFAlterar;
	private JMenuItem NFConsultar;
	private JMenuItem NFExcluir;
	private JMenuItem AjudaSobre;
	private JLayeredPane lPaneDadosPessoais;
	private JTabbedPane tabbedPane;
	private JLayeredPane lPaneCurso;
	private JLayeredPane lPaneNotasFaltas;
	private JLayeredPane lPaneBoletim;
	private JLabel lblRgm;
	private JTextField txtRGM_DP;
	private JLabel lblDataDeNascimento;
	private JTextField txtDataNasc_DP;
	private JLabel lblNome;
	private JTextField txtNome_DP;
	private JLabel lblCpf;
	private JTextField txtCPF_DP;
	private JLabel lblEmail;
	private JTextField txtEmail_DP;
	private JLabel lblEndereo;
	private JTextField txtEnd_DP;
	private JLabel lblMunicpio;
	private JTextField txtMunicipio_DP;
	private JLabel lblUf;
	private JComboBox cmbUF;
	private JLabel lblCelular;
	private JTextField txtCelular_DP;
	private JLabel lblCurso;
	private JComboBox cmbCurso_Curso;
	private JLabel lblCampus;
	private JComboBox cmbCampus_Curso;
	private JComboBox cmbDisc_Boletim;
	private JLabel lblPerodo;
	private JRadioButton rdbMat_Curso;
	private JRadioButton rdbVesp_Curso;
	private JRadioButton rdbNot_Curso;
	private JLabel label;
	private JTextField txtRGM_NF;
	private JLabel lblDisciplina;
	private JComboBox cmbDis_NF;
	private final ButtonGroup grpPeriodo = new ButtonGroup();
	private JLabel lblSemestre;
	private JComboBox cmbSem_NF;
	private JLabel lblNota;
	private JComboBox cmbNota_NF;
	private JLabel lblFaltas;
	private JComboBox cmbFaltas_NF;
	private JLabel label_2;
	private JLabel lblNome_1;
	private JTextField txtNome_Boletim;
	private JLabel lblCurso_1;
	private JTextField txtCurso_Boletim;
	private JLabel lblDisciplina_1;	
	private JLabel lblNota_1;
	private JTextField txtNota_Boletim;
	private JLabel lblFaltas_1;
	private JTextField txtFaltas_Boletim;
	private JTextField txtNome_NF;
	private JTextField txtCurso_NF;
	private Leitor leitor;
	private LeitorDAO dao;
	private JTextField txtRGM_Boletim;
	private JComboBox cmbSem_Boletim;
	



	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 532, 21);
		contentPane.add(menuBar);

		mnAluno = new JMenu("Aluno");
		menuBar.add(mnAluno);

		AluSalvar = new JMenuItem("Salvar");
		AluSalvar.addActionListener(new ActionListener() {
			private Leitor leitor;

			public void actionPerformed(ActionEvent e) {

				try {
					leitor = new Leitor();
					leitor.setRGM(Integer.parseInt(txtRGM_DP.getText()));
					leitor.setNome(txtNome_DP.getText());
					leitor.setCPF(txtCPF_DP.getText());
					leitor.setDataNasc(txtDataNasc_DP.getText());
					leitor.setEmail(txtEmail_DP.getText());
					leitor.setEndereco(txtEnd_DP.getText());
					leitor.setMunicipio(txtMunicipio_DP.getText());
					leitor.setUF((String) cmbUF.getSelectedItem());
					leitor.setCelular(txtCelular_DP.getText());
					leitor.setCurso((String) cmbCurso_Curso.getSelectedItem());
					leitor.setCampus((String) cmbCampus_Curso.getSelectedItem());
					if (rdbMat_Curso.isSelected()) {
						leitor.setPeriodo("Matutino");
					} else if (rdbVesp_Curso.isSelected()) {
						leitor.setPeriodo("Vespertino");
					} else if (rdbNot_Curso.isSelected()) {
						leitor.setPeriodo("Noturno");
					}
					
					dao = new LeitorDAO();
					dao.salvar(leitor);
					JOptionPane.showMessageDialog(null, "Cadastro salvado com sucesso!");	


				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, "Houve um erro, por favor verifique se todos os campos foram preenchidos!");	


				}
			}
		});
		AluSalvar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnAluno.add(AluSalvar);

		AluAlterar = new JMenuItem("Alterar");
		AluAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					leitor = new Leitor();
					leitor.setNome(txtNome_DP.getText());
					leitor.setCPF(txtCPF_DP.getText());
					leitor.setDataNasc(txtDataNasc_DP.getText());
					leitor.setEmail(txtEmail_DP.getText());
					leitor.setEndereco(txtEnd_DP.getText());
					leitor.setMunicipio(txtMunicipio_DP.getText());
					leitor.setUF((String) cmbUF.getSelectedItem());
					leitor.setCelular(txtCelular_DP.getText());
					leitor.setCurso((String) cmbCurso_Curso.getSelectedItem());
					leitor.setCampus((String) cmbCampus_Curso.getSelectedItem());
					if (rdbMat_Curso.isSelected()) {
						leitor.setPeriodo("Matutino");
					} else if (rdbVesp_Curso.isSelected()) {
						leitor.setPeriodo("Vespertino");
					} else if (rdbNot_Curso.isSelected()) {
						leitor.setPeriodo("Noturno");
					}
					leitor.setRGM(Integer.parseInt(txtRGM_DP.getText()));
					
					dao = new LeitorDAO();
					dao.alterar(leitor);
					JOptionPane.showMessageDialog(null, "Informações alteradas com sucesso!");
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, "Houve um erro, por favor verifique as informações e tente novamente!");	

				}

			}
		});
		mnAluno.add(AluAlterar);

		AluConsultar = new JMenuItem("Consultar");
		AluConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					int RGM = (Integer.parseInt(txtRGM_DP.getText()));
					dao = new LeitorDAO();
					leitor = dao.consultar(RGM);					
					txtNome_DP.setText(leitor.getNome());
					cmbCampus_Curso.setSelectedItem(leitor.getCampus());
					txtCelular_DP.setText(leitor.getCelular());
					txtCPF_DP.setText(leitor.getCPF());
					cmbCurso_Curso.setSelectedItem(leitor.getCurso());
					txtDataNasc_DP.setText(leitor.getDataNasc());
					txtEmail_DP.setText(leitor.getEmail());
					txtEnd_DP.setText(leitor.getEndereco());
					txtMunicipio_DP.setText(leitor.getMunicipio());					
					cmbUF.setSelectedItem(leitor.getUF());
					txtNome_NF.setText(leitor.getNome());
					txtCurso_NF.setText(leitor.getCurso());
					String periodo = String.valueOf(leitor.getPeriodo());
					if ( periodo.startsWith("M") ) {
						rdbMat_Curso.setSelected(true);
					}
					else if(periodo.startsWith("V") )  {
						rdbVesp_Curso.setSelected(true);
						
					}else if(periodo.startsWith("N") ) {
						rdbNot_Curso.setSelected(true);
						
					}
					JOptionPane.showMessageDialog(null, "Consulta realizada com sucesso!");
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, "Por favor verifique o RGM e tente novamente");			}

			}
		});
		mnAluno.add(AluConsultar);

		AluExcluir = new JMenuItem("Excluir");
		AluExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					int RGM = (Integer.parseInt(txtRGM_DP.getText()));
					dao = new LeitorDAO();
					dao.excluir(RGM);
					JOptionPane.showMessageDialog(null, "Cadastro excluido com sucesso!");
				} catch (Exception erro) {

				}

			}
		});
		mnAluno.add(AluExcluir);

		separator = new JSeparator();
		mnAluno.add(separator);

		AluSair = new JMenuItem("Sair");
		AluSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame jFrame = new JFrame();
		        int result = JOptionPane.showConfirmDialog(jFrame, "Deseja realmente sair?");

		        if (result == 0)
		        	System.exit(0);
		        	           
		}
	});
				
		AluSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.SHIFT_MASK));
		mnAluno.add(AluSair);

		mnNotasFaltas = new JMenu("Notas e Faltas");
		menuBar.add(mnNotasFaltas);

		NFSalvar = new JMenuItem("Salvar");
		mnNotasFaltas.add(NFSalvar);
		NFSalvar.addActionListener(new ActionListener() {
			private Leitor leitor;

			public void actionPerformed(ActionEvent e) {

				try {
					leitor = new Leitor();
					leitor.setRGM(Integer.parseInt(txtRGM_NF.getText()));
					leitor.setDisciplina((String)cmbDis_NF.getSelectedItem());
					leitor.setSemestre((String)cmbSem_NF.getSelectedItem());
					String notas = ((String) cmbNota_NF.getSelectedItem());
					float notasFloat= Float.parseFloat(notas);
					leitor.setNota(notasFloat);
					String faltas = ((String) cmbFaltas_NF.getSelectedItem());
					leitor.setFaltas(Integer.parseInt(faltas));
					dao = new LeitorDAO();
					dao.salvarnotasefaltas(leitor);
					JOptionPane.showMessageDialog(null, "Notas e Faltas salvadas com sucesso!");

				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, "Houve um erro, por favor verifique se todos os campos foram preenchidos!");	


				}
			}
		});

		NFAlterar = new JMenuItem("Alterar");
		
		NFAlterar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		NFAlterar.addActionListener(new ActionListener() {
			private Leitor leitor;

			public void actionPerformed(ActionEvent e) {

				try {
					leitor = new Leitor();
					String notas = ((String) cmbNota_NF.getSelectedItem());
					float notasFloat= Float.parseFloat(notas);
					leitor.setNota(notasFloat);
					String faltas = ((String) cmbFaltas_NF.getSelectedItem());
					leitor.setFaltas(Integer.parseInt(faltas));
					leitor.setRGM(Integer.parseInt(txtRGM_NF.getText()));
					leitor.setSemestre((String)cmbSem_NF.getSelectedItem());
					leitor.setDisciplina((String)cmbDis_NF.getSelectedItem());				
					dao = new LeitorDAO();
					dao.alterarnotasefaltas(leitor);
					JOptionPane.showMessageDialog(null, "Alterações salvadas com sucesso!");
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, "Houve um erro, por favor verifique se todos os campos foram preenchidos!");	


				}
			}
		});
		
		mnNotasFaltas.add(NFAlterar);

		NFConsultar = new JMenuItem("Consultar");
		NFConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					int RGMNotaseFaltas = (Integer.parseInt(txtRGM_NF.getText()));
					dao = new LeitorDAO();
					leitor = dao.consultarnotasefaltas(RGMNotaseFaltas);
					txtNome_NF.setText(leitor.getNome());
					txtCurso_NF.setText(leitor.getCurso());
					JOptionPane.showMessageDialog(null, "Consulta realizada com sucesso!");
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, "Por favor verifique o RGM e tente novamente");			}

			}
		});
		mnNotasFaltas.add(NFConsultar);

		NFExcluir = new JMenuItem("Excluir");
		NFExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					int RGM = (Integer.parseInt(txtRGM_NF.getText()));
					dao = new LeitorDAO();
					dao.excluirnotasefaltas(RGM);
					JOptionPane.showMessageDialog(null, "Cadastro excluido com sucesso!");
				} catch (Exception erro) {

				}

			}
		});
		mnNotasFaltas.add(NFExcluir);

		mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);

		AjudaSobre = new JMenuItem("Sobre");
		mnAjuda.add(AjudaSobre);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(30, 55, 472, 273);
		contentPane.add(tabbedPane);

		lPaneDadosPessoais = new JLayeredPane();
		tabbedPane.addTab("Dados Pessoais", null, lPaneDadosPessoais, null);

		lblRgm = new JLabel("RGM");
		lblRgm.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblRgm.setBounds(10, 21, 46, 14);
		lPaneDadosPessoais.add(lblRgm);

		txtRGM_DP = new JTextField();
		txtRGM_DP.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtRGM_DP.setBounds(50, 19, 104, 20);
		lPaneDadosPessoais.add(txtRGM_DP);
		txtRGM_DP.setColumns(10);

		lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblDataDeNascimento.setBounds(10, 62, 117, 14);
		lPaneDadosPessoais.add(lblDataDeNascimento);

		txtDataNasc_DP = new JTextField();
		txtDataNasc_DP.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtDataNasc_DP.setColumns(10);
		txtDataNasc_DP.setBounds(134, 60, 96, 20);
		lPaneDadosPessoais.add(txtDataNasc_DP);

		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNome.setBounds(189, 21, 46, 14);
		lPaneDadosPessoais.add(lblNome);

		txtNome_DP = new JTextField();
		txtNome_DP.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtNome_DP.setColumns(10);
		txtNome_DP.setBounds(232, 19, 225, 20);
		lPaneDadosPessoais.add(txtNome_DP);

		lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblCpf.setBounds(270, 62, 26, 14);
		lPaneDadosPessoais.add(lblCpf);

		txtCPF_DP = new JTextField();
		txtCPF_DP.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtCPF_DP.setColumns(10);
		txtCPF_DP.setBounds(306, 59, 151, 20);
		lPaneDadosPessoais.add(txtCPF_DP);

		lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblEmail.setBounds(10, 108, 46, 14);
		lPaneDadosPessoais.add(lblEmail);

		txtEmail_DP = new JTextField();
		txtEmail_DP.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtEmail_DP.setColumns(10);
		txtEmail_DP.setBounds(83, 106, 374, 20);
		lPaneDadosPessoais.add(txtEmail_DP);

		lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblEndereo.setBounds(10, 150, 57, 14);
		lPaneDadosPessoais.add(lblEndereo);

		txtEnd_DP = new JTextField();
		txtEnd_DP.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtEnd_DP.setColumns(10);
		txtEnd_DP.setBounds(83, 148, 374, 20);
		lPaneDadosPessoais.add(txtEnd_DP);

		lblMunicpio = new JLabel("Munic\u00EDpio");
		lblMunicpio.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblMunicpio.setBounds(10, 201, 57, 14);
		lPaneDadosPessoais.add(lblMunicpio);

		txtMunicipio_DP = new JTextField();
		txtMunicipio_DP.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtMunicipio_DP.setColumns(10);
		txtMunicipio_DP.setBounds(74, 199, 104, 20);
		lPaneDadosPessoais.add(txtMunicipio_DP);

		lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblUf.setBounds(191, 201, 26, 14);
		lPaneDadosPessoais.add(lblUf);

		cmbUF = new JComboBox();
		cmbUF.setModel(new DefaultComboBoxModel(
				new String[] { "", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
						"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cmbUF.setBounds(218, 199, 51, 20);
		lPaneDadosPessoais.add(cmbUF);

		lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblCelular.setBounds(289, 201, 40, 14);
		lPaneDadosPessoais.add(lblCelular);

		txtCelular_DP = new JTextField();
		txtCelular_DP.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtCelular_DP.setColumns(10);
		txtCelular_DP.setBounds(342, 199, 115, 20);
		lPaneDadosPessoais.add(txtCelular_DP);

		lPaneCurso = new JLayeredPane();
		tabbedPane.addTab("Curso", null, lPaneCurso, null);

		lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblCurso.setBounds(10, 21, 46, 14);
		lPaneCurso.add(lblCurso);

		cmbCurso_Curso = new JComboBox();
		cmbCurso_Curso.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		cmbCurso_Curso.setModel(
				new DefaultComboBoxModel(new String[] { "Selecione", "Analise e Desenvolvimento de Sistemas" }));
		cmbCurso_Curso.setBounds(75, 19, 382, 20);
		lPaneCurso.add(cmbCurso_Curso);

		lblCampus = new JLabel("Campus");
		lblCampus.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblCampus.setBounds(10, 59, 46, 14);
		lPaneCurso.add(lblCampus);

		cmbCampus_Curso = new JComboBox();
		cmbCampus_Curso.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "TATUAPE", "PINHEIROS"}));
		cmbCampus_Curso.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		cmbCampus_Curso.setBounds(75, 57, 382, 20);
		lPaneCurso.add(cmbCampus_Curso);

		lblPerodo = new JLabel("Per\u00EDodo");
		lblPerodo.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblPerodo.setBounds(10, 110, 46, 14);
		lPaneCurso.add(lblPerodo);

		rdbMat_Curso = new JRadioButton("Matutino");
		grpPeriodo.add(rdbMat_Curso);
		rdbMat_Curso.setBounds(75, 110, 87, 23);
		lPaneCurso.add(rdbMat_Curso);

		rdbVesp_Curso = new JRadioButton("Vespertino");
		grpPeriodo.add(rdbVesp_Curso);
		rdbVesp_Curso.setBounds(213, 110, 87, 23);
		lPaneCurso.add(rdbVesp_Curso);

		rdbNot_Curso = new JRadioButton("Noturno");
		grpPeriodo.add(rdbNot_Curso);
		rdbNot_Curso.setBounds(351, 110, 87, 23);
		lPaneCurso.add(rdbNot_Curso);

		lPaneNotasFaltas = new JLayeredPane();
		tabbedPane.addTab("Notas e Faltas", null, lPaneNotasFaltas, null);

		label = new JLabel("RGM");
		label.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label.setBounds(10, 21, 46, 14);
		lPaneNotasFaltas.add(label);

		txtRGM_NF = new JTextField();
		txtRGM_NF.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtRGM_NF.setBounds(50, 19, 117, 20);
		lPaneNotasFaltas.add(txtRGM_NF);
		txtRGM_NF.setColumns(10);

		lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblDisciplina.setBounds(10, 100, 60, 14);
		lPaneNotasFaltas.add(lblDisciplina);

		cmbDis_NF = new JComboBox();
		cmbDis_NF.setModel(new DefaultComboBoxModel(
				new String[] { "", "Banco de Dados", "Engenharia de Software", "Fundamenstro de Estrutura de Dados",
						"Programa Orientada a Objetos", "T\u00E9cnica de Programa\u00E7\u00E3o" }));
		cmbDis_NF.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		cmbDis_NF.setBounds(80, 98, 377, 20);
		lPaneNotasFaltas.add(cmbDis_NF);

		lblSemestre = new JLabel("Semestre");
		lblSemestre.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblSemestre.setBounds(10, 150, 60, 14);
		lPaneNotasFaltas.add(lblSemestre);

		cmbSem_NF = new JComboBox();
		cmbSem_NF.setModel(
				new DefaultComboBoxModel(new String[] { "", "2020-1", "2020-2", "2021-1", "2021-2", "2022-1" }));
		cmbSem_NF.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		cmbSem_NF.setBounds(80, 148, 87, 20);
		lPaneNotasFaltas.add(cmbSem_NF);

		lblNota = new JLabel("Nota");
		lblNota.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNota.setBounds(191, 150, 27, 14);
		lPaneNotasFaltas.add(lblNota);

		cmbNota_NF = new JComboBox();
		cmbNota_NF.setModel(new DefaultComboBoxModel(new String[] { "", "0.5", "1", "1.5", "2", "2.5", "3", "3.5", "4",
				"4.5", "5", "5.5", "6", "6.5", "7", "7.5", "8", "8.5", "9", "9.5", "10" }));
		cmbNota_NF.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		cmbNota_NF.setBounds(228, 148, 79, 20);
		lPaneNotasFaltas.add(cmbNota_NF);

		lblFaltas = new JLabel("Faltas");
		lblFaltas.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblFaltas.setBounds(337, 150, 31, 14);
		lPaneNotasFaltas.add(lblFaltas);

		cmbFaltas_NF = new JComboBox();
		cmbFaltas_NF.setModel(
				new DefaultComboBoxModel(new String[] { "", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		cmbFaltas_NF.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		cmbFaltas_NF.setBounds(378, 148, 79, 20);
		lPaneNotasFaltas.add(cmbFaltas_NF);

		txtNome_NF = new JTextField();
		txtNome_NF.setText("Nome");
		txtNome_NF.setEditable(false);
		txtNome_NF.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtNome_NF.setColumns(10);
		txtNome_NF.setBounds(190, 19, 267, 20);
		lPaneNotasFaltas.add(txtNome_NF);

		txtCurso_NF = new JTextField();
		txtCurso_NF.setText("Curso");
		txtCurso_NF.setEditable(false);
		txtCurso_NF.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtCurso_NF.setColumns(10);
		txtCurso_NF.setBounds(10, 56, 447, 20);
		lPaneNotasFaltas.add(txtCurso_NF);

		lPaneBoletim = new JLayeredPane();
		tabbedPane.addTab("Boletim", null, lPaneBoletim, null);

		label_2 = new JLabel("RGM");
		label_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		label_2.setBounds(10, 13, 46, 14);
		lPaneBoletim.add(label_2);

		lblNome_1 = new JLabel("Nome");
		lblNome_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNome_1.setBounds(165, 13, 46, 14);
		lPaneBoletim.add(lblNome_1);

		txtNome_Boletim = new JTextField();
		txtNome_Boletim.setEditable(false);
		txtNome_Boletim.setColumns(10);
		txtNome_Boletim.setBounds(202, 11, 251, 20);
		lPaneBoletim.add(txtNome_Boletim);

		lblCurso_1 = new JLabel("Curso");
		lblCurso_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblCurso_1.setBounds(10, 55, 46, 14);
		lPaneBoletim.add(lblCurso_1);

		txtCurso_Boletim = new JTextField();
		txtCurso_Boletim.setEditable(false);
		txtCurso_Boletim.setColumns(10);
		txtCurso_Boletim.setBounds(66, 53, 387, 20);
		lPaneBoletim.add(txtCurso_Boletim);

		lblDisciplina_1 = new JLabel("Disciplina");
		lblDisciplina_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblDisciplina_1.setBounds(10, 97, 57, 14);
		lPaneBoletim.add(lblDisciplina_1);

		cmbDisc_Boletim = new JComboBox();
		cmbDisc_Boletim.setModel(new DefaultComboBoxModel(
				new String[] { "", "Banco de Dados", "Engenharia de Software", "Fundamenstro de Estrutura de Dados",
						"Programa Orientada a Objetos", "T\u00E9cnica de Programa\u00E7\u00E3o" }));
		cmbDisc_Boletim.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		cmbDisc_Boletim.setBounds(66, 94, 387, 20);
		lPaneBoletim.add(cmbDisc_Boletim);
		
		

		lblNota_1 = new JLabel("Nota");
		lblNota_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNota_1.setBounds(77, 161, 46, 14);
		lPaneBoletim.add(lblNota_1);

		txtNota_Boletim = new JTextField();
		txtNota_Boletim.setEditable(false);
		txtNota_Boletim.setColumns(10);
		txtNota_Boletim.setBounds(116, 159, 73, 20);
		lPaneBoletim.add(txtNota_Boletim);

		lblFaltas_1 = new JLabel("Faltas");
		lblFaltas_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblFaltas_1.setBounds(235, 161, 46, 14);
		lPaneBoletim.add(lblFaltas_1);

		txtFaltas_Boletim = new JTextField();
		txtFaltas_Boletim.setEditable(false);
		txtFaltas_Boletim.setColumns(10);
		txtFaltas_Boletim.setBounds(291, 159, 73, 20);
		lPaneBoletim.add(txtFaltas_Boletim);
		
		txtRGM_Boletim = new JTextField();
		txtRGM_Boletim.setBounds(52, 11, 103, 20);
		lPaneBoletim.add(txtRGM_Boletim);
		txtRGM_Boletim.setColumns(10);
		
		JLabel lblSemestre_Boletim = new JLabel("Semestre");
		lblSemestre_Boletim.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblSemestre_Boletim.setBounds(127, 125, 62, 20);
		lPaneBoletim.add(lblSemestre_Boletim);
		
		cmbSem_Boletim = new JComboBox();
		cmbSem_Boletim.setModel(new DefaultComboBoxModel(new String[] {"", "2020-1", "2020-2", "2021-1", "2021-2", "2022-1"}));
		cmbSem_Boletim.setBounds(202, 125, 82, 22);
		lPaneBoletim.add(cmbSem_Boletim);
		
		JButton btnConsultaBoletim = new JButton("Consultar");
		btnConsultaBoletim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					int RGMBoletim = (Integer.parseInt(txtRGM_Boletim.getText()));
					String DisciplinaBoletim = ((String) cmbDisc_Boletim.getSelectedItem());;
					String SemestreBoletim = ((String) cmbSem_Boletim.getSelectedItem());;
					dao = new LeitorDAO();
					leitor = dao.consultarboletim(RGMBoletim, DisciplinaBoletim, SemestreBoletim);
					txtNota_Boletim.setText(String.valueOf(leitor.getNota()));
					txtFaltas_Boletim.setText(String.valueOf(leitor.getFaltas()));
					txtNome_Boletim.setText(leitor.getNome());
					txtCurso_Boletim.setText(leitor.getCurso());
					JOptionPane.showMessageDialog(null, "Consulta realizada com sucesso!");
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, "Por favor verifique as informações e tente novamente!" + erro);			}

			
				
			}
		});
		btnConsultaBoletim.setBackground(UIManager.getColor("Button.darkShadow"));
		btnConsultaBoletim.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnConsultaBoletim.setBounds(178, 203, 103, 31);
		lPaneBoletim.add(btnConsultaBoletim);

	}
}
