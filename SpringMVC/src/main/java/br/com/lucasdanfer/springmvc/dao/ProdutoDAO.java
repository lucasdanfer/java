package br.com.lucasdanfer.springmvc.dao;

import static br.com.lucasdanfer.springmvc.model.TipoPreco.COMBO;
import static br.com.lucasdanfer.springmvc.model.TipoPreco.EBOOK;
import static br.com.lucasdanfer.springmvc.model.TipoPreco.IMPRESSO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.lucasdanfer.springmvc.model.Preco;
import br.com.lucasdanfer.springmvc.model.Produto;

@Component
public class ProdutoDAO {
    
    private ArrayList<Produto> produtos;
    
    public ProdutoDAO() {
        
        produtos = new ArrayList<Produto>();
        produtos.add(new Produto(1, "Lucas", "Daniel Ferreira", 100, getPrecos()));
        produtos.add(new Produto(2, "Vitória", "Alencar Pereira", 120, getPrecos()));
        produtos.add(new Produto(3, "Lucas", "Yoshioka", 80, getPrecos()));
        
    }

    private ArrayList<Preco> getPrecos() {
        ArrayList<Preco> precos = new ArrayList<Preco>();
        precos.add(new Preco(new BigDecimal(50.0), IMPRESSO));
        precos.add(new Preco(new BigDecimal(40.0), EBOOK));
        precos.add(new Preco(new BigDecimal(70.0), COMBO));
        return precos;
    }
    
    public void gravar(Produto produto){
        System.out.println("GRAVOU");
        produtos.add(produto);
    }
    
    public List<Produto> listar(){
        return produtos;
    }
    
    public Produto find(Integer id) {
        
        for (Produto p: produtos) {
            if (p.getId() == id) {
                return p;
            }
        }
        
        return null;
    }

}
