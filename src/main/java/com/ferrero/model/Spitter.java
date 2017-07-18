package com.ferrero.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by drugo on 19/05/2017.
 */
@Entity
@Table(name = "spitter")
/*
    This makes it possible to use a Spitter object to represent a user in Spring Security.
    The getAuthorities() method is overridden to always grant users READER authority.
*/
public class Spitter  implements UserDetails, Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    private String first_name;

    private String last_name;

    private String email;

    /*
     In a larger application, the authorities granted to a user might themselves be entities
     and be maintained in a separate database table.
    */
    private ArrayList<GrantedAuthority> authorities;

    /*Il Costruttore vuoto serve per il converter "MappingJackson2HttpMessageConverter" a trasforamre i dati in
    * formato JSON che sono stati forniti nell'oggetto Spitter da memorizzare durante la chiamata REST POST*/
    public Spitter(){
    }

    //Usato per il test (SpitterControllerTest)
    public Spitter(String username, String password, String first_name, String last_name) {
        this(null, username, password, first_name, last_name,null);
    }

    //Usato per il test (SpitterControllerTest)
    public Spitter(Long id, String username, String password, String first_name, String last_name) {
        this(id, username, password, first_name, last_name, null);
    }

    public Spitter(String username, String password, String first_name, String last_name, String email) {
        this(null, username, password, first_name, last_name, email);
    }

    public Spitter(Long id, String username, String password, String first_name, String last_name, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.authorities = new ArrayList<GrantedAuthority>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name= first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name= last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(ArrayList<GrantedAuthority> authorities) {
        this.authorities= authorities;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, "firstName", "lastName", "username", "password", "email");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "firstName", "lastName", "username", "password", "email");
    }

}