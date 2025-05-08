package com.example;

public class Main {
    public static void main(String[] args) {

        SistemaLogin sistema = new SistemaLogin();


        Empleado empleado1 = new Empleado("empleado1", "1234");
        sistema.registrarEmpleado(empleado1);


        Administrador admin = new Administrador("admin", "clave123");
        sistema.asignarAdministrador(admin);


        if (empleado1.iniciarSesion("empleado1", "1234")) {
            empleado1.registrarHorario("entrada", "Lunes", "08:00");
            empleado1.registrarHorario("salida", "Lunes", "17:00");
        }


        if (admin.iniciarSesion("admin", "clave123")) {
            admin.verRegistros(sistema.getEmpleados());
            admin.eliminarHorario("empleado1", "entrada", sistema.getEmpleados());
        }


        admin.verRegistros(sistema.getEmpleados());
    }
}
