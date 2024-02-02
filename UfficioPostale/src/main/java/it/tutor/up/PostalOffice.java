/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tutor.up;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author loren
 */
public class PostalOffice {

    private static PostalOffice _instance = null;

    public static PostalOffice getInstance() {
        if (_instance == null) {
            _instance = new PostalOffice();
        }
        return _instance;
    }

    private PostalOffice() {
        super();
    }

    private List<Person> sportello1 = new LinkedList<>();
    private List<Person> sportello2 = new LinkedList<>();
    private List<Person> sportello3 = new LinkedList<>();
    private List<Person> sportello4 = new LinkedList<>();

    public List<Person> getSportello1() {
        return sportello1;
    }

    public List<Person> getSportello2() {
        return sportello2;
    }

    public List<Person> getSportello3() {
        return sportello3;
    }

    public List<Person> getSportello4() {
        return sportello4;
    }
    
    

    static int id = 0;

    /**
     * Il metodo giveId restituisce l'id progressivo
     *
     * @return l'id progressivo che è 0 nel primo caso
     */
    public final int giveId() {

        return id++;

    }

    //REVISION il javadoc è fatto male. La descrizione va in cima, nel tag param
    //ci va la descrizione del parametro, e nel tag @return manca la descrizione
    //del valore di ritorno e degli eventuali valori di errore
    //URGENT. Eseguire il refactor suggerito al task 25 e usare le enum
    //in luogo delle stringhe
    /**
     *
     * @param personeInFila restituisce il tempo di attesa dello sportello che
     * gli viene dato come parametro.
     * @return Ritorna la sommatoria dei tempi di attesa degli utenti in fila.
     * Se l'argomento è null ritorna null. Se l'argomento è una lista vuota
     * ritorna 0.
     */
    public Float getWaitingTime(List<Person> personeInFila) {

        if (personeInFila == null) {
            return null;
        }

        float temp = 0;
        for (Person i : personeInFila) {
            char service = i.getUsercode().charAt(0);
            ServiziCode codeByChar = ServiziCode.codeByChar(service);
            switch (codeByChar) {
                case S:
                    temp += ServiziType.SPEDIZIONI.getTempMedia();
                    break;
                case P:
                    temp += ServiziType.PAGAMENTI.getTempMedia();
                    break;
                case F:
                    temp += ServiziType.FINANZIARI.getTempMedia();
                    break;

                default:
                    return null;
            }
        }
        return temp;
    }

    //REVISION - COMPLETARE IL JAVADOC
    /**
     * La funzione qui presente controlla che un numero di telefono non sia in
     * nessuna lista
     *
     * @param number
     * un numero di telefono già <b>validato</b>
     * @return true
     */
    public boolean isNumberExisting(String number) {
        for (Person person : sportello1) {
            if (person.getPhonenumber().equals(number)) {
                return true;
            }
        }
        for (Person person : sportello2) {
            if (person.getPhonenumber().equals(number)) {
                return true;
            }

        }
        for (Person person : sportello3) {
            if (person.getPhonenumber().equals(number)) {
                return true;
            }
        }
        for (Person person : sportello4) {
            if (person.getPhonenumber().equals(number)) {
                return true;
            }
        }
        return false;
    }

    //REVISION: NOME METODO INIZIANTE CON UNA MAIUSCOLA. AAAAA 
    public String generateCode(ServiziType x) {
        String code = "";
        int f=prenota(x);
        
        if (x.equals(ServiziType.FINANZIARI)) {
            code = "F";
            code += String.valueOf(f);
            code += "-";
            code += String.valueOf(id);
            return code;
        }
        if (x.equals(ServiziType.PAGAMENTI)) {
            code = "P";
            code += String.valueOf(f);
            code += "-";
        }
        if (x.equals(ServiziType.SPEDIZIONI)) {
            code = "S";
            code += String.valueOf(f);
            code += "-";
        }
        code += String.valueOf(id);
        return code;

    }

    /**
     * Il metodo prenota restituisce lo sportello con meno tempo di attesa in
     * coda.
     *
     * @param type è il tipo di servizio per il quale si intende prenotare.
     * @return ritorna 4 se type è un servizio finanziario, sennò ritorna
     * l'indice dello sportello con minore tempo di attesa.
     */
    public int prenota(ServiziType type) {

        float waitingTime[] = new float[4];
        waitingTime[0] = getWaitingTime(sportello1);  
        waitingTime[1] = getWaitingTime(sportello2);
        waitingTime[2] = getWaitingTime(sportello3);
        waitingTime[3] = getWaitingTime(sportello4);

        if (type.equals(ServiziType.FINANZIARI)) {

            return 4;
        }

        int indexOfMin = 0;
        for (int i = 1; i < 3; i++) {
            if (waitingTime[i] < waitingTime[indexOfMin]) {
                indexOfMin = i;
            }

        }
        return indexOfMin+1;

    }

    public ErrorType validateFields(String name, String surname, String phonenumber) {

        if (name == null || name.isEmpty() || !name.matches("((de|di)\\s)?[A-Z][a-z]+")) {
            return ErrorType.NAME_INVALID;
        } else if (surname == null || surname.isEmpty() || !surname.matches("[A-Z][a-z]+")) {
            return ErrorType.SURNAME_INVALID;
        } else if (phonenumber == null || phonenumber.isEmpty() || !phonenumber.matches("((0039|\\+39)\\s?)?[0-9]{3}(\\s|-)?[0-9]{3}(\\s|-)?[0-9]{4}")) {
            return ErrorType.TELEPHONE_INVALID;
        }
        return ErrorType.NO_ERROR;
    }

    public Person createPerson(String name, String surname, String phonenumber, ServiziType x) {
        Person p = new Person(name, surname, phonenumber, null);
        p.setUsercode(generateCode(x));
        return p;
    }

    
    public void addInCoda( Person x, ServiziType y ){
        
        
        int k = prenota(y);
        
        switch (k){
            
            case 1: {
                this.sportello1.add(x);
            }
            case 2: {
                this.sportello2.add(x);
            }
            case 3: {
                this.sportello3.add(x);
            }
            case 4: {
                this.sportello4.add(x);
            }
        }      
    }
    
     public boolean validateCode(String code){
         if(!(code == null || code.isEmpty())){
             
             if(code.matches("[S,P,F][1-4]-[0-9]*")){
                 return true;
             }
             else{
                 return false;
             }
         }
         return false;
             
     }
    
    public void reset(){
     sportello1.clear();
     sportello2.clear();
     sportello3.clear();
     sportello4.clear();
        id = 0;
    }
}
