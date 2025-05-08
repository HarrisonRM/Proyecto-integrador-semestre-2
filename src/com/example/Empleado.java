package com.example;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Empleado extends Usuario implements Autenticable {

    private Map<String, Map<String, String>> horarios = new HashMap<>();
    private LocalDateTime inicioSesion;

    public Empleado(String nombre, String contrasena) {
        super(nombre, contrasena);
    }

    @Override
    public boolean iniciarSesion(String usuario, String contrasena) {
        if (this.nombre.equals(usuario) && this.contrasena.equals(contrasena)) {
            this.inicioSesion = LocalDateTime.now();
            return true;
        }
        return false;
    }

    public void registrarHorario(String tipoHorario, String dia, String hora) {
        Map<String, String> detalle = new HashMap<>();
        detalle.put("Dia", dia);
        detalle.put("Hora", hora);
        horarios.put(tipoHorario.toLowerCase(), detalle);
    }

    public void verHorarios() {
        if (horarios.isEmpty()) {
            System.out.println("No hay horarios registrados.");
            return;
        }

        System.out.println("Horarios del empleado: " + nombre);
        for (String tipo : horarios.keySet()) {
            Map<String, String> detalle = horarios.get(tipo);
            System.out.println("Tipo: " + tipo + " - Día: " + detalle.get("Dia") + " - Hora: " + detalle.get("Hora"));
        }
    }

    public LocalDateTime getInicioSesion() {
        return inicioSesion;
    }

    public void eliminarHorario(String tipo) {
        horarios.remove(tipo.toLowerCase());
    }
}
