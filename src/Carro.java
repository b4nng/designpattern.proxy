import java.util.Arrays;
import java.util.List;

public class Carro implements ICarro{

    private String placa;
    private String modelo;
    private String cor;
    private String marca;
    private String documentacao;

    public Carro(String placa, String modelo, String cor, String marca, String documentacao) {
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
        this.marca = marca;
        this.documentacao = documentacao;
    }

    public Carro(String placa){
        this.placa = placa;
        Carro carro = BD.getCarro(placa);
        this.modelo = carro.modelo;
        this.cor = carro.cor;
        this.marca = carro.marca;
        this.documentacao = carro.documentacao;

    }

    public String getPlaca() {
        return placa;
    }

    @Override
    public List<String> obterDadosCarro() {
        return Arrays.asList(this.marca, this.cor, this.modelo, this.placa);
    }

    @Override
    public List<String> obterDocumentacao(Autoridade autoridade) {
        return Arrays.asList(this.documentacao);
    }
}
