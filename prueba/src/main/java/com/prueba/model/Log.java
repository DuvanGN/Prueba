package com.prueba.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
	
@Entity
@Table(name = "Log")
public class Log {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="peticion")
	private String peticion;
	
	@Column(name = "respuesta")
	private String respuesta;
	
	@Column(name = "auditoria")
	private String auditoria;
	
			public String getpeticion() {
				return peticion;
			}
	
			public void setIdCliente(String idpeticion) {
				this.peticion = idpeticion;
			}
	
			public String getrespuesta() {
				return respuesta;
			}
	
			public void setrespuesta(String respuesta) {
				this.respuesta = respuesta;
			}
	
			public String getauditoria() {
				return auditoria;
			}
	
			public void setauditoria(String auditoria) {
				this.auditoria = auditoria;
			}
	
	}
