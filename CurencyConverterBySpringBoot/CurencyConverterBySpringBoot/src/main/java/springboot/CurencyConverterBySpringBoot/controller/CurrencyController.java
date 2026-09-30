package springboot.CurencyConverterBySpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.CurencyConverterBySpringBoot.dto.CurrencyRequest;
import springboot.CurencyConverterBySpringBoot.entity.CurrencyConverter;
import springboot.CurencyConverterBySpringBoot.service.CurrencyService;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @PostMapping("/convert")
    public CurrencyConverter convertCurrency(
            @RequestBody CurrencyRequest request) {

        return currencyService.converter(
                request.getFromCurrency(),
                request.getToCurrency(),
                request.getAmount()
        );
    }
}