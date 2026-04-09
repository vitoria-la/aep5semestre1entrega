package Entitys;

import java.util.List;

public class Cidadao extends Usuario{
    private String nome;
    private boolean ehAnonimo;
    private List<Ticket> listaDeTickets;

    public String getCpfFormatado() {
        String cpf = super.getCpf(); // 01234567890
        String cpfFormatado = "";

        int x = 0;
        do {
            if (cpfFormatado.length() == 3 || cpfFormatado.length() == 7) {
                cpfFormatado += ".";
            } else if (cpfFormatado.length() == 10) {
                cpfFormatado += "-";
            } else {
                cpfFormatado += cpf.charAt(x);
                x++;
            }
        } while (cpfFormatado.length() != 13);

        // 0 1 2 . 3 4 5 . 6 7 8 - 9 0
        return cpfFormatado;
    }

}


