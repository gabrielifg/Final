package leilao.testes;

import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.Test;

import leilao.entidades.Participante;
import leilao.jpa.util.JPAUtil;

public class TestaBanco {
	
	@SuppressWarnings("deprecation")
	@Test
	public void main() {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(new Participante("Joao Vitor", "444", new Date("2010/10/10")));
		em.getTransaction().commit();
	}
}