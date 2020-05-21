package by.epam.dietmanager.services;

import by.epam.dietmanager.repos.ClientRepository;
import by.epam.dietmanager.repos.NutritionistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private ClientRepository clientRepo;
    @Autowired
    private NutritionistRepository nutrRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDetails usr = nutrRepo.findByEmail(email) == null ? clientRepo.findByEmail(email) : nutrRepo.findByEmail(email);
        if (usr != null) return usr;
        else throw new UsernameNotFoundException(email);
    }
}
