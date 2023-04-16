package org.example;

import org.example.Dao.CuentaDao;
import org.example.connection.InitDT;
import org.example.enums.TipoCuenta;
import org.example.models.Cuenta;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class CuentaPractica {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Logger logger = Logger.getLogger("JDBC-CRUD");
        InitDT.init();
        CuentaDao repository = new CuentaDao();
        Cuenta dummy = new Cuenta();
        dummy.setIdCuenta(11111);
        dummy.setIdCliente(11);
        dummy.setTipoCuenta(TipoCuenta.Ahorro);
        dummy.setBalance(200.00);
        repository.save(dummy);

        List<Cuenta> res = repository.findAll();
        logger.info(res.get(0).toString());
    }
}
