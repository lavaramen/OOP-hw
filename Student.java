//Name: Curtis Ingram
import java.io.*;
import java.util.*;
public class Student {// I ended up just copy and pasting a lot of this
    private String name;
    private String year;
    private double GPA;
    public Student(){
        name="";
        year="";
        GPA=9.9;
    }
    public String getName() {
        return name;
    }
    public void setName() {
        System.out.println("Please enter the students name.");
        Scanner nameget = new Scanner(System.in);
        this.name = nameget.nextLine();
    }
    public String getYear() {
        return year;
    }
    public void setYear() {
        while(true) {
            System.out.println("Please enter the students academic year.");
            Scanner yearget = new Scanner(System.in);
            String newyear = yearget.nextLine();
            if (newyear.equals("freshman")||newyear.equals("sophomore")||newyear.equals("junior")||newyear.equals("senior")){
                this.year = newyear;
                return;
            }
        }
    }
    public double getGPA() {
        return GPA;
    }
    public void setGPA() {
        while (true){
            try {
                System.out.println("Please enter the students GPA.");
                Scanner GPAget = new Scanner(System.in);
                double newGPA= Double.parseDouble(GPAget.nextLine());
                if(newGPA>=0&&newGPA<=4){
                    this.GPA = newGPA;
                    return;
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Error.");
            }
        }
    }                                   //everything under this line is 99% copy/pasted
    public boolean chek4(){             // I left this as is because of the next method
        if (name!=""&&year!=""&&GPA!=9.9)
            return (true);
        if (name=="")
            System.out.println("Students name has not been filled yet.");
        if (year=="")
            System.out.println("Students year has not been filled yet.");
        if (GPA==9.9)
            System.out.println("Students GPA has not been filled yet.");
        return (false);
    }
    public void printf() throws IOException {// option 5-print to file
        if (chek4()) {
            File myFi = new File("javagrid.csv");                  //new and improved to not include the whole file path
            FileWriter myFiWri = new FileWriter(myFi, true);         //set append to true so it will-- you guessed it, append
            myFiWri.write(name + ", " + year + ", " + GPA+"\n");        //write command worked fine was I supposed to use append?
            System.out.println("Information printed to file. Select 7 to search");
            myFiWri.close();
        }
    }
    public void readf() throws FileNotFoundException{
        File myFi= new File("javagrid.csv");
        Scanner myScanner = new Scanner(myFi);
        while(myScanner.hasNextLine())
            System.out.println(myScanner.nextLine());
    }
    public void searchf() throws FileNotFoundException {//instead of a try catch I decided to use throws to free up space
        File myFi= new File("javagrid.csv");   // VERY IMPORTANT must make file variable then stick it in
        Scanner myScanner = new Scanner(myFi);          //scanner on this line rather than stick the file itself in or else will not read file
        Scanner usearch= new Scanner(System.in);
        System.out.println("Please enter student name to search for");
        String search= usearch.nextLine();
        int count=0;
        while(myScanner.hasNextLine()) {                //this loop check if any line contains the info you're searching for
            String lnref= myScanner.nextLine();         //also searches for content besides names, gonna label that a feature
            if(lnref.contains(search)) {
                System.out.println(lnref);
                count++;
            }
            if(!myScanner.hasNextLine())
                System.out.println(count+" result(s) found.");//if there is no names found this will say "0 result(s) found.
        }
    }
}