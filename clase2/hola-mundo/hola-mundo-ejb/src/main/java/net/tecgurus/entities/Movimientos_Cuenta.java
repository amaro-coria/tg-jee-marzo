package net.tecgurus.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the Movimientos_Cuenta database table.
 * 
 */
@Entity
@NamedQuery(name="Movimientos_Cuenta.findAll", query="SELECT m FROM Movimientos_Cuenta m")
public class Movimientos_Cuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_mov_cta")
	private int idMovCta;

	@Column(name="dsc_mov")
	private String dscMov;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fch_cre")
	private Date fchCre;

	@Column(name="fol_aut")
	private String folAut;

	@Column(name="id_cta")
	private int idCta;

	@Column(name="id_tip_mov")
	private int idTipMov;

	@Column(name="mnt_mov")
	private BigDecimal mntMov;

	public Movimientos_Cuenta() {
	}

	public int getIdMovCta() {
		return this.idMovCta;
	}

	public void setIdMovCta(int idMovCta) {
		this.idMovCta = idMovCta;
	}

	public String getDscMov() {
		return this.dscMov;
	}

	public void setDscMov(String dscMov) {
		this.dscMov = dscMov;
	}

	public Date getFchCre() {
		return this.fchCre;
	}

	public void setFchCre(Date fchCre) {
		this.fchCre = fchCre;
	}

	public String getFolAut() {
		return this.folAut;
	}

	public void setFolAut(String folAut) {
		this.folAut = folAut;
	}

	public int getIdCta() {
		return this.idCta;
	}

	public void setIdCta(int idCta) {
		this.idCta = idCta;
	}

	public int getIdTipMov() {
		return this.idTipMov;
	}

	public void setIdTipMov(int idTipMov) {
		this.idTipMov = idTipMov;
	}

	public BigDecimal getMntMov() {
		return this.mntMov;
	}

	public void setMntMov(BigDecimal mntMov) {
		this.mntMov = mntMov;
	}

}