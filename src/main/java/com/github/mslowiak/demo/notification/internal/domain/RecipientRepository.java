package com.github.mslowiak.demo.notification.internal.domain;

import java.util.UUID;

public interface RecipientRepository {
    String findCustomerEmail(UUID recipientId);
}
