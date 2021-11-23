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
//class ConsumerOfS {
//    public void consume(S s) {
//        s.use();
//    }
//}
//
//class Broker {
//    public static void deal(ProducerOfS p, ConsumerOfS c) {
//        for (int i=0; i<5; i++) {
//            S s= p.produce();
//            c.consume(s);
//        }
//    }
//}
//
//public class Main3 {
//    public static void main(String[] args) {
//        Broker.deal(new ProducerOfS(), new ConsumerOfS());
//    }
//}