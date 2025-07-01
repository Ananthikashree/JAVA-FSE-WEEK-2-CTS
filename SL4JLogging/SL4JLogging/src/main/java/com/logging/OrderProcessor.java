package com.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderProcessor {
    private static final Logger logger = LoggerFactory.getLogger(OrderProcessor.class);

    public void processOrder(String orderId) {
        logger.info("Starting processing for order: {}", orderId);

        if (orderId == null || orderId.isEmpty()) {
            logger.error("Order ID is missing!");
            return;
        }

        if (orderId.length() < 5) {
            logger.warn("Order ID is shorter than expected: {}", orderId);
        }

        // simulate business logic
        logger.debug("Checking inventory for order: {}", orderId);
        logger.info("Order {} processed successfully", orderId);
    }

    public static void main(String[] args) {
        OrderProcessor processor = new OrderProcessor();
        processor.processOrder("ORD001");
        processor.processOrder(""); // error
        processor.processOrder("123"); // warning
    }
}