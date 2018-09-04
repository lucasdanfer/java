package br.com.lucasdanfer.springmvc.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.lucasdanfer.springmvc.dao.ProdutoDAO;
import br.com.lucasdanfer.springmvc.model.Produto;
import br.com.lucasdanfer.springmvc.model.TipoPreco;
import br.com.lucasdanfer.springmvc.validation.ProdutoValidation;

@Controller
@RequestMapping("produtos")
public class ProdutosController {
    
    @Autowired
    private ProdutoDAO produtoDAO;
    
    @InitBinder
    public void InitBinder(WebDataBinder binder){
        binder.addValidators(new ProdutoValidation());
    }
    
    @RequestMapping("/form")
    public ModelAndView form(){
        ModelAndView modelAndView = new ModelAndView("produtos/form");
        modelAndView.addObject("tipos", TipoPreco.values());
        return modelAndView;
    }
    
    @RequestMapping(method=POST)
    public ModelAndView grava(@Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes){
        System.out.println(produto.toString());
        
        if(result.hasErrors()){
            return form();
        }
        
        produtoDAO.gravar(produto);
        redirectAttributes.addFlashAttribute("sucesso","Produto cadastrado com sucesso!");
        return new ModelAndView("redirect:produtos");
    }
    
    @RequestMapping(method=GET)
    public ModelAndView listar(){
        List<Produto> produtos = produtoDAO.listar();
        ModelAndView modelAndView = new ModelAndView("/produtos/lista");
        modelAndView.addObject("produtos", produtos);
        return modelAndView;
    }

}
