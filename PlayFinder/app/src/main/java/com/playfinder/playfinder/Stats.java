package com.playfinder.playfinder;

import android.widget.TextView;

/**
 * Created by itsadmin on 08/03/2018.
 */

public class Stats {
    TextView data;
    TextView nGiocati;
    TextView pe;
    TextView nCell;

    public Stats(TextView data, TextView nGiocati, TextView pe, TextView nCell) {
        this.data = data;
        this.nGiocati = nGiocati;
        this.pe = pe;
        this.nCell = nCell;}

    public TextView getData() {
        return data;
    }

    public void setData(TextView data) {
        this.data = data;
    }

    public TextView getnGiocati() {
        return nGiocati;
    }

    public void setnGiocati(TextView nGiocati) {
        this.nGiocati = nGiocati;
    }

    public TextView getPe() {
        return pe;
    }

    public void setPe(TextView pe) {
        this.pe = pe;
    }

    public TextView getnCell() {
        return nCell;
    }

    public void setnCell(TextView nCell) {
        this.nCell = nCell;
    }


}
