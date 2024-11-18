package view;

import controller.PacienteController;
import model.Paciente;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PacienteController controller = new PacienteController();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Listar Pacientes");
            System.out.println("2. Adicionar Paciente");
            System.out.println("3. Alterar Paciente");
            System.out.println("4. Excluir Paciente");
            System.out.println("5. Consultar Paciente");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            try {
                switch (opcao) {
                    case 1 -> {
                        List<Paciente> pacientes = controller.listarTodos();
                        pacientes.forEach(Paciente::listarPaciente);
                    }
                    case 2 -> {
                        System.out.print("Número: ");
                        int numero = scanner.nextInt();
                        System.out.print("Peso: ");
                        double peso = scanner.nextDouble();
                        System.out.print("Altura: ");
                        double altura = scanner.nextDouble();
                        controller.adicionarPaciente(new Paciente(numero, peso, altura));
                        System.out.println("Paciente adicionado!");
                    }
                    case 3 -> {
                        System.out.print("Número do Paciente a alterar: ");
                        int numero = scanner.nextInt();
                        System.out.print("Novo Peso: ");
                        double peso = scanner.nextDouble();
                        System.out.print("Nova Altura: ");
                        double altura = scanner.nextDouble();
                        controller.alterarPaciente(numero, new Paciente(numero, peso, altura));
                        System.out.println("Paciente alterado!");
                    }
                    case 4 -> {
                        System.out.print("Número do Paciente a excluir: ");
                        int numero = scanner.nextInt();
                        controller.excluirPaciente(numero);
                        System.out.println("Paciente excluído!");
                    }
                    case 5 -> {
                        System.out.print("Número do Paciente: ");
                        int numero = scanner.nextInt();
                        Paciente p = controller.consultarPaciente(numero);
                        if (p != null) {
                            p.listarPaciente();
                        } else {
                            System.out.println("Paciente não encontrado.");
                        }
                    }
                    case 6 -> {
                        System.out.println("Saindo...");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Opção inválida!");
                }
            } catch (IOException e) {
                System.out.println("Erro ao acessar o arquivo: " + e.getMessage());
            }
        }
    }
}
