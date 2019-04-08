package com.tomaszr.wig20.controllers;

import com.tomaszr.wig20.model.repositories.IntradayRepository;
import com.tomaszr.wig20.services.IntradayService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IntradayController {

    private IntradayRepository intradayRepository;
    private IntradayService intradayService;

    public IntradayController(IntradayRepository intradayRepository, IntradayService intradayService) {
        this.intradayRepository = intradayRepository;
        this.intradayService = intradayService;
    }

    @RequestMapping("/intraday")
    public String getIntraday(Model model) {
        model.addAttribute("intradays", intradayRepository.findByName("ALIOR"));
        intradayService.getIntraday("ALIOR");
        model.addAttribute("intradaysChart", intradayService.getIntraday("ALIOR"));
        return ("intraday");
    }
}
