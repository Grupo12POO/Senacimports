import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
public class bancodados {
    private Connection con = null;
    private Statement stm  = null;
    private ResultSet result = null;

    public void conecta() {
        String servidor = "jdbc:mysql://localhost:3306/loja";
        String usuario = "root";
        String senha = "P@$$w0rd";
        String driver = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driver);
            this.con = DriverManager.getConnection(servidor, usuario, senha);
            this.stm = this.con.createStatement();
        } catch (Exception e) {
            System.out.println("erro na conexão : " + e.getMessage());
        }
    }
    public boolean estaConecatdo() {
        return this.con != null;
    }
    public void listar() {
        try {
            String minhaQuery = "SELECT * FROM cliente ORDER BY nome";
            this.result = this.stm.executeQuery(minhaQuery);

            while (this.result.next()) {
                System.out.println("ID: "+this.result.getString("id_cliente") + " - Nome: "+this.result.getString("nome") + " - CEP: "+this.result.getString("cep") + " - CPF: "+this.result.getString("cpf") );
            }
        } catch(Exception e) {
            System.out.println("Erro na lista: "+ e.getMessage());
        }
    }
    public void inserir(String id_cliente, String nome, String cep, String cpf) {
        try {
            String query = "INSERT INTO cliente (id_cliente, nome, cep, cpf) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, id_cliente);
            stmt.setString(2, nome);
            stmt.setString(3, cep);
            stmt.setString(4, cpf);
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Dados inseridos com sucesso!");
            } else {
                System.out.println("Nenhum dado foi inserido.");
            }
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) { // código de erro para chave única violada
                System.err.println("Erro ao inserir dados: já existe um registro com o ID " + id_cliente);
            } else {
                System.err.println("Erro ao inserir dados: " + e.getMessage());
            }
        }
    }
    public void inseriritem(String id_item, String produto, Integer quantidade, String preço) {
        try {
            String query = "INSERT INTO senac_imports (id_item, produto, quantidade, preço) VALUES (?,?,?,?);";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, id_item);
            stmt.setString(2, produto);
            stmt.setInt(3, quantidade);
            stmt.setString(4, preço);
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Dados inseridos com sucesso!");
            } else {
                System.out.println("Nenhum dado foi inserido.");
            }
        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) { // código de erro para chave única violada
                System.err.println("Erro ao inserir dados: já existe um registro com o ID " + id_item);
            } else {
                System.err.println("Erro ao inserir dados: " + e.getMessage());
            }
        }
    }
    public void editar(String id_cliente, String nome) {
        try {
            String query = "UPDATE cliente SET nome ='"+ nome +"'  WHERE id_cliente = " + id_cliente + ";";
            this.stm.executeUpdate(query);
            System.out.println("ID: "+ id_cliente + " alterado com sucesso" );
        } catch(Exception e) {
            System.out.println("Erro na Alteracao: "+ e.getMessage());
        }
    }
    public void excluir(String id_cliente) {
        try {
            String query = "DELETE FROM cliente WHERE id_cliente = " + id_cliente + ";";
            this.stm.executeUpdate(query);
            System.out.println("ID: "+ id_cliente + "EXCLUIDO COM SUCESSO");

        } catch(Exception e) {
            System.out.println("Erro na Exclusao: "+ e.getMessage());
        }
    }
    public void excluiritem(String id_item) {
        try {
            String query = "DELETE FROM senac_imports WHERE id_item = " + id_item + ";";
            this.stm.executeUpdate(query);
            System.out.println("ID: "+ id_item + "EXCLUIDO COM SUCESSO");

        } catch(Exception e) {
            System.out.println("Erro na Exclusao: "+ e.getMessage());
        }
    }
}