import org.junit.Test;

import static org.junit.Assert.*;

public class CouchTest {

    @Test
    public void  EstadoDeUnAsientoEmpiezaTrue(){
        Couch test = new Couch();
        assertTrue(test.isOccupied());

    }


}