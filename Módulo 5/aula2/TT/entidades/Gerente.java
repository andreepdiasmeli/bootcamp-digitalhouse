package andreepdiasmeli.entidades;

import andreepdiasmeli.entidades.abstracoes.FuncionarioComBonificacao;

import java.math.BigDecimal;

public class Gerente extends FuncionarioComBonificacao {

    public Gerente() {
        super(
                new BigDecimal("6000"),
                0,
                new BigDecimal("0.125"),
                36,
                4
        );
    }

}
