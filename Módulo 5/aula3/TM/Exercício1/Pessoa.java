
public class Pessoa implements Precedente<Pessoa> {

    private String nome;
    private String cpf;

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public int precedeA(Pessoa t) {
        int compareToNome = this.getNome().compareToIgnoreCase(t.getNome());
        if(compareToNome == 0){
            return this.getCpf().compareTo(t.getCpf());
        }
        return compareToNome;
    }

    @Override
    public String toString() {
        return this.nome + " (" + this.cpf + ")";
    }
}
