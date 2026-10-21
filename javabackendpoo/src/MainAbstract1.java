package javabackendpoo.src;

/*
"is-a"  -> herencia
"has-a" -> composición
*/

class FullTimeEmployee extends Employee {
    private double salario;

    public FullTimeEmployee(String name, double salario) {
        super(name);
        this.salario = salario;
    }

    @Override
    public double calculateSalary() {
        return salario;
    }
}

class PartTimeEmployee extends Employee {
    private double salarioPorHora;
    private int horas;

    public PartTimeEmployee(String name, double salarioPorHora, int horas) {
        super(name);
        this.salarioPorHora = salarioPorHora;
        this.horas = horas;
    }

    @Override
    public double calculateSalary() {
        return (horas * salarioPorHora);
    }
}

public class MainAbstract1 {
    public static void main(String[] args) {
        Employee fullTimeEmployee1 = new FullTimeEmployee("Nicolas", 2000.50);
        Employee partTimeEmployee1 = new PartTimeEmployee("Omar", 200.5, 8);

        System.out.println("FullTimeEmployee: ");
        fullTimeEmployee1.showName();
        System.out.println(fullTimeEmployee1.calculateSalary());

        System.out.println("PartTimeEmployee");
        partTimeEmployee1.showName();
        System.out.println(partTimeEmployee1.calculateSalary());
    }
}
