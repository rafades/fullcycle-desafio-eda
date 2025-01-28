package com.consumer.balance.infraestructure;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.consumer.balance.service.BalanceService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumer {

    private BalanceService balanceService;
    

    public KafkaConsumer(BalanceService balanceService) {
		super();
		this.balanceService = balanceService;
	}

	@KafkaListener(topics = "transactions", groupId = "wallet")
    public void listenTransactionsTopic(String message) {
		log.info("Mensagem recebida no topico transactions {}",message);
    }

    @KafkaListener(topics = "balances", groupId = "wallet")
    public void listenBalancesTopic(String message) {
		log.info("Mensagem recebida no topico balances {}",message);
        balanceService.processBalance(message);
    }
}