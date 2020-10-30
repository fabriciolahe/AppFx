package application.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tblklient")
public class tblklient implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "emer")
	private String emri;

	@Column(name = "mbiemer")
	private String mbiemri;

	@Column(name = "kompania")
	private String kompania;

	@Column(name = "nrcelulari")
	private String nrcelulari;
	
	@ManyToMany(mappedBy="klient")
	private Set<tblautomjet> automjetet;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmri() {
		return emri;
	}

	public void setEmri(String emri) {
		this.emri = emri;
	}

	public String getMbiemri() {
		return mbiemri;
	}

	public void setMbiemri(String mbiemri) {
		this.mbiemri = mbiemri;
	}

	public String getKompania() {
		return kompania;
	}

	public void setKompania(String kompania) {
		this.kompania = kompania;
	}

	public String getNrcelulari() {
		return nrcelulari;
	}

	public void setNrcelulari(String nrcelulari) {
		this.nrcelulari = nrcelulari;
	}

	public Set<tblautomjet> getAutomjetet() {
		return automjetet;
	}

	public void setAutomjetet(Set<tblautomjet> automjetet) {
		this.automjetet = automjetet;
	}
	
	
}
