package memoEx.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Mapper<T> {
    T mapping(ResultSet resultSet) throws SQLException;
}
