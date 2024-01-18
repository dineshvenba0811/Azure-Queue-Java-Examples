package com.dinesh.organisation.azurequeuejava.service;

import com.azure.storage.queue.QueueClient;
import com.azure.storage.queue.models.SendMessageResult;

public interface QueueService {

    QueueClient getConnection();

    SendMessageResult createQueueAndSendMessage();

    void addingMessagesToQueue();

    void peekMessageInQueue();

    void updateMessageInQueue();

    long getQueueLength();

    void receiveMessage();

}
