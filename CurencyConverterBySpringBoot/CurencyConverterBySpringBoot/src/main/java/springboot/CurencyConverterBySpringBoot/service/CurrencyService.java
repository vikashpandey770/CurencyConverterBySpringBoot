package springboot.CurencyConverterBySpringBoot.service;

import springboot.CurencyConverterBySpringBoot.entity.CurrencyConverter;

public interface CurrencyService {

	CurrencyConverter saveConversion(CurrencyConverter converter);

	CurrencyConverter converter(String fromCurrency,String toCurrency, double amount);

}
