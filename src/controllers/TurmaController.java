package controllers;

import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.UUID;

import javax.swing.JOptionPane;

import entities.Aluno;
import entities.Curso;
import entities.Professor;
import entities.Turma;
import repositories.TurmaRepository;

public class TurmaController {
	public void cadastrarTurma() {
		try {
			var turma = obterDadosTurma();
			turma.setProfessor(obterDadosProfessor());
			turma.setCurso(obterDadosCurso());
			
			var quantidade = JOptionPane.showInputDialog("Quantos alunos deseja cadastrar? ");
			var quantidadeDeAlunos = Integer.parseInt(quantidade);
			
			if (quantidadeDeAlunos > 0) {
				var lista =  new ArrayList<Aluno>();
				
				for(var i = 0; i < quantidadeDeAlunos; i++) {
					JOptionPane.showMessageDialog(null, "Prenchimento do "+ (i+1)+ "ºAluno: ");
					lista.add(obterDadosAluno());
				}
				turma.setAlunos(lista);
			}
			//TODO
			var turmaRepository = new TurmaRepository();
			turmaRepository.exportarDados(turma);
			
		}
		catch(Exception e) {
			System.out.println("\nFalha ao cadastrar Turma!");
			System.out.println(e.getMessage());
		}
	}

	private Turma obterDadosTurma() {
		
		var turma = new Turma();
		turma.setIdTurma(UUID.randomUUID());
		turma.setNome(JOptionPane.showInputDialog("Nome da turma: "));
		try {
			turma.setDataInicio(new SimpleDateFormat("dd/MM/yyyy").parse(JOptionPane.showInputDialog("Data de inicio:")));
		} catch (HeadlessException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return turma;
		
	}

	private Professor obterDadosProfessor() {
		var professor = new Professor();
		professor.setIdProfessor(UUID.randomUUID());
		professor.setNome(JOptionPane.showInputDialog("Nome professor: "));
		professor.setTelefone(JOptionPane.showInputDialog("Telefone do professor:"));
		professor.setEmail(JOptionPane.showInputDialog("Email do professor:"));
		
		return professor;
	}
	
	private Curso obterDadosCurso() {
		var curso = new Curso();
		curso.setIdCurso(UUID.randomUUID());
		curso.setTitulo(JOptionPane.showInputDialog("Titulo do curso: "));
		curso.setCargaHoraria(JOptionPane.showInputDialog("Carga Horario do curso: "));
		
		return curso;
	}
	
	private Aluno obterDadosAluno() {
		var aluno = new Aluno();
		aluno.setIdAluno(UUID.randomUUID());
		aluno.setNome(JOptionPane.showInputDialog("Nome do aluno: "));
		return aluno;
	}
}
