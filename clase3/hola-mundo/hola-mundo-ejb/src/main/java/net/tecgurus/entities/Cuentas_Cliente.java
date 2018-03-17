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
	@Column(name="id_cta_cte")
	private int idCtaCte;

	@Column(name="cmnt_cta_cte")
	private String cmntCtaCte;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fch_cre")
	private Date fchCre;

	@Column(name="id_cta")
	private int idCta;

	@Column(name="id_cte")
	private int idCte;

	@Column(name="id_edo_cta_cte")
	private int idEdoCtaCte;

	@Column(name="id_tip_cta_cte")
	private int idTipCtaCte;

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

	public int getIdCta() {
		return this.idCta;
	}

	public void setIdCta(int idCta) {
		this.idCta = idCta;
	}

	public int getIdCte() {
		return this.idCte;
	}

	public void setIdCte(int idCte) {
		this.idCte = idCte;
	}

	public int getIdEdoCtaCte() {
		return this.idEdoCtaCte;
	}

	public void setIdEdoCtaCte(int idEdoCtaCte) {
		this.idEdoCtaCte = idEdoCtaCte;
	}

	public int getIdTipCtaCte() {
		return this.idTipCtaCte;
	}

	public void setIdTipCtaCte(int idTipCtaCte) {
		this.idTipCtaCte = idTipCtaCte;
	}

}