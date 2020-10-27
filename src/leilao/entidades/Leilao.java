package leilao.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Leilao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String descricao;
	private String situacao;
	
	@Temporal(TemporalType.DATE)
	private Date dataCriacao;
	
	private double valorInicial;
	private double valorArremate;
	
	public Leilao() {
		
	}
	
	public Leilao(String descricao) {
		this.descricao = descricao;
	}
	
	public Leilao(String descricao, Date dataCriacao, double valorInicial, String situacao) {
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.valorInicial = valorInicial;
		this.situacao = situacao;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public double getValorInicial() {
		return valorInicial;
	}
	public void setValorInicial(double valorInicial) {
		this.valorInicial = valorInicial;
	}
	public double getValorArremate() {
		return valorArremate;
	}
	public void setValorArremate(double valorArremate) {
		this.valorArremate = valorArremate;
	}
	
	
	
	
	
}
