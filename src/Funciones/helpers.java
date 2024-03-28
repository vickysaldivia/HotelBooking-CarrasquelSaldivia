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


/**
 * Clase utilitaria para validar diferentes tipos de entradas de usuario.
 */
public class helpers {
    
    /**
     * Valida que una cadena sea no nula y no esté vacía.
    *
     * @param
    cadena La cadena a validar.
    * @
    return true si la cadena no es nula y no está vacía, false en caso contrario.

    */
    public boolean validarString(String cadena) {
       return cadena != null && !cadena.isEmpty(); 
    }
    
    /**
     * Valida que una cadena sea no nula, no esté vacía y solo contenga letras y
     * espacios.
     *
     * @param str La cadena a validar.
     * @return true si la cadena cumple con las condiciones, false en caso
     * contrario.
     */
    public String validarString2(String str) {
        if(str != null && !str.isEmpty() && str.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s-]+$")){
            return str;
        }
        else{
            return null;
        }
}

    /**
     * Valida que un número sea un entero válido.
     *
     * @param num La cadena que representa el número a validar.
     * @return true si el número es válido, false en caso contrario.
     */
    public int validarNumero(String num){
        try{
            int numero = Integer.parseInt(num);
            return numero;
        }catch(Exception e){
            return -1;
        }    
    }
    
    /**
     * Valida que una fecha sea válida en el formato "dd/MM/yyyy".
     *
     * @param date La cadena que representa la fecha a validar.
     * @return La cadena si la fecha es válida, null en caso contrario.
     */
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

    /**
     * Valida que una fecha sea válida en el formato "dd/MM/yyyy" utilizando la
     * clase LocalDate.
     *
     * @param fecha La cadena que representa la fecha a validar.
     * @return true si la fecha es válida, false en caso contrario.
     */
    public String validarFecha2(String fecha) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate.parse(fecha, formatter);
            return fecha;
        } catch (Exception e) {
            return null;
        }
    }
    
    /**
     * Valida que un tipo de habitación sea válido entre "simple", "doble",
     * "triple" y "suite".
     *
     * @param tipoHab La cadena que representa el tipo de habitación a validar.
     * @return true si el tipo de habitación es válido, false en caso contrario.
     */

    public boolean validarTipoHab(String tipoHab){
        if(tipoHab.equals("simple") && tipoHab.equals("doble") && tipoHab.equals("triple") && tipoHab.equals("suite")){
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Valida que un tipo de habitación sea válido entre "simple", "doble",
     * "triple" y "suite".
     *
     * @param tipoHab La cadena que representa el tipo de habitación a validar.
     * @return La cadena si el tipo de habitación es válido, null en caso
     * contrario.
     */
    public String validarTipoHab2(String tipoHab){
        if(tipoHab.equals("simple") || tipoHab.equals("doble") || tipoHab.equals("triple") || tipoHab.equals("suite")){
            return tipoHab;
        } else {
            return null;
        }
    }
    
    /**
     * Valida que un número de teléfono tenga el formato "(###) ###-####".
     *
     * @param telf La cadena que representa el número de teléfono a validar.
     * @return true si el teléfono es válido, false en caso contrario.
     */

    public boolean validarTelf(String telf){
        String phonePattern = "\\(\\d{3}\\)\\s\\d{7}";
        Pattern pattern = Pattern.compile(phonePattern);
        Matcher matcher = pattern.matcher(telf);
        
        return matcher.matches();
    } 
    
    /**
     * Valida que un número de teléfono tenga el formato "(###) ###-####"
     * utilizando una expresión regular.
     *
     * @param telefono La cadena que representa el número de teléfono a validar.
     * @return true si el teléfono es válido, false en caso contrario.
     */

    public String validarTelefono(String telefono) {
        if(telefono != null && telefono.matches("^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$")){
            return telefono;
        }
        else{
            return null;
        }
    }


    /**
     * Valida que una cédula tenga el formato "##.###.###"
     *
     * @param cedula La cadena que representa la cédula a validar.
     * @return true si la cédula es válida, false en caso contrario.
     */
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
    
    /**
     * Valida que una cadena solo contenga dígitos.
     *
     * @param num La cadena a validar.
     * @return true si la cadena solo contiene dígitos, false en caso contrario.
     */
    private boolean validarnumeros(String num){
        return num.matches("[0-9]*");
    }
    
    /**
     * Valida que una cédula sea válida y tenga entre 7 y 9 dígitos.
     *
     * @param ci La cadena que representa la cédula a validar.
     * @return El número de cédula si es válido, -1 en caso contrario.
     */
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
    
    /**
     * Valida que un correo electrónico sea válido utilizando una expresión
     * regular compleja.
     *
     * @param email La dirección de correo electrónico a validar.
     * @return true si la dirección de correo electrónico es válida, false en
     * caso contrario.
     */
    public String validarEmail(String email){
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        
        Matcher mather = pattern.matcher(email);
        if (mather.find() == true) {
            return email;
        }else{
            return null;
        }
    
    }
    
    /**
     * Valida que un correo electrónico sea válido utilizando una expresión
     * regular simplificada.
     *
     * @param email La dirección de correo electrónico a validar.
     * @return true si la dirección de correo electrónico es válida, false en
     * caso contrario.
     */

    public boolean validarEmail2(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}
