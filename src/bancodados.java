import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
        if (this.con != null) {
            return true;
        }
        else {
            return false;
        }
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
            String query = "INSERT INTO cliente (id_cliente, nome, cep, cpf) VALUES ("+ id_cliente +", " + nome +", "+ cep +", " + cpf + ")";
            this.stm.executeUpdate(query);
            System.out.println("cliente " +id_cliente + "Incuido com SUCESSO" );
            System.out.println("cliente " +nome + "Incuido com SUCESSO" );
            System.out.println("cliente " +cep + "Incuido com SUCESSO" );
            System.out.println("cliente " +cpf + "Incuido com SUCESSO" );

        } catch(Exception e) {
            System.out.println("Erro na Inclusao: "+ e.getMessage());
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
}