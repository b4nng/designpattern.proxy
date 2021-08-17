import java.util.List;

public interface ICarro {
    List<String> obterDadosCarro();
    List<String> obterDocumentacao(Autoridade autoridade) throws IllegalAccessException;
}
