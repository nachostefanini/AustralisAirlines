import org.junit.Test;

import static org.junit.Assert.*;
//import static org.junit.AssertTrue;


public class FirstClassTest {
    @Test
    public void EstadoDeUnAsientoEmpiezaTrue(){
        FirstClass test = new FirstClass();
        assertTrue(test.isOccupied());
    }

}