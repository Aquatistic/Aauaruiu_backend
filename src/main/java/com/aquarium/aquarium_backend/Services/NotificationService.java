package com.aquarium.aquarium_backend.Services;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public NotificationService(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public void notifyUser(Long userId, String message) {
        simpMessagingTemplate.convertAndSendToUser(String.valueOf(userId), "/queue/notifications", message);
    }
}
