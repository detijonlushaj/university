//class G {
//    public void use() {
//        // use product
//        // ...
//    }
//}
//
//class ProducerOfG {
//    public G produce() { 
//        return new G(); 
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
//public class Main1 {
//    public static void main(String[] args) {
//        Broker.deal(new ProducerOfG(), new ConsumerOfG());
//    }
//}