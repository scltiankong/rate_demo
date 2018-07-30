package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author scl.BlueOcean
 * @version 1.0
 * @date 2018年07月30 14:09
 * @description
 */
@Component
//@PropertySource(value = {"classpath:rate_config.yml"})
@ConfigurationProperties(prefix = "rate")
public class RateManager {
    private Map<String ,Set<CountryNode>> countryNodes = new HashMap<>();

    public void setCountryNodes(Map<String, Set<CountryNode>> countryNodes) {
        this.countryNodes = countryNodes;
    }

    /*{
        CountryNode USD = new CountryNode("USD",1);
        CountryNode CNY = new CountryNode("CNY",6);
        Set<CountryNode> usdCny = new HashSet<>();
        usdCny.add(USD);
        usdCny.add(CNY);
         countryNodes.put("USD-CNY",usdCny);
    }*/

    public Map<String,CountryNode> getCountryNodes(String from ,String to){
        String key = String.format("%s-%s",from,to);
        Set<CountryNode> countryNods = countryNodes.get(key);
        if (countryNods == null){
            countryNods = countryNodes.get(String.format("%s-%s",to,from));
        }
        if (countryNods != null && !countryNods.isEmpty()){
            Map<String,CountryNode> countryNodeMap = new HashMap<>();
            for (CountryNode countryNode : countryNods) {
                countryNodeMap.put(countryNode.getName(),countryNode);
            }
            return countryNodeMap;
        }
        return null;
    }
}
