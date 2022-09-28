package diefenthaeler.matheus.springsecuritytraining.service;

import diefenthaeler.matheus.springsecuritytraining.model.UserAccount;
import diefenthaeler.matheus.springsecuritytraining.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserAccountService implements UserDetailsService {

    private final UserAccountRepository repository;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount userAccount = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found!"));
        return userAccount.getUserDetails();
    }
}
