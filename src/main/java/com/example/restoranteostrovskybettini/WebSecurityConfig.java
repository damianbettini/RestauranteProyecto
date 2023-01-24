package com.example.restoranteostrovskybettini;

import com.example.restoranteostrovskybettini.Interface.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import org.springframework.web.bind.annotation.PathVariable;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    String[] resources = new String[]{
            "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"
    };
    @Autowired
    private UsuarioService usuarioService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



        @Bean
        protected SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .authorizeHttpRequests((authz)-> {
                        try {
                            authz
                                    .requestMatchers(resources).permitAll()
                                    .requestMatchers("/login").permitAll()
                                    .requestMatchers("/menu").permitAll()
                                    .requestMatchers("/registro").permitAll()
                                    .requestMatchers("/bienvenido").permitAll()
                                    .requestMatchers("/bebidas").permitAll()
                                    .requestMatchers("/bebidas/nueva").permitAll()
                                    .requestMatchers("/bebidas/editar/{id}").permitAll()
                                    .requestMatchers("/comidas").permitAll()
                                    .requestMatchers("/comidas/nueva").permitAll()
                                    .requestMatchers("/comidas/editar/{id}").permitAll()
                                    .requestMatchers("/comidas/{id}").permitAll()
                                    .requestMatchers("/bebidas/{id}").permitAll()
                                    .anyRequest().authenticated().
                                    and().
                                    formLogin().
                                    loginPage("/login").

                                    and().
                                    httpBasic();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }).httpBasic(withDefaults());

            return http.build();
        }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(usuarioService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

   /* @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager user = new InMemoryUserDetailsManager();
        user.createUser(User.withUsername("sharon")
                .password(passwordEncoder().encode("12345"))
                .roles("user")
                .build());

        return user;
    }*/



}
