package andreepdiasmeli.entidades.abstracoes;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public abstract class Funcionario {

    public abstract void pagarSalario();

    public void imprimirSalarioDoMes(BigDecimal salarioDoMes){
        DecimalFormat f = new DecimalFormat("#,###.00");
        System.out.println("R$ " + f.format(salarioDoMes));
    }
}
