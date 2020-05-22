package by.epam.dietmanager.services;

import by.epam.dietmanager.repos.ClientRepository;
import by.epam.dietmanager.repos.NutritionistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private  ClientRepository clientRepository;
    @Autowired
    private NutritionistRepository nutrRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDetails usr = nutrRepository.findByEmail(email) == null ? clientRepository.findByEmail(email) : nutrRepository.findByEmail(email);
        if (usr != null) return usr;
        else throw new UsernameNotFoundException(email);
    }
    
    public boolean validateForEmailDuplicates(String email, Integer id){
        var client = Optional.ofNullable(clientRepository.findByEmail(email));
        var nutritionist = Optional.ofNullable(nutrRepository.findByEmail(email));
        if(client.isPresent()){
            return id.equals(client.get().getId());
        }
        else if(nutritionist.isPresent()){
            return id.equals(nutritionist.get().getId());
        }
        else return true;
    }
}
