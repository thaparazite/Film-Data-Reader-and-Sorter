# Film Data Reader and Sorter

- **Project Overview:**
  1. **Reading Film Data:**
     - Utilizes Java's file I/O mechanisms to parse a CSV file containing film data.
     - Extracts relevant information about each film from the file.

  2. **Statistical Calculations:**
     - Calculates statistics on the dataset, including:
       - Sum of lengths of films at even indexes.
       - Minimum length among films at odd indexes.

  3. **Sorting Films:**
     - Allows sorting films based on different criteria:
       - Film ID, Title, Genre, Director Name, Length, and Rating.
     - Employs Comparator implementations for flexible sorting.

  4. **Adding New Films:**
     - Interactive addition of new films to the list.
     - Prompts users to input details such as Genre, Director Name, Title, Rating, and Length.
     - Performs input validation and updates the file with the new film.

  5. **Multithreading for Sorting:**
     - Enhances sorting performance by employing multithreading.
     - Uses a fixed thread pool with six threads to sort.

# Project Scope:
The project aims to provide a robust and efficient solution for managing film data in a Java environment. It focuses on essential functionalities such as data reading, analysis, sorting, and user interaction. Future enhancements may include additional features for data visualization, advanced statistical analysis, and integration with external databases or APIs for enriched film information.


## Project Significance:
This project aims to demonstrate skills in file I/O, data manipulation, exception handling, and multithreading in Java programming. It provides users with a tool to manage film data efficiently, analyze statistics, and perform sorting operations based on user preferences.

## Getting Started:
### Note:
Ensure you have Java installed on your system to run this program.

#### Compilation and Execution Steps:
1. Clone or download the repository to your local machine.
2. Navigate to the directory containing the Java files.
3. Compile the Java files using `javac FilmDataReaderAndSorter.java`.
4. Run the compiled program using `java FilmDataReaderAndSorter`.

## Support and Assistance:
If you encounter any issues or have questions about the project, feel free to reach out to the project maintainer via email.

## Project Maintenance and Contributors:
This project is maintained and developed by [Flaviu Vanca](https://github.com/thaparazite). Contributions and suggestions are welcome via pull requests. Please adhere to the project's contribution guidelines outlined in the repository.

## License:
This project is provided without any specific license.

## Disclaimer:
This application is for educational and demonstration purposes only. It may not be suitable for production use without further validation and testing. Use at your own risk.
