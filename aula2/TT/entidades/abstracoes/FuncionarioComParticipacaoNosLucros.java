package andreepdiasmeli.entidades.abstracoes;

import java.math.BigDecimal;

public abstract class FuncionarioComParticipacaoNosLucros extends FuncionarioCLT{

    private BigDecimal percentualParticipacaoNosLucros;

    public FuncionarioComParticipacaoNosLucros(BigDecimal salarioBase, BigDecimal percentualParticipacaoNosLucros) {
        super(salarioBase);
        this.percentualParticipacaoNosLucros = percentualParticipacaoNosLucros;
    }

    public BigDecimal getPercentualParticipacaoNosLucros() {
        return percentualParticipacaoNosLucros;
    }

    public void pagarSalario() {
        BigDecimal salarioDoMes = getSalarioBase()
                .add( (this.getPercentualParticipacaoNosLucros().add(BigDecimal.ONE) )
                        .multiply(BigDecimal.ZERO) // TODO: multiplicar pelo total de lucro da empresa (após criar uma entidade com essa informação)
                );
        imprimirSalarioDoMes(salarioDoMes);
    }
}
