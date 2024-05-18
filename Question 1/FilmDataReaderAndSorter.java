import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import Custom_Exceptions.FilmDirectorNameValidationException;
import Custom_Exceptions.FilmGenreValidationException;
import Custom_Exceptions.FilmRatingValidationException;
import Custom_Exceptions.FilmTitleValidationException;
import Custom_Exceptions.FilmLengthValidationException;
import Custom_Exceptions.FilmDataValidationException;

public class FilmDataReaderAndSorter {

    public static void main(String[] args) {

        String path = "Question 1/CSV Files/Film.csv";// path to the file containing the film data
        // call the method to read the films from the file and store them in a list
        List<Film> films = readFilmsFromFile(path);

        System.out.println();// print a blank line
        FilmDataReaderAndSorter.divider();// print a divider line
        System.out.println("\t\t\t\t\t\t\t*** Terminal Assessment Based Assignment ***");// print the question number
        System.out.println("\t\t\t\t\t\t\t *   Algorithms and Advance Programming   *");// print the course name
        FilmDataReaderAndSorter.divider();// print a divider line
        System.out.println();// print a blank line
        String text = "Question 1. a)";
        FilmDataReaderAndSorter.printUnderline(text);// print underline of the text

        /*
         * 
         * test the program by printing the first two films in the list, if the list is
         * not empty, otherwise print a message indicating that no films were loaded
         */
        if (!films.isEmpty()) {
            System.out.println(films.get(0));
            System.out.println(films.get(1));
        } else {
            System.out.println("No films were loaded from the file.");
        } // end of if-else block
        FilmDataReaderAndSorter.divider();// print a divider line
        System.out.println();// print a blank line
        text = "Question 1. b)";
        FilmDataReaderAndSorter.printUnderline(text);// print underline of the text
        /*
         * I wasn't sure if its the even indexes of the list I stored the Film objects
         * or the even indexes of the Film.csv file, so I implemented the method to
         * calculate the sum of the lengths of the films from the Film.csv file.
         * 
         * call the method to calculate the sum of the lengths of the films at even
         * indexes in the list of films.
         */
        float sumOfLengthOfEvenIndexes = FilmDataReaderAndSorter.sumEvenIndexedRows(films, 0);
        System.out.println(
                "The sum of the lengths of the films at even indexes in the list of films is: "
                        + sumOfLengthOfEvenIndexes);
        FilmDataReaderAndSorter.divider();// print a divider line
        System.out.println();// print a blank line
        text = "Question 1. c)";
        FilmDataReaderAndSorter.printUnderline(text);// print underline of the text
        float minValueLengthofOddIndexes = FilmDataReaderAndSorter.findMinOddIndexes(films);
        FilmDataReaderAndSorter.printUnderline("The minimum value in the length column is: "
                + minValueLengthofOddIndexes);
        /*
         * print the film(s) with the minimum value in the length
         * column length(odd indexes)
         */
        for (int i = 1; i < films.size(); i += 2) {
            if (minValueLengthofOddIndexes == films.get(i).getLength()) {
                System.out.println(films.get(i));
            } // end of if statement
        } // end of for loop
        FilmDataReaderAndSorter.divider();// print a divider line
        System.out.println();// print a blank line
        text = "Question 1. d)";
        FilmDataReaderAndSorter.printUnderline(text);// print underline of the text

        /*
         * to avoid a ClassCastException for printing all 10K films, I will print first
         * 25 films from the list to test the sorting method
         */

        text = "The first 25 films in the list before sorting by choice ";
        FilmDataReaderAndSorter.printUnderline(text);// print underline of the text
        // print the first 25 films in the list sorted by default (filmID)
        for (Film film : films.subList(0, 25)) {
            System.out.println(film);
        } // end of for-each loop
        FilmDataReaderAndSorter.divider();// print a divider line
        System.out.println();// print a blank line

        // sort the films by a column of the user's choice
        Scanner input = new Scanner(System.in);
        try {
            boolean flag = false;
            while (!flag) {

                text = "Sort the films by a column of your choice";
                FilmDataReaderAndSorter.printUnderline(text);// print underline of the text
                System.out.println("1. Film ID");
                System.out.println("2. Title");
                System.out.println("3. Genre");
                System.out.println("4. Director Name");
                System.out.println("5. Length");
                System.out.println("6. Rating");
                // print dashes to overline the text
                for (int i = 0; i < text.length() + 3; i++) {
                    System.out.print("-");
                } // end of for loop
                System.out.println();

                while (!flag) {
                    text = "Enter the column number to sort the films by: ";

                    System.out.print(text + " ");// prompt the user to enter a column number
                    while (!input.hasNextInt()) {
                        String errorText = "That's not a number! Please enter a number between 1 and 6.";
                        FilmDataReaderAndSorter.printUnderline(errorText);// print underline of the text
                        System.out.print(text + " ");
                        input.next(); // discard non-integer input
                    } // end of while loop

                    int column = input.nextInt();
                    if (column >= 1 && column <= 6) {
                        for (int i = 0; i < text.length() + 2; i++) {
                            System.out.print("-");
                        } // end of for loop
                        System.out.println();
                        FilmDataReaderAndSorter.sortFilms(films, column);
                        for (Film film : films.subList(0, 25)) {
                            System.out.println(film);
                        } // end of for-each loop
                        FilmDataReaderAndSorter.divider();// print a divider line
                        flag = true;
                    } else {
                        text = "Invalid column number. Please enter a number between 1 and 6.";
                        FilmDataReaderAndSorter.printUnderline(text);// print underline of the text
                        flag = false;
                    } // end of if-else block
                } // end of while loop

                // ask the user if they want to continue sorting the films by another column
                while (flag) {
                    System.out.print("Continue sorting the films by another column? (yes/no):  ");
                    String choice = input.next();

                    // check if the user entered yes or no
                    if (choice.equalsIgnoreCase("yes")) {
                        flag = false;
                        FilmDataReaderAndSorter.divider();// print a divider line
                    } else if (choice.equalsIgnoreCase("no")) {
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter yes or no.");
                        FilmDataReaderAndSorter.divider();// print a divider line
                    } // end of if-else block
                } // end of inner while loop
            } // end of outer while loop
            FilmDataReaderAndSorter.divider();// print a divider line
        } catch (Exception e) {
            System.out.println("An error occurred. Program will terminate !");
            System.exit(0);
        } // end of try-catch block

        System.out.println();// print a blank line

        text = "Question 1. e)";
        FilmDataReaderAndSorter.printUnderline(text);// print underline of the text

        /*
         * create an executor service with a fixed thread pool of 6 threads to sort the
         * films by each column in parallel and save the sorted films to separate files
         * with the column number in the filename
         */
        ExecutorService executor = Executors.newFixedThreadPool(6);
        for (int i = 1; i <= 6; i++) {
            executor.execute(new FilmSorter(films, i));
        } // end of for loop
        executor.shutdown();// shut down the executor service

        try {
            executor.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            System.out.println("Sorting interrupted.");
        } // end of try-catch block

        text = "All files saved successfully.";
        System.out.println();// print a blank line
        FilmDataReaderAndSorter.printUnderline(text);// print underline of the text

        // Question 4 implementation starts here
        System.out.println();// print a blank line
        FilmDataReaderAndSorter.divider();// print a divider line
        System.out.println();// print a blank line
        text = "Question 4";
        FilmDataReaderAndSorter.printUnderline(text);// print underline of the text
        System.out.println();// print a blank line

        // Question 4. a)

        int trackException = 0;// track the exception thrown by the NumberFormatException
        try {
            boolean flag = false;
            while (!flag) {
                System.out.print("Enter genre: ");
                String genre = input.next();
                input.nextLine();// consume the newline character
                FilmDataReaderAndSorter.validateGenre(genre);
                System.out.print("Enter director: ");
                String directorName = input.nextLine();

                FilmDataReaderAndSorter.validateDirector(directorName);
                System.out.print("Enter title: ");
                String title = input.nextLine();

                FilmDataReaderAndSorter.validateTitle(title);
                System.out.print("Enter rating: ");
                ++trackException;
                float rating = Float.parseFloat(input.next());
                FilmDataReaderAndSorter.validateRating(rating);
                System.out.print("Enter length: ");
                ++trackException;
                float length = Float.parseFloat(input.next());
                FilmDataReaderAndSorter.validateLength(length);

                int newId = films.size() + 1;
                Film newFilm = new Film(newId, genre, directorName, title, rating, length);
                films.add(newFilm);

                FilmDataReaderAndSorter.addFilmToFile(newFilm, path);

                // sort the films by filmID to get the last film/s added to the list
                FilmDataReaderAndSorter.sortFilms(films, 1);

                text = "Film added successfully to the list.";
                for (Film film : films.subList(10000, films.size())) {
                    System.out.println(film);
                } // end of for-each loop

                System.out.println();// print a blank line
                FilmDataReaderAndSorter.printUnderline(text);// print underline of the text
                /*
                 * set the flag to true to enter the loop and ask the user
                 * if they want to add another film to the list
                 */
                flag = true;

                // ask the user if they want to add another film to the list
                while (flag) {
                    text = "Would you like to add another film to the list? (yes/no):  ";
                    for (int i = 0; i < text.length() + 2; i++) {
                        System.out.print("-");// print dashes to overline the text
                    } // end of for loop
                    System.out.println();// print a blank line
                    System.out.print(text);// prompt the user to enter yes or no
                    String choice = input.next();
                    for (int i = 0; i < text.length() + choice.length(); i++) {
                        System.out.print("-");
                    } // end of for loop
                    System.out.println();// print a blank line
                    // check if the user entered yes or no
                    if (choice.equalsIgnoreCase("yes")) {
                        flag = false;
                    } else if (choice.equalsIgnoreCase("no")) {
                        break;
                    } else {
                        text = "Invalid input. Please enter yes or no.";
                        for (int i = 0; i < text.length(); i++) {
                            System.out.print("-");
                        } // end of for loop
                        System.out.println();// print a blank line
                        System.out.println(text);
                        for (int i = 0; i < text.length(); i++) {
                            System.out.print("-");
                        } // end of for loop
                        System.out.println();// print a blank line
                    } // end of if-else block
                } // end of inner while loop
            } // end of outer while loop
        } catch (FilmTitleValidationException e) {
            FilmDataReaderAndSorter.divider();
            System.out.println("FilmTitleValidationException: " + e.getMessage());
            FilmDataReaderAndSorter.printEndProgramMessage();
            FilmDataReaderAndSorter.endProgram();
        } catch (FilmRatingValidationException e) {
            FilmDataReaderAndSorter.divider();
            System.out.println("FilmRatingValidationException: " + e.getMessage());
            FilmDataReaderAndSorter.printEndProgramMessage();
            FilmDataReaderAndSorter.endProgram();
        } catch (FilmDirectorNameValidationException e) {
            FilmDataReaderAndSorter.divider();
            System.out.println("FilmDirectorNameValidationException: " + e.getMessage());
            FilmDataReaderAndSorter.printEndProgramMessage();
            FilmDataReaderAndSorter.endProgram();
        } catch (FilmLengthValidationException e) {
            FilmDataReaderAndSorter.divider();
            System.out.println("FilmLengthValidationException: " + e.getMessage());
            FilmDataReaderAndSorter.printEndProgramMessage();
            FilmDataReaderAndSorter.endProgram();
        } catch (FilmGenreValidationException e) {
            FilmDataReaderAndSorter.divider();
            System.out.println("FilmGenreValidationException: " + e.getMessage());
            FilmDataReaderAndSorter.printEndProgramMessage();
            FilmDataReaderAndSorter.endProgram();
        } catch (FilmDataValidationException e) {
            FilmDataReaderAndSorter.divider();
            System.out.println("FilmDataValidationException: " + e.getMessage());
            FilmDataReaderAndSorter.printEndProgramMessage();
            FilmDataReaderAndSorter.endProgram();
        } catch (NumberFormatException e) {
            // check if the exception was thrown by the rating
            if (trackException == 1) {
                throw new FilmRatingValidationException("Rating must contain only digits.");
            } // end of if statement

            // check if the exception was thrown by the length
            if (trackException == 2) {
                throw new FilmLengthValidationException("Film length must contain only digits.");
            } // end of if statement
            FilmDataReaderAndSorter.printEndProgramMessage();
            FilmDataReaderAndSorter.endProgram();
        } finally {
            input.close();// close the scanner
        } // end of try-catch block

        text = "The last films added to the list are: ";
        FilmDataReaderAndSorter.printUnderline(text);// print underline of the
                                                     // text
        for (int i = 10000; i <= films.size() - 1; ++i) {
            System.out.println(films.get(i));
        } // end of for-each loop

        // print a message indicating that the program has finished executing
        FilmDataReaderAndSorter.printEndProgramMessage();
    }// end of main method

    private static void printEndProgramMessage() {
        // print a message indicating that the program has finished executing
        System.out.println(
                "-------------------------------------------------------------------- End of Program ---------------------------------------------------------------------");
    }// end of printEndProgramMessage method

    public static void addFilmToFile(Film film, String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath, true); // true means append to file
            writer.write(film.getFilmID() + ",");
            writer.write(film.getGenre() + ",");
            writer.write(film.getDirectorName() + ",");
            writer.write(film.getTitle() + ",");
            writer.write(film.getRating() + ",");
            writer.write(film.getLength() + "");
            writer.write("\n");// write a new line character to separate the films
            writer.close();
        } catch (IOException e) {
            FilmDataReaderAndSorter.divider();
            System.out.println("An error occurred while writing to file: " + e.getMessage());
            FilmDataReaderAndSorter.printEndProgramMessage();
            FilmDataReaderAndSorter.endProgram();
        } // end of try-catch block
    }// end of addFilmToFile method

    // method to end the program
    private static void endProgram() {
        System.exit(0);// exit the program
    }// end of endProgram method

    // Question 1. a)
    public static List<Film> readFilmsFromFile(String path) {
        List<Film> films = new ArrayList<>();// list to store the film objects
        // read the file and catch any exceptions that may occur
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine(); // skip the first line which contains the column names

            while ((line = br.readLine()) != null) {// read the file line by line until the end of the file
                // split the line into an array of strings using the comma as the delimiter
                String[] data = line.split(",");
                // create a new Film object and add it to the list of films
                films.add(new Film(Integer.parseInt(data[0]), data[1], data[2], data[3], Float.parseFloat(data[4]),
                        Float.parseFloat(data[5])));
            } // end of while loop
        } catch (FileNotFoundException e) {// catch the exception if the file is not found
            System.out.println("The file " + path + " was not found.");
        } catch (NumberFormatException e) {// catch the exception if there is an error parsing the data
            System.out.println("There was an error parsing the data. Please check the file format.");
        } catch (IOException e) {// catch the exception if there is an error reading the file
            System.out.println("An error occurred while reading the file.");
        } // end of try-catch block

        return films;
    }// end of readFilmsFromFile method

    /*
     * Question 1. b)
     *
     * method to calculate the sum of the lengths of the films at even indexes in
     * the list of films starting from the given index
     */
    public static float sumEvenIndexedRows(List<Film> films, int index) {
        /*
         * check if the index is greater than or equal to the size of the list,
         * to avoid an IndexOutOfBoundsException when trying to access an element
         */
        if (index >= films.size()) {
            return 0;
        } // end of if statement

        /*
         * check if the index is 0 and increment it by 1 to start from the first even
         * index in the .csv file
         */
        if (index == 0) {
            ++index;
        } // end of if statement

        /*
         * get the length of the film at the current index of the list and add it to the
         * sum, then recursively call the method with the next even index of the list
         */
        float value = films.get(index).getLength();
        return (value + sumEvenIndexedRows(films, index + 2)); // recursively call the method with the next even index
    } // end of sumEvenIndexedRows method

    /*
     * Question 1. c)
     * method to find the minimum value in the respective column from part b).
     */
    public static float findMinOddIndexes(List<Film> films) {
        float minValue = Float.MAX_VALUE;// set the initial minimum value to the maximum float value
        // iterate over the films list starting from the second element (odd indexes)
        for (int i = 1; i < films.size(); i += 2) {
            float value = films.get(i).getLength();
            if (value < minValue) {
                minValue = value;
            } // end of if statement
        } // end of for loop

        return minValue;// return the minimum value
    }// end of findMinOddIndexes method

    /*
     * Question 1. d)
     * 
     * I used the Comparator class and passing the method reference to the sort
     * method to sort the films by the column number entered by the user
     * 
     */
    public static void sortFilms(List<Film> films, int column) {
        switch (column) {
            case 1: // filmID
                films.sort(Comparator.comparingInt(Film::getFilmID));
                break;
            case 2: // title
                films.sort(Comparator.comparing(Film::getTitle));
                break;
            case 3: // genre
                films.sort(Comparator.comparing(Film::getGenre));
                break;
            case 4: // directorName
                films.sort(Comparator.comparing(Film::getDirectorName));
                break;
            case 5: // length
                films.sort(Comparator.comparingDouble(Film::getLength));
                break;
            case 6: // rating
                films.sort(Comparator.comparingDouble(Film::getRating));
                break;
            default:
                System.out.println("Invalid column number.");
                break;
        }// end of switch statement
    }// end of sortFilms method

    // method to print a divider line
    private static void divider() {
        for (int i = 0; i < 153; i++) {
            System.out.print("-");
        } // end of for loop
        System.out.println();
    }// end of divider method

    // print underline of a given text
    private static void printUnderline(String text) {
        System.out.println(text);
        for (int i = 0; i < text.length(); i++) {
            System.out.print("-");
        } // end of for loop
        System.out.println();
    }// end of printUnderscore method

    // Question 4
    // method to validate the genre of the film
    public static void validateGenre(String genre) {
        /*
         * check if the genre is null or empty and throw an exception if it is
         */
        if (genre == null || genre.trim().isEmpty()) {
            throw new FilmGenreValidationException("Genre cannot be empty.");
        }
        /*
         * check if the genre contains any digits and throw an exception if it does
         */
        if (genre.matches(".*\\d.*")) {
            throw new FilmGenreValidationException("Genre cannot contain digits.");
        } // end of if statement
    }// end of validateGenre method

    // method to validate the director name of the film
    public static void validateDirector(String director) {
        // check if the director name is null or empty and throw an exception if it is
        if (director == null || director.trim().isEmpty()) {
            throw new FilmDirectorNameValidationException("Director name cannot be empty.");
        } // end of if statement

        // check if the director name contains only digits and throw an exception if it
        // does
        if (director.matches("\\d+")) {
            throw new FilmDirectorNameValidationException("Director name cannot contain only digits.");
        } // end of if statement
    }// end of validateDirector method
     // method to validate the title of the film

    public static void validateTitle(String title) {
        // check if the title is null or empty and throw an exception if it is
        if (title == null || title.trim().isEmpty()) {
            throw new FilmTitleValidationException("Title cannot be empty.");
        } // end of if statement

        // check if the title contains only digits and throw an exception if it does
        if (title.matches("\\d+")) {
            throw new FilmTitleValidationException("Title cannot contain only digits.");
        } // end of if statement
    }// end of validateTitle method
     // method to validate the rating of the film

    public static void validateRating(float rating) {
        // check if the rating is less than 1 or greater than 10 and throw an exception
        if (rating < 1 || rating > 100) {
            throw new FilmRatingValidationException("Rating must be between 1 and 100.");
        } // end of if statement
    }// end of validateRating method

    public static void validateLength(float length) {
        // check if the length is less than 0 or greater than 10 and throw an exception
        if (length < 0 || length > 10) {
            String message = length < 0 ? "Film length must be greater than 0h." : "Film length cannot exceed 10h.";
            throw new FilmLengthValidationException(message);
        } // end of if statement
    }// end of validateLength method

}// end of ReadFilmData class

// Question 1. e)
// class to sort the films by the column number entered by the user and save the
// sorted films to a file
class FilmSorter implements Runnable {
    private List<Film> films;// list of films to be sorted
    private int column;// column number to sort the films by
    private String filename;

    // constructor to initialize the film list and column number
    public FilmSorter(List<Film> films, int column) {
        this.films = new ArrayList<>(films); // create a copy of the film list
        this.column = column; // set the column number
        String columnName = getColumnName(column);
        this.filename = "Question 1/CSV Files/Films_Sorted_By_" + columnName + ".csv";
    } // end of constructor

    // method to get column name from column number
    private String getColumnName(int column) {
        switch (column) {
            case 1:
                return "FilmID";
            case 2:
                return "Title";
            case 3:
                return "Genre";
            case 4:
                return "DirectorName";
            case 5:
                return "Length";
            case 6:
                return "Rating";
            default:
                return "Unknown";
        }// end of switch statement
    }// end of getColumnName method

    /*
     * the run method is called when the thread is started, it sorts the films by
     * the column number and saves the sorted films to a .csv file with the column
     * number in the filename
     */
    @Override
    public void run() {
        // call the sortFilms method to sort the films by the column number
        FilmDataReaderAndSorter.sortFilms(films, column);
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("FilmID,Title,Genre,DirectorName,Length,Rating");
            for (Film film : films) {
                writer.println(film.getFilmID() + "," + film.getTitle() + "," + film.getGenre() + ","
                        + film.getDirectorName() + "," + film.getLength() + "," + film.getRating());
            } // end of enhanced for loop
            System.out.println("Sorted file saved as: " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file: " + filename);
        } // end of try-with-resources/catch block
    }// end of run method
}// end of FilmSorter class

// class to represent a Film object
class Film implements Comparable<Object> {
    // instance variables
    private int filmID;
    private String title;
    private String genre;
    private String directorName;
    private float length;
    private float rating;

    // constructor to initialize the film object with the given values
    public Film(int filmID, String genre, String directorName, String title, float length, float rating) {
        super();
        this.filmID = filmID;
        this.title = title;
        this.genre = genre;
        this.directorName = directorName;
        this.length = length;
        this.rating = rating;
    }// end of the constructor

    // setters and getters for the instance variables
    public int getFilmID() {
        return filmID;
    }

    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    // so the film objects can be compared when sorting/searching
    // NOTE: this will only allow comparisons based on the id of the film
    @Override
    public int compareTo(Object obj) {
        /*
         * compare the filmID of the current film object with the filmID of the other
         * film object and return the difference
         */
        Film film = (Film) obj;
        return filmID - (film.getFilmID());
    }// end of compareTo method

    @Override
    public String toString() {
        return "Film ID: " + filmID + ", Title: " + title + ", Genre: " + genre + ", Director Name: "
                + directorName + ", Length: " + length + ", Rating: "
                + rating;
    }// end of toString method
}// end of Film class