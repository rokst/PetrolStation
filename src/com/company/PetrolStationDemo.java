package com.company;

import com.company.JavaIO.GenerateBinary;
import com.company.JavaIO.GenerateCSV;

import java.util.Scanner;

/**
 * Created by rokasstasys on 20/03/16.
 */

public class PetrolStationDemo {

    private PetrolStationFactory st = new PetrolStationFactory();

    private GenerateCSV csv = new GenerateCSV();
    private GenerateBinary binary = new GenerateBinary();

    private Scanner scan;

    public PetrolStationDemo()
    {
        menu(); //meniu iskvietimas4
    }

    public void menu() //pagrindinis visas meniu
    {
        scan = new Scanner(System.in);
        menu1(); // meniu išvedimas
        while (!scan.hasNextInt()) {
            System.out.println("Wrong input. Try again.");
            menu1(); // meniu išvedimas
            scan.next();
        }
        int n = scan.nextInt();

        switch (n) {
            case 1:
                changePrice();
                break;

            case 2:
                changeDiscount();
                break;

            case 3:
                fill();
                break;
            case 4:
                System.out.println("\nCurrent Petrol Station Data:");
                System.out.println("Gasoline   " + st.getLiterPrice(1) + " EUR,    Discount   " + st.getDiscount(1) + " EUR");
                System.out.println("Diesel     " + st.getLiterPrice(2) + " EUR,    Discount   " + st.getDiscount(2) + " EUR");
                System.out.println("LPG        " + st.getLiterPrice(3) + " EUR,    Discount   " + st.getDiscount(3) + " EUR\n");
                menu();
                break;
            case 5:
                csv.getCSV("DB.csv", st.getGasoline(), st.getDiesel(), st.getLPG());
                menu();
                break;
            case 6:
                binary.getBinary("binary.se", st.getGasoline(), st.getDiesel(), st.getLPG());
                menu();
                break;
            case 7:
                System.out.println("Program closes...");

                csv.createCSV("DB.csv", st.getGasoline(), st.getDiesel(), st.getLPG());
                binary.createBinary("binary.se", st.getGasoline(), st.getDiesel(), st.getLPG());
                break;
            default:
                menu();
                break;
        }
    }

    public void changePrice()
    {
        menu2(); // meniu išvedimas
        while (!scan.hasNextInt()) {
            System.out.print("Wrong input. Try again : ");
            menu2(); // meniu išvedimas
            scan.next();
        }
        int h = scan.nextInt();

        switch (h) {
            case 1:
                changePrice(h);
                menu();
                break;

            case 2:
                changePrice(h);
                menu();
                break;

            case 3:
                changePrice(h);
                menu();
                break;
        }
    }

    public void changePrice(int n) {
        double litroKaina;
        do {
            System.out.print("Enter new price : ");
            while (!scan.hasNextDouble()) {
                System.out.println("Wrong input. Try again.");
                scan.next();
            }
            litroKaina = scan.nextDouble();
            if (litroKaina < 0)
            {
                System.out.println("Wrong input. Try again.");
            }
        }
        while(litroKaina <= 0);

        st.changeFuelPrice(litroKaina, n);
        System.out.println("Price changed to " + st.getLiterPrice(n));
    }

    public void changeDiscount()
    {

        menu3(); //meniu išvedimas
        while (!scan.hasNextInt()) {
            System.out.println("Wrong input. Try again.");
            menu3(); // meniu išvedimas
            scan.next();
        }
        int x = scan.nextInt();

        switch (x) {
            case 1:
                changeDisc(x);
                menu();
                break;

            case 2:
                changeDisc(x);
                menu();
                break;

            case 3:
                changeDisc(x);
                menu();
                break;
        }
    }

    public void changeDisc(int x) {
        double nuolaida;
        do {
            System.out.print("Enter new discount : ");
            while (!scan.hasNextDouble()) {
                System.out.println("Wrong input. Try again.");
                scan.next();
            }
            nuolaida = scan.nextDouble();
            if(nuolaida < 0)
            {
                System.out.println("Wrong input. Try again.");
            }
        }
        while (nuolaida < 0);

        st.changeFuelDiscount(nuolaida, x);
        System.out.println("Discount changed to " + st.getDiscount(x));
    }

    public void fill()
    {

        menu4(); //meniu išvedimas
        while (!scan.hasNextInt())
        {
            System.out.println("Wrong input. Try again.");
            menu4(); // meniu išvedimas
            scan.next();
        }
        int y = scan.nextInt();

        switch (y) {

        case 1:
            fillUp(y);
            menu();
        break;

        case 2:
            fillUp(y);
            menu();
        break;

        case 3:
            fillUp(y);
            menu();
        break;
        }
    }

    public void fillUp(int y) {
        double kiekis;
        do {
        System.out.print("How much fuel would you like to fill? ");
        while ((!scan.hasNextDouble()))
        {
            System.out.println("Wrong input. Try again.");
            scan.next();
        }
        kiekis = scan.nextDouble();
        if(kiekis < 0)
        {
            System.out.println("Wrong input. Try again.");
        }
        }
        while (kiekis < 0);

        menu5();
        while (!scan.hasNextInt()) {
        System.out.println("Wrong input. Try again.");
        menu5(); // meniu išvedimas
        scan.next();
        }
        int kortele = scan.nextInt();

        switch (kortele) {
        case 1:
        System.out.println("Please pay " + st.fillUp(kiekis, kortele, y) + "EUR for " + kiekis + "L.\n");
        break;
        case 2:
        System.out.println("Please pay " + st.fillUp(kiekis, kortele, y) + "EUR for " + kiekis + "L.\n");
        break;
        }
    }

    public void menu1()
    {
        System.out.println("** Petrol Station Menu **\n");
        System.out.println("1 - Modify fuel price.");
        System.out.println("2 - Modify discount.");
        System.out.println("3 - Fill up.");
        System.out.println("4 - Show current petrol station data.");
        System.out.println("5 - Get petrol station data from CSV file.");
        System.out.println("6 - Get petrol station data from binary file");
        System.out.println("7 - Close application.\n");
        System.out.print("Enter : ");

    }
    public void menu2()
    {
        System.out.println("\n1 - Modify gasoline price.");
        System.out.println("2 - Modify diesel price.");
        System.out.println("3 - Modify LPG price.\n");
        System.out.print("Enter : ");
    }
    public void menu3()
    {
        System.out.println("\n1 - Modify gasoline discount.");
        System.out.println("2 - Modify diesel discount.");
        System.out.println("3 - Modify LPG discount.\n");
        System.out.print("Enter : ");
    }
    public void menu4()
    {
        System.out.println("\n1 - Fill gasoline.");
        System.out.println("2 - Fill diesel.");
        System.out.println("3 - Fill LPG.\n");
        System.out.print("Enter : ");
    }
    public void menu5()
    {
        System.out.println("\nDo you have a discount card?");
        System.out.println("1 - Yes, of course!");
        System.out.println("2 - Damn, no...\n");
        System.out.print("Enter : ");
    }
}