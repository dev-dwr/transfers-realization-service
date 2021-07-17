package com.transfersrealizationservice.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferDataDto {
    private Long senderAccount;
    private String recipientAccount;
    private String title;
    private Double amount;
}
