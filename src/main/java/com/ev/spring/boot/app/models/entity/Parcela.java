package com.ev.spring.boot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "parcelas")
public class Parcela implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "numero_parcela")
	private Integer numeroParcela;

	@NotEmpty
	@Column(name = "nombre_parcela")
	private String nombreParcela;

	@NotEmpty
	@Column(name = "direccion_parcela")
	private String direccionParcela;
	
	private String estado;

	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date createAt;

	@PrePersist
	public void prePersist() {
		createAt = new Date();
		estado = "ACTIVO";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumeroParcela() {
		return numeroParcela;
	}

	public void setNumeroParcela(Integer numeroParcela) {
		this.numeroParcela = numeroParcela;
	}

	public String getNombreParcela() {
		return nombreParcela;
	}

	public void setNombreParcela(String nombreParcela) {
		this.nombreParcela = nombreParcela;
	}

	public String getDireccionParcela() {
		return direccionParcela;
	}

	public void setDireccionParcela(String direccionParcela) {
		this.direccionParcela = direccionParcela;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
}
