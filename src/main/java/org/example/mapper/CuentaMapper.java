package org.example.mapper;

import org.example.enums.ClasificacionRiesgo;
import org.example.enums.TipoCuenta;
import org.example.models.Cliente;
import org.example.models.Cuenta;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CuentaMapper implements BaseMapper<Cuenta>{
    @Override
    public Cuenta toModel(ResultSet resultSet) {
        Cuenta cuenta = new Cuenta();
        try {
            cuenta.setIdCuenta(resultSet.getInt("id_cuenta"));
            cuenta.setIdCliente(resultSet.getInt("id_cliente"));
            cuenta.setTipoCuenta(TipoCuenta.valueOf(resultSet.getString("tipo_cuenta")));
            cuenta.setBalance(resultSet.getDouble("balance"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cuenta;
    }
}
