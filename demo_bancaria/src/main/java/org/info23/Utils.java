package org.info23;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {

    static NumberFormat formateandoValor = new DecimalFormat("$ #,##0.00");

    public static String doubleToString(Double valor) {
        return formateandoValor.format(valor);
    }
}
