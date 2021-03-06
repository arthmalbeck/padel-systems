package fourzeta.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fourzeta.IElement;

@Entity
//@JsonIgnoreProperties("torneio")
@Table(name="dupla", schema = "public")
public class Dupla implements Comparable<Dupla>, Serializable, IElement{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;

	// Torneio não é mapeado
	@ManyToOne
	private Torneio torneio;

//	@Enumerated(EnumType.ORDINAL)
	private String categoria;

//	@Enumerated(EnumType.STRING)
	private String impedimento;

	// Cria a tabela Atleta_dupla
	@OneToOne()
	private Atleta atleta1;
	
	@OneToOne()
	private Atleta atleta2;

	@Column(name = "pon_total")
	private long ponTotal;

//	@Override
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria.toUpperCase();
	}

	public long getPonTotal() {
		return ponTotal;
	}
	

	public Torneio getTorneio() {
		return torneio;
	}

	public void setTorneio(Torneio torneio) {
		this.torneio = torneio;
	}

	public void setPonTotal(long ponTotal) {
		this.ponTotal = ponTotal;
	}

	public String toString() {
		return this.atleta1.getNome() + " / " + this.atleta2.getNome();
	}

	public Atleta getAtleta1() {
		return atleta1;
	}

	public void setAtleta1(Atleta atleta1) {
		this.atleta1 = atleta1;
	}

	public Atleta getAtleta2() {
		return atleta2;
	}

	public void setAtleta2(Atleta atleta2) {
		this.atleta2 = atleta2;
	}

	public String getImpedimento() {
		return impedimento;
	}

	public void setImpedimento(String impedimento) {
		this.impedimento = impedimento;
	}
	
	@Override
	public int compareTo(Dupla arg0) {
		boolean maior = arg0.getId() > this.getId();
		if (maior)
			return -1;
		else
			return 1;
	}

}
