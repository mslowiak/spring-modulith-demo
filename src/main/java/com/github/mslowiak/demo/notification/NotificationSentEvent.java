package com.github.mslowiak.demo.notification;

import java.util.UUID;

public record NotificationSentEvent(UUID recipientId, String email, String notificationType) {
}
