package org.example.mapper;

import java.sql.ResultSet;

public interface BaseMapper <T>{
    public T toModel(ResultSet s);
}
