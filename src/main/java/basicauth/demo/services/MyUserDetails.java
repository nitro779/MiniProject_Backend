package basicauth.demo.services;

import basicauth.demo.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {
    private String username;
    private String password;
    private List<SimpleGrantedAuthority> authority;
    public MyUserDetails(User user){
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.authority = Arrays.asList(new SimpleGrantedAuthority[]{new SimpleGrantedAuthority("ROLE_USER")});
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authority;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
