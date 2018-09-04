package br.com.lucasdanfer.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.ibm.watson.developer_cloud.assistant.v1.Assistant;
import com.ibm.watson.developer_cloud.assistant.v1.model.InputData;
import com.ibm.watson.developer_cloud.assistant.v1.model.MessageOptions;
import com.ibm.watson.developer_cloud.assistant.v1.model.MessageResponse;

@Controller
public class WatsonController {
    
    @Autowired
    RestTemplate restTemplate;
    
    private static final String HOME = "home";
    
    @RequestMapping("/watson")
    public String nasa(){
        
        try {
            
            Assistant service = new Assistant(
                "2018-07-10",
                "2eb807ce-82fd-44c4-82ac-653b99af1f23",
                "e5GQPJhabtub");
            
            //service.setEndPoint("https://gateway-fra.watsonplatform.net/assistant/api");
            
            String workspaceId = "321f8023-8b22-4b11-b068-be1eb2d4c994";

            InputData input = new InputData.Builder("obrigado!").build();

            MessageOptions options = new MessageOptions.Builder(workspaceId)
              .input(input)
              .build();

            MessageResponse response = service.message(options).execute();

            System.out.println(response);
            
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
        }
        
        return HOME;
    }

}
