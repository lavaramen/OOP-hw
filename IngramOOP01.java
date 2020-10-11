//Name: Curtis Ingram

import java.io.*;
import java.util.*;
public class IngramOOP01 {
    public static void main(String args[]) throws IOException {
        Student lernt= new Student();
        boolean chek= false;
        int uin;
        while (!chek) {
            try {                           //I figure it didn't matter I just put it in the main as it's just one line, this was the print menu method
                System.out.println("Please enter 1, 2, 3, 4, 5, 6, 7 or 8\n1- Name\n2- Year\n3- GPA\n4- Info\n5- Print to file\n6- Read file\n7- Search\n8- Exit");
                Scanner input = new Scanner(System.in);
                uin = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                uin = 0;
            }
            if (uin >= 1 && uin <= 8) {     //interesting enough when I submitted this in week 3 before OOP it didn't include 8 making it unable to end, fixed
                if (uin == 1)               //option 1
                    lernt.setName();
                if (uin == 2)               //option 2
                    lernt.setYear();
                if (uin == 3)               //option 3
                    lernt.setGPA();
                if (uin == 4){              //option 4
                    if (lernt.chek4()){
                        System.out.println("Name: "+lernt.getName());
                        System.out.println("Academic year: "+lernt.getYear());
                        System.out.println("GPA: "+lernt.getGPA());
                    }
                }
                if (uin==5)                 //option 5
                    lernt.printf();
                if (uin==6)                 //option 6
                    lernt.readf();
                if (uin==7)                 //option 7
                    lernt.searchf();
                if (uin==8)                 //option 8
                    chek = true;
                try {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } catch (InterruptedException | IOException e) {
                    Runtime.getRuntime().exec("clear"); //I wanted to utilize this in other areas like
                }                                                //when an error occurred in the info collecting
            }                                                    //loops but since this wasn't working on my side I didn't
        }
    }
}
