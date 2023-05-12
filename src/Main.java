public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        bancodados bancoDados = new bancodados();
        bancoDados.conecta();
        if (bancoDados.estaConecatdo()) {
            bancoDados.inserir("18", "Joaquim Jose", "0478600", "72818941");
            bancoDados.listar();
            bancoDados.editar("5", "Fafazinha III");
            bancoDados.excluir("198");

        } else {
            System.out.println("Banco NÃO OK");}
    }

}
