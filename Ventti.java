/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package ventti;

import java.util.Scanner;
import static ventti.Ventti_lisaehdoilla.jaettuKortti;

/**
 *
 * @author s1800575
 */
public class Ventti {

    public static void main(String[] args) {
        
        Scanner lukija = new Scanner(System.in);
        
        System.out.println("Pelataan erä Venttiä!");
        System.out.println("[Hyväksy painamalla enter]");
        lukija.nextLine();
        System.out.println("Kerron ensin säännöt. Pääset aina eteenpäin painamalla enter.");
        lukija.nextLine();
        System.out.println("Jaan ensin kortit vain sinulle.");
        lukija.nextLine();
        System.out.println("Voit päättää jokaisen kortin jälkeen haluatko nostaa lisää vai lopettaa.");
        lukija.nextLine();
        System.out.println("Jos haluat lisää kortteja, kirjoita 'k'.");
        lukija.nextLine();
        System.out.println("Jos et halua enempää kortteja, kirjoita 'e' jolloin vuoro siirtyy minulle.");
        lukija.nextLine();
        System.out.println("Isoilla tai pienillä kirjaimilla ei ole väliä.");
        lukija.nextLine();
        System.out.println("Ässä = 14, Kurko = 13, Akka = 12, Jätkä = 11.");
        lukija.nextLine();
        
        //System.out.println("Saat itse valita onko ässä 1 vai 14. Ei hätää, kysyn sitä sinulta kyllä jos saat ässän :)");
        // lukija.nextLine();
        // tämä tehdään lisäosiot kohtaan
        
        System.out.println("Emäntä voittaa aina tasatilanteessa, myös jos molemmilla menee yli 21.");
        lukija.nextLine();
        System.out.println("Sitten aloitetaan! Saat ensimmäisen korttisi nyt painamalla enter.");
        lukija.nextLine();
          System.out.println("------------------------------------------------------------------------------------");
        
          
      
        Scanner valinta = new Scanner(System.in);
        int pelaajanPisteet = 0;
        int emannanPisteet = 0;
        String uusiKortti = "";
        pelaajanPisteet += jaettuKortti();

        System.out.printf("Pisteesi on "+pelaajanPisteet+". Nostatko vielä ? [K/E] ");
        uusiKortti = valinta.nextLine();
        

        if (uusiKortti.equalsIgnoreCase("K")) {
             while (uusiKortti.equalsIgnoreCase("K")) {
                pelaajanPisteet += jaettuKortti();
                
                    if (pelaajanPisteet == 21) {
                        System.out.println("Pelaajalla VENTTI :)");
                        break;
                    } else if (pelaajanPisteet > 21) {
                        System.out.println("Pelaajalla yli 21.");
                        break;
                    } else {
                        System.out.printf("Pisteesi on "+pelaajanPisteet+". Haluatko jatkaa? [K/E] ");
                        uusiKortti = valinta.nextLine();
                      }
                 }
          }
    
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Pelaajan vuoro päättyi - Emännän vuoro alkaa");
        System.out.println("------------------------------------------------------------------------------------");
        
        while (emannanPisteet < 21) {
            emannanPisteet += jaettuKortti();
            System.out.println("Emännän pisteet tällä hetkellä: "+emannanPisteet+".");
        }
         
          
        
      
        voittaja(pelaajanPisteet, emannanPisteet);
        // TARKASTA TÄMÄ. MITÄ TEKEE
    }
    
    
        public static int jaettuKortti() {
        int arvo = (int) ((Math.random() * 13) + 1);
        
//         ARPOOKO OIKEASTI Neljästä eri maasta vai miten tulisi kirjoittaa? Eli arpooko 
//         4x 14 korttia vai miten toimii?
  
         
        
        
        int pisteet = 0;
             
        if (arvo == 1) {
            System.out.println("Ässä");
            pisteet = 14;
          
        } else if (arvo == 13) {
            System.out.println("Kurko");
            pisteet = 13;
        } else if (arvo == 12) {
            System.out.println("Akka");
            pisteet = 12;
        } else if (arvo == 11) {
            System.out.println("Jätkä");
            pisteet = 11;
        } else {
            System.out.println(arvo);
            pisteet = arvo;
        }
        return pisteet;
    }

    public static void voittaja(int pelaajanKasi, int emannanKasi) {

        int pelaaja = pelaajanKasi;
        int emanta = emannanKasi;
        
        System.out.println("------------------------------------------------------------------------------------");
        if (pelaaja > 21) { 
            System.out.println("Pelaajalla "+pelaajanKasi+" eli meni yli. Emäntä voitti!");
        } else if (pelaaja == emanta) {
            System.out.println("Pisteet yhtäsuuret! Pelaaja: "+pelaajanKasi+". Emännän käsi: "+emannanKasi+".");
            System.out.println("Emäntä voitti!");
        } else if (emanta > 21) {
            System.out.println("Emännällä "+emannanKasi+" eli meni yli. Pelaaja voitti!");
        } else {
            if (pelaaja > emanta) {
                System.out.println("Pelaaja voitti! Pelaajalla "+pelaajanKasi+". Emännällä "+emannanKasi+".");
            } else {
                System.out.println("Emäntä voitti! Emännällä "+emannanKasi+". Pelaajalla "+pelaajanKasi+".");
            }
       

        }
        System.out.println("------------------------------------------------------------------------------------");
    }

}
