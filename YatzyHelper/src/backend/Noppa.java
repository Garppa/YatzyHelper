/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author intoit
 */
public class Noppa implements Comparable<Noppa> {
    public static final int YKSI = 1;
    public static final int KAKSI = 2;
    public static final int KOLME = 3;
    public static final int NELJÄ = 4;
    public static final int VIISI = 5;
    public static final int KUUSI = 6;
    
    public static final String[] SILMALUVUT = {"1", "2", "3", "4", "5", "6"};
    int silmaluku;
    
    public Noppa(int silmaluku){
        this.silmaluku = silmaluku;
    }
    
    public int annaSilmaluku(){
        return this.silmaluku;
    }
    
    public void tulostaNoppa(){
        System.out.println(this.silmaluku);
    }
    
    @Override
    public int compareTo(Noppa noppa){
        return this.silmaluku - noppa.annaSilmaluku();
    }
   
    
}
