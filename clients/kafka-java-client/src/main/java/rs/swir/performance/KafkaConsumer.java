package io.swir.performance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class KafkaConsumer {
    private final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);


    @Autowired
    AtomicInteger processedCounter;

    @KafkaListener(topics="Response")
    public void consume(String message) throws IOException {
        logger.info(String.format("#### -> Incoming message  -> %s", message));
        processedCounter.incrementAndGet();
    }
}

