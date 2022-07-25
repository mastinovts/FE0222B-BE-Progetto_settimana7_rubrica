package data;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name="contatti")
@Entity                                    
@NamedQuery(name="getAllContatti", query="select c from Contatto c")
@NamedQuery(name="getContatto.bySurname", query="select c from Contatto c where c.cognome like :cognome")
@NamedQuery(name="getContatto.byNumber", query="select c from Contatto c where c.id = any (select nt.contatto.id from NumTelefono nt where nt.numero = :numero)")
public class Contatto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String cognome;
	private String email;
	
	private List <NumTelefono> numeri;
	
	public Contatto() {}

	public Contatto(String nome, String cognome, String email, String numTelefono) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		
	}

	@Id
	@Column(name="id_contatto", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	@Column(name="nome",nullable=false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name="cognome",nullable=false)
	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	
	@Column(name="email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@OneToMany(mappedBy="contatto", cascade=CascadeType.ALL)
	public List<NumTelefono> getNumero() {
		return numeri;
	}

	public void setNumero(List<NumTelefono> numeri) {
		this.numeri = numeri;
	}
	

}
