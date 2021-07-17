package com.transfersrealizationservice.service.mapper;


import com.transfersrealizationservice.service.TransferData;
import com.transfersrealizationservice.service.dto.TransferDataDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TransferDataMapper {
    TransferDataMapper INSTANCE = Mappers.getMapper(TransferDataMapper.class);

    TransferDataDto accountToAccountDto(TransferData account);
}

