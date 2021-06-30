package andreepdiasmeli.Exercicio2;

public class Counter {

    private Integer value;

    public Counter() {
    }

    public Counter(Integer value) {
        this.value = value;
    }

    public Counter(Counter counter){
        this.value = counter.getValue();
    }

    public Integer getValue() {
        return value;
    }

    public void increase(Integer increment){
        this.value += increment;
    }

    public void decrease(Integer decrement){
        this.value -= decrement;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getValue());
    }

    public static void main(String[] args) {
        Counter counter = new Counter(10);
        System.out.println(counter.getValue());

        counter.increase(5);
        System.out.println(counter.getValue());

        counter.decrease(10);
        System.out.println(counter.getValue());
    }
}
