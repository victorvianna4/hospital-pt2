package model;

public class Paciente {
    private int numero;
    private double peso;
    private double altura;

    public Paciente(int numero, double peso, double altura) {
        this.numero = numero;
        this.peso = peso;
        this.altura = altura;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void listarPaciente() {
        System.out.println("Paciente Nº: " + numero + ", Peso: " + peso + ", Altura: " + altura);
    }

    @Override
    public String toString() {
        return numero + ";" + peso + ";" + altura;
    }

    public static Paciente fromString(String linha) {
        String[] dados = linha.split(";");
        int numero = Integer.parseInt(dados[0]);
        double peso = Double.parseDouble(dados[1]);
        double altura = Double.parseDouble(dados[2]);
        return new Paciente(numero, peso, altura);
    }
}
