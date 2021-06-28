package andreepdiasmeli.entidades;

import andreepdiasmeli.entidades.abstracoes.FuncionarioComBonificacao;

import java.math.BigDecimal;

public class Analista extends FuncionarioComBonificacao {

    public Analista() {
        super(
                new BigDecimal("4000"),
                0,
                new BigDecimal("0.08"),
                40,
                4
        );
    }
}
