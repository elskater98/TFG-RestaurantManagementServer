package com.tfg.server.controller;

import com.tfg.server.domain.Menjar;
import com.tfg.server.domain.Producte;
import com.tfg.server.repository.MenjarRepository;
import com.tfg.server.repository.ProducteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;


import static org.springframework.web.bind.annotation.RequestMethod.GET;


@BasePathAwareController
public class InventariController {

    @Autowired
    MenjarRepository menjarRepository;

    @Autowired
    ProducteRepository producteRepository;

    @RequestMapping(value = "/getMenjars", method = GET)
    @ResponseBody
    public ArrayList<Menjar> getMenjars(){

        for (Menjar m: menjarRepository.findAll()) {
            if(m.getIngredients()!=null){
                for (Producte producte: m.getIngredients()) {
                    if(!producte.getActive()){
                        m.setEnable(false);
                        menjarRepository.save(m);
                        break;
                    }else{
                        m.setEnable(true);
                        menjarRepository.save(m);
                    }
                }
            }
        }
        return menjarRepository.findAllByOrderByNameAsc();
    }

    @RequestMapping(value = "/getProducts", method = GET)
    @ResponseBody
    public ArrayList<Producte> getProductes(){
        return producteRepository.findAllByOrderByNameAsc();
    }
}
