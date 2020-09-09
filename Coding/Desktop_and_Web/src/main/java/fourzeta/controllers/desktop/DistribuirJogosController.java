package fourzeta.controllers.desktop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import fourzeta.desktop_views.DistribuirJogos;
import fourzeta.models.Jogo;
import fourzeta.models.Quadra;
import fourzeta.models.Torneio;
import fourzeta.models.Usuario;
import fourzeta.resources.JogoResource;


public class DistribuirJogosController implements ActionListener {

	private DistribuirJogos tela;
	private Usuario usuario;
	private Torneio torneio;
	private JogoResource jr;

	public DistribuirJogosController(Usuario usuario, Torneio torneio, DistribuirJogos tela) {
		this.tela = tela;
		this.usuario = usuario;
		this.torneio = torneio;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Quadra quadra = null;

		if (this.tela.getComboBoxCategoria().getSelectedItem().equals("SELECIONAR")) {
			this.tela.notifyInformarCategoria();
		} else if (this.tela.getComboBoxQuadra().getSelectedItem().equals("SELECIONAR")) {
			this.tela.notifyInformarQuadra();
		}

		switch (this.tela.getComboBoxQuadra().getSelectedItem().toString()) {
		case "LARANJA":
			quadra = new Quadra(1);
			break;
		case "AZUL":
			quadra = new Quadra(2);
			break;
		case "VERDE":
			quadra = new Quadra(3);
		}
		jr = new JogoResource();
		List<Jogo> jogos = jr.listaJogos();
		configurarQuadras(jogos, quadra, this.tela.getComboBoxCategoria().getSelectedItem().toString());
		this.tela.notifySucesso();
	}

	public void configurarQuadras(List<Jogo> jogos, Quadra quadra, String categoria) {
		jr = new JogoResource();
		for (Jogo j : jogos) {
			if (j.getCategoria().equalsIgnoreCase(categoria)) {
				j.setQuadra(quadra);
				jr.registraJogo(j);
			}
		}
	}

}