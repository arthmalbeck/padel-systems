package fourzeta.controllers.desktop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fourzeta.desktop_views.GradeJogos;
import fourzeta.models.Jogo;
import fourzeta.models.Quadra;
import fourzeta.models.Torneio;
import fourzeta.models.Usuario;
import fourzeta.resources.JogoResource;
import fourzeta.table.GradeJogosTableModel;

public class PesquisarJogosController implements ActionListener {

	private GradeJogos tela;
	private Torneio torneio;
	private Usuario usuario;
	private JogoResource jr;
	private List<Quadra> quadras;

	public PesquisarJogosController(Usuario usuario, Torneio torneio, GradeJogos tela) {
		this.tela = tela;
		this.usuario = usuario;
		this.torneio = torneio;

	}
	
//	public void definirQuadraJogo(List<Jogo> jogos, List<Jogo> slc, int i) {
//		for (Jogo j : jogos) {
//			if (j.getQuadra().getNumero() == i) {
//				slc.add(j);
//			}
//	}
//	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		jr = new JogoResource();
		List<Jogo> jogos = jr.listaJogos();
//		configurarQuadras(jogos);
		List<Jogo> selecionados = new ArrayList<Jogo>();
		for (Jogo jogo : jogos) {
			if(jogo.getChave().getTorneio().getId() == torneio.getId()) {
				selecionados.add(jogo);
			}
		}
//		
//		switch(this.tela.getComboQuadra().getSelectedItem().toString()) {
//			case "LARANJA": definirQuadraJogo(jogos,selecionados,1);
//				break;
//			case "AZUL": definirQuadraJogo(jogos,selecionados,2);
//				break;
//			case "VERDE": definirQuadraJogo(jogos,selecionados,3);
//			default: this.tela.notifySelecioneQuadra();
//		}
//
//		if (this.tela.getComboQuadra().getSelectedItem().toString().equalsIgnoreCase("LARANJA")) {
//			for (Jogo j : jogos) {
//				if (j.getQuadra().getNumero() == 1) {
//					selecionados.add(j);
//				}
//			}
//		} else if (this.tela.getComboQuadra().getSelectedItem().toString().equalsIgnoreCase("AZUL")) {
//			for (Jogo j : jogos) {
//				if (j.getQuadra().getNumero() == 2) {
//					selecionados.add(j);
//				}
//			}
//		} else if (this.tela.getComboQuadra().getSelectedItem().toString().equalsIgnoreCase("VERDE")) {
//			for (Jogo j : jogos) {
//				if (j.getQuadra().getNumero() == 3) {
//					selecionados.add(j);
//				}
//			}
//		} else {
//			this.tela.notifySelecioneQuadra();
//		}
		GradeJogosTableModel model = (GradeJogosTableModel) tela.getJogosTable().getModel();
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}
		this.tela.readTable(selecionados);
	}

//	public void configurarQuadras(List<Jogo> jogos) {
//		Random random = new Random();
//		for (Jogo j : jogos) {
//			System.out.println(j.getPartida());
//			if (j.getQuadra() != new Quadra(1) || j.getQuadra() != new Quadra(0) || j.getQuadra() != new Quadra(2)) {
//				j.setQuadra(new Quadra(random.nextInt(2)));
//			}
//		}
//	}

}
