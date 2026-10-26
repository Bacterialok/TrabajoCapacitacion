enum PaymentStatus {
    PENDING("Pendiente"),
    APPROVED("Aprobado"),
    REJECTED("Rechazado");

    private final String description;

    PaymentStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

public class MainEnum1 {
    public static void main(String[] args) {
        PaymentStatus status = PaymentStatus.APPROVED;

        switch (status) {
            case PENDING:
                System.out.println("ESTATUS: " + status.getDescription());
                break;
            case APPROVED:
                System.out.println("ESTATUS: " + status.getDescription());   
                break;
            case REJECTED:
                System.out.println("ESTATUS: " + status.getDescription());
                break;
        }

        System.out.println(" - - - - - - - - - - ");
        
        String statusTexto = "APPROVED";

        PaymentStatus statusConvertido  = PaymentStatus.valueOf(statusTexto);
        System.out.println(statusConvertido.getDescription());

        try {
            PaymentStatus statusInvalido = PaymentStatus.valueOf("INVALID");
            System.out.println(statusInvalido);
        } catch (IllegalArgumentException e) {
            System.out.println("El estatus no es valido");
        }
    }
}
