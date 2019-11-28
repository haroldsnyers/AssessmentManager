import java.io.Serializable;

/**
 *
 */
public class Assessment implements Serializable {
    /**
     *
     */
    private static float Result;
    /**
     *
     */
    private static String AcademicYear;

    /**
     * @param Result       
     * @param AcademicYear
     */
    public Assessment(final float Result, final String AcademicYear) {
        this.Result = Result;
        this.AcademicYear = AcademicYear;
    }
}
