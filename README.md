# Dog - Cloud Software Application with MySQL

Welcome to Dog, a cutting-edge web application designed to demonstrate the development of cloud software applications using MySQL. This application provides a hands-on approach to working with relational databases, performing CRUD operations, interacting with external APIs, and processing JSON data efficiently. Dog serves as an educational tool for developers looking to enhance their understanding of database management, API integration, and frontend development using PrimeFaces.

## Features

- **MySQL Database Integration**: Learn how to create and manage a MySQL database, including schema creation and data population through SQL scripts.
- **CRUD Operations**: Detailed examples of Create, Read, Update, and Delete operations within a MySQL database.
- **Jakarta Persistence Usage**: Guide on using Jakarta Persistence (formerly JPA) for database interaction, highlighting the ease of mapping objects to database tables.
- **External API Interaction**: Fetch JSON data from The Movie Database (TMDB) and Open Movie Database (OMDb) APIs, showcasing real-world data usage.
- **JSON Data Processing**: Techniques for processing JSON data with optionals (`optString`, `optInt`, `optDouble`, `optLong`), ensuring robust data handling.
- **Global and Column-specific Search**: Implementations of search functionalities within data tables, both globally and by specific columns.
- **Data Table Sorting**: How to sort data tables dynamically based on column values.
- **PrimeFaces Carousel**: Utilize PrimeFaces Carousel component to create a manual image slider displaying current movie posters.

## Getting Started

### Prerequisites

Before starting, ensure you have the following installed:
- MySQL Server
- Java Development Kit (JDK)
- Any IDE supporting Java (e.g., IntelliJ IDEA, Eclipse)
- Apache Maven (for dependency management)

### Installation and Setup

1. Clone the repository:
2. Set up the MySQL database:
- Create a new database named `dog`.
- Run the SQL scripts provided in the `database` directory to create tables and populate initial data.
3. Import the project into your IDE and configure database connection settings in `application.properties`.
4. Build and run the project using Maven:
5. Access the application at `http://localhost:8080`.

## Usage

1. Sign in to the application using your credentials.
2. Explore the various features such as CRUD operations, external API integration, and data table functionalities.
3. Follow the on-screen instructions and tooltips to navigate through the application.

## Contributing

We welcome contributions from the community! If you'd like to contribute to the project, please follow these guidelines:
- Check the [issue tracker](https://github.com/yourusername/dog/issues) for open issues or submit a new one.
- Fork the repository and create a new branch for your changes.
- Make your changes, ensuring they follow the project's coding standards and guidelines.
- Submit a pull request with a descriptive title and summary of your changes.

Please review the [CONTRIBUTING.md](CONTRIBUTING.md) file for more detailed instructions.

## License

This project is licensed under the [MIT License](LICENSE.md).

## Contact

For any questions or feedback, feel free to contact us at junsoo@vt.edu.
