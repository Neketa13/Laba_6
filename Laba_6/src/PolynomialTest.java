import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class PolynomialTest {
    Polynomial polynomial=new Polynomial();

    @Test
    public void maximum() {
        Assert.assertEquals(Optional.of(12), Optional.of(Polynomial.maximum(12, 3)));
    }

    @Test
    public void getHashFromFile() {
    }


    @Test
    public void difference() {
        Assert.assertEquals(Optional.of(9), Optional.of(Polynomial.Difference(12, 3)));


    }


}