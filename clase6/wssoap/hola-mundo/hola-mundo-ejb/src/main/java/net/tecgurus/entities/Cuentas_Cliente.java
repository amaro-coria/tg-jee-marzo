package net.tecgurus.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Cuentas_Cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cuentas_Cliente.findAll", query="SELECT c FROM Cuentas_Cliente c")
public class Cuentas_Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cta_cte")
	private int idCtaCte;

	@Column(name="cmnt_cta_cte")
	private String cmntCtaCte;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fch_cre")
	private Date fchCre;

	//bi-directional many-to-one association to Catalogo_General
	@ManyToOne
	@JoinColumn(name="id_edo_cta_cte")
	private Catalogo_General catalogoGeneral1;

	//bi-directional many-to-one association to Catalogo_General
	@ManyToOne
	@JoinColumn(name="id_tip_cta_cte")
	private Catalogo_General catalogoGeneral2;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cte")
	private Cliente cliente;

	//bi-directional many-to-one association to Cuenta
	@ManyToOne
	@JoinColumn(name="id_cta")
	private Cuenta cuenta;

	public Cuentas_Cliente() {
	}

	public int getIdCtaCte() {
		return this.idCtaCte;
	}

	public void setIdCtaCte(int idCtaCte) {
		this.idCtaCte = idCtaCte;
	}

	public String getCmntCtaCte() {
		return this.cmntCtaCte;
	}

	public void setCmntCtaCte(String cmntCtaCte) {
		this.cmntCtaCte = cmntCtaCte;
	}

	public Date getFchCre() {
		return this.fchCre;
	}

	public void setFchCre(Date fchCre) {
		this.fchCre = fchCre;
	}

	public Catalogo_General getCatalogoGeneral1() {
		return this.catalogoGeneral1;
	}

	public void setCatalogoGeneral1(Catalogo_General catalogoGeneral1) {
		this.catalogoGeneral1 = catalogoGeneral1;
	}

	public Catalogo_General getCatalogoGeneral2() {
		return this.catalogoGeneral2;
	}

	public void setCatalogoGeneral2(Catalogo_General catalogoGeneral2) {
		this.catalogoGeneral2 = catalogoGeneral2;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cuenta getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

}