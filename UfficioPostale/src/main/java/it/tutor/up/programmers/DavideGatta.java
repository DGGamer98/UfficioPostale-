/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tutor.up.programmers;

/**
 *
 * @author loren
 */
public class DavideGatta {
     
    private String name;
    private String surname;
    private String phonenumber; 
   
    
    public DavideGatta(){
        
    }
    
   public DavideGatta(String name,String surname,String phonenumber){
       
       this.name = name;
       this.surname = surname;
       this.phonenumber = phonenumber;
   }
   
   public String getName(){
       return name;
   }
   public String getSurname(){
       return surname;
   }
   public String getPhonenumber(){
       return phonenumber;
   }
   public void setName(String name){
   if(name == null || name.isEmpty() || !name.matches("((de|di)\\s)?[A-Z][a-z]+")){
                this.name = "INVALID";
            }
            else{
            this.name = name;
   }
   }
   public void setSurname(String surname){
       if(surname == null || surname.isEmpty() || !surname.matches("[A-Z][a-z]+")){
              this.surname = "INVALID";
       }
       else{
       this.surname = surname;
   }
   }
   public void setPhonenumber(String phonenumber){
       if(phonenumber == null || phonenumber.isEmpty() || !phonenumber.matches("((0039|+39)\\s?)?[0-9]{3}(\\s|-)?[0-9]{3}(\\s|-)?[0-9]{4}")){
                this.phonenumber = "INVALID";
            }
            else{
                this.phonenumber = phonenumber;
            }
   }
}

