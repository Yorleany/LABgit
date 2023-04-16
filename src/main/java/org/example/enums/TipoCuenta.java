package org.example.enums;

public enum TipoCuenta {
    Ahorro(1), Corriente(0), PlazoFijo(5);
    private int tasa;
    TipoCuenta(int tasa){
        this.tasa=tasa;
    }

    public int getTasa() {
        return tasa;
    }
}
