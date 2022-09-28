package diefenthaeler.matheus.springsecuritytraining.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private Boolean accountNonExpired = true;

    private Boolean accountNonLocked = true;

    private Boolean credentialsNonExpired = true;

    private Boolean enabled = true;

    @OneToMany(mappedBy = "userAccount")
    private Set<UserProfile> userProfiles;
    public UserDetails getUserDetails(){
        UserDetails user = new User(getUsername(), getPassword(), getEnabled(),
                getAccountNonExpired(), getCredentialsNonExpired(),
                getAccountNonLocked(), convertToAuthorities());
        return user;
    }

    private Set<? extends GrantedAuthority> convertToAuthorities() {
        if(CollectionUtils.isEmpty(userProfiles)) {
            return Collections.emptySet();
        }

        return userProfiles.stream()
                .map(UserProfile::getProfile)
                .map(Profile::getPermission)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }
}
