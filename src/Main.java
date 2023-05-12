public class Main {
    public static void main(String[] args) {
        bancodados bancoDados = new bancodados();
        bancoDados.conecta();
        if (bancoDados.estaConecatdo()) {
            bancoDados.inserir("1", "Joaquim Jose", "0478600", "72818941");
            bancoDados.inserir("2", "Dagoberto III Jr.", "0847600", "247891274");
            bancoDados.inseriritem("1", "Air Max", 12, "200");
            bancoDados.listar();
            bancoDados.editar("5", "Fafazinha III");
            bancoDados.excluir("1");
            bancoDados.excluir("2");
            bancoDados.excluiritem("1");
        }
        else {
            System.out.println("Banco NÃO OK");}
    }

}
