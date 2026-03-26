public class Main {
    public static void main(String[] args) {
        MenuManager menuManager = new MenuManager();
        Usuario user = menuManager.gerenciandoMenusIniciais();

        if (user instanceof Cidadao) {
            menuManager.loopCidadao((Cidadao) user);
        } else {
            menuManager.loopFuncionario((Gestor) user);
        }
    }
}
