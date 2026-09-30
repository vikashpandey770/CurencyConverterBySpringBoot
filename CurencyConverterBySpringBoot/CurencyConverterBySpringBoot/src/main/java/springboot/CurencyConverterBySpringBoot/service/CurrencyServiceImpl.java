package springboot.CurencyConverterBySpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import springboot.CurencyConverterBySpringBoot.dto.ExchangeRateResponse;
import springboot.CurencyConverterBySpringBoot.entity.CurrencyConverter;
import springboot.CurencyConverterBySpringBoot.repository.CurrencyRepository;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyRepository repository;

    private final RestClient restClient = RestClient.create();

    @Override
    public CurrencyConverter saveConversion(CurrencyConverter converter) {
        return repository.save(converter);
    }

    @Override
    public CurrencyConverter converter(
            String fromCurrency,
            String toCurrency,
            double amount) {

        String from = fromCurrency.toLowerCase();
        String to = toCurrency.toLowerCase();

        String url = "https://api.frankfurter.dev/v2/rate/"
                + from + "/" + to;

        ExchangeRateResponse response = restClient
                .get()
                .uri(url)
                .retrieve()
                .body(ExchangeRateResponse.class);

        double exchangeRate = response.getRate();

        double convertedAmount = amount * exchangeRate;

        CurrencyConverter conversion = new CurrencyConverter();

        conversion.setFromCurrency(fromCurrency.toUpperCase());
        conversion.setToCurrency(toCurrency.toUpperCase());
        conversion.setAmount(amount);
        conversion.setExchangeRate(exchangeRate);
        conversion.setConvertedAmount(convertedAmount);
        return repository.save(conversion);
    }
}