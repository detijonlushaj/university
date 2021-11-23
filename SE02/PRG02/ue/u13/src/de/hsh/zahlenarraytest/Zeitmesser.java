/**
 * Gruppe 03
 * @author lushaj
 * U13 Zahlenarray mit Zeitmessung
 */

package de.hsh.zahlenarraytest;

public class Zeitmesser {
    private long currentTime;
    private long currentTimestop;

    private boolean laeuft;

    /**
     * 
     */
    public Zeitmesser() {
        currentTime = 0;
        laeuft = false;
    }

    /**
     * starts timer
     */
    public void start() {
        if (!laeuft) {
            currentTime = System.currentTimeMillis();
            laeuft = true;
        } else {
            errorMessage();
        }
    }
    /**
     * stops timer
     */
    public void stop() {
        if (laeuft) {
            currentTimestop += System.currentTimeMillis() - currentTime;
            laeuft = false;
        } else {
            errorMessage();
        }
    }
    /**
     * 
     * @return time interval
     */
    public long getGemesseneGesamtzeit() {
        if (!laeuft) {
            return  currentTimestop;
        } else {
            errorMessage();
            return 0;
        }

    }
    /**
     * Error message 
     * 
     */
    public void errorMessage() {
        throw new IllegalStateException("time in progress");
    }

}
