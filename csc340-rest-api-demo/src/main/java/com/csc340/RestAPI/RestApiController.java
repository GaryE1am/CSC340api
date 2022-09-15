package com.csc340.RestAPI;


import org.json.JSONObject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author sentini
 */
@RestController
public class RestApiController {

    

    /**
     * Generate a random name.
     *
     * @return
     */
    @GetMapping("/User")
    public Object getQuote() {
        String url = "https://randomuser.me/api/";
        RestTemplate restTemplate = new RestTemplate();
        Object jSonUser = restTemplate.getForObject(url, Object.class);

        //Print the whole response to console.
        String quote = restTemplate.getForObject(url, String.class);
        //Parse out the most important info from the response.
        JSONObject jo = new JSONObject(quote);
        
        String quoteFirst = jo.getString("first");
        String quoteLast = jo.getString("last");
        System.out.println(quoteFirst);
        System.out.println(quoteLast);

        return jSonUser;
    }
}
