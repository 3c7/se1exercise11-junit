package org.bonn.se.ws14.geometry;

import junit.framework.TestCase;

public class MyPrettyRectangleTest extends TestCase {

    private MyPrettyRectangle left;
    private MyPrettyRectangle middle;
    private MyPrettyRectangle right;
    private MyPrettyRectangle somewhere;

    /*
     * Set-Up Methode, die fuer alle Test-Methoden die Rechtecke definiert.
     * Wird vor jeder Test-Methode ausgefuehrt.
     *
     */
    public void setUp() {
        //
        //     +-----------+   +---+
        //     |         r |   | s |
        // +---+---+---+   |   |   |
        // | l |   | m |   |   |   |
        // |   |   +---+   |   |   |
        // |   |       |   |   |   |
        // +---+-------+   |   +---+
        //     |           |
        //     +-----------+
        //
        // Annahme: 1 Einheit = 1cm
        // MyPrettyRectangle-Konstruktor: MyPrettyRectangle(x1,y1,x2,y2)
        // x1,y1: Punkt links unten
        // x2,y2: Punkt rechts oben

        left = new MyPrettyRectangle(0.0, 1.0, 3.0, 3.0);
        middle = new MyPrettyRectangle(2.0, 2.0, 3.0, 3.0);
        right = new MyPrettyRectangle(1.0, 0.0, 4.0, 4.0);
        somewhere = new MyPrettyRectangle(5.0, 1.0, 6.0, 4.0);

    }

    /*
     * Methode zum Testen einer Methode der Klasse MyPrettyRectangle, welche prueft, ob ein Rechteck
     * ein anderes Rechteck vollstaendig enthaelt.
     * (Ergebnis: boolean Wert)
     *
     */
    public void testContains() {
        // Erster Test, um die Korrektheit der Methode contains() zu ueberpruefen
        assertTrue(middle.contains(middle));
        assertFalse(somewhere.contains(left));
        assertTrue(right.contains(middle));


        // Hier sollten sie alle weiteren moeglichen Tests zur obigen Zeichnung einfuegen, um zu pruefen, ob
        // ein Rechteck ein anderes vollstaendig enthaelt
        // Die dazu gehoerige Methode sollten sie selbst implementieren.
        assertFalse(right.contains(left));
        assertFalse(right.contains(somewhere));
        assertTrue(right.contains(middle));

        assertFalse(middle.contains(left));
        assertFalse(middle.contains(somewhere));
        assertFalse(middle.contains(right));

        assertTrue(somewhere.contains(somewhere));
        assertFalse(somewhere.contains(middle));
        assertFalse(somewhere.contains(left));
        assertFalse(somewhere.contains(right));


    }

    /*
     * Methode zum Testen einer Methode der Kasse MyPrettyRectangle, welche den Mittelpunkt eines Rechtecks berechnet
     * (Ergebnis: ein Punkt in einem Koordinatensystem)
     *
     */
    public void testGetCenter() {
        // Erster Test, um die Korrektheit der Methode getCenter() zu ueberpruefen
        assertEquals(new MyPoint(1.5, 2.0), left.getCenter());

        // Hier sollten sie die weiteren Tests einfuegen, welche die errechneten Mittelpunkte der Rechtecke
        // right, middle und somewhere mit den tatsaechlichen Mittelpunkten vergleicht.
        // Die dazugehoerige Methode der Klasse MyPrettyRectangle sollten sie selbst implementieren.
        // Fuer einen korrekten Vergleich der MyPoint-Objekte sollten sie die Methode equals entsprechend ueberrschreiben
        // (siehe dazu auch Hinweise im Uebungsblatt (Link zur Seite von Frank Westphal) sowie in Kapitel 7).
        //
        assertEquals(new MyPoint(2.5, 2.5), middle.getCenter());
        assertEquals(new MyPoint(2.5, 2.0), right.getCenter());
        assertEquals(new MyPoint(5.5, 2.5), somewhere.getCenter());

    }

    /*
     * Methode zum Testen einer Methode der Klasse MyPrettyRectangle, welche die Flaeche eines Rechtecks berechnet
     * (Ergebnis: Wert in Quadratzentimeter, cm2)
     *
     */
    public void testGetArea() {
        // Hier sollten sie zwei Tests einfuegen, welche die errechneten Flaechen der Rechtecke
        // mit den tatsaechlichen Werten vergleicht.
        // Die Methode zur Berechnung der Flaeche sollten sie selbst definieren und implementieren.
        assertEquals(1.0, middle.getArea());
        assertEquals(12.0, right.getArea());
        assertEquals(6.0, left.getArea());
        assertEquals(3.0, somewhere.getArea());

    }


    /*
     * Methode zum Testen der Objekt-Identitaet zwischen den MyPrettyRectangle-Objekten
     *
     */
    public void testSameIdentity() {
        // Hier sollten sie fuenf Tests einfuegen, welche die Objekt-Identitaet des linken Rechtecks ('left')
        // mit den anderen Rechtecken (inklusive dem neuen Rechteck 'other') ueberprueft.
        //
        // [ihr Code]

        MyPrettyRectangle other = left;

        assertSame(other, left);
        assertSame(left, left);
        assertNotSame(left, right);
        assertNotSame(left, middle);
        assertNotSame(left, somewhere);

    }

    /*
     * Methode zum Testen einer statischen Methode einer weiteren Klasse BoundingBoxFactory, die auf Basis eines Arrays von
     * Rechtecken eine Bounding Box berechnet und zurueckliefert.
     *
     * Definition Bounding Box: Eine Bounding Box (deutsch: minimal umgebendes Rechteck, MUR) bezeichnet das
     * kleinstmoegliche achsenparallele Rechteck, das eine vorgegebene Menge von Rechtecken umschliesst.
     *
     */
    public void testGetBoundingBox() {

        MyPrettyRectangle[] rect = {right, middle, somewhere};
        MyPrettyRectangle[] rectAll = {right, middle, somewhere, left};
        MyPrettyRectangle boundingBox = BoundingBoxFactory.createBB(rect);
        MyPrettyRectangle boundingBoxAll = BoundingBoxFactory.createBB(rectAll);

        // Hier sollten sie einen Test einfuegen, der zunaechst mit der Klasse BoundingBoxFactory auf
        // Basis des o.g. Array die Bounding Box berechnet.
        // Testen sie die so erhaltene Bounding Box anhand eines SOLL / IST Vergleichs.
        // Die Methode der Klasse BoundingBoxFactory sollten sie selbst definieren und implementieren.
        assertTrue(boundingBox.contains(right));
        assertTrue(boundingBox.contains(middle));
        assertTrue(boundingBox.contains(somewhere));

        assertEquals(boundingBox, new MyPrettyRectangle(1.0, 0.0, 6.0, 4.0));
        assertEquals(boundingBoxAll, new MyPrettyRectangle(0.0, 0.0, 6.0, 4.0));


        // Testen sie zudem, ob ueberhaupt ein Objekt zurueckgegeben wird, d.h. der Rueckgabe-Wert ungleich NULL ist
        assertNotNull(BoundingBoxFactory.createBB(rect));
    }
}

