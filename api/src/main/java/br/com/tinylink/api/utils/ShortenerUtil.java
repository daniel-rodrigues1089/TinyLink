package br.com.tinylink.api.utils;

import java.util.Random;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.tinylink.api.models.Link;
import br.com.tinylink.api.service.LinkService;

@Component
public class ShortenerUtil {

    @Autowired
    private LinkService linkService;


    public String shortener(String url){
        try{

            Integer code = generateCode();
            Link newLink = new Link(url, code);
            linkService.add(newLink);
            return "http://localhost:8080/tinylink/"+String.valueOf(code);

        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    private Integer generateCode() {

        Random generator = new Random();
        Integer code;

        do {
            code = generator.nextInt(999999 - 111111 + 1) + 111111;
        } while(!isValidCode(code));

        return code;
    }

    private Boolean isValidCode(Integer code) {
        return linkService.findLinkByCode(code).isEmpty();
    }
}
