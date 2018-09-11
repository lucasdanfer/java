package br.com.lucasdanfer.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.lucasdanfer.springmvc.dao.ProdutoDAO;
import br.com.lucasdanfer.springmvc.model.Produto;

@Controller
public class HomeController {

    @Autowired
    private ProdutoDAO produtoDao;

    @RequestMapping("/")
    @Cacheable(value="produtosHome")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("home");
        List<Produto> produtos = produtoDao.listar();
        modelAndView.addObject("produtos",produtos);
        return modelAndView;
    }

}
