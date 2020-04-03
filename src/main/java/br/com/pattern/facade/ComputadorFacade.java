package br.com.pattern.facade;

public class ComputadorFacade {

    private Cpu cpu;
    private HardDrive hardDrive;
    private Memoria memoria;

    public ComputadorFacade() {
        this.cpu = new Cpu();
        this.hardDrive = new HardDrive();
        this.memoria = new Memoria();
    }

    public void ligar() {
        cpu.start();
        hardDrive.read();
        memoria.load();
        cpu.execute();
    }
}
