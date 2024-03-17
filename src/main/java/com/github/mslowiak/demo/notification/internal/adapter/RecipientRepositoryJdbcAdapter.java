package com.github.mslowiak.demo.notification.internal.adapter;

import java.util.UUID;

import com.github.mslowiak.demo.notification.internal.domain.RecipientRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RecipientRepositoryJdbcAdapter implements RecipientRepository {

    @Override
    public String findCustomerEmail(UUID recipientId) {
        return "test@gmail.com";
    }

}
