package leilao.controlador;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import leilao.entidades.Leilao;
import leilao.jpa.util.JPAUtil;


public class LeilaoDAO {
	
	private JPAUtil jpaUtil;
	private EntityManager em;

	public LeilaoDAO() {
		jpaUtil = new JPAUtil();
		em = jpaUtil.getEntityManager();
	}
	
	public void salva(Leilao leilao) {
		em.getTransaction().begin();
		Leilao existente = getLeilao(leilao.getId());

		if (existente == null) {
			em.persist(leilao);
		} else {

			existente.setDataCriacao(leilao.getDataCriacao());
			existente.setDescricao(leilao.getDescricao());
			existente.setSituacao(leilao.getSituacao());
			existente.setValorArremate(leilao.getValorArremate());
			existente.setValorInicial(leilao.getValorInicial());
		}
		em.getTransaction().commit();
		em.close();
	}


	public void deleta(Leilao leilao) {
		em.getTransaction().begin();
		leilao = em.find(Leilao.class, leilao.getId());
		em.remove(leilao);
		em.getTransaction().commit();
		em.close();
	}

	public List<Leilao> lista() {
		TypedQuery<Leilao> qry = em.createQuery("from Leilao", Leilao.class);
		return qry.getResultList();
	}

	public Leilao getLeilao(Long id) {
		return em.find(Leilao.class, id);
	}
}
