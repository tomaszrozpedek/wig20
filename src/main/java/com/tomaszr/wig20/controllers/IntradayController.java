package com.tomaszr.wig20.controllers;

import com.tomaszr.wig20.model.repositories.IntradayRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IntradayController {

    private IntradayRepository intradayRepository;

    public IntradayController(IntradayRepository intradayRepository) {
        this.intradayRepository = intradayRepository;
    }

    @RequestMapping("/intraday")
    public String getIntraday(Model model) {
        model.addAttribute("intradays", intradayRepository.findByName("ALIOR"));
        return ("intraday");
    }
}
