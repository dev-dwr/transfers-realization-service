package com.transfersrealizationservice.repository;

import com.transfersrealizationservice.service.TransferData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferDataRepository extends JpaRepository<TransferData, Long> {

}
