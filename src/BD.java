import java.util.HashMap;
import java.util.Map;

public class BD {
    private static Map<String, Carro> carros = new HashMap<>();

    public static Carro getCarro(String placa) {
        return carros.get(placa);
    }

    public static void addCarro(Carro carro) {
        carros.put(carro.getPlaca(), carro);
    }
}
