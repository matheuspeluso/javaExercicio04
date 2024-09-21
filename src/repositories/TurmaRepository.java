package repositories;

import java.io.File;
import java.io.PrintWriter;

import entities.Aluno;
import entities.Turma;

public class TurmaRepository {
	public void exportarDados(Turma turma) {
		try {
//			
//			var xmlMapper = new XmlMapper();
//			xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_1_1, true);
//	        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
//			
//			xmlMapper.writeValue(new File(caminho + "\\turma_"+turma.getIdTurma()+".xml"), turma);
//			System.out.println("\nArquivos Gravados com sucesso!");
//			
			var printWriter = new PrintWriter("turma" + turma.getIdTurma() + ".xml");

			printWriter.write("<?xml version='1.0' encoding='UTF-8");
			printWriter.write("<Turma>");
				printWriter.write("<idTurma>" + turma.getIdTurma() + "</idTurma>");
				printWriter.write("<Nome>" + turma.getNome() + "</Nome>");
				printWriter.write("<DataInicio>" + turma.getDataInicio() + "</DataInicio>");
				
				printWriter.write("<Professor>");
					printWriter.write("<idProfessor>" + turma.getProfessor().getIdProfessor() + "</idProfessor>");
					printWriter.write("<Nome>" + turma.getProfessor().getNome() + "</Nome>");
					printWriter.write("<Telefone>" + turma.getProfessor().getTelefone() + "</Telefone>");
					printWriter.write("<Email>" + turma.getProfessor().getEmail() + "</Email>");
				printWriter.write("</Professor>");
				
				printWriter.write("<Curso>");
				printWriter.write("<idCurso>" + turma.getCurso().getIdCurso() + "</idCurso>");
				printWriter.write("<Titulo>" + turma.getCurso().getTitulo() + "</Titulo>");
				printWriter.write("<CargaHoraria>" + turma.getCurso().getCargaHoraria() + "</CargaHoraria>");
				printWriter.write("</Curso>");
				
			printWriter.write("</Turma>");
			
			printWriter.write("<Alunos>");
			for (Aluno aluno : turma.getAlunos()) {
			    printWriter.write("<Aluno>");
			    printWriter.write("<idAluno>" + aluno.getIdAluno() + "</idAluno>");
			    printWriter.write("<Nome>" + aluno.getNome() + "</Nome>");
			    printWriter.write("</Aluno>");
			}
			printWriter.write("</Alunos>");
			
			printWriter.close();
			System.out.println("\nARQUIVO XML GRAVADO COM SUCESSO!");
			
			
		}catch(Exception e) {
			System.out.println("\nFalha ao exportar Dados xml!\n"+e.getMessage());
		}
	}
	
	private void criarDiretorio(String caminho) {
		var file = new File(caminho);
		
		if(!file.exists()) {
			file.mkdir(); // se o caminho não existir vai criar a pasta!
			System.out.println("Diretorio criado com sucesso!");
		}
		else {
			System.out.println("Diretorio já existente!");
		}
	}
}
