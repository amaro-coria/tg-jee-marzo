package net.tecgurus.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the Cuenta database table.
 * 
 */
@Entity
@NamedQuery(name="Cuenta.findAll", query="SELECT c FROM Cuenta c")
public class Cuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cta")
	private int idCta;

	@Column(name="blnc_cta")
	private BigDecimal blncCta;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fch_alt")
	private Date fchAlt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fch_cre")
	private Date fchCre;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fch_mod")
	private Date fchMod;

	@Column(name="id_est")
	private BigInteger idEst;

	@Column(name="id_tip_cta")
	private int idTipCta;

	@Column(name="no_cta")
	private String noCta;

	@Column(name="no_tar")
	private String noTar;

	public Cuenta() {
	}

	public int getIdCta() {
		return this.idCta;
	}

	public void setIdCta(int idCta) {
		this.idCta = idCta;
	}

	public BigDecimal getBlncCta() {
		return this.blncCta;
	}

	public void setBlncCta(BigDecimal blncCta) {
		this.blncCta = blncCta;
	}

	public Date getFchAlt() {
		return this.fchAlt;
	}

	public void setFchAlt(Date fchAlt) {
		this.fchAlt = fchAlt;
	}

	public Date getFchCre() {
		return this.fchCre;
	}

	public void setFchCre(Date fchCre) {
		this.fchCre = fchCre;
	}

	public Date getFchMod() {
		return this.fchMod;
	}

	public void setFchMod(Date fchMod) {
		this.fchMod = fchMod;
	}

	public BigInteger getIdEst() {
		return this.idEst;
	}

	public void setIdEst(BigInteger idEst) {
		this.idEst = idEst;
	}

	public int getIdTipCta() {
		return this.idTipCta;
	}

	public void setIdTipCta(int idTipCta) {
		this.idTipCta = idTipCta;
	}

	public String getNoCta() {
		return this.noCta;
	}

	public void setNoCta(String noCta) {
		this.noCta = noCta;
	}

	public String getNoTar() {
		return this.noTar;
	}

	public void setNoTar(String noTar) {
		this.noTar = noTar;
	}

}