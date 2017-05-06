package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.Cargaison;
import metier.Marchandise;

/**
 * Session Bean implementation class Transport
 */
@Stateless
public class ITransport implements ITransportRemote, ITransportLocal {

	@PersistenceContext(name = "WsPu")
	private EntityManager em;

	public void addCargaison(Cargaison c) {
		em.persist(c);

	}

	public void addMarchandise(Marchandise m, long refcarg) {
		Cargaison cargaison = em.find(Cargaison.class, refcarg);
		List<Marchandise> marchandises = new ArrayList<Marchandise>();
		marchandises.add(m);
		m.setCargaison(cargaison);
		cargaison.setMarchandises(marchandises);
		em.persist(cargaison);
	}

	public List<Cargaison> getAllCargaisons() {
		@SuppressWarnings("unchecked")
		List<Cargaison> cargaisons = em.createQuery("Select c from Cargaison c").getResultList();
		return cargaisons;
	}

	public List<Marchandise> getMarchandiseParMc(String mc) {
		Query query = em.createQuery("Select m from Marchandise m where m.nom like :nom");
		query.setParameter("nom", "%" + mc + "%");
		@SuppressWarnings("unchecked")
		List<Marchandise> marchandises = query.getResultList();
		return marchandises;
	}

	public void deleteMarchandise(long refMarchandise) {
		em.remove(em.find(Marchandise.class, refMarchandise));

	}

}
