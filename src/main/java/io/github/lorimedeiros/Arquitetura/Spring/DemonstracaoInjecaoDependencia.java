package io.github.lorimedeiros.Arquitetura.Spring;

import io.github.lorimedeiros.Arquitetura.Spring.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemonstracaoInjecaoDependencia {

    // será injetado o TodoValidator

    // 1ª forma (injeção via propriedade)
    // simplesmente deixando como atributo e anotando com @Autowired, sem precisar de um construtor
    @Autowired
    private TodoValidator validator;

    // 2ª forma (injeção via setter)
    // faz o método set e coloca anotação @Autowired
    @Autowired
    public void setValidator(TodoValidator validator){
        this.validator = validator;
    }

    // 3ª forma (injeção via construtor)
    // faz o construtor da classe e coloca anotação @Autowired
    @Autowired
    public DemonstracaoInjecaoDependencia(TodoValidator validator) {
        this.validator = validator;
    }

    /*
    O spring recomenda que injetemos via construtor pois dá ideia de obrigatoriedade
    já o set dá ideia de opcional (pois precisamos usar o método)
    já via propriedade não denota nem obrigatoriedade nem opcionalidade, é o menos recomendado possível, porém mais fácil de fazer

    Resumo da ópera: injeção via construtor é a mais recomendada e aceita nos padrões
    */
}
