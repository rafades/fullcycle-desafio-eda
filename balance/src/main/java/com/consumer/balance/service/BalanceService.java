package com.consumer.balance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.consumer.balance.dominio.Balance;
import com.consumer.balance.dominio.BalanceUpdatedDTO;
import com.consumer.balance.infraestructure.BalanceRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BalanceService {

	private BalanceRepository balanceRepository;

	public BalanceService(BalanceRepository balanceRepository) {
		super();
		this.balanceRepository = balanceRepository;
	}

	public List<Balance> findAll() {
		return balanceRepository.findAll();
	}

	public Optional<Balance> findByAccountId(String accountId) {
		if (accountId.isEmpty()) {
			return Optional.empty();
		}
		return balanceRepository.findByAccountId(accountId);
	}

	public void processBalance(String message) {
		try {
			BalanceUpdatedDTO balanceChange = new ObjectMapper().readValue(message, BalanceUpdatedDTO.class);
			saveBalanceFrom(balanceChange);
			saveBalanceTo(balanceChange);
		} catch (JsonProcessingException e) {
			log.error("Falha ao transformar objeto", e);
		}
	}

	private void saveBalanceTo(BalanceUpdatedDTO balanceChange) {
		Balance balance = findBalanceToProcess(balanceChange.getPayload().getAccountIdTo());
		balance.setBalance(balanceChange.getPayload().getBalanceAccountIdTo());
		balanceRepository.save(balance);
	}

	private void saveBalanceFrom(BalanceUpdatedDTO balanceChange) {
		Balance balance = findBalanceToProcess(balanceChange.getPayload().getAccountIdFrom());
		balance.setBalance(balanceChange.getPayload().getBalanceAccountIdFrom());
		balanceRepository.save(balance);
	}

	private Balance findBalanceToProcess(String accountId) {
		return findByAccountId(accountId)
				.orElseGet(() -> buildBalanceAccountId(accountId));
	}

	private Balance buildBalanceAccountId(String accountId) {
		return Balance.builder().accountId(accountId).build();
	}

}
