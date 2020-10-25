package leilao.controlador;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import leilao.entidades.Participante;
import leilao.jpa.util.JPAUtil;

public class ParticipanteDAO {
	
	private JPAUtil jpaUtil;
	private EntityManager em;

	public ParticipanteDAO() {
		jpaUtil = new JPAUtil();
		em = jpaUtil.getEntityManager();
	}
	
	public void salva(Participante participante) {
		em.getTransaction().begin();
		Participante existente = get(participante.getCpf());
		if(existente == null) {
			em.persist(participante);
		}else {
			existente.setCpf(participante.getCpf());
			existente.setName(participante.getName());
			existente.setDataAniversario(participante.getDataAniversario());
			em.persist(existente);
		}
		em.getTransaction().commit();
	}


	public void deleta(Participante participante) {
		em.getTransaction().begin();
		participante = em.find(Participante.class, participante.getCpf());
		em.remove(participante);
		em.getTransaction().commit();
	}

	public List<Participante> lista() {
		TypedQuery<Participante> qry = em.createQuery("from participantes", Participante.class);
		return qry.getResultList();
	}

	public Participante get(String cpf) {
		return em.find(Participante.class, cpf);
	}
}
