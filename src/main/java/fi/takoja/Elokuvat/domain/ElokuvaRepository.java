package fi.takoja.Elokuvat.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

	public interface ElokuvaRepository extends CrudRepository<Elokuva, Long> {

	    List<Elokuva> findByOtsikko(String otsikko);
	
}
