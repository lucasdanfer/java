package br.com.lucasdanfer.springmvc.model;

import static org.springframework.web.context.WebApplicationContext.SCOPE_SESSION;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value=SCOPE_SESSION)
public class CarrinhoCompras {

    private Map<CarrinhoItem, Integer> itens = new LinkedHashMap<>();

    public void add(CarrinhoItem item) {
        itens.put(item, getQuantidade(item) + 1);
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

}