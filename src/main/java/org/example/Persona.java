package org.example;

import org.example.Dao.ClienteDao;
import org.example.connection.InitDT;
import org.example.enums.ClasificacionRiesgo;
import org.example.models.Cliente;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;


public class Persona {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Logger logger = Logger.getLogger("JDBC-CRUD");
        InitDT.init();
        ClienteDao repository = new ClienteDao();
        Cliente dummy = new Cliente();
        dummy.setNombre("Alessio");
        dummy.setApellido("Maddaluno");
        dummy.setCedula("777777");
        dummy.setfNacimiento(LocalDate.now());
        dummy.setStatuslaboral(false);
        dummy.setNivelRiesgo(ClasificacionRiesgo.AA);
        repository.save(dummy);

        // Fetch all data from the table
        List<Cliente> res = repository.findAll();
        logger.info(res.toString());
    }
}

