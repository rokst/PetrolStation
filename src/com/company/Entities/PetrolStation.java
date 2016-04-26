package com.company.Entities;

/**
 * Created by rokasstasys on 20/03/16.
 */
public interface PetrolStation {

    /**
     * Pakeičia kuro litrui kainą;
     *
     * @param litroKaina: nauja kaina;
     * @param type:
     *            1 - Benzinas;
     *            2 - Dyzelinas;
     *            3- LPG;
     */
    void changeFuelPrice(double litroKaina, int type);

    /**
     * Keičia esamą nuolaidą nauja;
     *
     * @param nuolaida: nauja nuolaida;
     * @param type:
     *            1 - Benzinas;
     *            2 - Dyzelinas;
     *            3- LPG;
     */
    void changeFuelDiscount(double nuolaida, int type);

    /**
     * Įpila pasirinkta kieki kuro kiekį ir parodo kiek už tai sumokėta;
     *
     * @param kiekis: norimas kuro kiekis pilimui;
     * @param kortele:
     *               1 - Kortelė yra;
     *               2 - Kortelės nėra;
     * @param type:
     *            1 - Benzinas;
     *            2 - Dyzelinas;
     *            3 - LPG
     */
    double fillUp(double kiekis, int kortele, int type);

    /**
     * Gražina esamą kuro litrui kainą pasirinktai kuro rūšiai;
     *
     * @param type:
     *            1 - Benzinas;
     *            2 - Dyzelinas;
     *            3- LPG;
     */
    double getLiterPrice(int type);

    /**
     * Gražina esamą nuolaidą pasirinktai kuro rūšiai;
     *
     * @param type:
     *            1 - Benzinas;
     *            2 - Dyzelinas;
     *            3- LPG;
     */
    double getDiscount(int type);
}
