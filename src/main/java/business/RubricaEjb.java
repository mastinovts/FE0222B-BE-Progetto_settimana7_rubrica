package business;

import java.util.List;

import data.Contatto;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
@LocalBean
public class RubricaEjb implements RubricaEjbLocal {

   
	@PersistenceContext(unitName="RubricaPersistence")
	EntityManager em;
    public RubricaEjb() {
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public void inserisciContatto(Contatto cont) {
		em.persist(cont);
		
	}

	@Override
	public List<Contatto> visualizzaContatti() {
		Query q = em.createNamedQuery("getAllContatti");
		List <Contatto> c = q.getResultList();
		return c;
	}

	@Override
	public List<Contatto> getContattoBySurname(String cognome) {
		Query q = em.createNamedQuery("getContatto.bySurname");
		q.setParameter("cognome", "%"+cognome+"%");
		List <Contatto> c = q.getResultList();
		return c;
	}

	@Override
	public Contatto getContattoByNumber(String numero) {
		Query q = em.createNamedQuery("getContatto.byNumber");
		q.setParameter("numero", numero);
		Contatto c = (Contatto)q.getSingleResult();
		return c;
	}
	
	@Override
	public Contatto idcontatto(Long id) {
		return em.find(Contatto.class, id);
	}

	@Override
	public void updateContatto(Contatto contatto) {
		em.merge(contatto);
		
	}

	@Override
	public void deleteContatto(Contatto contatto) {
		em.remove(em.find(Contatto.class, contatto.getId()));
		
	}


}
