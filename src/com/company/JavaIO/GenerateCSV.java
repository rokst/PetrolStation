package com.company.JavaIO;

import com.company.Entities.Fuel;

import java.io.*;

public class GenerateCSV
{
    public void createCSV(String FileName, Fuel g, Fuel d, Fuel lpg)
    {
        try
        {
            FileWriter writer = new FileWriter(FileName);

            writer.append("TYPE");
            writer.append(';');
            writer.append("PRICE");
            writer.append(';');
            writer.append("DISCOUNT");
            writer.append('\n');

            writer.append("Gasoline");
            writer.append(';');
            writer.append(Double.toString(g.getLiterPrice()));
            writer.append(';');
            writer.append(Double.toString(g.getDiscount()));
            writer.append('\n');

            writer.append("Diesel");
            writer.append(';');
            writer.append(Double.toString(d.getLiterPrice()));
            writer.append(';');
            writer.append(Double.toString(d.getDiscount()));
            writer.append('\n');

            writer.append("LPG");
            writer.append(';');
            writer.append(Double.toString(lpg.getLiterPrice()));
            writer.append(';');
            writer.append(Double.toString(lpg.getDiscount()));
            writer.append('\n');

            writer.flush();
            writer.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void getCSV(String FileName,Fuel g, Fuel d, Fuel lpg)
    {
        BufferedReader br = null;
        String line = "";

        try
        {
            br = new BufferedReader(new FileReader(FileName));
            line = br.readLine(); //skip first line

            line = br.readLine();
            String[] fuel = line.split(";(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            g.setLiterPrice(Double.parseDouble(fuel[1]));
            g.setDiscount(Double.parseDouble(fuel[2]));
            System.out.println("Getting " + fuel[0] + " data...");

            line = br.readLine();
            fuel = line.split(";(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            d.setLiterPrice(Double.parseDouble(fuel[1]));
            d.setDiscount(Double.parseDouble(fuel[2]));
            System.out.println("Getting " + fuel[0] + " data...");

            line = br.readLine();
            fuel = line.split(";(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            lpg.setLiterPrice(Double.parseDouble(fuel[1]));
            lpg.setDiscount(Double.parseDouble(fuel[2]));
            System.out.println("Getting " + fuel[0] + " data...");

            System.out.println("Data from CSV file successfully taken!\n");
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found, getting default values...");
        }
        catch (Exception e)
        {
            getCSVComma("DB.csv", g, d, lpg);
            //System.out.println("CSV file content is not as expected, getting default values...");
        }
    }

    public void getCSVComma(String FileName,Fuel g, Fuel d, Fuel lpg)
    {
        BufferedReader br = null;
        String line = "";

        try
        {
            br = new BufferedReader(new FileReader(FileName));
            line = br.readLine(); //skip first line

            line = br.readLine();
            String[] fuel = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            g.setLiterPrice(Double.parseDouble(fuel[1]));
            g.setDiscount(Double.parseDouble(fuel[2]));
            System.out.println("Getting " + fuel[0] + " data...");

            line = br.readLine();
            fuel = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            d.setLiterPrice(Double.parseDouble(fuel[1]));
            d.setDiscount(Double.parseDouble(fuel[2]));
            System.out.println("Getting " + fuel[0] + " data...");

            line = br.readLine();
            fuel = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            lpg.setLiterPrice(Double.parseDouble(fuel[1]));
            lpg.setDiscount(Double.parseDouble(fuel[2]));
            System.out.println("Getting " + fuel[0] + " data...");

            System.out.println("Data from CSV file successfully taken!\n");
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found, getting default values...");
        }
        catch (Exception e)
        {
            System.out.println("CSV file content is not as expected, getting default values...");
        }
    }
}