package andreepdiasmeli.entidades;

import andreepdiasmeli.entidades.abstracoes.Funcionario;

import java.math.BigDecimal;

public class FuncionarioPJ extends Funcionario {

    private Integer horasTrabalhadas;
    private BigDecimal valorPorHoraTrabalhada;

    public FuncionarioPJ(BigDecimal valorPorHoraTrabalhada) {
        this.valorPorHoraTrabalhada = valorPorHoraTrabalhada;
    }

    public Integer getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public BigDecimal getValorPorHoraTrabalhada() {
        return valorPorHoraTrabalhada;
    }

    public void setHorasTrabalhadas(Integer horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    @Override
    public void pagarSalario() {
        BigDecimal salarioDoMes = valorPorHoraTrabalhada.multiply(new BigDecimal(this.getHorasTrabalhadas()));
        imprimirSalarioDoMes(salarioDoMes);
    }
}
