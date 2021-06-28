package andreepdiasmeli.entidades.abstracoes;

import java.math.BigDecimal;

public abstract class FuncionarioCLT extends Funcionario {

    private BigDecimal salarioBase;

    public FuncionarioCLT(BigDecimal salarioBase) {
        this.salarioBase = salarioBase;
    }

    public BigDecimal getSalarioBase() {
        return salarioBase;
    }
}
