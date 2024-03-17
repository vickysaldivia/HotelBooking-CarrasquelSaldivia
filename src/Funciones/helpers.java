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
    
    public boolean validarNumero(String num){
        int numero;
        try{
            numero = Integer.parseInt(num);
            return true;
        }catch(Exception e){
            return false;
        }    
    }
    
    public boolean validarFecha(String date){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        try {
          df.parse(date);
        } catch (Exception e) {
          return false;
        }
        return true;
    }
    
    public boolean validarTipoHab(String tipoHab){
        if(tipoHab.equals("simple") && tipoHab.equals("doble") && tipoHab.equals("triple") && tipoHab.equals("suite")){
            return true;
        } else {
            return false;
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
    
    public boolean validarEmail(String email){
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        
        Matcher mather = pattern.matcher(email);
        if (mather.find() == true) {
            return true;
        }else{
            return false;
        }
    
    }
}
