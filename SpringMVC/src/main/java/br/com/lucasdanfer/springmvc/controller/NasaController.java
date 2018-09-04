package br.com.lucasdanfer.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import br.com.lucasdanfer.springmvc.model.Apod;

@Controller
public class NasaController {
    
    @Autowired
    RestTemplate restTemplate;
    
    private static final String HOME = "home";
    
    @RequestMapping("/nasa")
    public String nasa(){
        
        try {
            String uri = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY";
            Apod response = restTemplate.getForObject(uri, Apod.class);
            System.out.println(response.getTitle());
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
        }
        
        return HOME;
    }

}
