package com.example;

public class Main {
    public static void main(String[] args) {
        // Crear instancia del sistema
        SistemaLogin sistema = new SistemaLogin();

        // Crear y registrar un empleado
        Empleado empleado1 = new Empleado("empleado1", "1234");
        sistema.registrarEmpleado(empleado1);

        // Crear y asignar un administrador
        Administrador admin = new Administrador("admin", "clave123");
        sistema.asignarAdministrador(admin);

        // Probar inicio de sesión de empleado
        if (empleado1.iniciarSesion("empleado1", "1234")) {
            empleado1.registrarHorario("entrada", "Lunes", "08:00");
            empleado1.registrarHorario("salida", "Lunes", "17:00");
        }

        // Probar inicio de sesión de administrador
        if (admin.iniciarSesion("admin", "clave123")) {
            admin.verRegistros(sistema.getEmpleados());
            admin.eliminarHorario("empleado1", "entrada", sistema.getEmpleados());
        }

        // Mostrar resultados finales
        admin.verRegistros(sistema.getEmpleados());
    }
}
