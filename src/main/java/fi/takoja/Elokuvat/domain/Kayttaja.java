package fi.takoja.Elokuvat.domain;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kayttaja {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
	private Long id;
    
    @Column(name = "kayttajanimi", nullable = false, unique = true)
    private String kayttajanimi;
	
	@Column(name = "salasana", nullable = false)
    private String salasanaHash;
    
    @Column(name = "rooli", nullable = false)
    private String rooli;
    
	public Kayttaja() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKayttajanimi() {
		return kayttajanimi;
	}

	public void setKayttajanimi(String kayttajanimi) {
		this.kayttajanimi = kayttajanimi;
	}

	public String getSalasanaHash() {
		return salasanaHash;
	}

	public void setSalasanaHash(String salasanaHash) {
		this.salasanaHash = salasanaHash;
	}

	public String getRooli() {
		return rooli;
	}

	public void setRooli(String rooli) {
		this.rooli = rooli;
	}

	@Override
	public String toString() {
		return "Kayttaja [id=" + id + ", kayttajanimi=" + kayttajanimi + ", salasanaHash=" + salasanaHash + ", rooli="
				+ rooli + "]";
	}
	
}
