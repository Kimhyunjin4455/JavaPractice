package memoEx.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository implements AutoCloseable {


    private Connection connection;

    private Repository() {
    }

    public static Repository newConnection(String url, String user, String password) throws SQLException {
        Repository repository = new Repository();
        repository.connection = connect(url, user, password);
        return repository;
    }

    private static Connection connect(String url, String user, String password) throws SQLException {
        // TODO : DBMS와 연결한다.
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        return DriverManager.getConnection(url, user, password);
    }

    public int update(String sql) {
        // TODO : 파라미터 없는 수정 질의(INSERT, UPDATE, DELETE)
        return updateQuery(sql, null);
    }

    public int update(String sql, Object[] parameters) {
        // TODO : 파라미터 있는 수정 질의(INSERT, UPDATE, DELETE)
        try {
            if (null == parameters) {
                throw new SQLException("파라미터가 존재하지 않습니다.");
            }
            return updateQuery(sql, parameters);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    private int updateQuery(String sql, Object[] parameters) {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            if (null != parameters) {
                // 파라미터가 존재하면 파라미터를 넣어준다.
                for (int i = 0; i < parameters.length; i++) {
                    Object parameter = parameters[i];
                    statement.setObject(i + 1, parameter);
                }
            }
            // 질의 전달
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public <T> List<T> find(String sql, Mapper<T> mapper) {
        // TODO : 파라미터 없는 검색 질의
        if (null == mapper) {
            return new ArrayList<>();
        }
        return findQuery(sql, null, mapper);
    }

    public <T> List<T> find(String sql, Object[] parameters, Mapper<T> mapper) {
        // TODO : 파라미터 있는 검색 질의
        if (null == parameters || null == mapper) {
            return new ArrayList<>();
        }
        return findQuery(sql, parameters, mapper);
    }

    private <T> List<T> findQuery(String sql, Object[] parameters, Mapper<T> mapper) {
        List<T> list = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            if (null != parameters) {
                // 파라미터가 존재하면 파라미터를 넣어준다.
                for (int i = 0; i < parameters.length; i++) {
                    Object parameter = parameters[i];
                    statement.setObject(i + 1, parameter);
                }
            }
            // 질의 전달
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                // 데이터를 매핑하는 것은 Mapper 구현체에 맡긴다
                list.add(mapper.mapping(resultSet));
            }
            // ResultSet 객체 닫음, PreparedStatement는 AutoCloseable 방식으로 닫는다
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void close() throws SQLException {
        // TODO : AutoCloseable의 인터페이스
        connection.close();
    }
}
