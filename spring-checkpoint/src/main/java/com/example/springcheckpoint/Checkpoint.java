package com.example.springcheckpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Checkpoint {

    //camelize first letter after underscore
    //still working on enabling OPTIONAL params
    @GetMapping("/camelize")
    public String camelizeText (
            @RequestParam(name = "original", required= true) String original
//            @RequestParam(name = "initial", required = false) Boolean initial
    ) {
        String newText = "";

        for (int i = 0; i < original.length() ; i++){
            if (original.charAt(i) == '_'){
                newText += original.toUpperCase().charAt(i+1);
                i++;
            } else {
                newText += original.charAt(i);
            }
        } //end of for loop

//        if(initial == true) {
//            newText.toUpperCase().charAt(0);
//        }
        return newText;
    }

    //react badword
    //still working getting multiple paramaters
    @GetMapping("/redact")
    public String redactText (
            @RequestParam(name = "original") String original,
            @RequestParam(name = "badWord") String badWord
    ){
        String newOriginal = "";

        if (original.contains(badWord)) {
            String redactString = "*";
            int numberOfAsterisks = badWord.length();
            newOriginal = original.replace(badWord,
                    redactString.repeat(numberOfAsterisks));
        }
        return newOriginal;
    }//end of redact class
}

