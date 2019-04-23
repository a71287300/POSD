import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;

public class TextUI {
    LogicSimulator LS = new LogicSimulator();
    public void displayMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "1. Load logic circuit file \n" +
                "2. Simulator\n" +
                "3. Display truth table\n" +
                "4. Exit\n" +
                "Command: ");
        int num1 = scanner.nextInt();
        boolean flag=false;
        switch(num1){
            case 1:
                try {
                System.out.println("Please key in a file path : ");
                Scanner scanner1 = new Scanner(System.in);
                String pathname = scanner1.nextLine();
                flag = LS.load(pathname);

                }catch (Exception e)
                {
                    System.out.println("File not found or file format error");
                }
                break;
             case 2:
                if(flag==true){

                }
                else{
                    System.out.println("Please load a lcf file, before using this operation.");
                }
                break;
             case 3:
                LS.getTruthTable();
                 break;
             case 4:
                 System.out.println("Goodbye , thanks for using LS.");
                 break;
             default:
                 System.out.println("Please key in an Integer(1~4)");
        }
    };
    public void processCommand(){};
}

