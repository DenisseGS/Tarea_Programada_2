/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jugador;

import java.io.Serializable;

/**
 *
 * @author Ale
 */
public class Jugador implements Serializable {

    private static String nickname;
    private String password;
    private int puntuacion;
    protected boolean activo = true;

    public Jugador(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;

    }

    public Jugador(String nickname, String password, int puntuacion) {
        this.nickname = nickname;
        this.password = password;
        this.puntuacion = puntuacion;

    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getTamano() {
        int tam1;
        tam1 = ((getNickname().length() * 2) + (getPassword().length() * 2) + 2 + 1);
        return tam1;
    }
}
