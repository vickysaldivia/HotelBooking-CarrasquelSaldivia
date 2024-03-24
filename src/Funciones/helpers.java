/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Ramón Carrasquel
 */



public class helpers {
    
    public boolean validarString(String cadena) {
       return cadena != null && !cadena.isEmpty(); 
    }
    
    public String validarString2(String cadena) {
        String regex = "^[a-zA-Z\\s]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cadena);
        if(matcher.matches()){
            return cadena;
        }
        return null;
    }
    
    
    public boolean validarNumero(String num){
        int numero;
        try{
            numero = Integer.parseInt(num);
            return true;
        }catch(Exception e){
            return false;
        }    
    }
    
    public String validarFecha(String date){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        try {
          df.parse(date);
        } catch (Exception e) {
          return null;
        }
        return date;
    }
    
//    public String validarFecha2(String fecha) {
//        if (fecha.length() != 10) {
//            return null;
//        }
//        if (fecha.charAt(2) != '/' || fecha.charAt(5) != '/') {
//            return null;
//        }
//
//        String dayStr = fecha.substring(0, 2);
//        String monthStr = fecha.substring(3, 5);
//        String yearStr = fecha.substring(6);
//
//        try {
//            int day = Integer.parseInt(dayStr);
//            int month = Integer.parseInt(monthStr);
//            int year = Integer.parseInt(yearStr);
//            
//            if (day < 1 || day > 31 || month < 1 || month > 12 || month < 1000 || year > 9999) {
//                return null;
//            }
//            // Verificar que el día sea válido para el mes dado
//            if ((month == 4 || month == 6 || month == 9 || month == 11) && month > 30) {
//                return null;
//            }
//            if (month == 2) {
//                // Verificar si el año es bisiesto
//                boolean bisiesto = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
//                if ((bisiesto && day > 29) || (!bisiesto && day > 28)) {
//                    return null;
//                }
//            }
//            return fecha;
//        } catch (NumberFormatException e) {
//            return null;
//        }
//
//    }
    
    public boolean validarTipoHab(String tipoHab){
        if(tipoHab.equals("simple") && tipoHab.equals("doble") && tipoHab.equals("triple") && tipoHab.equals("suite")){
            return true;
        } else {
            return false;
        }
    }
    
    public String validarTipoHab2(String tipoHab){
        if(tipoHab.equals("simple") || tipoHab.equals("doble") || tipoHab.equals("triple") || tipoHab.equals("suite")){
            return tipoHab;
        } else {
            return null;
        }
    }
    
    public boolean validarTelf(String telf){
        String phonePattern = "\\(\\d{3}\\)\\s\\d{7}";
        Pattern pattern = Pattern.compile(phonePattern);
        Matcher matcher = pattern.matcher(telf);
        
        if (matcher.matches()){
            return true;
        }else{
            return false;
        }
    } 
    
    public String validarTelf2(String telf){
        String phonePattern = "\\(\\d{3}\\)\\s\\d{7}";
        Pattern pattern = Pattern.compile(phonePattern);
        Matcher matcher = pattern.matcher(telf);
        
        if (matcher.matches()){
            return telf;
        }else{
            return null;
        }
    } 

    public boolean validarCedula(String cedula){
        String pattern = "^\\d{2}\\.\\d{3}\\.\\d{3}$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(cedula);
        if (m.find()) {
            return true;
        } else {
            return false;
        } 
    }
    
    private boolean validarnumeros(String num){
        return num.matches("[0-9]*");
    }
    
    public int ValidarCedula(String ci) {
        String replaceAll = ci.replace(".", "");
        if (validarnumeros(replaceAll) == true) {
            if (replaceAll.length() >= 7 && replaceAll.length() <= 9) {
                int num = Integer.parseInt(replaceAll);
                return num;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }
    
    public boolean validarEmail(String email){
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        
        Matcher mather = pattern.matcher(email);
        if (mather.find() == true) {
            return true;
        }else{
            return false;
        }
    
    }
    
    public String validarEmail2(String email){
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        
        Matcher mather = pattern.matcher(email);
        if (mather.find() == true) {
            return email;
        }else{
            return null;
        }
    
    }

}
