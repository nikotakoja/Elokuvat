package fi.takoja.Elokuvat.domain;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Elokuva {
		
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String otsikko, ohjaaja, imdb;
	private int vuosi;
		
	@ManyToOne
	@JoinColumn(name="kategoriaid")
	private Kategoria kategoria;
	
	@ManyToOne
	@JoinColumn(name="formaattiid")
	private Formaatti formaatti;
	
//	@Lob
//	private byte[] tiedosto;
	
	public Elokuva() {}
		
	public Elokuva(Kategoria kategoria) {
		super();
		this.kategoria = kategoria;
	}
	
	public Elokuva(Formaatti formaatti) {
		super();
		this.formaatti = formaatti;
	}

	public Elokuva(String otsikko, String ohjaaja, Kategoria kategoria, String imdb, int vuosi, Formaatti formaatti) {
		super();
		this.otsikko = otsikko;
		this.ohjaaja = ohjaaja;
		this.kategoria = kategoria;
		this.imdb = imdb;
		this.vuosi = vuosi;
		this.formaatti = formaatti;
	}
	
//	public Elokuva(String otsikko, String ohjaaja, Kategoria kategoria, String imdb, int vuosi, Formaatti formaatti, byte[] tiedosto) {
//		super();
//		this.otsikko = otsikko;
//		this.ohjaaja = ohjaaja;
//		this.kategoria = kategoria;
//		this.imdb = imdb;
//		this.vuosi = vuosi;
//		this.formaatti = formaatti;
//		this.tiedosto = tiedosto;
//	}
	
//	public byte[] getTiedosto() {
//		return tiedosto;
//	}
//
//	public void setTiedosto(byte[] tiedosto) {
//		this.tiedosto = tiedosto;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOtsikko() {
		return otsikko;
	}

	public void setOtsikko(String otsikko) {
		this.otsikko = otsikko;
	}

	public String getOhjaaja() {
		return ohjaaja;
	}

	public void setOhjaaja(String ohjaaja) {
		this.ohjaaja = ohjaaja;
	}

	public String getImdb() {
		return imdb;
	}

	public void setImdb(String imdb) {
		this.imdb = imdb;
	}

	public int getVuosi() {
		return vuosi;
	}

	public void setVuosi(int vuosi) {
		this.vuosi = vuosi;
	}

	public Kategoria getKategoria() {
		return kategoria;
	}

	public void setKategoria(Kategoria kategoria) {
		this.kategoria = kategoria;
	}

	public Formaatti getFormaatti() {
		return formaatti;
	}

	public void setFormaatti(Formaatti formaatti) {
		this.formaatti = formaatti;
	}

	@Override
	public String toString() {
		return "Elokuva [id=" + id + ", otsikko=" + otsikko + ", ohjaaja=" + ohjaaja + ", imdb=" + imdb + ", vuosi="
				+ vuosi + ", kategoria=" + kategoria + ", formaatti=" + formaatti + "]";
	}

//	@Override
//	public String toString() {
//		return "Elokuva [id=" + id + ", otsikko=" + otsikko + ", ohjaaja=" + ohjaaja + ", imdb=" + imdb + ", vuosi="
//				+ vuosi + ", kategoria=" + kategoria + ", formaatti=" + formaatti + ", tiedosto="
//				+ Arrays.toString(tiedosto) + "]";
//	}
	


	
}
