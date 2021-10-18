package fi.takoja.Elokuvat.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FormaattiRepository extends CrudRepository<Formaatti, Long> {

    List<Formaatti> findByFormaattinimi(String formaattinimi);

}