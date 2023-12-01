package lab8;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

import static java.sql.Types.NULL;

public class main {

    public static void adaugarePersoana(Connection connection, String nume, int varsta){
        String sql="insert into persoane(nume, varsta) values (?, ?)";
        try(PreparedStatement ps=connection.prepareStatement(sql)){
            ps.setString(1, nume);
            ps.setInt(2,varsta);
            int nr_randuri=ps.executeUpdate();
            System.out.println("\nNumar randuri afectate de adaugare="+nr_randuri);
        } catch(SQLException e){
            System.out.println(sql);
            e.printStackTrace();
        }
    }

    public static void adaugaExcursie(Connection connection, Scanner scanner) throws SQLException, ExceptieAnExcursie {
        System.out.println("Introduceti ID-ul persoanei la care doriti sa adaugati aceasta excursie: ");
        int idPersoana=scanner.nextInt();
        scanner.nextLine(); // consume newline zz

        if(!existaPersoana(connection,idPersoana))
        {
            System.out.println("Persoana cu acest ID nu exista!");
            return;
        }

        System.out.println("Introduceti destinatia excursiei: ");

        String destinatia = scanner.nextLine();

        System.out.println("Introduceti anul excursiei: ");

        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();


        int anulNasterii = returnVarsta(connection, idPersoana); // returneaza varsta
        anulNasterii=currentYear-anulNasterii;

        int anul = citesteAnExcursie(anulNasterii, scanner);

        String insertExcursie = "INSERT INTO excursii (id_persoana, destinatia, anul) VALUES (?, ?, ?)";
        try(PreparedStatement ps = connection.prepareStatement(insertExcursie))
        {
            ps.setInt(1, idPersoana);
            ps.setString(2, destinatia);
            ps.setInt(3,anul);
            ps.executeUpdate();
            System.out.println("Excursie adaugata la persoana cu ID-ul " + idPersoana + "!");
        }catch(SQLException e){
            System.out.println(insertExcursie);
            e.printStackTrace();
        }

    }

    public static int returnVarsta(Connection connection, int ID) throws SQLException {
        String existaPersoana = "SELECT varsta FROM persoane where id = ?";
        try(PreparedStatement ps = connection.prepareStatement(existaPersoana))
        {
            ps.setInt(1, ID);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            int varsta = resultSet.getInt(1);
            return varsta;
        }
    }
    public static boolean existaPersoana(Connection connection, int ID) throws SQLException {
        String existaPersoana = "SELECT COUNT(*) FROM persoane where id = ?";
        try(PreparedStatement ps = connection.prepareStatement(existaPersoana))
        {
            ps.setInt(1, ID);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            return count>0;
        }
    }

    public static int citesteVarsta(Scanner scanner) throws ExceptieVarsta {
        try {
            int varsta = scanner.nextInt();
            if (varsta < 0 || varsta > 150) {
                throw new ExceptieVarsta("Varsta trebuie sa fie intre 0 si 150");
            }
            return varsta;
        } catch(Exception e){
            scanner.nextLine(); // consume newline
            throw new ExceptieVarsta("Varsta introdusa nu este valida.");
        }
    }

    public static int citesteAnExcursie(int anNastere, Scanner scanner) throws ExceptieAnExcursie
    {
        try{
            int anul = scanner.nextInt();
            if(anul < anNastere || anul > 2023){
                throw new ExceptieAnExcursie("Anul excursiei trebuie sa fie intre anul " + anNastere + " si anul " + anul);
            }
            return anul;
        }catch(Exception e){
            scanner.nextLine(); // consume newline
            throw new ExceptieAnExcursie("Anul introdus pentru excursie nu este valid.");
        }
    }

    public static void afiseazaPersoane(Connection connection) throws SQLException {
        String selectPersoane = "SELECT p.id, p.nume, p.varsta, e.id_excursie, e.destinatia, e.anul FROM persoane p LEFT JOIN excursii e ON p.id = e.id_persoana";

        PreparedStatement statement = connection.prepareStatement(selectPersoane);
        ResultSet rs = statement.executeQuery(selectPersoane);

        int currentPersonId = -1;

        while(rs.next()) {
            int persoanaID = rs.getInt("id");
            if(persoanaID !=currentPersonId) {
                System.out.println("id=" + rs.getInt("id") + ", nume= " + rs.getString("nume") +
                        ", varsta=" + rs.getInt("varsta" ));
                currentPersonId=persoanaID;
            }
            if(rs.getInt("id_excursie")!=NULL)
                System.out.println(", id excursie=" + rs.getString("id_excursie") + ", destinatie = "+ rs.getString("destinatia") +
                        ", anul: " + rs.getInt("anul"));

        }
    }

    public static void afisareExcursiiPersoana(Connection connection, String nume_persoana) throws SQLException {

        String sql = "SELECT e.id_excursie, e.destinatia, e.anul FROM lab8db.persoane p JOIN lab8db.excursii e ON p.id = e.id_persoana WHERE p.nume = ?";

        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, nume_persoana);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("id excursie=" + rs.getInt("id_excursie") + ", destinatia = "+ rs.getString("destinatia") +
                        ", anul: " + rs.getInt("anul"));
            }
        } catch(SQLException e){
            System.out.println(sql);
            e.printStackTrace();
        }
    }

    public static void afisarePersoaneDupaDestinatie(Connection connection, Scanner scanner) throws SQLException{
        scanner.nextLine();
        String sql = "SELECT DISTINCT p.nume FROM lab8db.persoane p JOIN lab8db.excursii e ON p.id = e.id_persoana WHERE e.destinatia = ?";
        System.out.println("Introduceti numele destinatiei: ");
        String nume_destinatie = scanner.nextLine();
        try(PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, nume_destinatie);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("Nume: " + rs.getString(1));
            }
        }

    }

    public static void afisareDupaAnulExcursiei(Connection connection, Scanner scanner) throws SQLException {
        scanner.nextLine();
        String sql = "SELECT DISTINCT p.nume FROM persoane p JOIN excursii e ON p.id = e.id_persoana WHERE e.anul = ?";
        System.out.println("Introduceti anul: ");
        int an = scanner.nextInt();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, an);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            System.out.println("Nume: " + rs.getString(1));
        }
    }

    public static void stergereExcursie(Connection connection, Scanner scanner) throws SQLException{
        scanner.nextLine();
        String sql = "DELETE from excursii WHERE id_excursie = ?";
        System.out.println("Introduceti ID-ul excursiei pe care doriti sa o stergeti");
        int idExcursie = scanner.nextInt();
        PreparedStatement ps= connection.prepareStatement(sql);
        ps.setInt(1, idExcursie);
        int nr_randuri=ps.executeUpdate();
        if (nr_randuri>0)
            System.out.println("\nLinia cu ID-ul: " + idExcursie + " a fost stearsa!");
        else
            System.out.println("Nu s-a sters nicio linie");
    }

    public static void stergerePersoanaCuTotCuExcursii(Connection connection, Scanner scanner) throws SQLException{
        scanner.nextLine();
        String stergereExcursii = "DELETE FROM excursii where id_persoana = ?";
        String stergerePersoana = "DELETE FROM persoane where id = ?";
        System.out.println("Introduceti ID-ul persoanei pe care doriti sa o stergeti");
        int idPers = scanner.nextInt();
        PreparedStatement ps = connection.prepareStatement(stergereExcursii);
        ps.setInt(1, idPers);
        ps.executeUpdate();
        ps=connection.prepareStatement(stergerePersoana);
        ps.setInt(1, idPers);
        int checkIfRemoved = ps.executeUpdate();
        if(checkIfRemoved > 0)
            System.out.println("S-a sters persoana cu ID-ul: " + idPers);
        else
            System.out.println("Nu exista acest ID in tabela!");
    }

    public static void main(String[] args) throws SQLException, ExceptieVarsta, ExceptieAnExcursie {
        int opt;
        Scanner scanner = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/lab8db";
        Connection connection = DriverManager.getConnection (url, "root", "system");
        Statement statement;
        statement = connection.createStatement();

        ResultSet rs;
        rs = statement.executeQuery("select * from persoane");

        while (rs.next())
            System.out.println("id="+rs.getInt("id")+", nume= " + rs.getString("nume")+ ", varsta="+rs.getInt("varsta"));


        do{
            System.out.println("0. Iesire.");
            System.out.println("1. Adăugarea unei persoane în tabela persoane. Numele şi vârsta se vor prelua de la\n" +
                    "tastatură.");
            System.out.println("2. Adăugarea unei excursii în tabela excursii. Înainte de a efectua adăugarea se va\n" +
                    "verifica dacă persoana căreia îi aparține excursia a fost introdusă în tabela\n" +
                    "persoane. Dacă nu a fost introdusă se va afișa un mesaj corespunzător. Datele\n" +
                    "excursiei se vor prelua de la tastatură.");
            System.out.println("3. Afișarea tuturor persoanelor şi pentru fiecare persoană a excursiilor în care a fost");
            System.out.println("4. Afișarea excursiilor în care a fost o persoană al cărei nume se citește de la tastatură");
            System.out.println("5. Afișarea tuturor persoanelor care au vizitat o anumita destinație.");
            System.out.println("6. Afișarea persoanelor care au făcut excursii într-un an introdus");
            System.out.println("7. Ștergerea unei excursii");
            System.out.println("8. Ștergerea unei persoane (împreună cu excursiile în care a fost)");

            System.out.println("Introduceti optiunea dorita: ");
            opt = scanner.nextInt();

            switch(opt)
            {
                case 0:
                    connection.close();
                    statement.close();
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Introduceti numele persoanei pe care doriti sa o introduceti in tabela: ");
                    String nume = scanner.next();
                    System.out.println("Introduceti varsta persoanei pe care doriti sa o introduceti in tabela : ");
                    int varsta = citesteVarsta(scanner);
                    adaugarePersoana(connection, nume, varsta);

                    rs = statement.executeQuery("select * from persoane");
                    while (rs.next())
                        System.out.println("id="+rs.getInt("id")+", nume= " + rs.getString("nume")+ ", varsta="+rs.getInt("varsta"));
                    break;
                case 2:
                    adaugaExcursie(connection, scanner);
                    break;
                case 3:
                    afiseazaPersoane(connection);
                    break;
                case 4:
                    System.out.println("Introduceti numele persoanei pentru care doriti sa afisati: ");
                    String nume_persoana = scanner.next();
                    afisareExcursiiPersoana(connection, nume_persoana);
                    break;
                case 5:
                    afisarePersoaneDupaDestinatie(connection, scanner);
                    break;
                case 6:
                    afisareDupaAnulExcursiei(connection, scanner);
                    break;
                case 7:
                    stergereExcursie(connection, scanner);
                    break;
                case 8:
                    stergerePersoanaCuTotCuExcursii(connection, scanner);
                    break;
                default:
                    System.out.println("Optiune invalida!");

            }

        }while(true);
    }
}