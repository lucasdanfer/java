package br.com.lucasdanfer.springmvc.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Produto {

    private int id;
    private String titulo;
    private String descricao;
    private int paginas;
    
    @DateTimeFormat
    private Calendar dataLancamento;
    private String sumarioPath;
    
    private List<Preco> precos = new ArrayList<Preco>();
    
    public Produto() {
        super();
    }

    public Produto(int id, String titulo, String descricao, int paginas, List<Preco> precos) {
        super();
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.paginas = paginas;
        this.dataLancamento = Calendar.getInstance();
        this.sumarioPath = "localhost";
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
    
    public Calendar getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Calendar dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
    
    public String getSumarioPath() {
        return sumarioPath;
    }

    public void setSumarioPath(String sumarioPath) {
        this.sumarioPath = sumarioPath;
    }
    
    public List<Preco> getPrecos() {
        return precos;
    }
    
    public void setPrecos(List<Preco> precos) {
        this.precos = precos;
    }
    
    public BigDecimal precoPara(TipoPreco tipoPreco) {
        return precos.stream().filter(prec -> prec.getTipo().equals(tipoPreco)).findFirst().get().getValor();        
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Produto other = (Produto) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Produto [titulo=" + titulo + ", descricao=" + descricao + ", paginas=" + paginas + "]";
    }
    
}
