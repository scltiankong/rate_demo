package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author scl.BlueOcean
 * @version 1.0
 * @date 2018年07月30 14:02
 * @description
 */
@RestController
public class RateController {
    @Autowired
    private RateManager rateManager;
    @GetMapping("convert/{from}/{to}")
    public RateDto convert(@PathVariable String from ,@PathVariable String to,@RequestParam Double amount){
        Map<String, CountryNode> countryNodes = rateManager.getCountryNodes(from, to);
        if (countryNodes == null){
            return null;
        }
        CountryNode countryFrom = countryNodes.get(from);
        CountryNode countryTo = countryNodes.get(to);
        double rate = countryTo.getProportion()/countryFrom.getProportion();
        return new RateDto(from,to,amount,rate);
    }
    public static void main(String[] args){
        double a = 1;
        double b = 6;
        System.out.println(a/b);
    }
}
