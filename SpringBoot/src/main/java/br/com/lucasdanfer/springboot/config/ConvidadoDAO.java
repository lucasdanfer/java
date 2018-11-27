package br.com.lucasdanfer.springboot.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.lucasdanfer.springboot.model.Convidado;

@Component
public class ConvidadoDAO {
    
    private List<Convidado> database = new ArrayList<Convidado>();
    
    public ConvidadoDAO() {
        save(new Convidado("Lucas Daniel Ferreira", "lucas.danfer@gmail.com", "11998945594"));
        save(new Convidado("Cerginho da Pereira Nunes", "cerginho@gmail.com", "11998945592"));
        save(new Convidado("Rogerinho do Ingá", "rogerinho@gmail.com", "11998945593"));
    }
    
    public Iterable<Convidado> findAll(){
        return this.database;
    }
    
    public void save(Convidado convidado) {
        convidado.setId(nextID());
        this.database.add(convidado);
    }
    
    public Long nextID(){
        return new Long(this.database.size()+1);
    }

}
