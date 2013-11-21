/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author intoit
 */
public class Main {

    public static void main(String[] args) {
    
        Noppa noppa1 = new Noppa(1);
         Noppa noppa2 = new Noppa(5);
          Noppa noppa3 = new Noppa(8);
        PoydallaOlevat setti = new PoydallaOlevat();
        setti.lisaaNoppa(noppa1);
        setti.lisaaNoppa(noppa2);
        setti.lisaaNoppa(noppa3);

        System.out.println(setti.toString());
        
        setti.poistaNoppa(noppa3);
        
        System.out.println(setti.toString());
}
    
}
