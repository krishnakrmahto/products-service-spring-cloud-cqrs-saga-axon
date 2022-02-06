package com.sampleprojects.ecommercestore.productservice.command.interceptor;

import com.sampleprojects.ecommercestore.productservice.command.CreateProductCommand;
import com.sampleprojects.ecommercestore.productservice.command.consistencyvalidation.repository.ProductLookupRepository;
import java.util.List;
import java.util.function.BiFunction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.messaging.MessageDispatchInterceptor;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class CreateProductCommandDispatchInterceptor implements MessageDispatchInterceptor<CommandMessage<?>> {

  private final ProductLookupRepository productLookupRepository;

  @Override
  public BiFunction<Integer, CommandMessage<?>, CommandMessage<?>> handle(List<? extends CommandMessage<?>> list) {
    return (i, commandMessage) -> {

      if (CreateProductCommand.class.equals(commandMessage.getPayloadType())) {

        CreateProductCommand createProductCommand = (CreateProductCommand) commandMessage.getPayload();
        String productId = createProductCommand.getProductId();
        String productTitle = createProductCommand.getTitle();

        log.info("Intercepted CreateProductCommand command message with payloadType: {}, productId: {}",
            commandMessage.getPayloadType(), productId);

        if(productLookupRepository.findByProductIdOrTitle(productId, productTitle).isPresent()) {
          throw new IllegalStateException("Product with title " + productTitle + " already exists");
        }
      }
      return commandMessage;
    };
  }
}
