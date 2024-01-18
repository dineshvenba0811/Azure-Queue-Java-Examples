package com.dinesh.organisation.azurequeuejava.service;

import com.azure.storage.queue.QueueClient;
import com.azure.storage.queue.QueueClientBuilder;
import com.azure.storage.queue.models.QueueProperties;
import com.azure.storage.queue.models.SendMessageResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class QueueServiceImpl implements  QueueService{

    @Value("${spring.cloud.azure.storage.blob.endpoint}")
    private String connectionString;

    QueueClient queueClient=null;
    // Create a unique name for the queue
    String queueName = "sampleQueue-" + java.util.UUID.randomUUID();
    @Override
    public QueueClient getConnection() {
         queueClient=new QueueClientBuilder().connectionString(connectionString).queueName(queueName).buildClient();
        return queueClient;
    }

    @Override
    public SendMessageResult createQueueAndSendMessage() {
        // create the queue
        queueClient.create();
        // sending the messages.
        return queueClient.sendMessage("Hallo Azure Guten Tag");


    }

    @Override
    public void addingMessagesToQueue() {

    }

    @Override
    public void peekMessageInQueue() {
        // get the message
        queueClient.peekMessages(5,null,null).forEach(System.out::println);

    }

    @Override
    public void updateMessageInQueue() {
        // update the messages in the queue
        queueClient.updateMessage(queueClient.sendMessage("Hallo Azure Guten Tag").getMessageId(),
                queueClient.sendMessage("Hallo Azure Guten Tag").getPopReceipt()," Hallo Azure Guten Morgen",
                Duration.ofSeconds(5));
    }

    @Override
    public long getQueueLength() {
        QueueProperties queueProperties= queueClient.getProperties();
        return queueProperties.getApproximateMessagesCount();
    }

    @Override
    public void receiveMessage() {
        queueClient.receiveMessages(10).forEach(msg->System.out.println(msg.getMessageText()));

    }

}
