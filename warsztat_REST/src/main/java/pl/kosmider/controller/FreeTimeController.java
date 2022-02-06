package pl.kosmider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;

@Controller
public class FreeTimeController {
    @GetMapping("/freeTime")
    @ResponseBody
    public String checkFreeTime() {
        LocalDateTime localDateTime = LocalDateTime.of(2022, Month.JANUARY, 9, 17, 00);
        LocalDateTime now = LocalDateTime.now();
        DayOfWeek dayOfWeek = DayOfWeek.from(localDateTime);
        int hour = localDateTime.getHour();

        if (dayOfWeek.equals(DayOfWeek.SATURDAY) || dayOfWeek.equals(DayOfWeek.SUNDAY)) {
            return "Wolne " + localDateTime;
        } else if (hour >= 9 && hour <= 17) {
            return "Pracuje nie dzwon " + localDateTime;
        } else

            return "Po pracy " + localDateTime;
    }
}

