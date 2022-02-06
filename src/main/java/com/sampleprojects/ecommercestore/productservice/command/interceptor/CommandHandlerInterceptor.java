package com.sampleprojects.ecommercestore.productservice.command.interceptor;

import com.sampleprojects.ecommercestore.productservice.command.CreateProductCommand;
import java.math.BigDecimal;
import java.util.List;
import java.util.function.BiFunction;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.messaging.MessageDispatchInterceptor;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CommandHandlerInterceptor implements MessageDispatchInterceptor<CommandMessage<CreateProductCommand>> {

//  @Override
//  public CommandMessage<CreateProductCommand> handle(CommandMessage<CreateProductCommand> message) {
//    return MessageDispatchInterceptor.super.handle(message);
//  }

  @Override
  public BiFunction<Integer, CommandMessage<CreateProductCommand>, CommandMessage<CreateProductCommand>> handle(
      List<? extends CommandMessage<CreateProductCommand>> list) {
    return (integer, commandMessage) -> {

      CreateProductCommand payload = commandMessage.getPayload();

      log.info("Intercpeted CreateProductCommand command message with payloadType: {}, productId: {}",
          commandMessage.getPayloadType(), payload.getProductId());
      validateBeanProperties(payload);

      return commandMessage;
    };
  }

  private void validateBeanProperties(CreateProductCommand createProductCommand) {
    // Validate createProductCommand
    if (createProductCommand.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
      throw new IllegalArgumentException("Price must be greater than 0");
    }

    if(createProductCommand.getTitle() != null && createProductCommand.getTitle().isBlank()) {
      throw new IllegalArgumentException("Product title cannot be empty");
    }
  }
}
