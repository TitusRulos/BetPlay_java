package com.simplesoccer.entity;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String nombreEquipo;
    private String ciudadEquipo;
    private List<Player> listJugadores;
    private List<Coach> listEntrenadores;
    private List<Doctor> listMasajistas;
    
    public Team(int codigoEquipo, String nombreEquipo, String ciudadEquipo) {
        listEntrenadores = new ArrayList<Coach>();
        listJugadores = new ArrayList<Player>();
        listMasajistas = new ArrayList<Doctor>();
    }

    public String getNombre() {
        return nombreEquipo;
    }

    public void setNombre(String nombre) {
        this.nombreEquipo = nombre;
    }

    public String getCiudad() {
        return ciudadEquipo;
    }

    public void setCiudad(String ciudad) {
        this.ciudadEquipo = ciudad;
    }

    public List<Player> getListJugadores() {
        return listJugadores;
    }

    public void setListJugadores(List<Player> players) {
        this.listJugadores.addAll(players);
    }

    public List<Coach> getListEntrenadores() {
        return listEntrenadores;
    }

    public void setListEntrenadores(List<Coach> coachs) {
        this.listEntrenadores.addAll(coachs);
    }

    public List<Doctor> getListMasajistas() {
        return listMasajistas;
    }

    public void setListMasajistas(List<Doctor> masajistas) {
        this.listMasajistas.addAll(masajistas);
    }
}
