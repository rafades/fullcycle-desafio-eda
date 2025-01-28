package com.consumer.balance.infraestructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consumer.balance.dominio.Balance;

import java.util.Optional;


@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long> {
    Optional<Balance> findByAccountId(String accountId);
}