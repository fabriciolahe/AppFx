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
@Table(name = "tblpjeskembimi")
public class tblpjeskembimi implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@ManyToOne
	@JoinColumn(name = "auto_id")
	private tblautomjet targa;

	@Column(name = "kod_pjese")
	private String kodPjese;

	@Column(name = "emer_pjese")
	private String emerPjese;

	@Column(name = "data")
	@Temporal(TemporalType.DATE)
	private Date dataKrjimit;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getKodPjese() {
		return kodPjese;
	}

	public void setKodPjese(String kodPjese) {
		this.kodPjese = kodPjese;
	}

	public String getEmerPjese() {
		return emerPjese;
	}

	public void setEmerPjese(String emerPjese) {
		this.emerPjese = emerPjese;
	}

	public tblautomjet getTarga() {
		return targa;
	}

	public void setTarga(tblautomjet targa) {
		this.targa = targa;
	}

	public Date getDataKrjimit() {
		return dataKrjimit;
	}

	public void setDataKrjimit(Date dataKrjimit) {
		this.dataKrjimit = dataKrjimit;
	}

}
