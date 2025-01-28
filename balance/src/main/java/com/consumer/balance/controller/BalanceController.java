package com.consumer.balance.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consumer.balance.dominio.Balance;
import com.consumer.balance.service.BalanceService;

@RestController
@RequestMapping("/")
public class BalanceController {

    private BalanceService balanceService;

    public BalanceController(BalanceService balanceService) {
		super();
		this.balanceService = balanceService;
	}

	@GetMapping("/balances")
    public ResponseEntity<List<Balance>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(balanceService.findAll());
    }

    @GetMapping("/balances/{accountId}")
    public ResponseEntity<Balance> getBalanceFromAccountId(@PathVariable String accountId) {
       return ResponseEntity.of(balanceService.findByAccountId(accountId));
    }
    
}
