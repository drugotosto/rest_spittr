/**
 * Created by drugo on 30/06/2017.
 **/

package com.ferrero.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    /*
    Specifies that requests for “/” (which ReadingListController’s methods are mapped to)
    require an authenticated user with the READER role. All other request paths are
    configured for open access to all users.
    It also designates /login as the path for the login page as well as the login
    failure page (along with an error attribute).
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
//                .anyRequest().permitAll()

                .antMatchers("/").authenticated()
//                .access("hasRole('READER')")
                .antMatchers("/**").permitAll()
            .and()
                .httpBasic()

            .and()
                .csrf().disable();
    }

    /*
    Versione che fa uso di un bean della classe "userDetailsService" per meglio customizzare
    il servizio di autenticazione degli utenti attraverso apposito data store.
  */
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth
            .authenticationProvider(authProvider());
    }

    /*
        - We are injecting our implementation of the users details service
        - We are defining an authentication provider that references our details service
        - We are also enabling the password encoder
    */
    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        /*
            To use SpitterUserService to authenticate users, you can configure it in your security
            configuration with the "setUserDetailsService()" method.
            The userDetailsService() method (like jdbcAuthentication(), ldapAuthentication, and inMemoryAuthentication())
            configures a configuration store. But instead of using one of Spring’s provided user stores,
            it takes any implementation of "UserDetailsService".
         */
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    // Bean che viene utilizzato per decifrare la password scelta/inserita dall'utente.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new StandardPasswordEncoder();
    }

}
