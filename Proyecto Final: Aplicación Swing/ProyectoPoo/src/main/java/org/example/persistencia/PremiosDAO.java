package org.example.persistencia;



import org.example.modelo.Premios;

import java.sql.*;
import java.util.ArrayList;

public class PremiosDAO implements InterfazDAO {
    public PremiosDAO() {
    }
    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO Premios (Categoria,Condecorado,Nacionalidad,Fecha,Url) VALUES(?,?,?,?,?)";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("PremiosNobelDB.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1,((Premios)obj).getCategoria());
        pstm.setString(2,((Premios)obj).getCondecorado());
        pstm.setString(3,((Premios)obj).getNacionalidad());
        pstm.setString(4,((Premios)obj).getFecha());
        pstm.setString(5,((Premios)obj).getUrl());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE Premios SET Categoria = ?, Condecorado = ?, Nacionalidad = ?, Fecha = ?, Url = ? WHERE id = ? ;";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("PremiosNobelDB.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1,((Premios)obj).getCategoria());
        pstm.setString(2,((Premios)obj).getCondecorado());
        pstm.setString(3,((Premios)obj).getNacionalidad());
        pstm.setString(4,((Premios)obj).getFecha());
        pstm.setString(5,((Premios)obj).getUrl());
        pstm.setInt(6,((Premios)obj).getId());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete="DELETE FROM Premios WHERE id=?;";
        int rowCout=0;
        PreparedStatement pstm= ConexionSingleton.getInstance("PremiosNobelDB.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1,Integer.parseInt(id));
        rowCout =pstm.executeUpdate();
        return rowCout>0;
    }


    @Override
    public ArrayList<Premios> obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM Premios ";
        ArrayList<Premios> resultado = new ArrayList<>();
        String dbPath = "C:/Users/alber/IdeaProjects/ProyectoPoo/PremiosNobelDB.db";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                resultado.add(new Premios(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5), resultSet.getString(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resultado;
    }


    @Override
    public Object buscarPorId(String id) throws SQLException {
            String sql ="SELECT * FROM Premios WHERE id=?";
           Premios premios =null;

            PreparedStatement pstm = ConexionSingleton.getInstance("PremiosNobelDB.db").getConnection().prepareStatement(sql);
            pstm.setInt(1,Integer.parseInt(id));
            ResultSet rst= pstm.executeQuery();
            if (rst.next()) {
                premios = new Premios(rst.getInt(1), rst.getString(2), rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6));
                return premios;
            }
            return null;
        }
    }