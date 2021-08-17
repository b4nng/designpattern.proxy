import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.fail;

public class testProxy {

    @BeforeEach
    void setUp(){
        BD.addCarro(new Carro("NGB9934", "Onyx", "Branco", "Chevrolet", "MG91289371892"));
        BD.addCarro(new Carro("MKC0021", "Celta", "Preto", "Chevrolet", "MG12351243154"));
    }

    @Test
    void deveRetornarDadosCarro(){
        CarroProxy carro = new CarroProxy("NGB9934");

        Assertions.assertEquals("[Chevrolet, Branco, Onyx, NGB9934]", carro.obterDadosCarro().toString());
    }

    @Test
    void deveRetornarDocumentacao() throws IllegalAccessException {
        Autoridade autoridade = new Autoridade();
        autoridade.setCredenciado(true);
        CarroProxy carroProxy = new CarroProxy("MKC0021");
        String o = "[MG12351243154]";

        Assertions.assertEquals(o, carroProxy.obterDocumentacao(autoridade).toString());

    }

    @Test
    void deveFalharRetornarDocumentacao() throws IllegalAccessException {
        try{Autoridade autoridade = new Autoridade();
        autoridade.setCredenciado(false);
        CarroProxy carroProxy = new CarroProxy("MKC0021");
        String o = "[MG12351243154]";

        carroProxy.obterDocumentacao(autoridade);
        fail();
        }
        catch (IllegalAccessException e){
            Assertions.assertEquals("Not Authorized", e.getMessage());
        }
    }



}
