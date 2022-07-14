package com.example.doubleNineX;

import com.example.doubleNineX.domain.calc.PriceCalculator;
import com.example.doubleNineX.domain.calc.PriceEngine;
import com.example.doubleNineX.domain.product.GetProductHandler;
import com.example.doubleNineX.domain.product.ProductService;
import com.example.doubleNineX.domain.product.ProductServiceImpl;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public PriceCalculator getPriceCalculator() {
        return new PriceEngine();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public ProductService getProductService(GetProductHandler getProductHandler,
                                            PriceCalculator priceCalculator) {
        return new ProductServiceImpl(getProductHandler, priceCalculator);
    }

}
