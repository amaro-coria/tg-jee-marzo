package net.tecgurus.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Cliente database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c"),
	@NamedQuery(name="Cliente.findFiltered", query="SELECT c FROM Cliente c WHERE c.estadoCliente.idCat = :idCat")
})

public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cte")
	private int idCte;

	@Column(name="ape_mat_cte")
	private String apeMatCte;

	@Column(name="ape_pat_cte")
	private String apePatCte;

	@Column(name="dir_cte")
	private String dirCte;

	/*
	@Column(name="id_edo_cte")
	private int idEdoCte;
	*/
    @ManyToOne
    @JoinColumn(name="id_edo_cte")
    private Catalogo_General estadoCliente;

	@Column(name="nom_cte")
	private String nomCte;

	@Column(name="tel_cte")
	private String telCte;

	//bi-directional many-to-one association to Cuentas_Cliente
	@OneToMany(mappedBy="cliente")
	private List<Cuentas_Cliente> cuentasClientes;

	public Cliente() {
	}

	public int getIdCte() {
		return this.idCte;
	}

	public void setIdCte(int idCte) {
		this.idCte = idCte;
	}

	public String getApeMatCte() {
		return this.apeMatCte;
	}

	public void setApeMatCte(String apeMatCte) {
		this.apeMatCte = apeMatCte;
	}

	public String getApePatCte() {
		return this.apePatCte;
	}

	public void setApePatCte(String apePatCte) {
		this.apePatCte = apePatCte;
	}

	public String getDirCte() {
		return this.dirCte;
	}

	public void setDirCte(String dirCte) {
		this.dirCte = dirCte;
	}

	/*
	public int getIdEdoCte() {
		return this.idEdoCte;
	}

	public void setIdEdoCte(int idEdoCte) {
		this.idEdoCte = idEdoCte;
	}
*/

	//Getters de fix
    public Catalogo_General getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(Catalogo_General estadoCliente) {
        this.estadoCliente = estadoCliente;
    }
    //Fin de getters de fix

    public String getNomCte() {
		return this.nomCte;
	}

	public void setNomCte(String nomCte) {
		this.nomCte = nomCte;
	}

	public String getTelCte() {
		return this.telCte;
	}

	public void setTelCte(String telCte) {
		this.telCte = telCte;
	}

	public List<Cuentas_Cliente> getCuentasClientes() {
		return this.cuentasClientes;
	}

	public void setCuentasClientes(List<Cuentas_Cliente> cuentasClientes) {
		this.cuentasClientes = cuentasClientes;
	}

	public Cuentas_Cliente addCuentasCliente(Cuentas_Cliente cuentasCliente) {
		getCuentasClientes().add(cuentasCliente);
		cuentasCliente.setCliente(this);

		return cuentasCliente;
	}

	public Cuentas_Cliente removeCuentasCliente(Cuentas_Cliente cuentasCliente) {
		getCuentasClientes().remove(cuentasCliente);
		cuentasCliente.setCliente(null);

		return cuentasCliente;
	}

}