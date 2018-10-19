package trabalhoSDRMI;

import java.io.Serializable;

public class Mensagem implements Serializable {
    private String msg = null;
    Mensagem(String msg) {
        this.msg = msg;
    }
    
    String getText() {
        return this.msg;
    }
}
