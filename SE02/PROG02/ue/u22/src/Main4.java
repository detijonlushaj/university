/**
 * Gruppe 03
 * @author lushaj
 * U22 Substitutionsprinzip, Kovarianz, Kontravarianz
 */
class G {
    public void use() {
        // use product
        // ...
    }
}
class S extends G {
    private static Log log= new Log("log-S.txt");
    /**
     * create text file protocol
     */
    public void use() {
        super.use();
        // write log entry
        log.log("used "+getClass().getName());
    }
}

class ProducerOfG {
    /**
     * 
     * @return G object
     */
    public G produce() { 
        return new G(); 
    }
}
class ProducerOfS extends ProducerOfG {
    /**
     * @return S object
     */
    public S produce() { 
        return new S();
    }
}

class ConsumerOfG extends ConsumerOfS {
    private static Log log= new Log("consumer.txt");
    /**
     * create text file protocol wiht a G object
     * @param g
     */
    public void consume(G g) {
        g.use();
        log.log("used "+g.getClass().getName());
    }
    /**
     * upcast S objet to G object to override super.consume
     * @param S
     */
    @Override
    public void consume(S s) {
        G g = (G)s;
        this.consume(g);
    }
}
class ConsumerOfS {
    /**
     * call use and create text file
     * @param s
     */
    public void consume(S s) {
        s.use();
    }
}

class Broker {
    /**
     * deal
     * @param p
     * @param c
     */
    public static void deal(ProducerOfS p, ConsumerOfS c) {
        for (int i=0; i<5; i++) {
            S s= p.produce();
            c.consume(s);
        }
    }
}

public class Main4 {
    public static void main(String[] args) {
        ProducerOfS ps= new ProducerOfS();
        Broker.deal(ps, new ConsumerOfS());
        Broker.deal(ps, new ConsumerOfG());
    }
}