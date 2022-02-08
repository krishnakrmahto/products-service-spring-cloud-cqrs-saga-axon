package com.sampleprojects.ecommercestore.productservice.core.config;

import com.sampleprojects.ecommercestore.productservice.core.errorhandling.ProductServiceEventsErrorHandler;
import org.axonframework.config.EventProcessingConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

  @Autowired
  public void configure(EventProcessingConfigurer configurer) {
    configurer.registerListenerInvocationErrorHandler("product-processors",
        configuration -> new ProductServiceEventsErrorHandler());
  }
}
