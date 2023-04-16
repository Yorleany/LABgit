package org.example.mapper;

import org.example.enums.ClasificacionRiesgo;
import org.example.models.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ClienteMapper implements BaseMapper<Cliente> {
    @Override
    public Cliente toModel(ResultSet resultSet) {
        Cliente cliente = new Cliente();
        try {
            cliente.setIdCliente(resultSet.getInt("id_cliente"));
            cliente.setNombre(resultSet.getString("nombre"));
            cliente.setApellido(resultSet.getString("apellido"));
            cliente.setCedula(resultSet.getString("cedula"));
            cliente.setfNacimiento(resultSet.getDate("f_nacimiento").toLocalDate());
            cliente.setStatuslaboral(resultSet.getBoolean("status_laboral"));
            cliente.setNivelRiesgo(ClasificacionRiesgo.valueOf(resultSet.getString("nivel_riesgo")));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }
}
