import java.io.Serializable;

/**
 *
 */
public class Assessment implements Serializable {
    /**
     *
     */
    private static float result;
    /**
     *
     */
    private static String academicYear;

    /**
     * @param theResult receive a result
     * @param theAcademicYear receive a academic year
     */
    public Assessment(final float theResult, final String theAcademicYear) {
        this.result = theResult;
        this.academicYear = theAcademicYear;
    }
}
