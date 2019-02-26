package org.Primeau.exception;
public class NombreChangeInvalide extends RuntimeException {
    public NombreChangeInvalide(){
        super("Le nombre de change dépasse la capacité maximum permise de 40");
    }
}
