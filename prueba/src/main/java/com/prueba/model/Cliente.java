package com.prueba.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_cliente")
	private Long idCliente;
	
	@Column(name = "tipo_doc")
	private Long tipoDocId;
	
	@Column(name = "num_doc")
	private Long numDoc;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "celular")
	private Long celular;

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getTipoDocId() {
		return tipoDocId;
	}

	public void setTipoDocId(Long tipoDocId) {
		this.tipoDocId = tipoDocId;
	}

	public Long getNumDoc() {
		return numDoc;
	}

	public void setNumDoc(Long numDoc) {
		this.numDoc = numDoc;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Long getCelular() {
		return celular;
	}

	public void setCelular(Long celular) {
		this.celular = celular;
	}
	
}
