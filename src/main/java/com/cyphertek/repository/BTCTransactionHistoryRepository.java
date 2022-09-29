package com.cyphertek.repository;

import com.cyphertek.entity.BTCTransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BTCTransactionHistoryRepository extends JpaRepository<BTCTransactionHistory, String> {
}
