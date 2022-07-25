package business;

import java.util.List;

import data.Contatto;
import jakarta.ejb.Local;

@Local
public interface RubricaEjbLocal {
	public void inserisciContatto(Contatto cont);
	public List <Contatto> visualizzaContatti();
	public List <Contatto> getContattoBySurname(String cognome);
	public Contatto getContattoByNumber(String numero);
	public Contatto idcontatto(Long id);
	public void updateContatto(Contatto contatto);
	public void deleteContatto (Contatto contatto);
}
