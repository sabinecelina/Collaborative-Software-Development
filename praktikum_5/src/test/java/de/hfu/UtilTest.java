package de.hfu;
import org.junit.Test;
import static org.junit.Assert.*;
public class UtilTest {
    @Test
    public void testIstErstesHalbjahr(){
       assertTrue("Januar ist im ersten Halbjahr", Util.istErstesHalbjahr( 1));
       assertFalse("Oktober ist nicht im ersten Halbjar", Util.istErstesHalbjahr(10));
       assertFalse("Juli sollte im zweiten Halbjahr liegen", Util.istErstesHalbjahr(7));
       Util.istErstesHalbjahr(-1);
       fail("Erwartetete Exception wurde nicht geworfen");
    }
}
