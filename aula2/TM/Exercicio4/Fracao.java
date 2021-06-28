package andreepdiasmeli.Exercicio4;

public class Fracao {

    private Integer numerador;
    private Integer denominador;

    public Fracao(Integer numerador, Integer denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Integer getNumerador() {
        return numerador;
    }

    public Integer getDenominador() {
        return denominador;
    }

    public static Fracao adicionar(Fracao f1, Fracao f2){
        Integer denominador = f1.getDenominador() * f2.getDenominador();
        return new Fracao(
                ((denominador / f1.getDenominador()) * f1.getNumerador()) + ((denominador / f2.getDenominador()) * f2.getNumerador()),
                denominador
        );
    }

    public static Fracao subtrair(Fracao f1, Fracao f2){
        Integer denominador = f1.getDenominador() * f2.getDenominador();
        return new Fracao(
                ((denominador / f1.getDenominador()) * f1.getNumerador()) - ((denominador / f2.getDenominador()) * f2.getNumerador()),
                denominador
        );
    }

    public static Fracao multiplicar(Fracao f1, Fracao f2){
        return new Fracao(
                f1.getNumerador() * f2.getNumerador(),
                f1.getDenominador() * f2.getDenominador()
        );
    }

    public static Fracao dividir(Fracao f1, Fracao f2){
        return new Fracao(
                f1.getNumerador() * f2.getDenominador(),
                f1.getDenominador() * f2.getNumerador()
        );
    }

    public static Fracao adicionar(Fracao f, Integer i){
        return adicionar(f, new Fracao(i, 1));
    }

    public static Fracao adicionar(Integer i, Fracao f){
        return adicionar(f, i);
    }

    public static Fracao subtrair(Fracao f, Integer i){
        return subtrair(f, new Fracao(i, 1));
    }

    public static Fracao subtrair(Integer i, Fracao f){
        return subtrair(new Fracao(i, 1), f);
    }

    public static Fracao multiplicar(Fracao f, Integer i){
        return multiplicar(f, new Fracao(i, 1));
    }

    public static Fracao multiplicar(Integer i, Fracao f){
        return multiplicar(f, i);
    }

    public static Fracao dividir(Fracao f, Integer i){
        return dividir(f, new Fracao(i, 1));
    }

    public static Fracao dividir(Integer i, Fracao f){
        return dividir(new Fracao(i, 1), f);
    }

    @Override
    public String toString() {
        return numerador + "/" + denominador;
    }

    public static void main(String[] args) {
        Fracao f1 = new Fracao(1, 2);
        Fracao f2 = new Fracao(1, 2);

        System.out.println(Fracao.adicionar(f1, f2).toString());
        System.out.println(Fracao.subtrair(f1, f2).toString());
        System.out.println(Fracao.multiplicar(f1, f2).toString());
        System.out.println(Fracao.dividir(f1, f2).toString());

        System.out.println();

        System.out.println(Fracao.adicionar(f1, 1).toString());
        System.out.println(Fracao.subtrair(f1, 1).toString());
        System.out.println(Fracao.multiplicar(f1, 1).toString());
        System.out.println(Fracao.dividir(f1, 1).toString());

        System.out.println();

        System.out.println(Fracao.adicionar(1, f1).toString());
        System.out.println(Fracao.subtrair(1, f1).toString());
        System.out.println(Fracao.multiplicar(1, f1).toString());
        System.out.println(Fracao.dividir(1, f1).toString());
    }
}
