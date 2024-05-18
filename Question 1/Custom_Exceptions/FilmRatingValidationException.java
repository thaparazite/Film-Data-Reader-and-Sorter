package Custom_Exceptions;

public class FilmRatingValidationException extends FilmDataValidationException {
    public FilmRatingValidationException(String message) {
        super(message);
    }// end constructor
}// end of FilmRatingValidationException class