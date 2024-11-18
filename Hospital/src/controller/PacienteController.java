package controller;

import model.Paciente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteController {
    private final String arquivoPacientes = "pacientes.txt";

    public List<Paciente> listarTodos() throws IOException {
        List<Paciente> pacientes = new ArrayList<>();
        File file = new File(arquivoPacientes);

        if (!file.exists()) file.createNewFile();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoPacientes))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                pacientes.add(Paciente.fromString(linha));
            }
        }
        return pacientes;
    }

    public void adicionarPaciente(Paciente paciente) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoPacientes, true))) {
            bw.write(paciente.toString());
            bw.newLine();
        }
    }

    public void alterarPaciente(int numero, Paciente pacienteAtualizado) throws IOException {
        List<Paciente> pacientes = listarTodos();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoPacientes))) {
            for (Paciente p : pacientes) {
                if (p.getNumero() == numero) {
                    bw.write(pacienteAtualizado.toString());
                } else {
                    bw.write(p.toString());
                }
                bw.newLine();
            }
        }
    }

    public void excluirPaciente(int numero) throws IOException {
        List<Paciente> pacientes = listarTodos();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoPacientes))) {
            for (Paciente p : pacientes) {
                if (p.getNumero() != numero) {
                    bw.write(p.toString());
                    bw.newLine();
                }
            }
        }
    }

    public Paciente consultarPaciente(int numero) throws IOException {
        List<Paciente> pacientes = listarTodos();
        for (Paciente p : pacientes) {
            if (p.getNumero() == numero) {
                return p;
            }
        }
        return null;
    }
}
