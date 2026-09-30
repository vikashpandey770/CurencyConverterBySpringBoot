package springboot.CurencyConverterBySpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.CurencyConverterBySpringBoot.entity.CurrencyConverter;

public interface CurrencyRepository extends JpaRepository<CurrencyConverter,Long> {

	
}
