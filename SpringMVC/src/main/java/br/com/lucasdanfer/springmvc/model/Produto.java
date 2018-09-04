package br.com.lucasdanfer.springmvc.model;

import java.util.List;

public class Produto {

    private int id;
    private String titulo;
    private String descricao;
    private int paginas;
    
    private List<Preco> precos;
    
    public Produto() {
        super();
    }

    public Produto(int id, String titulo, String descricao, int paginas, List<Preco> precos) {
        super();
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.paginas = paginas;
        this.precos = precos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public int getPaginas() {
        return paginas;
    }
    
    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }
    
    public List<Preco> getPrecos() {
        return precos;
    }
    
    public void setPrecos(List<Preco> precos) {
        this.precos = precos;
    }

    @Override
    public String toString() {
        return "Produto [titulo=" + titulo + ", descricao=" + descricao + ", paginas=" + paginas + "]";
    }
    
}
