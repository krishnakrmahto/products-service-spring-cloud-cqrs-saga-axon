package com.sampleprojects.ecommercestore.productservice.command.config;

import com.sampleprojects.ecommercestore.productservice.command.interceptor.CreateProductCommandDispatchInterceptor;
import org.axonframework.commandhandling.CommandBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {

  @Autowired
  public void registerInterceptor(CommandBus commandBus,
      CreateProductCommandDispatchInterceptor createProductCommandDispatchInterceptor) {

    commandBus.registerDispatchInterceptor(createProductCommandDispatchInterceptor);
  }
}
