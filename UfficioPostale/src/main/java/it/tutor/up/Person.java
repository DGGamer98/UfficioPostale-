/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tutor.up;

/**
 *
 * @author loren
 */
public class Person {
    
    private String name;
    private String surname;
    private String phonenumber;
    private String usercode;

    public Person() {
        
    }
    
    
     public Person(String name, String surname, String phonenumber, String usercode) {
      
       setName(name);
       setSurname(surname);
       setPhonenumber(phonenumber);
       setSurname(surname);
       setUsercode(usercode);
       
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }
    
    public String getUsercode(){
        return usercode;
    }

    public final void setName(String name) {
        if(name == null || name.isEmpty() || !name.matches("((de|di)\\s)?[A-Z][a-z]+")){
                this.name = "INVALID";
            }
            else{
                this.name = name;
            }
    }

    public final void setSurname(String surname) {
        
         if(surname == null || surname.isEmpty() || !surname.matches("[A-Z][a-z]+")){
                this.surname = "INVALID";
            }
            else{
                this.surname = surname;
            }
        
        
        
    }

    public final void setPhonenumber(String phonenumber) {
        
         if(phonenumber == null || phonenumber.isEmpty() || !phonenumber.matches("((0039|\\+39)\\s?)?[0-9]{3}(\\s|-)?[0-9]{3}(\\s|-)?[0-9]{4}")){
                this.phonenumber = "INVALID";
            }
            else{
                this.phonenumber = phonenumber;
            }
        
       
    }
    
    public final void setUsercode(String usercode){
        this.usercode= usercode;
    }
    
    
    
    
    public boolean isValid(){
        if (this.name.equals("INVALID") || this.surname.equals("INVALID") || this.phonenumber.equals("INVALID") ) {
            return false;
        }else{
            return true;
        }
        
    }

}
