/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto_psc_a3.utils;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class CalculoIdade {
    private String anoNasc;
    private String diaNasc;
    private String mesNasc;

    public CalculoIdade(String diaNasc, String mesNasc, String anoNasc) {
        this.anoNasc = anoNasc;
        this.diaNasc = diaNasc;
        this.mesNasc = mesNasc;
    }

    public String getAnoNasc() {
        return anoNasc;
    }

    public void setAnoNasc(String anoNasc) {
        this.anoNasc = anoNasc;
    }

    public String getDiaNasc() {
        return diaNasc;
    }

    public void setDiaNasc(String diaNasc) {
        this.diaNasc = diaNasc;
    }

    public String getMesNasc() {
        return mesNasc;
    }

    public void setMesNasc(String mesNasc) {
        this.mesNasc = mesNasc;
    }
    
    public int getIdade() {
        GregorianCalendar gc = new GregorianCalendar();
        int diaAtual = gc.get(Calendar.DAY_OF_MONTH);
        int mesAtual = gc.get(Calendar.MONTH);
        int anoAtual = gc.get(Calendar.YEAR);
        int idade = (anoAtual - Integer.parseInt(anoNasc));
        if (mesAtual < Integer.parseInt(mesNasc)) {
            idade--;
        } else if (mesAtual == Integer.parseInt(mesNasc)) {
            if (diaAtual < Integer.parseInt(diaNasc)) {
                idade--;
            }
        }
        return idade;
}
    
}
