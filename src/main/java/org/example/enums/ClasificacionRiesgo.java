package org.example.enums;

public enum ClasificacionRiesgo {
    AAA, AA, A, BBB, BB, B, C, D, F;
    public boolean isRisky(){
        switch (this){
            case AAA, AA, A, BBB, BB, B -> {
                return false;
            }
            default -> {
                return true;
            }

        }
    }
}
