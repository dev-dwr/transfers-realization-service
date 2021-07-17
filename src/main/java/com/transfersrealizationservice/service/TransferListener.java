package com.transfersrealizationservice.service;

import com.commons.TransferMessage;
import com.transfersrealizationservice.repository.TransferDataRepository;
import com.transfersrealizationservice.service.dto.TransferDataDto;
import com.transfersrealizationservice.service.mapper.TransferDataMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import javax.transaction.Transactional;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Service
public class TransferListener {

    private final TransferDataRepository repository;
    private final TransferDataMapper mapper;

    @KafkaListener(topics="transfers")
    @Transactional()
    public void consume(@Payload TransferMessage transferMessage) throws IOException{

        TransferData data = new TransferData();
        data.setAmount(transferMessage.getTransfer().getAmount());
        data.setRecipientAccount(transferMessage.getTransfer().getRecipientAccount());
        data.setTitle(transferMessage.getTransfer().getTitle());
        data.setSenderAccount(transferMessage.getTransfer().getSenderAccount());
        repository.save(data);

        log.info("consumed message: " + transferMessage);
    }
}
