package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;
import web.service.CarServiceImpl;

@Controller
public class CarController {

    private final CarService carService = new CarServiceImpl();

    @GetMapping(value = "/cars")
    public String printAmountOfCars(
            @RequestParam(value = "count", required = false) Integer count,
            ModelMap model) {
        if (count == null || count >= 5){
            model.addAttribute("cars", carService.getAllCars());
        } else {
            model.addAttribute("cars", carService.getCars(count));
        }

        return "cars";
    }
}
