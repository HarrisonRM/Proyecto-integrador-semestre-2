package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SistemaLogin {

    private Map<String, Empleado> empleados = new HashMap<>();
    private Administrador administrador = new Administrador("admin", "clave123");

    public void menu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Sistema Login ---");
            System.out.println("1. Ingresar como Empleado");
            System.out.println("2. Ingresar como Administrador");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            int opc = Integer.parseInt(sc.nextLine());

            switch (opc) {
                case 1 -> menuEmpleado(sc);
                case 2 -> menuAdministrador(sc);
                case 3 -> {
                    System.out.println("Saliendo...");
                    return;
                }
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private void menuEmpleado(Scanner sc) {
        System.out.print("Ingrese nombre de usuario: ");
        String nombre = sc.nextLine();
        Empleado emp = empleados.get(nombre);

        if (emp == null) {
            System.out.print("Usuario nuevo. Ingrese contraseña para registrar: ");
            String pass = sc.nextLine();
            emp = new Empleado(nombre, pass);
            empleados.put(nombre, emp);
            System.out.println("Empleado registrado.");
        }

        System.out.print("Ingrese su contraseña: ");
        String pass = sc.nextLine();

        if (emp.iniciarSesion(nombre, pass)) {
            System.out.println("Sesión iniciada.");
            int opc = -1;
            while (opc != 3) {
                System.out.println("1. Registrar horario");
                System.out.println("2. Ver horarios");
                System.out.println("3. Volver");
                System.out.print("Opción: ");
                opc = Integer.parseInt(sc.nextLine());

                if (opc == 1) {
                    System.out.print("Tipo de horario (entrada/salida): ");
                    String tipo = sc.nextLine();
                    System.out.print("Día: ");
                    String dia = sc.nextLine();
                    System.out.print("Hora (HH:mm): ");
                    String hora = sc.nextLine();
                    emp.registrarHorario(tipo, dia, hora);
                } else if (opc == 2) {
                    emp.verHorarios();
                }
            }
        } else {
            System.out.println("Usuario o contraseña incorrectos.");
        }
    }

    private void menuAdministrador(Scanner sc) {
        System.out.print("Usuario: ");
        String user = sc.nextLine();
        System.out.print("Contraseña: ");
        String pass = sc.nextLine();

        if (administrador.iniciarSesion(user, pass)) {
            System.out.println("Sesión administrador iniciada.");
            int opc = -1;
            while (opc != 4) {
                System.out.println("1. Ver registros");
                System.out.println("2. Eliminar inicio de sesión");
                System.out.println("3. Eliminar horario");
                System.out.println("4. Volver");
                System.out.print("Opción: ");
                opc = Integer.parseInt(sc.nextLine());

                Map<String, Empleado> empleado = Map.of();
                switch (opc) {
                    case 1 -> administrador.verRegistros(empleado);
                    case 2 -> {
                        System.out.print("Empleado: ");
                        String nom = sc.nextLine();
                        Empleado e = empleados.get(nom);
                        if (e != null) administrador.eliminarInicioSesion(e);
                    }
                    case 3 -> {
                        System.out.print("Empleado: ");
                        String nom = sc.nextLine();
                        Empleado e = empleados.get(nom);
                        if (e != null) {
                            System.out.print("Tipo horario (entrada/salida): ");
                            String tipo = sc.nextLine();
                            administrador.eliminarHorario(e, tipo);
                        }
                    }
                }
            }
        } else {
            System.out.println("Credenciales incorrectas.");
        }
    }

    public static void main(String[] args) {
        new SistemaLogin().menu();
    }

    public void registrarEmpleado(Empleado empleado1) {
    }

    public void asignarAdministrador(Administrador admin) {
    }

    public Map<String,Empleado> getEmpleados() {
        return null;
    }
}
