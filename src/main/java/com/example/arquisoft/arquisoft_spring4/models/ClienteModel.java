package com.example.arquisoft.arquisoft_spring4.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "clientes")
public class ClienteModel {

    @Id
    private String id;
    private String DNI;
    private String nombre;
    private String email;
    private String profesion;
    private String actividad_economica;
    private String empresa;
    private int ingresos;
    private int deudas;
    private int credit_scoring;
    private boolean cliente_actual;
}
