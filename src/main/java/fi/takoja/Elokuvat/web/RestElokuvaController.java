package fi.takoja.Elokuvat.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fi.takoja.Elokuvat.domain.Elokuva;
import fi.takoja.Elokuvat.domain.ElokuvaRepository;
import fi.takoja.Elokuvat.domain.KategoriaRepository;

@RestController
public class RestElokuvaController {

	@Autowired
	ElokuvaRepository erepository; 
	@Autowired
	KategoriaRepository krepository;
	
		// Elokuvat tietokannasta
		@GetMapping("/elokuvat")
	    public List<Elokuva> elokuvaListRest(){
			System.out.println("RestElokuvaController: /elokuvat");
	        return (List<Elokuva>) erepository.findAll();
	    }
	
		// Hae elokuva ID:llä
	    @GetMapping("/elokuvat/{id}")
	    public @ResponseBody Optional<Elokuva> findElokuvaRest(@PathVariable("id") Long elokuvaId) {	
	    	return erepository.findById(elokuvaId);
	    }       
	    
	    @PostMapping("/elokuvat")
	    public List<Elokuva> tallennaElokuva(@RequestBody Elokuva elokuva){
	    	System.out.println("RestElokuvaController: tallennaElokuva");
	    	erepository.save(elokuva);
	        return (List<Elokuva>) erepository.findAll();
	    }
}
