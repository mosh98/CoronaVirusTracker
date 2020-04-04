package io.coronaTracker.controllers;

import io.coronaTracker.Models.LocationStats;
import io.coronaTracker.services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

   @Autowired
    CoronaVirusDataService cs;

    @GetMapping("/")
        public String home(Model model){

        List<LocationStats> allstats = cs.getAllStats();
       int totalReportedCases =  allstats.stream().mapToInt(stat-> stat.getLatestTotalCase() ).sum();


        model.addAttribute("locationStats", allstats);
        model.addAttribute("totalReportedCases", totalReportedCases);



            return "home";
        }


}
