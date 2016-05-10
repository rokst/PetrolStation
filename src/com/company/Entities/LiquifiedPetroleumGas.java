package com.company.Entities;

/**
 * Created by rokasstasys on 05/03/16.
 */

public class LiquifiedPetroleumGas extends Fuel {

    public LiquifiedPetroleumGas(String name, double literPrice, double discount)
    {
        super(name, literPrice, discount);
    }

    //Kuro pilimo metodas. Imamas papildomas 1 euro aptarnavimo mokestis.
    public double fillUp(double amount, boolean kortele)
    {
        //System.out.println("Filling up liquified petroleum gas...");
        //System.out.println("Bus pridetas aptarnavimo mokestis 1 euras.");
        double kaina = amount * literPrice + 1;
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
        if(!(obj instanceof LiquifiedPetroleumGas))
        {
            return false;
        }

        boolean flag = false;
        LiquifiedPetroleumGas emp = (LiquifiedPetroleumGas) obj;
        if(emp.literPrice == literPrice)
        {
            flag = true;
        }
        return flag;
    }
}
