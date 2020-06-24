package loja.api.model.enums;

public enum TipoUsuario {
    CLIENTE(1), ENTREGADOR(2), ADMINISTRADOR(3);

    private int code;

    private TipoUsuario(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static TipoUsuario valueOf(int code) {
        for (TipoUsuario value : TipoUsuario.values()) {
            if (value.getCode() == code) {
                return value;
            }

        }
        throw new IllegalMonitorStateException("Codigo TipoUsuario invalido.");
    }
}
