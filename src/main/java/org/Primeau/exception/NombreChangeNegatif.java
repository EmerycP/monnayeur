package org.Primeau.exception;
public class NombreChangeNegatif extends RuntimeException {
    public NombreChangeNegatif(){
        super("Le nombre de change est en dessous de zero");
    }
}
