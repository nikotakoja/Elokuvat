package fi.takoja.Elokuvat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fi.takoja.Elokuvat.domain.Kayttaja;
import fi.takoja.Elokuvat.domain.KayttajaRepository;


/**
 * This class is used by spring security to authenticate and authorize user
 **/
@Service
public class UserDetailServiceImpl implements UserDetailsService  {
	private final KayttajaRepository repository;

	@Autowired
	public UserDetailServiceImpl(KayttajaRepository KayttajaRepository) {
		this.repository = KayttajaRepository;
	}

    @Override
    public UserDetails loadUserByUsername(String kayttajanimi) throws UsernameNotFoundException
    {   
    	Kayttaja curruser = repository.findByKayttajanimi(kayttajanimi);
        UserDetails user = new org.springframework.security.core.userdetails.User(kayttajanimi, curruser.getSalasanaHash(), 
        		AuthorityUtils.createAuthorityList(curruser.getRooli()));
        return user;
    }   
} 
