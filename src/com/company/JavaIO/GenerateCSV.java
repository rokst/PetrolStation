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

            writer.append(addQuotes(g.getName()));
            writer.append(';');
            writer.append(Double.toString(g.getLiterPrice()));
            writer.append(';');
            writer.append(Double.toString(g.getDiscount()));
            writer.append('\n');

            writer.append(addQuotes(d.getName()));
            writer.append(';');
            writer.append(Double.toString(d.getLiterPrice()));
            writer.append(';');
            writer.append(Double.toString(d.getDiscount()));
            writer.append('\n');

            writer.append(addQuotes(lpg.getName()));
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
            g.setName(deleteDoubleQuotes(deleteQuotes(fuel[0])));
            System.out.println("Getting " + g.getName() + " data...");

            line = br.readLine();
            fuel = line.split(";(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            d.setLiterPrice(Double.parseDouble(fuel[1]));
            d.setDiscount(Double.parseDouble(fuel[2]));
            d.setName(deleteDoubleQuotes(deleteQuotes(fuel[0])));
            System.out.println("Getting " + d.getName() + " data...");

            line = br.readLine();
            fuel = line.split(";(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            lpg.setLiterPrice(Double.parseDouble(fuel[1]));
            lpg.setDiscount(Double.parseDouble(fuel[2]));
            lpg.setName(deleteDoubleQuotes(deleteQuotes(fuel[0])));
            System.out.println("Getting " + lpg.getName() + " data...");

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

    private String deleteQuotes(String word)
    {
        if (word != null)
        {
            if (word.startsWith("\"") && word.endsWith("\""))
            {
                word = word.substring(1, word.length() - 1);
            }
        }
        return word;
    }

    private String deleteDoubleQuotes(String word)
    {
        for (int i = 0; i < word.length(); ++i)
        {
            if (word.charAt(i) == '"' && word.charAt(i + 1) == '"')
            {
                word = word.substring(0, i) + word.substring(i + 1, word.length());
            }
        }
        return word;
    }

    private static String addQuotes(String line) {
        if (line != null) {
            boolean hasSpecialChar = (line.contains("\"") || line.contains(",") || line.contains(" "));
            String temp = "";
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '"') {
                    temp += '"';
                }
                temp += line.charAt(i);
            }
            if (hasSpecialChar) {
                return "\"" + temp + "\"";
            } else {
                return temp;
            }
        } else {
            return line;
        }
    }
}