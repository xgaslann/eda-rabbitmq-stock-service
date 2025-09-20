package com.xgaslan.edarabbitmqstockservice.consumer;

import com.xgaslan.edarabbitmqstockservice.dto.OrderEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderConsumer {

    @RabbitListener(queues = "${rabbitmq.queue.order.name}")
    public void consume(OrderEvent orderEvent)
    {
        log.info("Consuming message: {}", orderEvent);
        // Save order event data to db or process it as needed
        log.info("Message processed successfully for Order ID: {}", orderEvent.getOrder().getOrderId());
    }
}
