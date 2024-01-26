package question1;

public class EnsembleTest extends junit.framework.TestCase {

    public void testUnion() {
        question1.Ensemble<Integer> e1, e2;
        e1 = new question1.Ensemble<Integer>();
        assertEquals(true, e1.add(2));
        assertEquals(true, e1.add(3));

        e2 = new question1.Ensemble<Integer>();
        assertEquals(true, e2.add(3));
        assertEquals(true, e2.add(4));

        question1.Ensemble<Integer> union = e1.union(e2);
        assertEquals(3, union.size());
        assertTrue(union.contains(2));
        assertTrue(union.contains(3));
        assertTrue(union.contains(4));
    }
    
    public void testAddUnique() {
        var ensemble = new question1.Ensemble<Integer>();
        assertTrue("echec lors de l'ajout d'un element unique (1)", ensemble.add(1));
        assertTrue("echec lors de l'ajout d'un element unique (2)", ensemble.add(2));
        // La taille doit etre 2 apres l'ajout de deux elements uniques
        assertEquals("La taille de l'ensemble devrait etre 2 apres l'ajout d'elements uniques", 2, ensemble.size());
    }

    public void testAddDuplicate() {
        var ensemble = new question1.Ensemble<Integer>();
        ensemble.add(1);
        // Essayer d'ajouter le meme element
        assertFalse("echec d'ajoute d'un element deja present", ensemble.add(1));
        // La taille doit rester 1 apres ajouter un doublon
        assertEquals("taille doit etre 1", 1, ensemble.size());
    }
    
     public void testUnion_2() {
        var e1 = new Ensemble<Integer>();
        var e2 = new Ensemble<Integer>();

        e1.add(1);
        e1.add(2);
        e2.add(2);
        e2.add(3);

        var union = e1.union(e2);

        assertEquals(3, union.size());
        assertTrue(union.contains(1));
        assertTrue(union.contains(2));
        assertTrue(union.contains(3));
    }
    
    public void testInter() {
        var e1 = new Ensemble<Integer>();
        var e2 = new Ensemble<Integer>();
    
        e1.add(1);
        e1.add(2);
        e2.add(2);
        e2.add(3);

        var inter = e1.inter(e2);

        assertEquals(1, inter.size());
        assertTrue(inter.contains(2));
    }

    public void testDiff() {
        var e1 = new Ensemble<Integer>();
        var e2 = new Ensemble<Integer>();

        e1.add(1);
        e1.add(2);
        e2.add(2);
        e2.add(3);

        var diff = e1.diff(e2);

        assertEquals(1, diff.size());
        assertTrue(diff.contains(1));
    }

    public void testDiffSym() {
        var e1 = new Ensemble<Integer>();
        var e2 = new Ensemble<Integer>();

        e1.add(1);
        e1.add(2);
        e2.add(2);
        e2.add(3);

        var diffSym = e1.diffSym(e2);

        assertEquals(2, diffSym.size());
        assertTrue(diffSym.contains(1));
        assertTrue(diffSym.contains(3));
    }
    
}
