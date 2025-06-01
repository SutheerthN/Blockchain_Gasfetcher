package com.example.backend.controller;

import com.example.backend.service.MonitorService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/monitor")
public class MonitorController {

    @Autowired
    private MonitorService monitorService;

    @GetMapping("/transaction/{hash}")
    public JSONObject getTransaction(@PathVariable String hash) {
        return monitorService.getTransactionByHash(hash);
    }

    @GetMapping("/gas-data")
    public JSONObject getGasData() {
        return monitorService.getGasData();
    }

    @GetMapping("/notify-high-gas")
    public String checkHighGas() {
        JSONObject gas = monitorService.getGasData();
        int proposeGas = gas.getInt("ProposeGasPrice");
        return proposeGas > 50 ? "High gas detected!" : "Gas is within threshold.";
    }
}
