package br.com.lucasdanfer.springmvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.lucasdanfer.springmvc.dao.UsuarioDAO;

@EnableWebSecurity 
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private UsuarioDAO usuarioDao;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/produtos/form").hasRole("ADMIN")
            .antMatchers("/carrinho/**").permitAll()        
            .antMatchers("/produtos/").hasRole("ADMIN")
            .antMatchers("/produtos/**").permitAll()
            .antMatchers("/resources/**").permitAll()
            .antMatchers("/pagamento/**").permitAll()
            .antMatchers("/").permitAll()
            .anyRequest().authenticated()
            .and().formLogin().loginPage("/login")
            .defaultSuccessUrl("/produtos").permitAll()
            .and().logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .permitAll().logoutSuccessUrl("/login");    
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) 
            throws Exception {

        auth.userDetailsService(usuarioDao)
            .passwordEncoder(new BCryptPasswordEncoder());
    }

}
