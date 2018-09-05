package br.com.lucasdanfer.springmvc.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.lucasdanfer.springmvc.dao.ProdutoDAO;
import br.com.lucasdanfer.springmvc.model.CarrinhoCompras;
import br.com.lucasdanfer.springmvc.model.CarrinhoItem;
import br.com.lucasdanfer.springmvc.model.Produto;
import br.com.lucasdanfer.springmvc.model.TipoPreco;

@Controller
@RequestMapping("/carrinho")
@Scope(value=SCOPE_REQUEST)
public class CarrinhoComprasController {

    @Autowired
    private ProdutoDAO produtoDao;

    @Autowired
    private CarrinhoCompras carrinho;

    @RequestMapping("/add")
    public ModelAndView add(Integer produtoId, TipoPreco tipoPreco) {

        ModelAndView modelAndView = new ModelAndView("redirect:/carrinho");
        CarrinhoItem carrinhoItem = criaItem(produtoId,tipoPreco);

        carrinho.add(carrinhoItem);

        return modelAndView;   
    }

    private CarrinhoItem criaItem(Integer produtoId, TipoPreco tipoPreco) {

        Produto produto = produtoDao.find(produtoId);
        CarrinhoItem carrinhoItem = new CarrinhoItem(produto, tipoPreco);

        return carrinhoItem;
    }
    
    @RequestMapping(method=GET)
    public ModelAndView itens(){
        return new ModelAndView("/carrinho/itens");
    }
    
    @RequestMapping(value="/remover", method=POST)
    public ModelAndView remover(Integer produtoId, TipoPreco tipoPreco){
        carrinho.remover(produtoId, tipoPreco);
        return new ModelAndView("redirect:/carrinho");
    }
}
