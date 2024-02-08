package com.chattApp.V1;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface MessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage>findByChannelId(Long channelId);
}
