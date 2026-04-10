import Entitys.Cidadao;
import Entitys.Gestor;
import Entitys.Usuario;

public class Main {
    public static void main(String[] args) {
        MenuManager menuManager = new MenuManager();
        int saida = -1;

        do {
            Usuario user = menuManager.gerenciandoMenusIniciais();

            if (user == null) {
                System.out.println("\n\u001B[1mObrigado por utilizar o ObservaAção! Encerrando o sistema...\u001B[0m");
                break;
            }

            if (user instanceof Cidadao) {
                saida = menuManager.loopCidadao((Cidadao) user);
            } else if (user instanceof Gestor) {
                saida = menuManager.loopFuncionario((Gestor) user);
            }

        } while (saida == 0);


    }
}
