package com.tfg.server.controller;

import com.tfg.server.domain.Reserva;
import com.tfg.server.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@BasePathAwareController
public class ReservaController {

    @Autowired
    ReservaService reservaService;

    @RequestMapping(value = "/getByDate", method = POST)
    @ResponseBody
    public List<Reserva> getByDate(@RequestBody String date){
        return reservaService.findByDate(date);
    }

    @RequestMapping(value = "/getReservaInseteByDate", method = POST)
    @ResponseBody
    public List<Reserva> getByDateAndInsite(@RequestBody String date){
        return reservaService.findByDateAndInside(date,true);
    }

    @RequestMapping(value = "/getReservaOutsiteByDate", method = POST)
    @ResponseBody
    public List<Reserva> getByDateAndOutsite(@RequestBody String date){
        return reservaService.findByDateAndInside(date,false);
    }

    @RequestMapping(value = "/findBySubIdAndInside",method = POST)
    @ResponseBody
    public List<Reserva> findBySubIdAndInside(@RequestBody String subId){
        return  reservaService.findBySubIdAndInside(subId,true);
    }

    @RequestMapping(value = "/findBySubIdAndOutside",method = POST)
    @ResponseBody
    public List<Reserva> findBySubIdAndOutside(@RequestBody String subId){
        return  reservaService.findBySubIdAndInside(subId,false);
    }



}
