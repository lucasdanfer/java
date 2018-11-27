package br.com.lucasdanfer.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucasdanfer.springboot.model.Convidado;

@Service
public class ConvidadoService {
    
    @Autowired
    private ConvidadoDAO repository;


    public Iterable<Convidado> obterTodos(){
        Iterable<Convidado> convidados = repository.findAll();
        return convidados;
    }

    public void salvar(Convidado convidado){
        repository.save(convidado);
    }

}
