/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Calendar;

/**
 *
 * @author john
 */
public class Formatadores {

    public static String getData() {
        Calendar calendario = Calendar.getInstance();
        String dia = String.valueOf(calendario.get(Calendar.DAY_OF_MONTH));
        String mes = String.valueOf(calendario.get(Calendar.MONTH));
        String ano = String.valueOf(calendario.get(Calendar.YEAR));
        String hora = String.valueOf(calendario.get(Calendar.HOUR_OF_DAY));
        String minuto = String.valueOf(calendario.get(Calendar.MINUTE));
        String seg = String.valueOf(calendario.get(Calendar.SECOND));

        return new String("'"
                + ano + "-"
                + mes + "-"
                + dia + " "
                + hora + ":"
                + minuto + ":"
                + seg + "'");

    }

}
