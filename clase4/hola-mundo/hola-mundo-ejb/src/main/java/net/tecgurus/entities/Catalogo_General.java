package net.tecgurus.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Catalogo_General database table.
 * 
 */
@Entity
@NamedQuery(name="Catalogo_General.findAll", query="SELECT c FROM Catalogo_General c")
public class Catalogo_General implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cat")
	private int idCat;

	@Column(name="dsc_com_cat")
	private String dscComCat;

	@Column(name="dsc_cor_cat")
	private String dscCorCat;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fch_cre")
	private Date fchCre;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fch_mod")
	private Date fchMod;

	@Column(name="id_est_cat")
	private int idEstCat;

	//bi-directional many-to-one association to Cuenta
	@OneToMany(mappedBy="catalogoGeneral")
	private List<Cuenta> cuentas;

	//bi-directional many-to-one association to Cuentas_Cliente
	@OneToMany(mappedBy="catalogoGeneral1")
	private List<Cuentas_Cliente> cuentasClientes1;

	//bi-directional many-to-one association to Cuentas_Cliente
	@OneToMany(mappedBy="catalogoGeneral2")
	private List<Cuentas_Cliente> cuentasClientes2;

	//bi-directional many-to-one association to Movimientos_Cuenta
	@OneToMany(mappedBy="catalogoGeneral")
	private List<Movimientos_Cuenta> movimientosCuentas;

	public Catalogo_General() {
	}

	public int getIdCat() {
		return this.idCat;
	}

	public void setIdCat(int idCat) {
		this.idCat = idCat;
	}

	public String getDscComCat() {
		return this.dscComCat;
	}

	public void setDscComCat(String dscComCat) {
		this.dscComCat = dscComCat;
	}

	public String getDscCorCat() {
		return this.dscCorCat;
	}

	public void setDscCorCat(String dscCorCat) {
		this.dscCorCat = dscCorCat;
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

	public int getIdEstCat() {
		return this.idEstCat;
	}

	public void setIdEstCat(int idEstCat) {
		this.idEstCat = idEstCat;
	}

	public List<Cuenta> getCuentas() {
		return this.cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public Cuenta addCuenta(Cuenta cuenta) {
		getCuentas().add(cuenta);
		cuenta.setCatalogoGeneral(this);

		return cuenta;
	}

	public Cuenta removeCuenta(Cuenta cuenta) {
		getCuentas().remove(cuenta);
		cuenta.setCatalogoGeneral(null);

		return cuenta;
	}

	public List<Cuentas_Cliente> getCuentasClientes1() {
		return this.cuentasClientes1;
	}

	public void setCuentasClientes1(List<Cuentas_Cliente> cuentasClientes1) {
		this.cuentasClientes1 = cuentasClientes1;
	}

	public Cuentas_Cliente addCuentasClientes1(Cuentas_Cliente cuentasClientes1) {
		getCuentasClientes1().add(cuentasClientes1);
		cuentasClientes1.setCatalogoGeneral1(this);

		return cuentasClientes1;
	}

	public Cuentas_Cliente removeCuentasClientes1(Cuentas_Cliente cuentasClientes1) {
		getCuentasClientes1().remove(cuentasClientes1);
		cuentasClientes1.setCatalogoGeneral1(null);

		return cuentasClientes1;
	}

	public List<Cuentas_Cliente> getCuentasClientes2() {
		return this.cuentasClientes2;
	}

	public void setCuentasClientes2(List<Cuentas_Cliente> cuentasClientes2) {
		this.cuentasClientes2 = cuentasClientes2;
	}

	public Cuentas_Cliente addCuentasClientes2(Cuentas_Cliente cuentasClientes2) {
		getCuentasClientes2().add(cuentasClientes2);
		cuentasClientes2.setCatalogoGeneral2(this);

		return cuentasClientes2;
	}

	public Cuentas_Cliente removeCuentasClientes2(Cuentas_Cliente cuentasClientes2) {
		getCuentasClientes2().remove(cuentasClientes2);
		cuentasClientes2.setCatalogoGeneral2(null);

		return cuentasClientes2;
	}

	public List<Movimientos_Cuenta> getMovimientosCuentas() {
		return this.movimientosCuentas;
	}

	public void setMovimientosCuentas(List<Movimientos_Cuenta> movimientosCuentas) {
		this.movimientosCuentas = movimientosCuentas;
	}

	public Movimientos_Cuenta addMovimientosCuenta(Movimientos_Cuenta movimientosCuenta) {
		getMovimientosCuentas().add(movimientosCuenta);
		movimientosCuenta.setCatalogoGeneral(this);

		return movimientosCuenta;
	}

	public Movimientos_Cuenta removeMovimientosCuenta(Movimientos_Cuenta movimientosCuenta) {
		getMovimientosCuentas().remove(movimientosCuenta);
		movimientosCuenta.setCatalogoGeneral(null);

		return movimientosCuenta;
	}

}