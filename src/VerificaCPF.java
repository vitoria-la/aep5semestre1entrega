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
        145.382.206-20
        14538220620

        1	4	5	3	8	2	2	0	6
        X	X	X	X	X	X	X	X	X
        10	9	8	7	6	5	4	3	2
        10	36	40	21	48	10	8	0	12
         */

        int y = 10;
        int soma = 0;
        for (int x = 0; x < 9; x++) {
            soma += numerosCpf[x]*y;
            y--;
        }

        int resto = soma%11;

        resto = soma%11;
        int primDigitoVer = 11 - resto;
        if (primDigitoVer >= 10) {
            primDigitoVer = 0;
        }

        if (numerosCpf[9] != primDigitoVer) {
            return false;
        }

        /*
        1	4	5	3	8	2	2	0	6	2
        X	X	X	X	X	X	X	X	X	X
        11	10	9	8	7	6	5	4	3	2
        11	40	45	24	56	12	10	0	18	4
         */

        y = 11;
        soma = 0;
        for (int x = 0; x < 10; x++) {
            soma += numerosCpf[x]*y;
            y--;
        }

        resto = soma%11;
        int segDigitoVer = 11 - resto;
        if (segDigitoVer >= 10) {
            segDigitoVer = 0;
        }

        if (numerosCpf[10] != segDigitoVer) {
            return false;
        }

        return true;
    }
}
