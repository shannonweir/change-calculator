package za.co.shoprite.changecalculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.shoprite.changecalculator.domain.Transaction;

//@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
