package andreepdiasmeli.entidades.abstracoes;

import java.math.BigDecimal;

public abstract class FuncionarioComBonificacao extends FuncionarioCLT{

    private Integer metasBatidasNoMes;
    private BigDecimal bonificacaoMetaBatida;
    private Integer horasJornadaSemanal;
    private Integer horasDescansoSemanalRemunerado;

    public FuncionarioComBonificacao(BigDecimal salarioBase, Integer metasBatidasNoMes, BigDecimal bonificacaoMetaBatida, Integer horasJornadaSemanal, Integer horasDescansoSemanalRemunerado) {
        super(salarioBase);
        this.metasBatidasNoMes = metasBatidasNoMes;
        this.bonificacaoMetaBatida = bonificacaoMetaBatida;
        this.horasJornadaSemanal = horasJornadaSemanal;
        this.horasDescansoSemanalRemunerado = horasDescansoSemanalRemunerado;
    }

    public Integer getMetasBatidasNoMes() {
        return metasBatidasNoMes;
    }

    public BigDecimal getBonificacaoMetaBatida() {
        return bonificacaoMetaBatida;
    }

    public Integer getHorasJornadaSemanal() {
        return horasJornadaSemanal;
    }

    public Integer getHorasDescansoSemanalRemunerado() {
        return horasDescansoSemanalRemunerado;
    }

    public void setMetasBatidasNoMes(Integer metasBatidasNoMes) {
        this.metasBatidasNoMes = metasBatidasNoMes;
    }

    public void pagarSalario() {
        BigDecimal salarioDoMes = getSalarioBase()
                .multiply(
                        BigDecimal.ONE.add(
                                this.getBonificacaoMetaBatida().multiply(new BigDecimal(this.getMetasBatidasNoMes()))
                        )
                );
        imprimirSalarioDoMes(salarioDoMes);
    }

}
