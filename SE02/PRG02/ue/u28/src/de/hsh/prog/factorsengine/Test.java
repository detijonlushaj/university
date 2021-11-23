package de.hsh.prog.factorsengine;

import java.util.Arrays;

public class Test  {


    public static void main(String[] args) throws Exception {
        System.out.println("Starting test cycle ...");
        shouldCalculate();
        shouldMonitorShortRunningJob();
        shouldMonitorLongRunningJob();
        shouldPreventStartingAJobTwice();
        shouldImplementProgressForShortRunningJob();
        shouldImplementProgressForLongRunningJob();
        shouldDeliverIntermediateResults();
        shouldShutdown();
        System.out.println();
        System.out.println("Finished test cycle.");
    }


    public static void shouldCalculate() {
        logMethod();
        long number1= 72, number2= 1400, number3= 32768;
        runAndWait1sec(number1);
        runAndWait1sec(number2);
        runAndWait1sec(number3);
    }


    public static void shouldMonitorShortRunningJob() {
        logMethod();
        long number= 78;
        FactorsEngine engine= new FactorsEngineImpl();
        runAndWait1sec(engine, number);
        abortShortJob(engine, number);
    }


    public static void shouldMonitorLongRunningJob() {
        logMethod();
        long number= 999999999999L;
        FactorsEngine engine= new FactorsEngineImpl();
        engine.startJob(number);
        long[] running= engine.getRunningJobs();
        System.out.println("running=" + Arrays.toString(running)+" (should be ["+number+"])");
        abortLongJob(engine, number);
    }


    public static void shouldPreventStartingAJobTwice() {
        logMethod();
        long number= 1234567890123L;
        FactorsEngine engine= new FactorsEngineImpl();
        engine.startJob(number);
        boolean started= engine.startJob(number);
        System.out.println("started = "+started+" (should be false)");
        abortLongJob(engine, number);
    }


    public static void shouldImplementProgressForShortRunningJob() {
        logMethod();
        long number= 134L;
        FactorsEngine engine= new FactorsEngineImpl();
        engine.startJob(number);
        sleep(1000);
        double progress= engine.getProgress(number);
        System.out.println("progress = " + progress + " (should be 1.0)");
        abortShortJob(engine, number);
    }


    public static void shouldImplementProgressForLongRunningJob() {
        logMethod();
        long number= 1234567890123L;
        FactorsEngine engine= new FactorsEngineImpl();
        engine.startJob(number);
        sleep(1000);
        double progress= engine.getProgress(number);
        System.out.println("progress = " + progress + " (should be >=0 and <1)");
        abortLongJob(engine, number);
    }



    public static void shouldDeliverIntermediateResults() {
        logMethod();
        long number= 999999999999L;
        FactorsEngine engine= new FactorsEngineImpl();
        engine.startJob(number);
        sleep(1000);
        long[] intermediate= engine.getFactorsIntermediateResult(number);
        System.out.println("intermediate.length = " + intermediate.length + " (should be > 0)");
        abortLongJob(engine, number);
    }

    public static void shouldShutdown() {
        logMethod();
        long number1= 134L, number2= 512L, number3= 123456789033L, number4= 123456798013L;
        FactorsEngine engine= new FactorsEngineImpl();

        engine.startJob(number1);
        engine.startJob(number2);
        engine.startJob(number3);
        engine.startJob(number4);

        sleep(1000);

        long[] running= engine.getRunningJobs();
        System.out.println("running = " + Arrays.toString(running) + " (should be ["+number3+","+number4+"] in arbitrary order)");

        long[] observed1= engine.getFactors(number1);
        System.out.println("observed1.length = "+observed1.length+" (should be > 0)");
        long[] observed2= engine.getFactors(number2);
        System.out.println("observed2.length = "+observed2.length+" (should be > 0)");

        engine.shutdown();

        long[] runningAfterShutdown= engine.getRunningJobs();
        System.out.println("runningAfterShutdown.length = " + runningAfterShutdown.length + " (should be 0)");

        long[] observed1AfterShutdown= engine.getFactors(number1);
        System.out.println("observed1AfterShutdown.length = "+observed1AfterShutdown.length+" (should be > 0)");
        long[] observed2AfterShutdown= engine.getFactors(number2);
        System.out.println("observed2AfterShutdown.length = "+observed2AfterShutdown.length+" (should be > 0)");
    }


    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }


    private static void abortLongJob(FactorsEngine engine, long number) {
        boolean success= engine.abortJob(number);
        System.out.println("success=" + success+" (should be true)");
        long[] running= engine.getRunningJobs();
        System.out.println("running.length=" + running.length+" (should be 0)");
    }

    private static void abortShortJob(FactorsEngine engine, long number) {
        boolean success= engine.abortJob(number);
        System.out.println("success=" + success+" (should be false)");
        long[] running= engine.getRunningJobs();
        System.out.println("running.length=" + running.length+" (should be 0)");
    }

    private static long[] runAndWait1sec(final FactorsEngine engine, final long number) {
        engine.startJob(number);
        Double progress1= engine.getProgress(number);
        sleep(1000);
        Double progress2= engine.getProgress(number);
        System.out.println("progress1 = "+progress1+", progress2 = "+progress2+" (should read progress1 <= progress2 = 1.0)");
        return engine.getFactors(number);
    }


    private static void runAndWait1sec(long number) {
        FactorsEngine engine= new FactorsEngineImpl();
        long[] observed= runAndWait1sec(engine, number);
        System.out.println(Arrays.toString(observed));
    }

    private static void logMethod() {
        System.out.println();
        System.out.println("Method " + new Exception().getStackTrace()[1].getMethodName());
    }
}