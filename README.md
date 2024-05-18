# Film Data Reader and Sorter

## Project Overview:
The Film Data Reader and Sorter is a Java application designed to read film data from a Comma-Separated Values (CSV) file, perform various operations on the data, and allow users to interactively sort the films based on different criteria. It provides functionalities such as reading film data from a file, calculating statistics on the data, sorting films by different columns, and adding new films to the list.

## Key Features:
1. **Reading Film Data**: The program can read film data from a CSV file containing information such as film ID, title, genre, director name, length, and rating.
   
2. **Data Analysis**: Users can calculate statistics on the film data, such as the sum of lengths of films at even indexes and finding the minimum value in the length column.

3. **Interactive Sorting**: The application allows users to sort films by different columns, including film ID, title, genre, director name, length, and rating. Users can choose the column they want to sort by and observe the sorted results.

4. **Parallel Sorting**: Sorting operations are optimized using multithreading. The program creates an executor service with a fixed thread pool to sort films by each column in parallel, enhancing performance for large datasets.

5. **Exception Handling**: Robust exception handling is implemented to manage errors gracefully. Various custom exception classes are used to handle validation errors, such as invalid genre, director name, title, rating, and length.

6. **Dynamic Film Addition**: Users can dynamically add new films to the list by providing details such as genre, director name, title, rating, and length. The program validates user input to ensure data integrity.

7. **File Management**: The application supports saving sorted films to separate files with the column number in the filename. This feature enables users to export sorted data for further analysis or sharing.

## Project Significance:
This project showcases proficiency in Java programming, including file I/O, data manipulation, exception handling, multithreading, and object-oriented design principles. It provides users with a comprehensive tool for managing film data, analyzing statistics, and performing sorting operations based on user preferences.

## Getting Started:
### Prerequisites:
Ensure you have Java Development Kit (JDK) installed on your system to compile and run the program.

### Compilation and Execution Steps:
1. Clone or download the repository to your local machine.
2. Open a terminal or command prompt and navigate to the directory containing the Java files.
3. Compile the Java files using the command: `javac FilmDataReaderAndSorter.java`.
4. Run the compiled program using the command: `java FilmDataReaderAndSorter`.

## Support and Assistance:
If you encounter any issues or have questions about the project, feel free to reach out to the project maintainer via email. Support for this project is provided on a best-effort basis.

## Project Maintenance and Contributors:
This project is maintained and developed by [Flaviu Vanca](https://github.com/thaparazite). Contributions and suggestions are welcome via pull requests. Please adhere to the project's contribution guidelines outlined in the repository.

## License:
This project is provided without any specific license. Users are free to use, modify, and distribute the code for educational and non-commercial purposes.

## Disclaimer:
This application is for educational and demonstration purposes only. It may not be suitable for production use without further validation and testing. Use at your own risk.


----------------------------

# Project Overview

The Film Data Reader and Sorter is a Java application designed to handle film data stored in a CSV file. It offers various functionalities to interact with the film data, including reading the data from the file, performing statistical calculations, sorting films based on different criteria, and allowing users to add new films to the list.

## 1. Reading Film Data:
The application starts by reading film data from a CSV file. It utilizes Java's file I/O mechanisms to parse the file and extract relevant information about each film. This operation ensures that the film data is available for subsequent processing.

## 2. Statistical Calculations:
Once the film data is loaded, the application performs statistical calculations on the dataset. Specifically:
- **Sum of Lengths at Even Indexes:** It calculates the sum of the lengths of films located at even indexes in the list of films.
- **Minimum Length at Odd Indexes:** It identifies the minimum value in the length column among films located at odd indexes in the list.

## 3. Sorting Films:
The application allows users to sort films based on different criteria, including Film ID, Title, Genre, Director Name, Length, and Rating. Users input their choice of column for sorting, and the application sorts the films accordingly. It employs Comparator implementations to enable flexible sorting based on user preferences.

## 4. Adding New Films:
Users can interactively add new films to the list. The application prompts users to input details such as Genre, Director Name, Title, Rating, and Length for the new film. It performs input validation to ensure the entered data adheres to specified criteria. Upon successful addition, the new film is appended to the existing list, and the file is updated accordingly.

## 5. Multithreading for Sorting:
To enhance performance, the application employs multithreading to sort films by each column in parallel. It utilizes a fixed thread pool with six threads to concurrently sort the films based on different criteria. This approach improves efficiency when dealing with large datasets and reduces overall execution time.

## User Input and Interaction:
The application interacts with users through the command-line interface (CLI). Users input their preferences and provide necessary information when prompted by the application. Input validation mechanisms ensure that users enter valid data, enhancing the robustness of the application. Additionally, the application provides clear prompts, error messages, and instructions to guide users throughout the interaction process.

# Key Features:
- **Data Reading:** Read film data from a CSV file.
- **Statistical Analysis:** Calculate statistics on film data, including sum and minimum values.
- **Sorting:** Sort films based on different criteria chosen by users.
- **User Input Validation:** Validate user input to ensure data integrity and prevent errors.
- **Multithreading:** Utilize multithreading to improve sorting performance on large datasets.
- **Interactive Addition:** Allow users to add new films interactively, with input validation and file updates.

# Use Cases:
- **Film Database Management:** Manage a collection of films, perform analysis, and efficiently sort films based on various attributes.
- **Film Inventory Management:** Maintain an inventory of available films, add new entries, and sort the inventory for easy access and retrieval.
- **Film Statistics and Analysis:** Analyze film data to derive insights such as average length, distribution of ratings, and common genres.

# Target Audience:
- **Film Enthusiasts:** Individuals passionate about films who want to organize and manage their film collections effectively.
- **Film Industry Professionals:** Professionals working in the film industry who require tools for data analysis and management.
- **Students and Educators:** Students and educators studying or teaching Java programming, file I/O, and multithreading concepts.

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
