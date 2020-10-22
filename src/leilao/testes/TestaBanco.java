package leilao.testes;

import javax.persistence.EntityManager;
import leilao.entidades.Participante;
import leilao.jpa.util.JPAUtil;

public class TestaBanco {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(new Participante("222.222.222-22", "Joao Vitor"));
		em.getTransaction().commit();
	}
}