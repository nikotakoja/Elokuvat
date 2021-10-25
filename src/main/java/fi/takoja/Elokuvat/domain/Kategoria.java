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
public class Kategoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long kategoriaid;
	private String kategorianimi;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="kategoria")
	private List<Elokuva> elokuvat;
	
	public Kategoria() {};
	
	public Kategoria(long kategoriaid, String kategorianimi, List<Elokuva> elokuvat) {
		super();
		this.kategoriaid = kategoriaid;
		this.kategorianimi = kategorianimi;
		this.elokuvat = elokuvat;
	}
	
	public Kategoria(String kategorianimi) {
		super();
		this.kategorianimi = kategorianimi;
	}

	public long getKategoriaid() {
		return kategoriaid;
	}

	public void setKategoriaid(long kategoriaid) {
		this.kategoriaid = kategoriaid;
	}

	public String getKategorianimi() {
		return kategorianimi;
	}

	public void setKategorianimi(String kategorianimi) {
		this.kategorianimi = kategorianimi;
	}

	public List<Elokuva> getElokuvat() {
		return elokuvat;
	}

	public void setElokuvat(List<Elokuva> elokuvat) {
		this.elokuvat = elokuvat;
	}

	@Override
	public String toString() {
		return "Kategoria [kategoriaid=" + kategoriaid + ", kategorianimi=" + kategorianimi + "]";
	}

	
}
