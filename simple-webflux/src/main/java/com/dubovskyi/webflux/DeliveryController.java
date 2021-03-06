package com.dubovskyi.webflux;


import com.dubovskyi.webflux.service.UuidCalculateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryController {

   private final UuidCalculateService calculateService;

    public DeliveryController(UuidCalculateService calculateService) {
        this.calculateService = calculateService;
    }

    @GetMapping("/delivery")
    public String getDelivery(){

        return calculateService.calculates();
    }




}
