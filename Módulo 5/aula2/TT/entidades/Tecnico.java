package andreepdiasmeli.entidades;

import andreepdiasmeli.entidades.abstracoes.FuncionarioComBonificacao;

import java.math.BigDecimal;

public class Tecnico extends FuncionarioComBonificacao {

    public Tecnico() {
        super(
                new BigDecimal("3200"),
                0,
                new BigDecimal("0.05"),
                40,
                0
        );
    }
}
