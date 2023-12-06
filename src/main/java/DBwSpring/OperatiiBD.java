package DBwSpring;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Scanner;

public class OperatiiBD {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public void insert(Scanner scanner/*String marca, int anulFabricatiei, String culoarea, int numarKm*/) {
        System.out.println("Introduceti marca masinii: ");
        String marca = scanner.nextLine();
        System.out.println("Introduceti anul fabricatiei masinii: ");
        int anulFabricatiei = scanner.nextInt();
        scanner.nextLine(); // consume line
        System.out.println("Introduceti culoarea masinii: ");
        String culoarea = scanner.nextLine();
        System.out.println("Introduceti numarul de KM al masinii: ");
        int numarKm = scanner.nextInt();
        String SQL="insert into masini (marca, anulFabricatiei, culoarea, numarKm) values (?, ?, ?, ?)";
        jdbcTemplateObject.update(SQL, marca, anulFabricatiei, culoarea, numarKm);
    }

    public void delete(int numarInmatriculare){
        String SQL = "delete from masini where numarInmatriculare= ?";
        jdbcTemplateObject.update(SQL, numarInmatriculare);
        System.out.println("S-a sters masisna cu numarul de inmatriculare: " + numarInmatriculare);
    }


    public Masina getMasina(int numarInmatriculare){
        String SQL = "select * from masini where numarInmatriculare = ?";
        Masina masina = jdbcTemplateObject.queryForObject(SQL, new Object[]{numarInmatriculare}, new MasiniMapper());
        return masina;
    }

    public List<Masina> getListaMasina(){
        String SQL = "select * from masini";
        List<Masina> masina = jdbcTemplateObject.query(SQL, new MasiniMapper());
        return masina;
    }





}
