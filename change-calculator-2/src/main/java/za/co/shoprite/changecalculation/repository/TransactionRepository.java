package za.co.shoprite.changecalculation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.shoprite.changecalculation.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
