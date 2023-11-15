package ge.softlab.distancecalculator.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;


@Getter
@Setter
@Entity
@Table(schema = "public", name = "users")
public class UserDomain implements UserDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="users_seq_generation")
    @SequenceGenerator(name="users_seq_generation", sequenceName="users_id_seq", allocationSize = 1)
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public boolean isAccountNonExpired() {
        return Objects.equals(active, Boolean.TRUE);
    }

    @Override
    public boolean isAccountNonLocked() {
        return Objects.equals(active, Boolean.TRUE);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return Objects.equals(active, Boolean.TRUE);
    }

    @Override
    public boolean isEnabled() {
        return Objects.equals(active, Boolean.TRUE);
    }
}
