import dao.*;

import servici.ServiciiElev;
import servici.ServiciiProfesor;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        GrupaDao grupaDao = new GrupaDao(new HashMap<>());
        LocatieDao locatieDao = new LocatieDao(new HashMap<>());
        MaterieDao materieDao = new MaterieDao(new HashMap<>());
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

        while (comanda != "exit") {
            // citesti comanda
            comanda = cin.nextLine();

            switch(comanda) {
                case "creare_programare_elev" -> { //Integer id_profesor , Integer id_elev , Date zi , Integer id, String plata
                    int id_profesor = cin.nextInt();
                    int id_elev = cin.nextInt();
                    String zi = cin.nextLine();
                    int id = cin.nextInt();
                    String plata = cin.nextLine();
                    try {
                        serviciiElev.creare_programare(id_profesor, id_elev, new SimpleDateFormat("yyyy-MM-dd").parse(zi), id, plata);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case "inscriere_in_grupa_elev" -> {
                    int id_elev = cin.nextInt();
                    int id_grupa = cin.nextInt();
                    serviciiElev.inscriere_in_grupa(id_elev, id_grupa);
                }
                case "tema_completata_elev" -> {
                    int id_elev = cin.nextInt();
                    int id_tema = cin.nextInt();
                    serviciiElev.tema_completata(id_elev, id_tema);
                }
                case "anulare_programare_elev" -> {
                    int id_programare = cin.nextInt();
                    serviciiElev.anulare_programare(id_programare);
                }
                case "metoda_plata_elev" -> {//String plata, Integer id_programare
                    String plata = cin.nextLine();
                    int id_programare = cin.nextInt();
                    serviciiElev.metoda_plata(plata, id_programare);
                }
                case "anulare_programare_profesor" -> {
                    int id_programare = cin.nextInt();
                    serviciiProfesor.anulare_programare(id_programare);
                }
                case "evaluare_tema_profesor" -> {
                    int id_tema = cin.nextInt();
                    int nota = cin.nextInt();
                    serviciiProfesor.evaluare_tema(id_tema, nota);
                }
                case "creare_tema_profesor" -> {
                    String deadline = cin.nextLine();
                    Boolean done = cin.nextBoolean();
                    int id_elev = cin.nextInt();
                    try {
                        serviciiProfesor.creare_tema(new SimpleDateFormat("yyyy-MM-dd").parse(deadline), done, id_elev);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case "adaugare_materie_de_predare" -> {
                    String nume_materie = cin.nextLine();
                    int id_profesor = cin.nextInt();
                    serviciiProfesor.adaugare_materie_de_predare(nume_materie, id_profesor);
                }
                case "scoatere_materie_de_predare" -> {
                    String nume_materie = cin.nextLine();
                    int id_prof = cin.nextInt();
                    serviciiProfesor.adaugare_materie_de_predare(nume_materie, id_prof);
                }
            }
        }
    }
}
