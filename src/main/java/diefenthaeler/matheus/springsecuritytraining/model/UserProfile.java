package diefenthaeler.matheus.springsecuritytraining.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_account_id")
    private UserAccount userAccount;

    @ManyToOne
    @JoinColumn(name="profile_id")
    private Profile profile;
}
