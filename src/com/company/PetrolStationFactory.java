package com.company;

import com.company.Entities.*;

/**
 * Created by rokasstasys on 20/03/16.
 */

public class PetrolStationFactory implements PetrolStation {

    //default values
    private Fuel l = new LiquifiedPetroleumGas(0.5, 0.04);
    private Fuel d = new Diesel(0.89, 0.05);
    private Fuel g = new Gasoline(1.05, 0.05);

    public Fuel getGasoline()
    {
        return g;
    }
    public Fuel getDiesel()
    {
        return d;
    }
    public Fuel getLPG()
    {
        return l;
    }


    public void changeFuelPrice(double litroKaina, int type)
    {
        switch (type)
        {
            case 1:
                ChangeFuelPrice(g, litroKaina);
                break;

            case 2:
                ChangeFuelPrice(d, litroKaina);
                break;

            case 3:
                ChangeFuelPrice(l, litroKaina);
                break;
        }
    }
    public void ChangeFuelPrice(Fuel f, double litroKaina)
    {
        f.setLiterPrice(litroKaina);
    }

    public void changeFuelDiscount(double nuolaida, int type)
    {
        switch (type)
        {
            case 1:
                changeFuelDiscount(g, nuolaida);
                break;

            case 2:
                changeFuelDiscount(d, nuolaida);
                break;

            case 3:
                changeFuelDiscount(l, nuolaida);
                break;
        }

    }
    public void changeFuelDiscount(Fuel f, double nuolaida)
    {
        f.setDiscount(nuolaida);
    }

    public double fillUp(double kiekis, int kortele, int type)
    {
        switch (type)
        {
            case 1:
                return fillUp(g, kiekis, kortele);

            case 2:
                return fillUp(d, kiekis, kortele);

            case 3:
                return fillUp(l, kiekis, kortele);
            default:
                return 0;
        }
    }
    public double fillUp(Fuel f, double kiekis, int kortele)
    {
        switch(kortele)
        {
            case 1:
                return f.fillUp(kiekis, true);
            case 2:
                return f.fillUp(kiekis, false);
            default:
                return 0;
        }
    }

    public double getLiterPrice(int n)
    {
        switch (n)
        {
            case 1:
                return getLiterPrice(g);
            case 2:
                return getLiterPrice(d);
            case 3:
                return getLiterPrice(l);
            default:
                return 0;
        }
    }
    public double getLiterPrice(Fuel f)
    {
        return f.getLiterPrice();
    }

    public double getDiscount(int n)
    {
        switch (n)
        {
            case 1:
                return getDiscount(g);
            case 2:
                return getDiscount(d);
            case 3:
                return getDiscount(l);
            default:
                return 0;
        }
    }
    public double getDiscount(Fuel f)
    {
        return f.getDiscount();
    }
}