# KJ User Guide

KJ is a desktop task manager optimized for Speed and Simplicity. It uses a Command Line Interface (CLI) to help you manage your life without touching your mouse.

## 📋 Basic Command Syntax

| Action                      | Format                           | Example                                                   |
|:----------------------------|:---------------------------------|:----------------------------------------------------------|
| Adds a Basic Todo Task      | todo [description]               | `todo Buy milk`                                           |
| Add Deadline                | deadline [desc] /by [time]       | `deadline Return book /by 2026-02-10 1200`                |
| Add Event                   | event [desc] /from [t1] /to [t2] | `event Meeting /from 2026-02-03 1800 /to 2026-02-03 2000` |
| Mark Done                   | mark [index]                     | `mark 1`                                                  |
| Umark                       | unmark [index]                   | `unmark 3`                                                |
| List All                    | list                             | `list`                                                    |
| Delete Task                 | delete [index]                   | `delete 4`                                                |
| Find Secified Task          | find [keyword]                   | `find milk`                                               |
| Sort Task Lisk by name/date | sort [desc]                      | `sort name`/`sort date`                                   |
| Exit                        | bye                              | `bye`                                                     |

## 🚀 Getting Started

Prerequisites: JDK 17, update Intellij to the most recent version.

1. Open Intellij (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project first)
2. Open the project into Intellij as follows:
   - Click `Open`.
   - Select the project directory, and click `OK`.
   - If there are any further prompts, accept the defaults.
3. Configure the project to use **JDK 17** (not other versions) as explained in [here](https://www.jetbrains.com/help/idea/sdk.html#set-up-jdk).<br>
   In the same dialog, set the **Project language level** field to the `SDK default` option.
4. Let Gradle finish syncing. 
**Warning:** Keep the `src\main\java` folder as the root folder for Java files (i.e., don't rename those folders or move Java files to another folder outside of this folder path), as this is the default location some tools (e.g., Gradle) expect to find Java files.

## 📥 Running the Application
1. Running from Source
   If you have cloned the repository and want to run it via Gradle:

   1. Open your terminal in the project root folder.

   2. Run the following command:

      - Windows: `gradlew run`

      - Mac/Linux: `./gradlew run`

2. Using the Executable JAR
   1. Build the shaded JAR:
      ```./gradlew shadowJar```
   2. Run it: 
      ``` java -jar build/libs/kj.jar```
   
