package fourzeta.desktop_views;

import java.awt.Dimension;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import fourzeta.controllers.desktop.DistribuirJogosController;
import fourzeta.controllers.desktop.GradeJogosController;
import fourzeta.models.Categoria;
import fourzeta.models.Torneio;
import fourzeta.models.Usuario;

public class DistribuirJogos extends JFrame {
	private final Dimension SIZE = new Dimension(350, 320);
	private Usuario usuario;
	private Torneio torneio;
	private JLabel lblDistribirJogos;
	private JLabel lblCategoria;
	private JComboBox comboBoxCategoria;
	private JComboBox comboBoxQuadra;
	private DistribuirJogosController controller;
	private GradeJogosController gradeJogosController;
	private JLabel lblQuadra;
	private JButton btnVoltar;
	private JButton btnDistribuir;

	public DistribuirJogos(Usuario usuario, Torneio torneio) throws ParseException {
		configFrame();
		this.getContentPane().add(configLblDistribuirJogos());
		this.getContentPane().add(configLblCategoria());
		this.getContentPane().add(configComboCategoria());
		this.getContentPane().add(configLblQuadra());
		this.getContentPane().add(configBtnDistribuir(usuario, torneio));
		this.getContentPane().add(configLblNotify());
		this.getContentPane().add(configComboQuadra());
		this.getContentPane().add(configBtnVoltar(usuario, torneio));

	}

	private void configFrame() {
		this.usuario = usuario;
		this.torneio = torneio;
		setTitle("Distribuir Jogos");
		this.setSize(SIZE);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	private JLabel configLblDistribuirJogos() {
		lblDistribirJogos = new JLabel("Distribuir Jogos");
		lblDistribirJogos.setHorizontalAlignment(SwingConstants.CENTER);
		lblDistribirJogos.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblDistribirJogos.setBounds(12, 22, 321, 35);
		getContentPane().add(lblDistribirJogos);
		return lblDistribirJogos;
	}

	private JLabel configLblCategoria() {
		lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCategoria.setBounds(22, 75, 100, 15);
		getContentPane().add(lblCategoria);
		return lblCategoria;
	}

	private JLabel configLblQuadra() {
		lblQuadra = new JLabel("Quadra:");
		lblQuadra.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblQuadra.setBounds(22, 150, 70, 15);
		getContentPane().add(lblQuadra);
		return lblQuadra;

	}

	private JButton configBtnDistribuir(Usuario usuario, Torneio torneio) {
		btnDistribuir = new JButton("Distribuir");
		btnDistribuir.setBounds(208, 215, 114, 25);
		btnDistribuir.setFont(new Font("Times New Roman", Font.BOLD, 14));
		controller = new DistribuirJogosController(usuario, this);
		btnDistribuir.addActionListener(controller);
		getContentPane().add(btnDistribuir);
		return btnDistribuir;
	}

	private JLabel configLblNotify() {
		JLabel lblselecioneACategoria = new JLabel("*Distribuir jogos por categoria na quadra desejada");
		lblselecioneACategoria.setFont(new Font("Times new Roman", Font.PLAIN, 12));
		lblselecioneACategoria.setBounds(22, 249, 311, 43);
		getContentPane().add(lblselecioneACategoria);
		return lblselecioneACategoria;
	}

	private JComboBox configComboQuadra() {
		comboBoxQuadra = new JComboBox();
		comboBoxQuadra.addItem("SELECIONAR");
		comboBoxQuadra.addItem("LARANJA");
		comboBoxQuadra.addItem("AZUL");
		comboBoxQuadra.addItem("VERDE");
		getContentPane().add(comboBoxQuadra);
		comboBoxQuadra.setFont(new Font("Times New Roman", Font.BOLD, 12));
		comboBoxQuadra.setBounds(22, 173, 300, 24);
		getContentPane().add(comboBoxQuadra);
		return comboBoxQuadra;
	}

	private JComboBox configComboCategoria() {
		comboBoxCategoria = new JComboBox();
		comboBoxCategoria.addItem("SELECIONAR");
		Categoria[] catEnums = Categoria.values();
		for (int i = 0; i < catEnums.length; i++) {
			comboBoxCategoria.addItem(catEnums[i]);
		}
		comboBoxCategoria.setFont(new Font("Times New Roman", Font.BOLD, 12));
		comboBoxCategoria.setBounds(22, 98, 300, 24);
		return this.comboBoxCategoria;
	}

	private JButton configBtnVoltar(Usuario usuario, Torneio torneio) throws ParseException {
		btnVoltar = new JButton("Voltar");
		DistribuirJogosController controller = new DistribuirJogosController(usuario, torneio);
		btnVoltar.addActionListener(controller.actionPerformedVoltar());
		btnVoltar.setBounds(22, 215, 114, 25);
		getContentPane().add(btnVoltar);

		return btnVoltar;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Torneio getTorneio() {
		return torneio;
	}

	public void setTorneio(Torneio torneio) {
		this.torneio = torneio;
	}

	public JLabel getLblDistribirJogos() {
		return lblDistribirJogos;
	}

	public void setLblDistribirJogos(JLabel lblDistribirJogos) {
		this.lblDistribirJogos = lblDistribirJogos;
	}

	public JLabel getLblCategoria() {
		return lblCategoria;
	}

	public void setLblCategoria(JLabel lblCategoria) {
		this.lblCategoria = lblCategoria;
	}

	public JComboBox getComboBoxCategoria() {
		return comboBoxCategoria;
	}

	public void setComboBoxCategoria(JComboBox comboBoxCategoria) {
		this.comboBoxCategoria = comboBoxCategoria;
	}

	public JComboBox getComboBoxQuadra() {
		return comboBoxQuadra;
	}

	public void setComboBoxQuadra(JComboBox comboBoxQuadra) {
		this.comboBoxQuadra = comboBoxQuadra;
	}

	public JLabel getLblQuadra() {
		return lblQuadra;
	}

	public void setLblQuadra(JLabel lblQuadra) {
		this.lblQuadra = lblQuadra;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public JButton getBtnDistribuir() {
		return btnDistribuir;
	}

	public void setBtnDistribuir(JButton btnDistribuir) {
		this.btnDistribuir = btnDistribuir;
	}

	public Dimension getSIZE() {
		return SIZE;
	}

	public void notifyInformarQuadra() {
		JOptionPane.showMessageDialog(this, "Informe uma Quadra.");

	}

	public void notifyInformarCategoria() {
		JOptionPane.showMessageDialog(this, "Informe uma Categoria.");

	}

	public void notifySucesso() {
		JOptionPane.showMessageDialog(this, "Jogos distribuidos com Sucesso!!");

	}

	public static void main(String[] args) throws ParseException {
		Usuario g = new Usuario();
		g.setNome("Wagner");
		Torneio t = new Torneio();
		DistribuirJogos frame = new DistribuirJogos(g, t);
		frame.setVisible(true);
		frame.setSize(frame.SIZE);
		frame.setLocationRelativeTo(null);
	}
}
