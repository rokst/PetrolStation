package com.company.JavaIO;

import com.company.Entities.Fuel;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rokas on 24/04/16.
 */
public class GenerateBinary {

    public void createBinary(String FileName, Fuel g, Fuel d, Fuel lpg)
    {
        List<String> fuelData = Arrays.asList(
                Double.toString(g.getLiterPrice()), Double.toString(g.getDiscount()), Double.toString(d.getLiterPrice()),
                Double.toString(d.getDiscount()), Double.toString(lpg.getLiterPrice()), Double.toString(lpg.getDiscount())
        );
        try (
                OutputStream file = new FileOutputStream(FileName);
                OutputStream buffer = new BufferedOutputStream(file);
                ObjectOutput output = new ObjectOutputStream(buffer);
        ){
            output.writeObject(fuelData);
        }
        catch (IOException ex)
        {
            System.out.println("Binary file generation failed.");
        }
    }

    public void getBinary(String FileName, Fuel g, Fuel d, Fuel lpg)
    {
        try(
                InputStream file = new FileInputStream(FileName);
                InputStream buffer = new BufferedInputStream(file);
                ObjectInput input = new ObjectInputStream (buffer);
        ){
            //deserialize the List
            List<String> recoveredFuel = (List<String>)input.readObject();

            //Gasoline price
            g.setLiterPrice(Double.parseDouble(recoveredFuel.get(0)));
            //Gasoline discount
            g.setDiscount(Double.parseDouble(recoveredFuel.get(1)));

            //Diesel price
            d.setLiterPrice(Double.parseDouble(recoveredFuel.get(2)));
            //Diesel discount
            d.setDiscount(Double.parseDouble(recoveredFuel.get(3)));

            //LPG price
            lpg.setLiterPrice(Double.parseDouble(recoveredFuel.get(4)));
            //LPG discount
            lpg.setDiscount(Double.parseDouble(recoveredFuel.get(5)));

            System.out.println("Data from binary file successfully taken!\n");
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found, getting default values...");
        }
        catch(Exception e)
        {
            System.out.println("File content is not as expected, getting default values...");
        }
    }
}
