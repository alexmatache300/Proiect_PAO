package repos;

import dao.MaterieDao;
import entitati.Elev;
import entitati.Materie;
import entitati.Profesor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfesorRepo {
    public ProfesorRepo() {
        try (Connection con = DriverManager
                .getConnection(SQLConn.getUrl(),
                        SQLConn.getUserName(), SQLConn.getPassword())) {

            String createTable = "create table if not exists profesor(" +
                                 "   id int primary key auto_increment," +
                                 "   nume varchar(30) not null," +
                                 "   prenume varchar(30) not null," +
                                 "   materii varchar(255) not null," +
                                 "   idLocatie int not null" +
                                 ");";
            con.createStatement().executeUpdate(createTable);

            String deleteAll = "delete from profesor;";
            con.createStatement().executeUpdate(deleteAll);

            String insertStmt1 = "insert into profesor(nume,prenume,materii,idLocatie) " + "values ('Matei','Aurel','mate fizica',1)";
            String insertStmt2 = "insert into profesor(nume,prenume,materii,idLocatie) " + "values ('Drumea','Silviu','informatica',2)";
            String insertStmt3 = "insert into profesor(nume,prenume,materii,idLocatie) " + "values ('Alistari','Toma','chimie fizica biologie',3)";

            con.createStatement().executeUpdate(insertStmt1);
            con.createStatement().executeUpdate(insertStmt2);
            con.createStatement().executeUpdate(insertStmt3);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Profesor readById(int id) {
        Profesor profesor = null;

        try (Connection con = DriverManager
                .getConnection(SQLConn.getUrl(),
                        SQLConn.getUserName(), SQLConn.getPassword())) {

            String selectSql = "select * from profesor where id=" + id + ";";
            Statement stmt = con.createStatement();

            ResultSet resultSet = stmt.executeQuery(selectSql);

            if (resultSet.next()) {
                profesor = new Profesor();
                profesor.setId(resultSet.getInt("id"));
                profesor.setNume(resultSet.getString("nume"));
                profesor.setPrenume(resultSet.getString("prenume"));

                String materiiStr = resultSet.getString("materii");
                List<String> numeMaterii = List.of(materiiStr.split(" "));
                List<Materie> materii = new ArrayList<>();

                for (String numeMaterie : numeMaterii) {
                    materii.add(MaterieDao.getMaterie(numeMaterie));
                }

                profesor.setMaterii(materii);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return profesor;
    }

    public List<Profesor> getAll() {
        List<Profesor> profesori = new ArrayList<>();

        try (Connection con = DriverManager
                .getConnection(SQLConn.getUrl(),
                        SQLConn.getUserName(), SQLConn.getPassword())) {

            String selectSql = "select * from profesor;";
            ResultSet resultSet = con.createStatement().executeQuery(selectSql);

            while (resultSet.next()) {
                Profesor profesor = new Profesor();
                profesor = new Profesor();
                profesor.setId(resultSet.getInt("id"));
                profesor.setNume(resultSet.getString("nume"));
                profesor.setPrenume(resultSet.getString("prenume"));

                String materiiStr = resultSet.getString("materii");
                List<String> numeMaterii = List.of(materiiStr.split(" "));
                List<Materie> materii = new ArrayList<>();

                for (String numeMaterie : numeMaterii) {
                    materii.add(MaterieDao.getMaterie(numeMaterie));
                }

                profesor.setMaterii(materii);

                profesori.add(profesor);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return profesori;
    }

    public void insertProfesor(Profesor profesor) {
        try (Connection con = DriverManager
                .getConnection(SQLConn.getUrl(),
                        SQLConn.getUserName(), SQLConn.getPassword())) {

            String insertSql = "insert into profesor(nume,prenume,materii,idLocatie) " + "values (?,?,?,?)";
            PreparedStatement prep = con.prepareStatement(insertSql);

            prep.setString(1, profesor.getNume());
            prep.setString(2, profesor.getPrenume());

            StringBuilder materiiStrBuilder = new StringBuilder();
            for (Materie materie : profesor.getMaterii()) {
                materiiStrBuilder.append(" ");
                materiiStrBuilder.append(materie.getId());
            }

            String materiiStr = materiiStrBuilder.toString();

            prep.setString(3, materiiStr);
            prep.setInt(4, profesor.getIdLocatie());

            prep.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProfesor(Profesor profesor) {
        try (Connection con = DriverManager
                .getConnection(SQLConn.getUrl(),
                        SQLConn.getUserName(), SQLConn.getPassword())) {

             String updateSql = "update profesor set" +
                                "   id=?," +
                                "   nume=?," +
                                "   prenume=?," +
                                "   materii=?," +
                                "   idLocatie=?," +
                                "   where id=?;";

            PreparedStatement prep = con.prepareStatement(updateSql);

            prep.setInt(1, profesor.getId());
            prep.setString(2, profesor.getNume());
            prep.setString(3, profesor.getPrenume());

            StringBuilder materiiStrBuilder = new StringBuilder();
            for (Materie materie : profesor.getMaterii()) {
                materiiStrBuilder.append(" ");
                materiiStrBuilder.append(materie.getId());
            }

            String materiiStr = materiiStrBuilder.toString();

            prep.setString(4, materiiStr);

            prep.setInt(5, profesor.getIdLocatie());
            prep.setInt(6, profesor.getId());

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

            String deleteSql = "delete from profesor where id=?;";
            PreparedStatement prep = con.prepareStatement(deleteSql);

            prep.setInt(1, id);

            prep.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
