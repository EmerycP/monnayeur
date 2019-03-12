package org.Primeau.exception;
public class ManqueDePlace extends RuntimeException {
    public ManqueDePlace(){
        super("Vous n'avez pas assez de place dans la caisse!!!");
    }
}
