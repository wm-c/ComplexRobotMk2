package client;

import tasks.Task;
import java.io.Serializable;
import java.math.BigDecimal;

public class Pi implements Task<Integer>, Serializable {

    private static final long serialVersionUID = 227L;

    public Pi(){
        
    }

    /**
     * Calculate pi.
     */
    public Integer execute() {
        int x = 30 + 999;
        return x;
    }


}