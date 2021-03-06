package fourzeta.controllers.desktop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;

import fourzeta.desktop_views.GerenciarTorneio;
import fourzeta.desktop_views.GradeJogos;
import fourzeta.desktop_views.SelecionarTorneio;
import fourzeta.models.Usuario;
import fourzeta.models.Torneio;

public class GradeJogosController implements ActionListener {

	private JFrame tela;
	private Torneio torneio;
	private GradeJogos grade;
	private Usuario usuario;

	public GradeJogosController(Usuario usuario, Torneio torneio, JFrame tela) throws ParseException {
		this.tela = tela;
		this.torneio = torneio;
		this.usuario = usuario;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton source = (JButton) arg0.getSource();		
		if(source.getName().equals("btnGradeDeJogos")) {
			actionAbreGrade();
		}
		else {
			actionVoltar();
		}
	}
	
	private void actionAbreGrade() {
		try {
			this.grade = new GradeJogos(usuario, torneio);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.tela.setVisible(false);
		this.grade.setVisible(true);
	}
	
	private void actionVoltar() {
		GerenciarTorneio gt = null;
		try {
			gt = new GerenciarTorneio(usuario, torneio);
		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}
		tela.setVisible(false);
		gt.setVisible(true);
	}

}
