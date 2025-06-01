package com.example.backend.controller;

import com.example.backend.model.Transaction;
import com.example.backend.repository.TransactionRepository;
import com.example.backend.service.GasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/gas")
public class GasController {

    @Autowired
    private GasService gasService;

    @Autowired
    private TransactionRepository transactionRepository;

    @PostMapping("/calculate-gas")
    public Map<String, Object> estimateGas(@RequestBody Map<String, String> body) throws Exception {
        String to = body.get("to");
        String value = body.get("value");

        BigDecimal gas = gasService.estimateGas(to, value);

        return Map.of(
                "estimatedValue", gas.toPlainString()
        );
    }

    @PostMapping("/deposit")
    public Map<String, String> deposit(@RequestBody Map<String, String> body) throws Exception {
        String to = body.get("to");
        String value = body.get("value");

        String txHash = gasService.deposit(to, value);
        Transaction tx = new Transaction("sender-address", to, value, txHash);
        transactionRepository.save(tx);

        return Map.of("message", "Deposit successful", "txHash", txHash);
    }

    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}
