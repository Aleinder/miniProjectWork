package it.es.gestionale.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "ordine")
public class OrdineEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="dipendente_id")
	private DipendenteEntity dipendente;


	@Column(name="data")
	private Date data;

	@Column(name="consegna")
	private String consegna;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private ClienteEntity cliente;

	@OneToMany(mappedBy ="ordine")
	private List<DettaglioEntity> dettagli;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getConsegna() {
		return consegna;
	}

	public void setConsegna(String consegna) {
		this.consegna = consegna;
	}

	public List<DettaglioEntity> getDettagli() {
		return dettagli;
	}

	public void setDettagli(List<DettaglioEntity> dettagli) {
		this.dettagli = dettagli;
	}
	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "OrdineEntity [id=" + id + ", dipendente=" + dipendente + ", data=" + data + ", consegna=" + consegna
				+ "]";
	}

}
