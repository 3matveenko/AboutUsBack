package kz.fe.aboutUs.controller;

import kz.fe.aboutUs.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Controller
public class MainController {

    @Autowired
    MainService mainService;

    @GetMapping(value = "/")
    public String index(Model model){
        model.addAttribute("date1", LocalDate.now());
        model.addAttribute("date2", LocalDate.now());
        model.addAttribute("clickCount", mainService.getClickCountByDate(LocalDate.now(), LocalDate.now()));
        return "index";
    }

    @PostMapping(value = "/between_date")
    public String index2(
            Model model,
            @RequestParam("date1") LocalDate date1String,
            @RequestParam("date2") LocalDate date2String) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate localDate1 = LocalDate.parse(date1String, formatter);
//        LocalDate localDate2 = LocalDate.parse(date2String, formatter);
        model.addAttribute("date1", date1String);
        model.addAttribute("date2", date2String);
        model.addAttribute("clickCount", mainService.getClickCountByDate(date1String, date2String));
        return "index";
    }
}
