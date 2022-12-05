/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Mihailo
 */
public class Sala extends AbstractDomainObject{
    private Long salaID;
    private String nazivSale;

    @Override
    public String toString() {
        return nazivSale;
    }

    public Sala(Long salaID, String nazivSale) {
        setSalaID(salaID);
        setNazivSale(nazivSale);
    }

    public Sala() {
    }

    @Override
    public String nazivTabele() {
        return " Sala ";
    }

    @Override
    public String alijas() {
        return " s ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Sala s = new Sala(rs.getLong("SalaID"), rs.getString("nazivSale"));

            lista.add(s);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        if(salaID == null){
            throw new NullPointerException("Vrednost salaID za primarni kljuc ne sme biti null");
        }
        if(salaID < -1){
            throw new RuntimeException("Vrednost salaID za primarni kljuc ne sme biti "
                    + "manja od 1");
        }
        return " SalaID = " + salaID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        return "";
    }

    public Long getSalaID() {
        return salaID;
    }

    public void setSalaID(Long salaID) {
        this.salaID = salaID;
    }

    public String getNazivSale() {
        return nazivSale;
    }

    public void setNazivSale(String nazivSale) {
        if(nazivSale == null){
            throw new NullPointerException("Naziv sale za ne sme biti null");
        }
        if(nazivSale.length() < 2){
            throw new RuntimeException("naziv sale salaID za ne sme biti "
                    + "manja od 2 karaktera");
        }
        this.nazivSale = nazivSale;
    }
}
