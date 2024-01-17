# sew9-2324-worttrainer-fatjonHani
sew9-2324-worttrainer-fatjonHani created by GitHub Classroom
## Gradle Project
First clone the empty project in Intellij, then create a new module and have it built in gradle via Intellij selection.
## Word Trainer Model
Statistics:

-Identify the specific statistics I need to gather. This could include things like the number of words, characters, sentences, or any other relevant metrics.
Locate the parts of my code that are responsible for these statistics. This might involve modifying existing functions or creating new ones.
Update the code to accurately collect and display the required statistics.
Current Word Entry:

-Determine what is meant by "current word entry." Am I tracking the word being actively entered by a user, or is it related to some other functionality?
Locate the relevant code sections where word entry is handled.
Implement changes based on the new requirements. This might involve updating data structures or UI components to reflect the current word entry.
Collection to Replace the Word List Class:

-Identify the existing word list class in my project.
Choose a new collection class or data structure that better meets my current requirements. This could be something like an ArrayList, HashSet, or any other appropriate Java collection class.
Replace the usages of the old word list class with the new collection class throughout my code.





## Project Overview

WordTrainer, a Java-based application, has been meticulously crafted to enhance users' language learning experience. 
It boasts a range of features, including efficient word list management, progress tracking, and engaging interactive training sessions. 

Embracing the Model-View-Controller (MVC) architectural pattern ensures a robust separation of concerns, contributing to a well-organized and easily maintainable application.

### Model

. `Rechtschreibrainer` : takes an Array lsit of WortEintrag and staking also an SessionStorageStrategy to specify the way how the objet will be saved.

- `WortEintrag`: Represents a word entry, encapsulating details such as the word itself, its meaning, and usage examples. This class is central to the application's functionality, serving as the primary data structure for word storage and manipulation.

- `JsonStorageStategy`: Extends the `Persistence` class to provide functionality for storing and retrieving application data in JSON format. This class plays a crucial role in data persistence, enabling the application to maintain state across sessions.

- `SessionStorageStrategy`: Interface which ist vital for having the Strategy pattern with the base function like save and load
### View

- `Anzeige`: takes an Rechtschreibtrainer and uses the URL and the String word to create an image with JOptionpane and a possebility to give user input

### Controller

- `WortMain`: Serves as the central controller for the application. It manages interactions between the model and view components, orchestrating the overall flow of the application. This class is key to implementing the MVC architecture effectively.
