public class Celular implements Precedente<Celular> {

    private String nome;
    private String numero;

    public Celular(String nome, String numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public int precedeA(Celular t) {
        int compareToNome = this.getNome().compareToIgnoreCase(t.getNome());
        if (compareToNome == 0) {
            return this.getNumero().compareTo(t.getNumero());
        }
        return compareToNome;
    }

    @Override
    public String toString() {
        return this.nome + " (" + this.numero + ")";
    }
}
