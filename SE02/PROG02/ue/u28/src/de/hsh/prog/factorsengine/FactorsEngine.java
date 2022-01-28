package de.hsh.prog.factorsengine;

/**
 * This interface provides methods to access a collection of jobs that compute
 * the set of factors for numbers specified by the client.
 * Jobs can be identified by their number.
 * Jobs can be monitored by starting a job, querying it's progress and
 * aborting a running job. The computation results of completed jobs
 * can be obtained for individual numbers.
 */
public interface FactorsEngine {

    /**
     * Initiates a compute job to calculate the factors of a given number.
     * 
     * @param number
     *            the number, for which the factors are requested.
     * @return false, if the job has been started already in the past. true, if
     *         the job was successfully started.
     */
    boolean startJob(long number);

    /**
     * Aborts a job for the given number. Will wait, until the job has
     * terminated.
     * 
     * @param number
     *            identifies the job to abort.
     * @return true, if successfully aborted. false, if there is no running job to
     *         abort
     */
    boolean abortJob(long number);

    /**
     * aborts all running jobs. Compute jobs
     * that completed successfully will remain in the list, so the
     * corresponding results are available even after shutdown. This method
     * will wait, until all running compute threads have been aborted
     * successfully.
     */
    void shutdown();

    /**
     * @return an array of job numbers currently running. A job is said to be 
     * running, if it's progress is less than 1.0
     */
    long[] getRunningJobs();


    /**
     * Returns the progress value (between 0.0 and 1.0) of the job that
     * calculates the factors for the given number.
     * 
     * @param number
     *            the number, for which the factors are requested.
     * @return null, if there is no job for the specified number. Otherwise returns
     *         the current or final
     *         progress (betweem or equal 0.0 and 1.0)
     */
    Double getProgress(long number);

    /**
     * Returns an array of factors in ascending order.
     * 
     * @param number
     *            the number, for which the factors are requested.
     * @return null if the factors are not (yet) available.
     *     If the result is available, this method returns an array of all factors of 
     *     the specified number in ascending order.
     */
    long[] getFactors(long number);

    /**
     * Returns an array of factors in ascending order.
     * This method differs from {@link #getFactors(long) getFactors}
     * in that it returns an array of factors even if the compute job has not 
     * completed its work. The return value therefore can be seen as a subset 
     * of all factors of number.
     * 
     * @param number
     *            the number, for which the factors are requested.
     * @return a possible empty array with a subset of all factors of 
     *     the specified number. The array is in ascending order.
     */
    long[] getFactorsIntermediateResult(long number);
}