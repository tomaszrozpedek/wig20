package com.tomaszr.wig20.controllers;

import com.tomaszr.wig20.model.repositories.IntradayRepository;
import com.tomaszr.wig20.services.IntradayService;
import com.tomaszr.wig20.services.IntradayServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IntradayController {

    private IntradayRepository intradayRepository;
    private IntradayServiceImpl intradayService;
    private String shareName;
    private String startDate;
    private String endDate;

    public IntradayController(IntradayRepository intradayRepository, IntradayServiceImpl intradayService) {
        this.intradayRepository = intradayRepository;
        this.intradayService = intradayService;
        shareName = "ALIOR";
        startDate = "20190101";
        endDate = "20190315";
    }

    @GetMapping("/intraday")
    public String getIntraday(Model model) {
        model.addAttribute("shareName", shareName);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("intradaysChart", intradayService.getIntraday(shareName, startDate, endDate));
        System.out.println("getmapping: " + shareName + " " + startDate + " " + endDate);
        return ("intraday");
    }

//    @RequestMapping(params = "drawChart", method = RequestMethod.POST)
//    public String drawChart(@RequestParam("shareName") String shareName,
//                            @RequestParam("startDate") String startDate,
//                            @RequestParam("endDate") String endDate,Model model) {
//        this.shareName=shareName;
//        this.startDate=startDate;
//        this.endDate=endDate;
//        model.addAttribute("intradaysChart", intradayService.getIntraday(shareName,startDate,endDate));
//        System.out.println(shareName+" "+startDate+" "+endDate);
//        System.out.println(intradayService.getIntraday(shareName,startDate,endDate));
//        return "intraday";
//    }

    @PostMapping("/intraday")
    public String drawChart(@RequestParam(value = "shareName") String shareName,
                            @RequestParam(value = "startDate") String startDate,
                            @RequestParam(value = "endDate") String endDate,
                            Model model) {
        this.shareName = shareName;
        this.startDate = startDate;
        this.endDate = endDate;
//        model.addAttribute("intradaysChart", intradayService.getIntraday(shareName, startDate, endDate));
        System.out.println("jestem: " + model);
        return "redirect:intraday";
    }


}
