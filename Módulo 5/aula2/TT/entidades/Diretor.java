package andreepdiasmeli.entidades;

import andreepdiasmeli.entidades.abstracoes.FuncionarioComParticipacaoNosLucros;

import java.math.BigDecimal;

public class Diretor extends FuncionarioComParticipacaoNosLucros {

    public Diretor() {
        super(
                new BigDecimal("15000"),
                new BigDecimal("0.03")
        );
    }
}
