package repos;

import entitati.Elev;
import entitati.Tema;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
private Integer id;
    private Date deadline;
    private Boolean done;
    private Integer nota;
    private Integer idElev;
*/

public class TemaRepo {
    public TemaRepo() {
        try (Connection con = DriverManager
                .getConnection(SQLConn.getUrl(),
                        SQLConn.getUserName(), SQLConn.getPassword())) {

            String createTable = "create table if not exists tema(" +
                                 "   id int primary key auto_increment," +
                                 "   deadline date not null," +
                                 "   done boolean not null," +
                                 "   nota int not null," +
                                 "   idElev int not null" +
                                 ");";
            con.createStatement().executeUpdate(createTable);

            String deleteAll = "delete from tema;";
            con.createStatement().executeUpdate(deleteAll);

            String insertStmt1 = "insert into tema(deadline,done,nota,idElev) " + "values ('2017-06-15',1,9,1)";
            String insertStmt2 = "insert into tema(deadline,done,nota,idElev) " + "values ('2017-06-15',1,10,2)";
            String insertStmt3 = "insert into tema(deadline,done,nota,idElev) " + "values ('2017-06-15',0,4,3)";

            con.createStatement().executeUpdate(insertStmt1);
            con.createStatement().executeUpdate(insertStmt2);
            con.createStatement().executeUpdate(insertStmt3);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Tema readById(int id) {
        Tema tema = null;

        try (Connection con = DriverManager
                .getConnection(SQLConn.getUrl(),
                        SQLConn.getUserName(), SQLConn.getPassword())) {

            String selectSql = "select * from tema where id=" + id + ";";
            Statement stmt = con.createStatement();

            ResultSet resultSet = stmt.executeQuery(selectSql);

            if (resultSet.next()) {
                tema = new Tema();
                tema.setId(resultSet.getInt("id"));
                tema.setDeadline(resultSet.getDate("deadline"));
                tema.setDone(resultSet.getBoolean("done"));
                tema.setNota(resultSet.getInt("nota"));
                tema.setIdElev(resultSet.getInt("idElev"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return tema;
    }

    public List<Tema> getAll() {
        List<Tema> teme = new ArrayList<>();

        try (Connection con = DriverManager
                .getConnection(SQLConn.getUrl(),
                        SQLConn.getUserName(), SQLConn.getPassword())) {

            String selectSql = "select * from tema;";
            ResultSet resultSet = con.createStatement().executeQuery(selectSql);

            while (resultSet.next()) {
                Tema tema = new Tema();
                tema.setId(resultSet.getInt("id"));
                tema.setDeadline(resultSet.getDate("deadline"));
                tema.setDone(resultSet.getBoolean("done"));
                tema.setNota(resultSet.getInt("nota"));
                tema.setIdElev(resultSet.getInt("idElev"));

                teme.add(tema);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return teme;
    }

    public void insertTeme(Tema tema) {
        try (Connection con = DriverManager
                .getConnection(SQLConn.getUrl(),
                        SQLConn.getUserName(), SQLConn.getPassword())) {

            String insertSql = "insert into tema(deadline,done,nota,idElev) " + "values (?,?,?,?)";
            PreparedStatement prep = con.prepareStatement(insertSql);

            prep.setDate(1, new java.sql.Date(tema.getDeadline().getTime()));
            prep.setBoolean(2, tema.getDone());
            prep.setInt(3, tema.getNota());
            prep.setInt(4, tema.getIdElev());

            prep.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTema(Tema tema) {
        try (Connection con = DriverManager
                .getConnection(SQLConn.getUrl(),
                        SQLConn.getUserName(), SQLConn.getPassword())) {

             String updateSql = "update elev set" +
                                "   id=?," +
                                "   deadline=?," +
                                "   done=?," +
                                "   nota=?," +
                                "   idElev=?," +
                                "   where id=?;";

            PreparedStatement prep = con.prepareStatement(updateSql);

            prep.setInt(1, tema.getId());
            prep.setDate(2, new java.sql.Date(tema.getDeadline().getTime()));
            prep.setBoolean(3, tema.getDone());
            prep.setInt(4, tema.getNota());
            prep.setInt(5, tema.getIdElev());
            prep.setInt(6, tema.getId());

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

            String deleteSql = "delete from tema where id=?;";
            PreparedStatement prep = con.prepareStatement(deleteSql);

            prep.setInt(1, id);

            prep.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
