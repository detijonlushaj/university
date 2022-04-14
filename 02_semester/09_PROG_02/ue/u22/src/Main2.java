//class G {
//    public void use() {
//        // use product
//        // ...
//    }
//}
//class S extends G {
//    private static Log log= new Log("log-S.txt");
//    public void use() {
//        super.use();
//        // write log entry
//        log.log("used "+getClass().getName());
//    }
//}
//
//class ProducerOfG {
//    public G produce() { 
//        return new G(); 
//    }
//}
//class ProducerOfS extends ProducerOfG {
//    public S produce() { 
//        return new S();
//    }
//}
//
//class ConsumerOfG {
//    private static Log log= new Log("consumer.txt");
//    public void consume(G g) {
//        g.use();
//        log.log("used "+g.getClass().getName());
//    }
//}
//
//class Broker {
//    public static void deal(ProducerOfG p, ConsumerOfG c) {
//        for (int i=0; i<5; i++) {
//            G g= p.produce();
//            c.consume(g);
//        }
//    }
//}
//
//public class Main2 {
//    public static void main(String[] args) {
//        ConsumerOfG cg= new ConsumerOfG();
//        Broker.deal(new ProducerOfG(), cg);
//        Broker.deal(new ProducerOfS(), cg);
//    }
//}