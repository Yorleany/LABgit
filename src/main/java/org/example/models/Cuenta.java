package org.example.models;

import org.example.enums.TipoCuenta;

import java.io.Serializable;

public class Cuenta implements Serializable {
    private int idCuenta;
    private int idCliente;

    @Override
    public String toString() {
        return "Cuenta{" +
                "idCuenta=" + idCuenta +
                ", idCliente=" + idCliente +
                ", tipoCuenta=" + tipoCuenta +
                ", balance=" + balance +
                ", movInterest=" + movInterest +
                ", movMan=" + movMan +
                ", MAX_MOV_MAN=" + MAX_MOV_MAN +
                ", MAX_MOV_INTEREST=" + MAX_MOV_INTEREST +
                ", titular=" + titular +
                '}';
    }

    private TipoCuenta tipoCuenta;
    private double balance;
    private int movInterest= 0;
    private int movMan = 0;
    private int MAX_MOV_MAN = 4;
    private int MAX_MOV_INTEREST = 6;
    private Cliente titular;

    public Cuenta(int idCuenta, int idCliente, TipoCuenta tipoCuenta, double balance, int movInterest,
                  int movMan, int MAX_MOV_MAN, int MAX_MOV_INTEREST, Cliente titular) {
        this.idCuenta = idCuenta;
        this.idCliente = idCliente;
        this.tipoCuenta = tipoCuenta;
        this.balance = balance;
        this.movInterest = movInterest;
        this.movMan = movMan;
        this.MAX_MOV_MAN = MAX_MOV_MAN;
        this.MAX_MOV_INTEREST = MAX_MOV_INTEREST;
        this.titular = titular;
    }

    public Cuenta() {

    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getMovInterest() {
        return movInterest;
    }

    public void setMovInterest(int movInterest) {
        this.movInterest = movInterest;
    }

    public int getMovMan() {
        return movMan;
    }

    public void setMovMan(int movMan) {
        this.movMan = movMan;
    }

    public int getMAX_MOV_MAN() {
        return MAX_MOV_MAN;
    }

    public void setMAX_MOV_MAN(int MAX_MOV_MAN) {
        this.MAX_MOV_MAN = MAX_MOV_MAN;
    }

    public int getMAX_MOV_INTEREST() {
        return MAX_MOV_INTEREST;
    }

    public void setMAX_MOV_INTEREST(int MAX_MOV_INTEREST) {
        this.MAX_MOV_INTEREST = MAX_MOV_INTEREST;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }
}

