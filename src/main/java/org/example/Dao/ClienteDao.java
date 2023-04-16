package org.example.Dao;

import org.example.connection.DBConnector;
import org.example.mapper.ClienteMapper;
import org.example.models.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ClienteDao implements CrudD<Cliente, Integer> {
    private Connection connection;
    private ClienteMapper mapper;

    public ClienteDao() throws SQLException, ClassNotFoundException {
        this.connection = DBConnector.getConnection();
        this.mapper = new ClienteMapper();
    }

    @Override
    public void save(Cliente model) {
        String insertUserQuery = "INSERT INTO cliente (id_cliente, nombre, apellido, cedula, " +
                "f_nacimiento, status_laboral, nivel_riesgo) VALUES (?,?,?,?,?,?,?)";
        var date = new Date(1);


        try(PreparedStatement preparedStatement = connection.prepareStatement(insertUserQuery)){
            preparedStatement.setInt(1,model.getIdCliente());
            preparedStatement.setString(2,model.getNombre());
            preparedStatement.setString(3,model.getApellido());
            preparedStatement.setString(4, model.getCedula());
            preparedStatement.setDate(5, Date.valueOf(model.getfNacimiento().toString()));
            preparedStatement.setBoolean(6,model.isStatuslaboral());
            preparedStatement.setString(7, model.getNivelRiesgo().name());
            preparedStatement.executeUpdate();
        }catch (SQLException e ){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Cliente> findById(Integer id) {
        String selectByIdQuery = "SELECT * FROM CUSTOMERS WHERE ID_CUSTOMER = ?";
        Cliente cliente = null;
        try(PreparedStatement preparedStatement = connection.prepareStatement(selectByIdQuery)){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                cliente = mapper.toModel(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Objects.nonNull(cliente) ? Optional.of(cliente):Optional.empty();
    }

    @Override
    public List<Cliente> findAll() {
        String selectAllQuery = "SELECT * FROM cliente";
        List<Cliente> customers = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(selectAllQuery)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Cliente customer = mapper.toModel(resultSet);
                customers.add(customer);
            }
        }catch (SQLException e ){
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public Cliente update(Cliente model) {
        String updateCustomerQuery = "UPDATE cliente SET nombre = ? , apellido = ? , cedula = ? , f_nacimiento = ? , " +
                "status_laboral = ? , nivel_riesgo = ? WHERE id_cliente = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(updateCustomerQuery)){
            preparedStatement.setString(1,model.getNombre());
            preparedStatement.setString(2,model.getApellido());
            preparedStatement.setString(3, model.getCedula());
            preparedStatement.setString(4,model.getfNacimiento().toString());
            preparedStatement.setBoolean(5,model.isStatuslaboral());
            preparedStatement.setString(6, model.getNivelRiesgo().name());
            preparedStatement.setInt(7,model.getIdCliente());
        }catch (SQLException e ){
            e.printStackTrace();
        }
        return model;
    }

    @Override
    public void delete(Integer id) {
        String deleteQuery = "DELETE FROM cliente WHERE id_cliente = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAll() {
        String deleteQuery = "DELETE FROM cliente";
        try(PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)){
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
