package com.company.Entities;

/**
 * Created by rokasstasys on 05/03/16.
 */
public abstract class Fuel {

    protected double literPrice, discount;

    public Fuel(double literPrice, double discount)
    {
        this.literPrice = literPrice;
        this.discount = discount;
    }

    //setters
    public void setLiterPrice(double literPrice)
    {
        this.literPrice = literPrice;
    }
    public void setDiscount(double discount)
    {
        this.discount = discount;
    }
    public abstract double fillUp(double amount, boolean kortele);

    //getters
    public double getLiterPrice()
    {
        return this.literPrice;
    }
    public double getDiscount()
    {
        return this.discount;
    }


    //functions
    public String toString()
    {
        return ("Litro kaina - " + this.literPrice + ", nuolaida su kortele -  " + this.discount);
    }

    public double discount(double amount, double kaina)
    {
        kaina = kaina - (amount * this.discount);
        return kaina;
    }

    public abstract boolean equals(Object obj);

    public int hashCode()
    {
        int result = 17;

        long doubleFieldBits = Double.doubleToLongBits(this.literPrice);
        result = 31 * result + (int)(doubleFieldBits ^ (doubleFieldBits >>> 32));

        doubleFieldBits = Double.doubleToLongBits(this.discount);
        result = 31 * result + (int)(doubleFieldBits ^ (doubleFieldBits >>> 32));

        return result;
    }
}
