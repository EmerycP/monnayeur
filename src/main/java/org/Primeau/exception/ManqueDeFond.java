package org.Primeau.exception;
public class ManqueDeFond extends RuntimeException {
    public ManqueDeFond(){
        super("Vous n'avez pas donné assez de fond dans la caisse!!!");
    }
}
