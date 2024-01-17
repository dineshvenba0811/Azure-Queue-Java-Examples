package com.dinesh.organisation.azurequeuejava.service;

import com.azure.storage.queue.QueueClient;
import com.azure.storage.queue.QueueClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class QueueServiceImpl implements  QueueService{

    @Value("${spring.cloud.azure.storage.blob.endpoint}")
    private String connectionString;

    // Create a unique name for the queue
    String queueName = "sampleQueue-" + java.util.UUID.randomUUID();
    @Override
    public QueueClient getConnection() {
        QueueClient queueClient=new QueueClientBuilder().connectionString(connectionString).queueName(queueName).buildClient();
        return null;
    }

    @Override
    public void createQueue() {

    }

    @Override
    public void addingMessagesToQueue() {

    }

    @Override
    public void peekMessageInQueue() {

    }

    @Override
    public void updateMessageInQueue() {

    }

    @Override
    public Integer getQueueLength() {
        return null;
    }

    @Override
    public void receiveMessage() {

    }

    @Override
    public void deleteMessage() {

    }
}
