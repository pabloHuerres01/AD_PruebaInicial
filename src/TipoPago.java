public enum TipoPago {
    EFECTIVO('E', "Efectivo"),
    TARJETA('T', "Tarjeta"),
    CONTADO('C', "Contado");

    private char codigo;
    private String descripcion;

    // Constructor por defecto
    TipoPago() {
        // Constructor por defecto
    }

    // Constructor que inicializa todos los atributos
    TipoPago(char codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    // Métodos para acceder a los atributos
    public char getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // Método para obtener TipoPago a partir del código
    public static TipoPago fromCodigo(char codigo) {
        for (TipoPago tipo : TipoPago.values()) {
            if (tipo.getCodigo() == codigo) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Código de pago no válido: " + codigo);
    }
}
