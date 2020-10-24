package leilao.entidades;



import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Participante {
	
	private String name;
	
	@Id
	private String cpf;
	
	@Temporal(TemporalType.DATE)
	private Date dataAniversario;
	
	public Participante() {
		
	}

	
	public Participante(String name, String cpf, Date dataAniversario) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.dataAniversario = dataAniversario;
	}


	public Participante(String cpf) {
		this.cpf = cpf;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(Date dataAniversario) {
		this.dataAniversario = dataAniversario;
	}	
}

