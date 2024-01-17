package com.dinesh.organisation.azurequeuejava.controller;

import com.azure.storage.queue.QueueClient;
import com.dinesh.organisation.azurequeuejava.service.QueueService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@AllArgsConstructor
@RestController
@RequestMapping("/Queue")
public class QueueController {
    private QueueService queueService;

    @GetMapping("/createConnection")
    public QueueClient readBlobFile() throws IOException {
        return queueService.getConnection();
    }
}
