/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author intoit
 */
public class Noppa {
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
}
