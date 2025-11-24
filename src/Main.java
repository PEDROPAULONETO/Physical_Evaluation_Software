import avaliacaofisica.Imc;
import avaliacaofisica.Setedobras;
import database.BaseDados;
import usuarios.DadosPessoais;

import java.sql.SQLException;
import java.util.Scanner;

import static database.BaseDados.buscarUsuario;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

                // Loop principal para exibir o menu e processar as opções
        while (true) {

            System.out.println("---- Menu de Avaliação Física ----");
            System.out.println("1. Inserir novo usuário");
            System.out.println("2. Remover usuário");
            System.out.println("3. Buscar usuário");
            System.out.println("4. Listar todos os usuários");
            System.out.println("5. Sair do programa\n");
            System.out.print("Escolha uma opção: ");

            String input = scanner.nextLine();
            int opcao = Integer.parseInt(input); // Consome a nova linha

            switch (opcao) {
                case 1:
                            // Lógica para Inserir novo usuário
                    System.out.println("--- Inserir Novo Usuário ---");

                    System.out.print("Digite seu nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite sua idade: ");
                    int idade = scanner.nextInt();

                    System.out.print("Digite seu e-mail: ");
                    String email = scanner.next();

                    System.out.print("Digite seu peso em 'KG': ");
                    double peso = scanner.nextDouble();

                    System.out.print("Digite sua altura em 'Metros': ");
                    double altura = scanner.nextDouble();

                    System.out.print("Digite o sexo [M/F]: ");
                    String sexo = scanner.next();
                    String sexo1;
                    if (sexo.equalsIgnoreCase("m")) {
                        sexo1 = "Masculino";
                    } else if (sexo.equalsIgnoreCase("f")) {
                        sexo1 = "Feminino";
                    } else {
                        sexo1 = "Sexo Inválido";
                    }

                    System.out.println("Olá " + nome + " você tem " + idade + " anos, do sexo " + sexo1);
                    System.out.println("Insira o valor das dobras em 'mm'");
                    System.out.println();

                    System.out.print("Abdominal: ");
                    double abdominal = scanner.nextDouble();

                    System.out.print("Supra Ilíaca: ");
                    double supra = scanner.nextDouble();

                    System.out.print("subescapilar: ");
                    double subescapular = scanner.nextDouble();

                    System.out.print("Axilar Média: ");
                    double axilar = scanner.nextDouble();

                    System.out.print("Peitoral: ");
                    double peitoral = scanner.nextDouble();

                    System.out.print("Triceptal: ");
                    double triceptal = scanner.nextDouble();

                    System.out.print("Coxa: ");
                    double coxa = scanner.nextDouble();

                            // Instanciar objetos e calcular valores
                            // Chamar o método para inserir no banco de dados
                    BaseDados.inserirUsuario(nome, idade, email, sexo1, peso, altura, abdominal, supra, subescapular, axilar, peitoral, triceptal, coxa);

                    double calcularImc = Imc.calcularImc(peso, altura);
                    System.out.printf("Seu IMC é: %.2f\n", calcularImc);

                    double somaDobras = Setedobras.somaDobras(abdominal, supra, axilar, supra, peitoral, triceptal, coxa);
                    double densidadeCorporal = Setedobras.densidadeCorporal(somaDobras, idade, sexo);
                    double percentualGordura = Setedobras.percentualGordura(densidadeCorporal, sexo, idade);
                    System.out.printf("Seu Percentual de Gordura é: %.2f\n", percentualGordura);

                    break;

                case 2:
                        // Lógica para Remover usuário
                        System.out.println("--- Remover Usuário ---");
                        System.out.print("Digite o e-mail do usuário a ser removido: ");
                        String emailRemover = scanner.next();
                        BaseDados.removerUsuario(emailRemover);
                        scanner.nextLine(); // Limpa o buffer
                        break;

                case 3:
                        System.out.println("--- Buscar Usuário ---");
                        System.out.print("Digite o nome do usuário: ");
                        String usuario = scanner.nextLine();

                        BaseDados buscarUsuario = buscarUsuario(usuario);
                        if (buscarUsuario != null) {
                            System.out.println("\n--- Usuário Encontrado ---\n");
                            System.out.println(buscarUsuario);
                        System.out.println("Nenhum usuário com o nome " + usuario + " foi encontrado.");
                        }
                        break;

                case 4:
                    // Listar todos os usuários
                    System.out.println("--- Lista de Todos os Usuários ---");
                    BaseDados.listarTodosUsuarios();
                    break;


                case 5:
                    // Opção para Sair do programa
                    System.out.println("Obrigado por usar o NEOFIT - software de avaliação física!!");
                    scanner.close(); // Fecha o Scanner antes de sair
                    return;

            default:
                            // Mensagem para opções inválidas
            System.out.println("Opção inválida. Por favor, escolha uma opção entre 1 e 4.");
            break;
            }
        }
    }
}