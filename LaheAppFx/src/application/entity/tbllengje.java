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
@Table(name = "tbllengje")
public class tbllengje implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@ManyToOne
	@JoinColumn(name = "auto_id")
	private tblautomjet targa;

	@Column(name = "tipi")
	private String tipi;

	@Column(name = "kodi")
	private String kodi;

	@Column(name = "sasia")
	private String sasia;

	@Column(name = "data")
	@Temporal(TemporalType.DATE)
	private Date dataKrijimit;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipi() {
		return tipi;
	}

	public void setTipi(String tipi) {
		this.tipi = tipi;
	}

	public String getKodi() {
		return kodi;
	}

	public void setKodi(String kodi) {
		this.kodi = kodi;
	}

	public String getSasia() {
		return sasia;
	}

	public void setSasia(String sasia) {
		this.sasia = sasia;
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
