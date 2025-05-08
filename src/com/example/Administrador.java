package com.example;

import java.util.Map;

public class Administrador extends Usuario implements Autenticable {

    public Administrador(String nombre, String contrasena) {
        super(nombre, contrasena);
    }

    @Override
    public boolean iniciarSesion(String usuario, String contrasena) {
        return this.nombre.equals(usuario) && this.contrasena.equals(contrasena);
    }

    public void verRegistros(Map<String, Empleado> empleados) {
        for (Empleado e : empleados.values()) {
            System.out.println("\nEmpleado: " + e.getNombre());
            System.out.println("Inicio de sesión: " + (e.getInicioSesion() != null ? e.getInicioSesion() : "No registrado"));
            e.verHorarios();
        }
    }

    public void eliminarInicioSesion(Empleado e) {
        System.out.println("Inicio de sesión eliminado para " + e.getNombre());
        e.iniciarSesion(e.getNombre(), ""); // reinicia a null
    }

    public void eliminarHorario(Empleado e, String tipoHorario) {
        e.eliminarHorario(tipoHorario);
        System.out.println("Horario eliminado: " + tipoHorario + " para " + e.getNombre());
    }

    public void eliminarHorario(String empleado1, String entrada, Map<String, Empleado> empleados) {
    }
}
