import com.juaracoding.Atm;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AtmTest {

    private Atm atm;

    @BeforeMethod
    public void setUp() {
        atm = new Atm(1000.0); // Menginisialisasi ATM dengan saldo awal 1000.0
    }

    @Test
    public void testLihatSaldo() {
        Assert.assertEquals(atm.lihatSaldo(), 1000.0, "Saldo awal harus 1000.0");
    }

    @Test
    public void testSetorUang() {
        atm.setorUang(500.0);
        Assert.assertEquals(atm.lihatSaldo(), 1500.0, "Saldo setelah setor harus 1500.0");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSetorUangNegatif() {
        atm.setorUang(-100.0); // Jumlah negatif
    }

    @Test
    public void testTarikUang() {
        atm.tarikUang(200.0);
        Assert.assertEquals(atm.lihatSaldo(), 800.0, "Saldo setelah tarik harus 800.0");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTarikUangLebihDariSaldo() {
        atm.tarikUang(2000.0); // Penarikan melebihi saldo
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testTarikUangNegatif() {
        atm.tarikUang(-50.0); // Jumlah negatif
    }
}