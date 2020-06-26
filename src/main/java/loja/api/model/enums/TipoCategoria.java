package loja.api.model.enums;

public enum TipoCategoria {
    DESKTOP(1), NOTEBOOK(2), PERIFERICO(3), SOFTWARE(4);

    private int code;

    private TipoCategoria(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static TipoCategoria valueOf(int code) {
        for (TipoCategoria value : TipoCategoria.values()) {
            if (value.getCode() == code) {
                return value;
            }

        }
        throw new IllegalMonitorStateException("Codigo Tipo categoria invalido.");
    }
}
