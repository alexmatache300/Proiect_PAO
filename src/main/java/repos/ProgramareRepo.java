package repos;

import entitati.Programare;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProgramareRepo {
    public ProgramareRepo() {
        try (Connection con = DriverManager
                .getConnection(SQLConn.getUrl(),
                        SQLConn.getUserName(), SQLConn.getPassword())) {

            String createTable = "create table if not exists programare(" +
                                 "   idProfesor int not null," +
                                 "   idElev int not null," +
                                 "   zi date not null," +
                                 "   anulata boolean not null," +
                                 "   plata varchar(30) not null," +
                                 "   primary key(idProfesor, idElev)" +
                                 ");";
            con.createStatement().executeUpdate(createTable);

            String deleteAll = "delete from programare;";
            con.createStatement().executeUpdate(deleteAll);

            String insertStmt1 = "insert into programare(idProfesor,idElev,zi,anulata,plata) values (1,2,'2017-06-15',1,'cash')";
            String insertStmt2 = "insert into programare(idProfesor,idElev,zi,anulata,plata) values (2,3,'2017-06-14',0,'card')";
            String insertStmt3 = "insert into programare(idProfesor,idElev,zi,anulata,plata) values (3,1,'2017-06-10',1,'cash')";

            con.createStatement().executeUpdate(insertStmt1);
            con.createStatement().executeUpdate(insertStmt2);
            con.createStatement().executeUpdate(insertStmt3);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Programare readById(int idProfesor, int idElev) {
        Programare programare = null;

        try (Connection con = DriverManager
                .getConnection(SQLConn.getUrl(),
                        SQLConn.getUserName(), SQLConn.getPassword())) {

            String selectSql = "select * from programare where idProfesor=" + idProfesor +
                    " and idElev=" + idElev + ";";
            Statement stmt = con.createStatement();

            ResultSet resultSet = stmt.executeQuery(selectSql);

            if (resultSet.next()) {
                programare = new Programare();
                programare.setId(resultSet.getInt("id"));
                programare.setIdProfesor(resultSet.getInt("idProfesor"));
                programare.setIdElev(resultSet.getInt("idElev"));
                programare.setZi(resultSet.getDate("zi"));
                programare.setId(resultSet.getInt("id"));
                programare.setAnulata(resultSet.getBoolean("anulata"));
                programare.setPlata(resultSet.getString("plata"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return programare;
    }

    public List<Programare> getAll() {
        List<Programare> programari = new ArrayList<>();

        try (Connection con = DriverManager
                .getConnection(SQLConn.getUrl(),
                        SQLConn.getUserName(), SQLConn.getPassword())) {

            String selectSql = "select * from programare;";
            ResultSet resultSet = con.createStatement().executeQuery(selectSql);

            while (resultSet.next()) {
                Programare programare = new Programare();
                programare.setId(resultSet.getInt("id"));
                programare.setIdProfesor(resultSet.getInt("idProfesor"));
                programare.setIdElev(resultSet.getInt("idElev"));
                programare.setZi(resultSet.getDate("zi"));
                programare.setId(resultSet.getInt("id"));
                programare.setAnulata(resultSet.getBoolean("anulata"));
                programare.setPlata(resultSet.getString("plata"));

                programari.add(programare);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return programari;
    }

    public void insertProgramare(Programare programare) {
        try (Connection con = DriverManager
                .getConnection(SQLConn.getUrl(),
                        SQLConn.getUserName(), SQLConn.getPassword())) {

            String insertSql = "insert into programare(idProfesor,idElev,zi,anulata,plata) values (?,?,?,?,?,?)";
            PreparedStatement prep = con.prepareStatement(insertSql);

            prep.setInt(1, programare.getProfesor());
            prep.setInt(2, programare.getElev());
            prep.setDate(3, new java.sql.Date(programare.getZi().getTime()));
            prep.setInt(4, programare.getId());
            prep.setBoolean(5, programare.getAnulata());
            prep.setString(6, programare.getPlata());

            prep.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProgramare(Programare programare) {
        try (Connection con = DriverManager
                .getConnection(SQLConn.getUrl(),
                        SQLConn.getUserName(), SQLConn.getPassword())) {

             String updateSql = "update elev set" +
                                "   idProfesor=?," +
                                "   idElev=?," +
                                "   zi=?," +
                                "   anulata=?," +
                                "   plata=?," +
                                "   where idProfesor=? and idElev=?;";

            PreparedStatement prep = con.prepareStatement(updateSql);

            prep.setInt(1, programare.getProfesor());
            prep.setInt(2, programare.getElev());
            prep.setDate(3, new java.sql.Date(programare.getZi().getTime()));
            prep.setInt(4, programare.getId());
            prep.setBoolean(5, programare.getAnulata());
            prep.setString(6, programare.getPlata());
            prep.setInt(7, programare.getProfesor());
            prep.setInt(8, programare.getElev());

            prep.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer idProfesor, Integer idElev) {
        try (Connection con = DriverManager
                .getConnection(SQLConn.getUrl(),
                        SQLConn.getUserName(), SQLConn.getPassword())) {

            String deleteSql = "delete from programare where idProfesor=? and idElev=?;";
            PreparedStatement prep = con.prepareStatement(deleteSql);

            prep.setInt(1, idProfesor);
            prep.setInt(2, idElev);

            prep.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
