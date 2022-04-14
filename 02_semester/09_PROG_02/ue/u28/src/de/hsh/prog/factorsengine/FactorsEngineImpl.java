/***
 * 
 */
package de.hsh.prog.factorsengine;

import java.util.ArrayList;
import java.util.HashMap;

public class FactorsEngineImpl extends Thread implements FactorsEngine {
    private long numberR, zaehler = 2;
    private ArrayList<Long> res = new ArrayList<Long>();
    private HashMap<Long, FactorsEngineImpl> map = new HashMap<Long, FactorsEngineImpl>();
    
    /**
     * start job
     * @param long number
     */
    public boolean startJob(long number) {
        this.numberR = number;
        if (map.containsKey(this.numberR)) {
            return false;
        }
        map.put(this.numberR, this);
        this.start();
        return true;
    }

    /**
     * closes one thread
     * @param lon number
     */
    @Override
    public boolean abortJob(long number) {
        map.get(number).interrupt();
        return false;
    }
    
    /**
     * closes all threads
     */
    @Override
    public void shutdown() {
        for (Long i : map.keySet()) {
            map.get(i).interrupt();
        }
        
    }
    
    /**
     * returns array of all running jobs
     */
    @Override
    public long[] getRunningJobs() {
        int count = 0;
        for (int i = 0; i < res.size(); i++) {
            if (getProgress(numberR) < 1) {
                count++;
            }
        }
        long[] temp = new long[count];
        for (int i = 0; i < res.size(); i++) {
            if (getProgress(numberR) < 1) {
                temp[i] = res.get(i);
            }
        }
        return temp;
    }
    
    /**
     * long number
     */
    @Override
    public synchronized Double getProgress(long number) {
        System.out.println(zaehler + " " + number);
        return (double) Math.round((double) (zaehler * 2) / number * 100)/100;
    }

    /**
     * long number
     */
    @Override
    public synchronized long[] getFactors(long number) {
        long[] temp = new long[res.size()];
        for (int i = 0; i < res.size(); i++) {
            temp[i] = res.get(i);
        }
        return temp;
    }
    
    /**
     * @param long number
     */
    @Override
    public long[] getFactorsIntermediateResult(long number) {
        long[] temp = new long[res.size()];
        for (int i = 0; i < res.size(); i++) {
            temp[i] = res.get(i);
        }
        return temp;
    }
    
    /**
     * run
     */
    @Override
    public synchronized void run() {
        Thread.currentThread().setName("TFE_" + Long.toString(this.numberR));
        for (long i = zaehler; i <= numberR / 2; i++) {
            if (numberR % i == 0) {
                res.add(i);
            }
            zaehler++;
            System.out.println(zaehler + " " + i);
            if (Thread.interrupted()) break;
        }
    }

}
