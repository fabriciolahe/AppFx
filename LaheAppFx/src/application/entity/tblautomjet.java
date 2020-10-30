package application.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tblautomjet")
public class tblautomjet implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "targa")
	private String targa;

	@Column(name = "nrshasi")
	private String nrshasi;

	@Column(name = "marka")
	private String marka;

	@Column(name = "model")
	private String model;

	@Column(name = "cilindrata")
	private String cilindrata;

	@Column(name = "fuqia")
	private String fuqia;

	@Column(name = "karburant")
	private String karburant;

	@Column(name = "kambio")
	private String kambio;

	@Column(name = "viti")
	private String viti;

	@ManyToMany
	@JoinTable(name = "tblklient_automjet", joinColumns = @JoinColumn(name = "automjet_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "klient_id", referencedColumnName = "id"))
	private Set<tblklient> klient;

	@OneToMany(mappedBy = "targa")
	private Set<tblmirembajtje> mirembajtje;

	@OneToMany(mappedBy = "targa")
	private Set<tblpjeskembimi> pjesekembimi;

	@OneToMany(mappedBy = "targa")
	private Set<tbllengje> lengje;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public String getNrshasi() {
		return nrshasi;
	}

	public void setNrshasi(String nrshasi) {
		this.nrshasi = nrshasi;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCilindrata() {
		return cilindrata;
	}

	public void setCilindrata(String cilindrata) {
		this.cilindrata = cilindrata;
	}

	public String getFuqia() {
		return fuqia;
	}

	public void setFuqia(String fuqia) {
		this.fuqia = fuqia;
	}

	public String getKarburant() {
		return karburant;
	}

	public void setKarburant(String karburant) {
		this.karburant = karburant;
	}

	public String getKambio() {
		return kambio;
	}

	public void setKambio(String kambio) {
		this.kambio = kambio;
	}

	public String getViti() {
		return viti;
	}

	public void setViti(String viti) {
		this.viti = viti;
	}

	public Set<tblklient> getKlient() {
		return klient;
	}

	public void setKlient(Set<tblklient> klient) {
		this.klient = klient;
	}

	public Set<tblmirembajtje> getMirembajtje() {
		return mirembajtje;
	}

	public void setMirembajtje(Set<tblmirembajtje> mirembajtje) {
		this.mirembajtje = mirembajtje;
	}

	public Set<tblpjeskembimi> getPjesekembimi() {
		return pjesekembimi;
	}

	public void setPjesekembimi(Set<tblpjeskembimi> pjesekembimi) {
		this.pjesekembimi = pjesekembimi;
	}

	public Set<tbllengje> getLengje() {
		return lengje;
	}

	public void setLengje(Set<tbllengje> lengje) {
		this.lengje = lengje;
	}

}
