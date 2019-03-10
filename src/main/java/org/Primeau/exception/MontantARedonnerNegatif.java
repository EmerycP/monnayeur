package org.Primeau.exception;
public class MontantARedonnerNegatif extends RuntimeException {
    public MontantARedonnerNegatif(){
        super("Vous n'avez pas donné assez d'argent!!!");
    }
}
