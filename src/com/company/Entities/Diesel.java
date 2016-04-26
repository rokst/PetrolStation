package com.company.Entities;

/**
 * Created by rokasstasys on 05/03/16.
 */
public class Diesel extends Fuel {

    public Diesel(double literPrice, double discount)
    {
        super(literPrice, discount);
    }

    //Kuro pilimo metodas. Dyzelinui taikoma papildoma nuolaida, jei kiekis yra didesnis arba lygus 60 l.
    public double fillUp(double amount, boolean kortele)
    {
        //System.out.println("Filling up diesel...");
        double kaina = amount * literPrice;
        if(kortele == true)
        {
            if(amount >= 60){
                //System.out.println("extra 30% off!!!");
                return discount(amount, kaina) * 0.7;
            }
            return discount(amount, kaina);
        }
        else
        {
            return kaina;
        }
    }

    public boolean equals(Object obj)
    {
        if(!(obj instanceof Diesel))
        {
            return false;
        }

        boolean flag = false;
        Diesel emp = (Diesel)obj;
        if(emp.literPrice == literPrice)
        {
            flag = true;
        }
        return flag;
    }
}
