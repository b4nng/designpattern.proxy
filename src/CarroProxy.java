import java.util.List;

public class CarroProxy implements ICarro{

    private Carro carro;
    private String placa;

    public CarroProxy(String placa) {
        this.placa = placa;
    }

    @Override
    public List<String> obterDadosCarro() {
        if (this.carro == null){
            this.carro = new Carro(this.placa);
        }
        return this.carro.obterDadosCarro();
    }

    @Override
    public List<String> obterDocumentacao(Autoridade autoridade) throws IllegalAccessException {
        if(!autoridade.isCredenciado()){
            throw new IllegalAccessException("Not Authorized");
        }
        if (this.carro == null){
            this.carro = new Carro(this.placa);
        }
        return this.carro.obterDocumentacao(autoridade);
    }
}
