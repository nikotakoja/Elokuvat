package fi.takoja.Elokuvat.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Formaatti {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long formaattiid;
	private String formaattinimi;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="formaatti")
	private List<Elokuva> elokuvat;
	
	public Formaatti() {};
	
	public Formaatti(String formaattinimi) {
		super();
		this.formaattinimi = formaattinimi;
	}

	public Formaatti(long formaattiid, String formaattinimi) {
		super();
		this.formaattiid = formaattiid;
		this.formaattinimi = formaattinimi;
	}
	
	public Formaatti(long formaattiid, String formaattinimi, List<Elokuva> elokuvat) {
		super();
		this.formaattiid = formaattiid;
		this.formaattinimi = formaattinimi;
		this.elokuvat = elokuvat;
	}
	
	
	public List<Elokuva> getElokuvat() {
		return elokuvat;
	}

	public void setElokuvat(List<Elokuva> elokuvat) {
		this.elokuvat = elokuvat;
	}

	public long getFormaattiid() {
		return formaattiid;
	}

	public void setFormaattiid(long formaattiid) {
		this.formaattiid = formaattiid;
	}

	public String getFormaattinimi() {
		return formaattinimi;
	}

	public void setFormaattinimi(String formaattinimi) {
		this.formaattinimi = formaattinimi;
	}

	@Override
	public String toString() {
		return "Formaatti [formaattiid=" + formaattiid + ", formaattinimi=" + formaattinimi + "]";
	}

	

	
	
}
