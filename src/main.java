import dao.*;

import servici.Audit;
import servici.ServiciiElev;
import servici.ServiciiProfesor;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GrupaDao grupaDao = new GrupaDao(new HashMap<>());
        LocatieDao locatieDao = new LocatieDao(new HashMap<>());
        MaterieDao materieDao = new MaterieDao(new HashMap<>());
        Audit audit;
        try {
            audit = new Audit("audit.csv");
        }catch (Exception e)
        {
            e.printStackTrace();
            return;
        }
        PersoanaDao persoanaDao;
        try {
            persoanaDao = new PersoanaDao(new HashMap<>());
        }catch (Exception e)
        {
            e.printStackTrace();
            return;
        }
        ProgramareDao programareDao = new ProgramareDao(new HashMap<>());
        TemaDao temaDao = new TemaDao(new HashMap<>());
        ServiciiElev serviciiElev = new ServiciiElev(programareDao, grupaDao, persoanaDao, temaDao);
        ServiciiProfesor serviciiProfesor = new ServiciiProfesor(programareDao, grupaDao, persoanaDao, temaDao, materieDao);

        String comanda = "";
        Scanner cin = new Scanner(System.in);

        while (!comanda.equals("exit")) {

            System.out.print("comanda: ");
            comanda = cin.nextLine();

            switch(comanda) {
                case "creare programare elev" -> {
                    System.out.print("id profesor: ");
                    int idProfesor = Integer.parseInt(cin.nextLine());
                    System.out.print("id elev: ");
                    int idElev = Integer.parseInt(cin.nextLine());
                    System.out.print("data (yyyy-MM-dd): ");
                    String zi = cin.nextLine();
                    System.out.print("id programare: ");
                    int id = Integer.parseInt(cin.nextLine());
                    System.out.print("metoda plata: ");
                    String plata = cin.nextLine();
                    try {
                        serviciiElev.creareProgramare(idProfesor, idElev, new SimpleDateFormat("yyyy-MM-dd").parse(zi), id, plata);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        audit.logAction("creare programare elev");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case "inscriere in grupa elev" -> {
                    System.out.print("id elev: ");
                    int idElev = Integer.parseInt(cin.nextLine());
                    System.out.print("id grupa: ");
                    int idGrupa = Integer.parseInt(cin.nextLine());
                    serviciiElev.inscriereInGrupa(idElev, idGrupa);
                    try {
                        audit.logAction("inscriere in grupa elev");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case "tema completata elev" -> {
                    System.out.print("id elev: ");
                    int idElev = Integer.parseInt(cin.nextLine());
                    System.out.print("id tema: ");
                    int idTema = Integer.parseInt(cin.nextLine());
                    serviciiElev.temaCompletata(idElev, idTema);
                    try {
                        audit.logAction("tema completata elev");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case "anulare programare elev" -> {
                    System.out.print("id programare: ");
                    int idProgramare = Integer.parseInt(cin.nextLine());
                    serviciiElev.anulareProgramare(idProgramare);
                    try {
                        audit.logAction("anulare programare elev");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case "metoda plata elev" -> {
                    System.out.print("metoda plata: ");
                    String plata = cin.nextLine();
                    System.out.print("id programare: ");
                    int idProgramare = Integer.parseInt(cin.nextLine());
                    serviciiElev.metodaPlata(plata, idProgramare);
                    try {
                        audit.logAction("metoda plata elev");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case "anulare programare profesor" -> {
                    System.out.print("id programare: ");
                    int idProgramare = Integer.parseInt(cin.nextLine());
                    serviciiProfesor.anulareProgramare(idProgramare);
                    try {
                        audit.logAction("anulare programare profesor");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case "evaluare tema profesor" -> {
                    System.out.print("id tema: ");
                    int idTema = Integer.parseInt(cin.nextLine());
                    System.out.print("nota: ");
                    int nota = Integer.parseInt(cin.nextLine());
                    serviciiProfesor.evaluareTema(idTema, nota);
                    try {
                        audit.logAction("evaluare tema profesor");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case "creare tema profesor" -> {
                    System.out.print("deadline (yyyy-MM-dd): ");
                    String deadline = cin.nextLine();
                    System.out.print("done (true/false): ");
                    Boolean done = Boolean.parseBoolean(cin.nextLine());
                    System.out.print("id elev: ");
                    int idElev = Integer.parseInt(cin.nextLine());
                    try {
                        serviciiProfesor.creareTema(new SimpleDateFormat("yyyy-MM-dd").parse(deadline), done, idElev);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        audit.logAction("creare tema profesor");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case "adaugare materie de predare" -> {
                    System.out.print("nume matrerie: ");
                    String numeMaterie = cin.nextLine();
                    System.out.print("id profesor: ");
                    int idProfesor = Integer.parseInt(cin.nextLine());
                    serviciiProfesor.adaugareMaterieDePredare(numeMaterie, idProfesor);
                    try {
                        audit.logAction("adaugare materie de predare");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case "scoatere materie de predare" -> {
                    System.out.print("nume materie: ");
                    String numeMaterie = cin.nextLine();
                    System.out.print("id profesor: ");
                    int idProf = Integer.parseInt(cin.nextLine());
                    serviciiProfesor.adaugareMaterieDePredare(numeMaterie, idProf);
                    try {
                        audit.logAction("scoatere materie de predare");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
