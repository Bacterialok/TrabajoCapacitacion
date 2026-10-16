package javabackendpoo.src;

public abstract class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public void showName() {
        System.out.println("Empleado: " + name);
    }

    public abstract double calculateSalary();
}
