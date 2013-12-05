/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pelimoottori;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author intoit
 */
public abstract class PerustaTest {
    public PerustaTest(){

    }
    
    protected Peli luoPeli(String... nimi){
     List<String> pelaajat = new ArrayList<String>();
     for (String joo : nimi) {
         pelaajat.add(joo);
     }

     Peli p = new Peli(pelaajat);

     return p;
 }
}
