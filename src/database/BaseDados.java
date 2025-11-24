package database;

import usuarios.DadosPessoais;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDados {

    /**
     * Lista todos os usuários da tabela 'dadosusuariosavaliacao'.
     */
    public static void listarTodosUsuarios() {
        String sql = "SELECT nome, idade, email, sexo1, peso, altura, abdominal, supra, subescapular, axilar, peitoral, triceptal, coxa FROM dadosusuariosavaliacao";
        try (Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = conexao.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            System.out.println("\n--- Lista de Usuários ---\n");
            boolean encontrou = false;
            while (resultSet.next()) {
                encontrou = true;
                System.out.println("Nome: " + resultSet.getString("nome"));
                System.out.println("Idade: " + resultSet.getInt("idade"));
                System.out.println("Email: " + resultSet.getString("email"));
                System.out.println("Sexo: " + resultSet.getString("sexo1"));
                System.out.println("Peso: " + resultSet.getDouble("peso"));
                System.out.println("Altura: " + resultSet.getDouble("altura"));
                System.out.println("Abdominal: " + resultSet.getDouble("abdominal"));
                System.out.println("Supra: " + resultSet.getDouble("supra"));
                System.out.println("Subescapular: " + resultSet.getDouble("subescapular"));
                System.out.println("Axilar: " + resultSet.getDouble("axilar"));
                System.out.println("Peitoral: " + resultSet.getDouble("peitoral"));
                System.out.println("Triceptal: " + resultSet.getDouble("triceptal"));
                System.out.println("Coxa: " + resultSet.getDouble("coxa"));
                System.out.println("-----------------------------");
            }
            if (!encontrou) {
                System.out.println("Nenhum usuário cadastrado.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar usuários: " + e.getMessage());
        }
    }

    private static final String URL = "******************************";
    private static final String USER = "*****";
    private static final String PASSWORD = "*******";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found. Make sure the JAR is in your classpath.");
        }
    }

    /**
     * Insere um novo usuário na tabela 'usuarios'.
     *
     * @return
     */
    public static void inserirUsuario(String nome, int idade, String email, String sexo1, double peso, double altura, double abdominal, double supra, double subescapular, double axilar, double peitoral, double triceptal, double coxa) {
        // Bloco try-with-resources garante que a conexão será fechada automaticamente.
        try (Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD)) {

            String sql = "INSERT INTO dadosusuariosavaliacao (nome, idade, email, sexo1, peso, altura, abdominal, supra, subescapular, axilar, peitoral, triceptal, coxa) VALUES (?, ? ,? ,? ,? ,? ,? ,?, ? ,? ,? ,? ,?)";

            // PreparedStatement evita injeção de SQL e melhora a performance.
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                statement.setString(1, nome);
                statement.setInt(2, idade);
                statement.setString(3, email);
                statement.setString(4, sexo1);
                statement.setDouble(5, peso);
                statement.setDouble(6, altura);
                statement.setDouble(7, abdominal);
                statement.setDouble(8, supra);
                statement.setDouble(9, subescapular);
                statement.setDouble(10, axilar);
                statement.setDouble(11, peitoral);
                statement.setDouble(12, triceptal);
                statement.setDouble(13, coxa);

                int linhasAfetadas = statement.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Usuário " + nome + " inserido com sucesso!");
                }
            }
        } catch (SQLException e) {
            // Tratamento de erros, por exemplo, duplicidade de email
            System.err.println("Erro ao inserir usuário: " + e.getMessage());
        }
    }

    /**
     * Buscar usuários da tabela 'dadosusuariosavaliacao' e os exibe.
     */
    public static BaseDados buscarUsuario(String nome) {
        String sql = "SELECT nome, idade, email, sexo1, peso, altura, abdominal, supra, subescapular, axilar, peitoral, triceptal, coxa FROM dadosusuariosavaliacao WHERE nome = ?";

        try (Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {

            preparedStatement.setString(1, nome);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next(); {

                nome = resultSet.getString("nome");
                String email = resultSet.getString("email");

                System.out.println("\n--- Usuário Encontrado ---\n");

                System.out.println("Nome: " + nome);
                System.out.println("Email: " + email);

            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuários: " + e.getMessage());
        }
        return null;
    }

    /**
     * Remove um usuário da tabela 'dadosusuariosavaliacao' pelo email.
     */
    public static void removerUsuario(String email) {
        String sql = "DELETE FROM dadosusuariosavaliacao WHERE email = ?";
        try (Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = conexao.prepareStatement(sql)) {
            statement.setString(1, email);
            int linhasAfetadas = statement.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Usuário removido com sucesso!");
            } else {
                System.out.println("Nenhum usuário encontrado com esse email.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao remover usuário: " + e.getMessage());
        }
    }

}