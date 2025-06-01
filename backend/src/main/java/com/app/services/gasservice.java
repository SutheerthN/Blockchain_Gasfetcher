package com.example.backend.service;

import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.math.BigDecimal;

@Service
public class GasService {

    private final Web3j web3j;
    private final Credentials credentials;

    public GasService() {
        String rpcUrl = System.getenv("RPC_URL");
        String privateKey = System.getenv("PRIVATE_KEY");

        this.web3j = Web3j.build(new HttpService(rpcUrl));
        this.credentials = Credentials.create(privateKey);
    }

    public BigDecimal estimateGas(String to, String valueEth) throws Exception {
        BigDecimal valueInEther = new BigDecimal(valueEth);
        Transfer.sendFunds(web3j, credentials, to, valueInEther, Convert.Unit.ETHER).estimateGas();
        // You can further implement gas estimation logic with web3j
        return valueInEther;
    }

    public String deposit(String to, String valueEth) throws Exception {
        BigDecimal value = new BigDecimal(valueEth);
        return Transfer.sendFunds(web3j, credentials, to, value, Convert.Unit.ETHER).send().getTransactionHash();
    }
}
