package com.company.Entities;

/**
 * Created by rokasstasys on 05/03/16.
 */
public class Gasoline extends Fuel {

    public Gasoline(String name, double literPrice, double discount)
    {
        super(name, literPrice, discount);
    }

    public double fillUp(double amount, boolean kortele)
    {
        //System.out.println("Filling up gasoline...");
        double kaina = amount * literPrice;
        if(kortele == true)
        {
            return discount(amount, kaina);
        }
        else
        {
            return kaina;
        }
    }

    public boolean equals(Object obj)
    {
        if(!(obj instanceof Gasoline))
        {
            return false;
        }

        boolean flag = false;
        Gasoline emp = (Gasoline) obj;
        if(emp.literPrice == literPrice)
        {
            flag = true;
        }
        return flag;
    }
}
