package com.example.arquisoft.arquisoft_spring4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.arquisoft.arquisoft_spring4.models.ClienteModel;
import com.example.arquisoft.arquisoft_spring4.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PutMapping("/{dni}/updateCreditScoring")
    public ClienteModel updateCreditScoring(@PathVariable String dni) {
        System.out.println("entro a cambiar CREDIT SCORING");
        return clienteService.updateCreditScoring(dni);
    }

    @GetMapping("/{dni}/creditScoring")
    public double getCreditScoring(@PathVariable String dni) {
        return clienteService.getCreditScoring(dni);
    }
}
