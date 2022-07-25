package data;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name="numeri_telefono")
@Entity
public class NumTelefono implements Serializable {
	private static final long serialVersionUID = 1L;

	private String numero;
	private Long idTelefono;
	
	private Contatto contatto;
	
	public NumTelefono() {}

	public NumTelefono(String numero) {
		this.numero = numero;
	}
	
	

	@Id
	@Column(name="id_telefono")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getIdTelefono() {
		return idTelefono;
	}

	public void setIdTelefono(Long idTelefono) {
		this.idTelefono = idTelefono;
	}

	@Column(name="numero", nullable=false)
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	
	@ManyToOne
	@JoinColumn(name="id")
	public Contatto getContatto() {
		return contatto;
	}

	public void setContatto(Contatto contatto) {
		this.contatto = contatto;
	}

}
