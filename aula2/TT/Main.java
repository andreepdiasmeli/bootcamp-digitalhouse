package andreepdiasmeli;

import andreepdiasmeli.entidades.*;
import andreepdiasmeli.entidades.abstracoes.Funcionario;
import andreepdiasmeli.entidades.abstracoes.FuncionarioComBonificacao;
import andreepdiasmeli.entidades.abstracoes.FuncionarioComParticipacaoNosLucros;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        FuncionarioComBonificacao tecnico = new Tecnico();
        FuncionarioComBonificacao analista = new Analista();
        FuncionarioComBonificacao gerente = new Gerente();
        FuncionarioComParticipacaoNosLucros diretor = new Diretor();
        FuncionarioPJ pj = new FuncionarioPJ(new BigDecimal("40"));

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(tecnico);
        funcionarios.add(analista);
        funcionarios.add(gerente);
        funcionarios.add(diretor);
        funcionarios.add(pj);

        tecnico.setMetasBatidasNoMes(10);
        analista.setMetasBatidasNoMes(10);
        gerente.setMetasBatidasNoMes(10);
        pj.setHorasTrabalhadas(160);

        funcionarios.forEach(f -> f.pagarSalario());
    }
}
