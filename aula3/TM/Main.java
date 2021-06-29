import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Pessoa pessoas[] = new Pessoa[5];
        pessoas[0] = new Pessoa("André", "370");
        pessoas[1] = new Pessoa("André", "073");
        pessoas[2] = new Pessoa("Eduardo", "459");
        pessoas[3] = new Pessoa("Pacheco", "657");
        pessoas[4] = new Pessoa("Dias", "008");

        SortUtil.sort(pessoas);

        System.out.println(Arrays.toString(pessoas));

        Celular celulares[] = new Celular[5];
        celulares[0] = new Celular("André", "0055");
        celulares[1] = new Celular("André", "0047");
        celulares[2] = new Celular("Eduardo", "9923");
        celulares[3] = new Celular("Pacheco", "3622");
        celulares[4] = new Celular("Dias", "6226");

        SortUtil.sort(celulares);

        System.out.println(Arrays.toString(celulares));

    }
}
