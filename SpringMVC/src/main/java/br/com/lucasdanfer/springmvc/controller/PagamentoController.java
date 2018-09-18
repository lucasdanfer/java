package br.com.lucasdanfer.springmvc.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.lucasdanfer.springmvc.model.CarrinhoCompras;
import br.com.lucasdanfer.springmvc.model.DadosPagamento;
import br.com.lucasdanfer.springmvc.model.Usuario;

@RequestMapping("/pagamento")
@Controller
public class PagamentoController {
    
    @Autowired
    CarrinhoCompras carrinho;
    
    @Autowired
    RestTemplate restTemplate;
    
    @Autowired
    private MailSender sender;
    
    @RequestMapping(value="/finalizar", method=POST)
    public Callable<ModelAndView> finalizar(@AuthenticationPrincipal Usuario usuario, RedirectAttributes model){
        return () -> {
            try {
                String uri = "http://book-payment.herokuapp.com/payment";
                String response = restTemplate.postForObject(uri, new DadosPagamento(carrinho.getTotal()), String.class);
                
                //enviaEmailCompraProduto(usuario);
                
                model.addFlashAttribute("message", response);
                System.out.println(response);
                return new ModelAndView("redirect:/produtos");
            } catch (HttpClientErrorException e) {
                e.printStackTrace();
                model.addFlashAttribute("message", "Valor maior que o permitido");
                return new ModelAndView("redirect:/produtos");
            }
        };
    }
    
    @SuppressWarnings("unused") // COMENTADO POIS GMAIL BLOQUEIA
    private void enviaEmailCompraProduto(Usuario usuario) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setSubject("Compra finalizada com sucesso");
        email.setTo(usuario.getEmail());
        email.setText("Compra aprovada com sucesso no valor de " + carrinho.getTotal());
        email.setFrom("lucas.danfer@gmail.com");
        
        sender.send(email);
    }
    
}