package br.com.pattern.strategy;

import java.util.UUID;

public class Funcionario {

    private UUID id = UUID.randomUUID();
    private Strategy cargo;

    public Strategy getCargo() {
        return cargo;
    }

    public void setCargo(Strategy cargo) {
        this.cargo = cargo;
    }
}
