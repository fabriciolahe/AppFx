package application.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tblmirembajtje")
public class tblmirembajtje implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@ManyToOne
	@JoinColumn(name = "auto_id")
	private tblautomjet targa;

	@Column(name = "kilomatrat")
	private String kilomatrat;

	@Column(name = "filter_ajri")
	private boolean filterAjri;

	@Column(name = "filter_gabine")
	private boolean filterGabine;

	@Column(name = "filter_vaji")
	private boolean filterVaji;

	@Column(name = "filter_karburanti")
	private boolean filterKarburanti;

	@Column(name = "sae_vaji")
	private String saeVaji;

	@Column(name = "data")
	@Temporal(TemporalType.DATE)
	private Date dataKrijimit;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getKilomatrat() {
		return kilomatrat;
	}

	public void setKilomatrat(String kilomatrat) {
		this.kilomatrat = kilomatrat;
	}

	public boolean isFilterAjri() {
		return filterAjri;
	}

	public void setFilterAjri(boolean filterAjri) {
		this.filterAjri = filterAjri;
	}

	public boolean isFilterGabine() {
		return filterGabine;
	}

	public void setFilterGabine(boolean filterGabine) {
		this.filterGabine = filterGabine;
	}

	public boolean isFilterVaji() {
		return filterVaji;
	}

	public void setFilterVaji(boolean filterVaji) {
		this.filterVaji = filterVaji;
	}

	public boolean isFilterKarburanti() {
		return filterKarburanti;
	}

	public void setFilterKarburanti(boolean filterKarburanti) {
		this.filterKarburanti = filterKarburanti;
	}

	public String getSaeVaji() {
		return saeVaji;
	}

	public void setSaeVaji(String saeVaji) {
		this.saeVaji = saeVaji;
	}

	public tblautomjet getTarga() {
		return targa;
	}

	public void setTarga(tblautomjet targa) {
		this.targa = targa;
	}

	public Date getDataKrijimit() {
		return dataKrijimit;
	}

	public void setDataKrijimit(Date dataKrijimit) {
		this.dataKrijimit = dataKrijimit;
	}
}
