/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    
    public boolean validarString2(String str) {
    return str != null && !str.isEmpty() && str.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$");
}

    
    public boolean validarNumero(String num){
        try{
            int numero = Integer.parseInt(num);
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

    public boolean validarFecha2(String fecha) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate.parse(fecha, formatter);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
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
    
    public boolean validarTelefono(String telefono) {
        return telefono != null && telefono.matches("^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$");
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
    
    public boolean validarEmail2(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    
    

}
