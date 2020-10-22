package leilao.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Participante {
	
	private String name;
	
	@Id
	private String cpf;
	
	public Participante() {
		
	}

	public Participante(String name, String cpf) {
		super();
		this.name = name;
		this.cpf = cpf;
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
	
	
}
