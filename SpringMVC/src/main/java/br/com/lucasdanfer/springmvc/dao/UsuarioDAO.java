package br.com.lucasdanfer.springmvc.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.lucasdanfer.springmvc.model.Role;
import br.com.lucasdanfer.springmvc.model.Usuario;

@Component
public class UsuarioDAO implements UserDetailsService {

    public UserDetails loadUserByUsername(String email) {
        List<Usuario> usuarios = getUserBy(email);

        if(usuarios.isEmpty()) {
            throw new UsernameNotFoundException("Usuário " + email + " não foi encontrado");
        }

        return usuarios.get(0);
    }

    private List<Usuario> getUserBy(String email) {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(user());
        return usuarios;
    }

    private Usuario user() {
        Usuario usuario = new Usuario();
        usuario.setEmail("lucas.danfer@gmail.com");
        usuario.setNome("Lucas Daniel");
        usuario.setSenha("$2a$10$FQbdmgTkBbNbjb0ZkvGRj.8qH.bY5Le9ozgfuGschqR1c.wiiwmwG");
        usuario.setRoles(roles());
        return usuario;
    }

    private List<Role> roles() {
        List<Role> roles = new ArrayList<>();
        roles.add(admin());
        return roles;
    }

    private Role admin() {
        Role role = new Role();
        role.setNome("ROLE_ADMIN");
        return role;
    }
}