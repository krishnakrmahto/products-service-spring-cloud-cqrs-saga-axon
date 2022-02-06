package com.sampleprojects.ecommercestore.productservice.command.interceptor;

import com.sampleprojects.ecommercestore.productservice.command.CreateProductCommand;
import java.math.BigDecimal;
import java.util.List;
import java.util.function.BiFunction;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.messaging.MessageDispatchInterceptor;

@Slf4j
public class CreateProductCommandDispatchInterceptor implements MessageDispatchInterceptor<CommandMessage<?>> {


  @Override
  public BiFunction<Integer, CommandMessage<?>, CommandMessage<?>> handle(List<? extends CommandMessage<?>> list) {
    return (i, commandMessage) -> {

      if (CreateProductCommand.class.equals(commandMessage.getPayloadType())) {
        CreateProductCommand payload = (CreateProductCommand) commandMessage.getPayload();
        log.info("Intercepted CreateProductCommand command message with payloadType: {}, productId: {}",
            commandMessage.getPayloadType(), payload.getProductId());
        validateBeanProperties(payload);
      }
      return commandMessage;
    };
  }

  private void validateBeanProperties(CreateProductCommand createProductCommand) {

    if (createProductCommand.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
      throw new IllegalArgumentException("Price must be greater than 0");
    }

    if(createProductCommand.getTitle() != null && createProductCommand.getTitle().isBlank()) {
      throw new IllegalArgumentException("Product title cannot be empty");
    }
  }
}
