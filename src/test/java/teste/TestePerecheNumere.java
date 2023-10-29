package teste;

import exJSONtesting.PerecheNumere;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestePerecheNumere {

    @Test
    public void fibonacciConsecutive() {
        PerecheNumere pereche = new PerecheNumere(5, 8);
        assertFalse(pereche.fibonacciConsecutiv(5,8));
    }

    @Test
    public void testCalculCMMCM() {
        PerecheNumere pereche = new PerecheNumere(12, 18);
        assertEquals(36, pereche.cmmmc(12,18));
    }

    @Test
    public void testAuSumaCifrelorEgala() {
        PerecheNumere pereche = new PerecheNumere(123, 321);
        assertTrue(pereche.sumCifreEgale(123,321));
    }

    @Test
    public void testAuAcelasiNumarCifrePare() {
        PerecheNumere pereche = new PerecheNumere(246, 864);
        assertTrue(pereche.evenCountNumber(246,864));
    }
}
