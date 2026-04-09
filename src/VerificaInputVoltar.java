public abstract class VerificaInputVoltar {

    private VerificaInputVoltar() {

    }

    public static boolean verificarStringIgualAZero(String string) {
        if (string.length() == 1 && Character.getNumericValue(string.charAt(0)) == 0) {
            return true;
        } else {
            return false;
        }
    }

}
