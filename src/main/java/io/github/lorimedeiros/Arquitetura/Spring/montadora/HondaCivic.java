package io.github.lorimedeiros.Arquitetura.Spring.montadora;

import java.awt.*;

public class HondaCivic extends Carro{
    public HondaCivic(Motor motor) {
        super(motor);
        setModelo("Civic");
        setCor(Color.BLACK);
        setMontadora(Montadora.HONDA);
    }
}
