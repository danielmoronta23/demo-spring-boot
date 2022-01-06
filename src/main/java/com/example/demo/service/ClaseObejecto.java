package com.example.demo.service;

public class ClaseObejecto {
    private Object resultado;

    public ClaseObejecto(Object objecto) {
        this.resultado = objecto;
    }

    public Object getResultado() {
        return resultado;
    }

    public void setResultado(Object resultado) {
        this.resultado = resultado;
    }

    public static ClaseObejecto crearNuevoResultado(Object obj) {
        return new ClaseObejecto(obj);
    }
}
