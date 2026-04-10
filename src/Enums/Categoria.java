package Enums;

public enum Categoria {
    ILUMINACAO(1),
    ASFALTO(2),
    GRAMA(3),
    PONTO_DE_ONIBUS(4),
    OUTRO(5);

    private final int id;

    Categoria(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Categoria fromId(int id) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.getId() == id) {
                return categoria;
            }
        }
        return null;
    }
}
