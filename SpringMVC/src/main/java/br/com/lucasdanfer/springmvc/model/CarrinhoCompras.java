package br.com.lucasdanfer.springmvc.model;

import static org.springframework.context.annotation.ScopedProxyMode.TARGET_CLASS;
import static org.springframework.web.context.WebApplicationContext.SCOPE_SESSION;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value=SCOPE_SESSION, proxyMode=TARGET_CLASS)
public class CarrinhoCompras implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Map<CarrinhoItem, Integer> itens = new LinkedHashMap<>();

    public void add(CarrinhoItem item) {
        itens.put(item, getQuantidade(item) + 1);
    }
    
    public void remover(Integer produtoId, TipoPreco tipoPreco) {
        Produto produto = new Produto();
        produto.setId(produtoId);
        itens.remove(new CarrinhoItem(produto, tipoPreco));
    }
    
    public int getQuantidade() {
        return itens.values().stream()
            .reduce(0, (proximo, acumulador) -> proximo + acumulador);
    }

    public Integer getQuantidade(CarrinhoItem item) {
        if(!itens.containsKey(item)) {
            itens.put(item, 0);
        }
        return itens.get(item);
    }
    
    public Collection<CarrinhoItem> getItens() {
        return itens.keySet();
    }
    
    public BigDecimal getTotal(){
        BigDecimal total = BigDecimal.ZERO;
        for (CarrinhoItem item : itens.keySet()) {
            total = total.add(getTotal(item));
        }
        return total;
    }
    
    public BigDecimal getTotal(CarrinhoItem item){
        return item.getTotal(getQuantidade(item));
    }

}