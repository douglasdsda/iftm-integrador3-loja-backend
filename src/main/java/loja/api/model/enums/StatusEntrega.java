package loja.api.model.enums;

public enum StatusEntrega {
            ENTREGUE(1), CAMINHANDO(2), PREPARANDO(3), ESPERA(4);

    private int code;

    StatusEntrega(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static StatusEntrega valueOf(int code) {
        for (StatusEntrega value : StatusEntrega.values()) {
            if (value.getCode() == code) {
                return value;
            }

        }
        throw new IllegalMonitorStateException("Codigo invalido.");
    }
}
