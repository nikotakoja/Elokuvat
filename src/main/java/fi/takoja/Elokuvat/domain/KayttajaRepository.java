package fi.takoja.Elokuvat.domain;

import org.springframework.data.repository.CrudRepository;

public interface KayttajaRepository extends CrudRepository <Kayttaja, Long> {

	Kayttaja findByKayttajanimi(String kayttajanimi);
	
}
