package fi.takoja.Elokuvat.web;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fi.takoja.Elokuvat.domain.Elokuva;
import fi.takoja.Elokuvat.domain.ElokuvaRepository;
import fi.takoja.Elokuvat.domain.Formaatti;
import fi.takoja.Elokuvat.domain.FormaattiRepository;
import fi.takoja.Elokuvat.domain.Kategoria;
import fi.takoja.Elokuvat.domain.KategoriaRepository;

@Controller
public class ElokuvaController {
	
	@Autowired
	private ElokuvaRepository erepository; 
	@Autowired
	private KategoriaRepository krepository;
	@Autowired
	private FormaattiRepository frepository;
	
	@GetMapping({"/index","/"})
	public String elokuvaListaus(Model model) {
		model.addAttribute("elokuvat", erepository.findAll());
		return "/elokuvalistaus";	
	}
	
    @GetMapping("/lisaa")
    public String lisaaElokuva(Model model){
    	model.addAttribute("elokuva", new Elokuva());
    	model.addAttribute("luokat", krepository.findAll());
    	model.addAttribute("formaatit", frepository.findAll());
        return "/lisaaelokuva";
    }
        
	@PostMapping("/tallenna")
    public String tallennaElokuva(Elokuva elokuva){
        erepository.save(elokuva);
        return "redirect:/index";
    }
	
    @GetMapping("/muokkaa/{id}")
    public String muokkaaElokuva(@PathVariable("id") Long elokuvaId, Model model){
    	Elokuva elokuva= erepository.findById(elokuvaId)
    			.orElseThrow(() -> new IllegalArgumentException("Väärä elokuva ID:" + elokuvaId));
    	model.addAttribute("elokuva", elokuva);
    	model.addAttribute("luokat", krepository.findAll());
    	model.addAttribute("formaatit", frepository.findAll());
        return "/muokkaaelokuvaa";
    }
    
    @PostMapping("/muokkaa/{id}")
    public String paivitaElokuva(@PathVariable("id") long id, @Valid Elokuva elokuva, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	elokuva.setId(id);
            return "/muokkaaelokuvaa";
        }            
        erepository.save(elokuva);
        return "redirect:/index";
    }
	
    @GetMapping("/poista/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String poistaElokuva(@PathVariable("id") Long elokuvaId, Model model) {
    	erepository.deleteById(elokuvaId);
        return "redirect:/index";
    }
	
	// Kategoriahallinta
    
	@GetMapping("/kategorialistaus")
	public String kategoriaListaus(Model model) {
		model.addAttribute("kategoria", krepository.findAll());
		return "/kategorialistaus";	
	}
	
    @GetMapping("/klisaa")
    public String lisaaKategoria(Model model){
    	model.addAttribute("kategoria", new Kategoria());
    	return "/lisaakategoria";
    }
	
	@PostMapping("/ktallenna")
    public String tallennaKategoria(Kategoria kategoria){
        krepository.save(kategoria);
        return "/kategorialistaus";
    }
	
    @GetMapping("/kpoista/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String poistaKategoria(@PathVariable("id") Long kategoriaId, Model model) {
    	erepository.deleteById(kategoriaId);
        return "redirect:/index";
    }
    
    @GetMapping("/kmuokkaa/{id}")
    public String muokkaaKategoriaa(@PathVariable("id") Long kategoriaId, Model model){
    	Kategoria kategoria= krepository.findById(kategoriaId)
    			.orElseThrow(() -> new IllegalArgumentException("Väärä kategoria ID:" + kategoriaId));
    	model.addAttribute("kategoria", kategoria);
        return "/muokkaakategoria";
    }
    
    @PostMapping("/kmuokkaa/{id}")
    public String paivitaKategoria(@PathVariable("id") long kategoriaId, @Valid Kategoria kategoria, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	kategoria.setKategoriaid(kategoriaId);
            return "/muokkaakategoria";
        }            
        krepository.save(kategoria);
        return "/kategorialistaus";
    }
    
    // Formaattihallinta
    
	@GetMapping("/formaattilistaus")
	public String formaattiListaus(Model model) {
		model.addAttribute("formaatti", frepository.findAll());
		return "/formaattilistaus";	
	}
	
    @GetMapping("/flisaa")
    public String lisaaFormaatti(Model model){
    	model.addAttribute("formaatti", new Formaatti());
    	return "/lisaaformaatti";
    }
	
	@PostMapping("/ftallenna")
    public String tallennaFormaatti(Formaatti formaatti){
        frepository.save(formaatti);
        return "/formaattilistaus";
    }
	
    @GetMapping("/fpoista/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String poistaFormaatti(@PathVariable("id") Long formaattiId, Model model) {
    	erepository.deleteById(formaattiId);
        return "/formaattilistaus";
    }
    
    @GetMapping("/fmuokkaa/{id}")
    public String muokkaaFormaatti(@PathVariable("id") Long formaattiId, Model model){
    	Formaatti formaatti= frepository.findById(formaattiId)
    			.orElseThrow(() -> new IllegalArgumentException("Väärä formaatti ID:" + formaattiId));
    	model.addAttribute("formaatti", formaatti);
        return "/muokkaaformaatti";
    }
    
    @PostMapping("/fmuokkaa/{id}")
    public String paivitaFormaatti(@PathVariable("id") long formaattiId, @Valid Formaatti formaatti, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	formaatti.setFormaattiid(formaattiId);
            return "/muokkaaformaatti";
        }            
        frepository.save(formaatti);
        return "/formaattilistaus";
    }
	
//	@PostMapping("/profile-picture")
//    public ResponseEntity uploadImage(@RequestParam("file") MultipartFile imageFile, @ModelAttribute UserDTO requestDto) {
//     try {
//          UserDTO created  =userDetailsService.saveImg(requestDto, file.getBytes());
//          return new ResponseEntity<>(created, HttpStatus.OK);
//
//    } catch (IOException e) {
//        // TODO Auto-generated catch block
//        e.printStackTrace();
//    }    
//    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//}
    


}