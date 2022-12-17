package com.clevertec.generationCashReceipt.repository;

import com.clevertec.generationCashReceipt.model.DiscountCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The DiscountCardRepository interface provides basic operations
 * for searching, saving, deleting data (CRUD operations)
 *
 * @author Ilkevich Anastasiya
 * @version 1.0
 */

@Repository
public interface DiscountCardRepository extends JpaRepository<DiscountCard, Long> {
}