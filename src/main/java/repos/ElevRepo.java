package repos;

import entitati.Elev;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ElevRepo {
    public ElevRepo() {
            try (Connection con = DriverManager
                    .getConnection(SQLConn.getUrl(),
                            SQLConn.getUserName(), SQLConn.getPassword())) {

                String createTable = "create table if not exists elev(" +
                                     "   id int primary key auto_increment," +
                                     "   nume varchar(30) not null," +
                                     "   prenume varchar(30) not null," +
                                     "   clasa int not null" +
                                     ");";
                con.createStatement().executeUpdate(createTable);

                String deleteAll = "delete from elev;";
                con.createStatement().executeUpdate(deleteAll);

                String insertStmt1 = "insert into elev(nume,prenume,clasa) " + "values ('Matache','Alexandru',11)";
                String insertStmt2 = "insert into elev(nume,prenume,clasa) " + "values ('Marian','Vlad',12)";
                String insertStmt3 = "insert into elev(nume,prenume,clasa) " + "values ('Tudose','George',10)";

                con.createStatement().executeUpdate(insertStmt1);
                con.createStatement().executeUpdate(insertStmt2);
                con.createStatement().executeUpdate(insertStmt3);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public Elev readById(int id) {
        Elev elev = null;

        try (Connection con = DriverManager
                .getConnection(SQLConn.getUrl(),
                        SQLConn.getUserName(), SQLConn.getPassword())) {

            String selectSql = "select * from elev where id=" + id + ";";
            Statement stmt = con.createStatement();

            ResultSet resultSet = stmt.executeQuery(selectSql);

            if (resultSet.next()) {
                elev = new Elev();
                elev.setId(resultSet.getInt("id"));
                elev.setNume(resultSet.getString("nume"));
                elev.setPrenume(resultSet.getString("prenume"));
                elev.setClasa(resultSet.getInt("clasa"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return elev;
    }

    public List<Elev> getAll() {
        List<Elev> elevi = new ArrayList<>();

        try (Connection con = DriverManager
                .getConnection(SQLConn.getUrl(),
                        SQLConn.getUserName(), SQLConn.getPassword())) {

            String selectSql = "select * from elev;";
            ResultSet resultSet = con.createStatement().executeQuery(selectSql);

            while (resultSet.next()) {
                Elev elev = new Elev();
                elev.setId(resultSet.getInt("id"));
                elev.setNume(resultSet.getString("nume"));
                elev.setPrenume(resultSet.getString("prenume"));
                elev.setClasa(resultSet.getInt("clasa"));

                elevi.add(elev);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return elevi;
    }

    public void insertElev(Elev elev) {
        try (Connection con = DriverManager
                .getConnection(SQLConn.getUrl(),
                        SQLConn.getUserName(), SQLConn.getPassword())) {

            String insertSql = "insert into elev(nume,prenume,clasa) " + "values (?,?,?)";
            PreparedStatement prep = con.prepareStatement(insertSql);

            prep.setString(1, elev.getNume());
            prep.setString(2, elev.getPrenume());
            prep.setInt(3, elev.getClasa());

            prep.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateElev(Elev elev) {
        try (Connection con = DriverManager
                .getConnection(SQLConn.getUrl(),
                        SQLConn.getUserName(), SQLConn.getPassword())) {

             String updateSql = "update elev set" +
                                "   id=?," +
                                "   nume=?," +
                                "   prenume=?," +
                                "   clasa=?," +
                                "   where id=?;";

            PreparedStatement prep = con.prepareStatement(updateSql);

            prep.setInt(1, elev.getId());
            prep.setString(2, elev.getNume());
            prep.setString(3, elev.getPrenume());
            prep.setInt(4, elev.getClasa());
            prep.setInt(5, elev.getId());

            prep.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id) {
        try (Connection con = DriverManager
                .getConnection(SQLConn.getUrl(),
                        SQLConn.getUserName(), SQLConn.getPassword())) {

            String deleteSql = "delete from elev where id=?;";
            PreparedStatement prep = con.prepareStatement(deleteSql);

            prep.setInt(1, id);

            prep.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
