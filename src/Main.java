public class Main {
    public static void main(String[] args) {
        MenuManager menuManager = new MenuManager();
        int saida = -1;

        do {
            Usuario user = menuManager.gerenciandoMenusIniciais();

            if (user instanceof Cidadao) {
                saida = menuManager.loopCidadao((Cidadao) user);
            } else {
                saida = menuManager.loopFuncionario((Gestor) user);
            }
        } while (saida == 0);


    }
}
