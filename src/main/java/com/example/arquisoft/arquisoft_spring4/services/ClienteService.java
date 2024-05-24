package com.example.arquisoft.arquisoft_spring4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.arquisoft.arquisoft_spring4.models.ClienteModel;
import com.example.arquisoft.arquisoft_spring4.repositories.ClienteRepository;

import java.util.Optional;
import java.util.Random;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    private Random random = new Random();

    public ClienteModel updateCreditScoring(String dni) {
        Optional<ClienteModel> optionalCliente = clienteRepository.findByDNI(dni);

        if (optionalCliente.isPresent()) {
            ClienteModel cliente = optionalCliente.get();
            int ingresos = cliente.getIngresos();
            int deudas = cliente.getDeudas();
            int creditScoring;

            if (ingresos > deudas) {
                creditScoring = 5 + random.nextInt(6); // Genera un valor entre 5 y 10
            } else {
                creditScoring = 1 + random.nextInt(5); // Genera un valor entre 1 y 5
            }

            cliente.setCredit_scoring(creditScoring);
            clienteRepository.save(cliente);

            return cliente;
        } else {
            throw new RuntimeException("Cliente no encontrado con DNI: " + dni);
        }
    }

    public int getCreditScoring(String dni) {
        Optional<ClienteModel> optionalCliente = clienteRepository.findByDNI(dni);

        if (optionalCliente.isPresent()) {
            return optionalCliente.get().getCredit_scoring();
        } else {
            throw new RuntimeException("Cliente no encontrado con DNI: " + dni);
        }
    }
}
