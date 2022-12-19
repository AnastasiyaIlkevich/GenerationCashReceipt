package com.clevertec.generationCashReceipt.repository;

import com.clevertec.generationCashReceipt.model.CashReceipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashReceiptRepository extends JpaRepository<CashReceipt, Long> {
}
