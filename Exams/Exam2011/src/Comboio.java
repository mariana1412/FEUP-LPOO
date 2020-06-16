import java.util.ArrayList;
import java.util.List;

public class Comboio {

    private String nome;
    private final List<Carruagem> carruagens;
    private int numPassageiros;
    private int lugaresLivres;
    private ServicoABordo servicoABordo;

    public Comboio(String nome) {
        this.nome = nome;
        this.carruagens = new ArrayList<>();
        this.numPassageiros = 0;
        this.lugaresLivres = 0;
        this.servicoABordo = new ServicoRegular();
    }

    public String getNome() {
        return nome;
    }

    public int getNumLugares(){
        int num = 0;
        for(Carruagem carruagem : carruagens) num += carruagem.getNumLugares();
        return num;
    }

    public int getNumCarruagens(){
        return carruagens.size();
    }

    public void addCarruagem(Carruagem c) {
        this.carruagens.add(c);
        this.lugaresLivres += c.getNumLugares();
    }

    public Carruagem getCarruagemByOrder(int order){
        if((order > getNumCarruagens()) || (order < 0)) return null;
        return carruagens.get(order);
    }

    public void removeAllCarruagens(int num) {
        List<Carruagem> toRemove = new ArrayList<>();

        for(Carruagem carruagem : carruagens){
            if(carruagem.getNumLugares() == num) toRemove.add(carruagem);
        }

        for(Carruagem carruagem : toRemove) carruagens.remove(carruagem);
    }

    public int getNumPassageiros() {
        return numPassageiros;
    }

    public int getLugaresLivres() {
        return lugaresLivres;
    }

    public List<Carruagem> getCarruagens() {
        return carruagens;
    }

    public ServicoABordo getServicoABordo() {
        return servicoABordo;
    }

    public String getDescricaoServico(){
        return this.servicoABordo.toString();
    }

    public void setServicoABordo(ServicoABordo servicoABordo) {
        this.servicoABordo = servicoABordo;
    }

    public void addPassageiros(int num) throws PassengerCapacityExceeded {
        if((lugaresLivres-num) < 0) throw new PassengerCapacityExceeded();
        this.lugaresLivres -= num;
        this.numPassageiros += num;
    }

    public void removePassageiros(int num) {

        int number;
        if(numPassageiros < num) number = num - (num - numPassageiros);
        else number = num;

        this.numPassageiros -= number;
        this.lugaresLivres += number;
    }

    public void removePassageiros() {
        this.numPassageiros = 0;
        this.lugaresLivres = getNumLugares();
    }


    @Override
    public String toString() {
        return "Comboio " + getNome() + ", " +
                getNumCarruagens() + (getNumCarruagens() != 1 ?  " carruagens" : " carruagem") + ", " +
                getNumLugares() + (getNumLugares() != 1 ?  " lugares" : " lugar") + ", " +
                getNumPassageiros() + (getNumPassageiros() != 1 ?  " passageiros" : " passageiro");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comboio)) return false;
        Comboio comboio = (Comboio) o;

        if(getNumLugares() != comboio.getNumLugares()) return false;
        if(getNumCarruagens() != comboio.getNumCarruagens()) return false;

        for(int i = 0; i < getNumCarruagens(); i++){
            if(carruagens.get(i).getNumLugares() != comboio.getCarruagens().get(i).getNumLugares()) return false;
        }

        return true;
    }

}
