package loja.api.model.enums;

public enum StatusCompra {
            PAGO(1), ESPERANDO(2), VENCIDO(3);

    private int code;

    StatusCompra(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static StatusCompra valueOf(int code) {
        for (StatusCompra value : StatusCompra.values()) {
            if (value.getCode() == code) {
                return value;
            }

        }
        throw new IllegalMonitorStateException("Codigo invalido.");
    }
}
