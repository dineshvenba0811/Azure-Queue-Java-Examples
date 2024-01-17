package com.dinesh.organisation.azurequeuejava.service;

import com.azure.storage.queue.QueueClient;

public interface QueueService {

    QueueClient getConnection();

    void createQueue();

    void addingMessagesToQueue();

    void peekMessageInQueue();

    void updateMessageInQueue();

    Integer getQueueLength();

    void receiveMessage();

    void deleteMessage();
}
