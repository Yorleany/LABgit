package org.example.Dao;

import org.example.connection.DBConnector;
import org.example.mapper.CuentaMapper;
import org.example.models.Cuenta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CuentaDao implements CrudD<Cuenta, Integer>{
    private Connection connection;
    private CuentaMapper mapper;

    public CuentaDao() throws SQLException, ClassNotFoundException {
        this.connection = DBConnector.getConnection();
        this.mapper = new CuentaMapper();
    }
    @Override
    public void save(Cuenta model) {
        String insertUserQuery = "INSERT INTO cuenta (id_cuenta, id_cliente, tipo_cuenta, balance) VALUES (?,?,?,?)";
        var date = new Date(1);

        try(PreparedStatement preparedStatement = connection.prepareStatement(insertUserQuery)){
            preparedStatement.setInt(1,model.getIdCuenta());
            preparedStatement.setInt(2,model.getIdCliente());
            preparedStatement.setString(3,model.getTipoCuenta().toString());
            preparedStatement.setDouble(4,model.getBalance());
            preparedStatement.executeUpdate();
        }catch (SQLException e ){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Cuenta> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Cuenta> findAll() {
        String selectAllQuery = "SELECT * FROM cuenta";
        List<Cuenta> cuenta = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(selectAllQuery)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Cuenta cuentaResutl = mapper.toModel(resultSet);
                cuenta.add(cuentaResutl);
            }
        }catch (SQLException e ){
            e.printStackTrace();
        }
        return cuenta;
    }

    @Override
    public Cuenta update(Cuenta model) {
        String insertUserQuery = "UPDATE cuenta id_cuenta = ?, id_cliente = ?, tipo_cuenta = ?, balance = ? WHERE id_cuenta = ?";
        var date = new Date(1);

        try(PreparedStatement preparedStatement = connection.prepareStatement(insertUserQuery)){
            preparedStatement.setInt(1,model.getIdCuenta());
            preparedStatement.setInt(2,model.getIdCliente());
            preparedStatement.setDouble(3,model.getBalance());
            preparedStatement.executeUpdate();
        }catch (SQLException e ){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void delete(Integer id) {
        String deleteQuery = "DELETE FROM cuenta WHERE id_cuenta = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAll() {
        String deleteQuery = "DELETE FROM cuenta";
        try(PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)){
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
