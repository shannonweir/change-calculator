package za.co.shoprite.changecalculator2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.shoprite.changecalculator2.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
