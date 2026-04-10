public abstract class VerificaCPF {

    private VerificaCPF() {

    }


    public static boolean verificarCPF(String cpf) {

        if (cpf.length() != 11) {
            return false;
        }

        int[] numerosCpf = new int[11];

        for (int x = 0; x < 11; x++) {
            numerosCpf[x] = Character.getNumericValue(cpf.charAt(x));
        }

        /*
        14538220620

        1	4	5	3	8	2	2	0	6
        X	X	X	X	X	X	X	X	X
        10	9	8	7	6	5	4	3	2
        10	36	40	21	48	10	8	0	12
         */

        int multiplicador = 10;
        int soma = 0;
        for (int x = 0; x < 9; x++) {
            soma += numerosCpf[x]* multiplicador;
            multiplicador--;
        }

        int resto;

        resto = soma%11;
        int primeiroDigitoVerificador = 11 - resto;
        if (primeiroDigitoVerificador >= 10) {
            primeiroDigitoVerificador = 0;
        }

        if (numerosCpf[9] != primeiroDigitoVerificador) {
            return false;
        }

        /*
        1	4	5	3	8	2	2	0	6	2
        X	X	X	X	X	X	X	X	X	X
        11	10	9	8	7	6	5	4	3	2
        11	40	45	24	56	12	10	0	18	4
         */

        multiplicador = 11;
        soma = 0;
        for (int x = 0; x < 10; x++) {
            soma += numerosCpf[x]* multiplicador;
            multiplicador--;
        }

        resto = soma%11;
        int segundoDigitoVerificador = 11 - resto;
        if (segundoDigitoVerificador >= 10) {
            segundoDigitoVerificador = 0;
        }

        if (numerosCpf[10] != segundoDigitoVerificador) {
            return false;
        }

        return true;
    }
}
