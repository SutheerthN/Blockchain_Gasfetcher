package com.example.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

@Service
public class MonitorService {
    private final String apiKey = System.getenv("BLOCK_EXPLORER_API_KEY");
    private final String blockExplorerUrl = "https://api-sepolia.etherscan.io/api";

    public JSONObject getTransactionByHash(String hash) {
        String url = blockExplorerUrl + "?module=proxy&action=eth_getTransactionByHash&txhash=" + hash + "&apikey=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        return new JSONObject(response).getJSONObject("result");
    }

    public JSONObject getGasData() {
        String url = blockExplorerUrl + "?module=gastracker&action=gasoracle&apikey=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        return new JSONObject(response).getJSONObject("result");
    }
}
