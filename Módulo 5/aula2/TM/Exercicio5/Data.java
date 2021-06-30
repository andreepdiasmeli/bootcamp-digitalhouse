package andreepdiasmeli.Exercicio5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Data {

    private Date data;
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public Data(Integer dia, Integer mes, Integer ano) {
        if(!validarData(dia, mes, ano)){
            throw new RuntimeException("A data é inválida");
        }

        String dataFormatada = String.format("%02d", dia)
                + "/" + String.format("%02d", mes)
                + "/" + String.format("%04d", ano);

        try {
            this.data = formatter.parse(dataFormatada);
        } catch (ParseException e) {
            System.out.println("Não foi possível criar a data.");
        }
    }

    public String getData() {
        return this.toString();
    }

    public boolean validarData(Integer dia, Integer mes, Integer ano){
        if(dia < 1 || mes < 1 || ano < 1) return false;

        Calendar calendar = new GregorianCalendar(ano, mes - 1, dia);

        if(calendar.get(Calendar.DAY_OF_MONTH) != dia
                || calendar.get(Calendar.MONTH) + 1 != mes
                || calendar.get(Calendar.YEAR) != ano) return false;
        return true;
    }

    public void incrementarDia(){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(data);
        calendar.add(Calendar.DAY_OF_MONTH, 1);

        this.data = calendar.getTime();
    }

    @Override
    public String toString() {
        return formatter.format(this.data);
    }

    public static void main(String[] args) {
        Data data = new Data(28, 02, 2021);
        System.out.println(data.toString());

        data.incrementarDia();
        System.out.println(data.toString());
    }
}
