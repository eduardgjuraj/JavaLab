package DBwSpring;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

class MasiniMapper implements RowMapper<Masina> {
    public Masina mapRow(ResultSet rs, int rowNum) throws SQLException {
        Masina masina = new Masina();
        masina.setNumarInmatriculare(rs.getInt("numarInmatriculare"));
        masina.setCuloarea(rs.getString("culoarea"));
        masina.setMarca(rs.getString("marca"));
        masina.setAnulFabricatiei(rs.getInt("anulFabricatiei"));
        masina.setNumarKm(rs.getInt("numarKm"));
        return masina;
    }
}
