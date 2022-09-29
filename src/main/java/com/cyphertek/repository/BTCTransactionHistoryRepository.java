package com.cyphertek.repository;

import com.cyphertek.entity.BTCTransactionHistory;
import com.cyphertek.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BTCTransactionHistoryRepository extends JpaRepository<BTCTransactionHistory, String> {
    List<BTCTransactionHistory> findAllByUser(User user);
}
