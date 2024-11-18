<h1 align="center" style="font-weight: bold;">OracleLibrary 💻</h1>

<div align="center">
  <a href="#">
    <img src="https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white" alt="Oracle Badge">
  </a>
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java Badge">
</div>

<p align="center">
  <b>This project, built using Java and Oracle Database 18c, aims to enhance the management of a local library. The Oracle database is designed to handle the entire lifecycle of library operations, including tracking books, authors, library members, loans, and returns. It offers robust features for real-time book availability checks, managing and calculating fines for overdue items, and generating detailed reports on book popularity and usage trends.</b>
</p>

<h3>Features</h3>
<ul>
  <li>Real-time book availability tracking.</li>
  <li>Detailed member management and loan history tracking.</li>
  <li>Automated overdue fine calculation and management.</li>
  <li>Comprehensive reporting on book usage and popularity.</li>
</ul>

<h3>Prerequisites</h3>
Before running this project, make sure you have the following installed:

- [Oracle Database 18c](https://www.oracle.com/database/technologies/xe-downloads.html) - Used for managing all library data.
- [Oracle SQL Developer](https://www.oracle.com/tools/downloads/sqldev-downloads.html) - Useful for managing and querying the Oracle Database.
- [JDK 23](https://www.oracle.com/java/technologies/javase/jdk23-archive-downloads.html) - Java Development Kit to compile and run the project.

<h3>Recommended IDE</h3>

- [Visual Studio Code](https://code.visualstudio.com/Download) - This project was developed using VS Code. It is recommended due to its excellent support for Java projects and integrated features like debugging, extensions, and dependency management.


<h3>Installing JDK 23</h3>

Follow these steps to install JDK 23 on your system:

1. **Download JDK 23**
   - Visit the [JDK 23 download page](https://www.oracle.com/java/technologies/javase/jdk23-archive-downloads.html).
   - Choose the appropriate installer for your operating system (Windows, macOS, or Linux).
   
2. **Install JDK 23**
   - **Windows**:
     - Run the `.exe` file that you downloaded.
     - Follow the installation wizard, click "Next" to proceed through the steps, and select the destination folder.
     - Once installation is complete, click "Close".
   - **macOS**:
     - Open the `.dmg` file and run the installer.
     - Follow the installation prompts to complete the process.
   - **Linux**:
     - Extract the `.tar.gz` file to your preferred installation directory using:
       ```bash
       tar -xvzf jdk-23_linux-x64_bin.tar.gz -C /your/preferred/location
       ```

3. **Set JAVA_HOME Environment Variable**
   - **Windows**:
     - Go to "Control Panel" > "System and Security" > "System" > "Advanced system settings".
     - Click on "Environment Variables", then click "New" under "System variables".
     - Set `JAVA_HOME` to the path where JDK 23 was installed (e.g., `C:\Program Files\Java\jdk-23`).
     - Add `%JAVA_HOME%\bin` to your `Path` variable.
   - **macOS/Linux**:
     - Edit your shell profile file (`~/.bashrc` or `~/.zshrc`):
       ```bash
       export JAVA_HOME=/your/preferred/location/jdk-23
       export PATH=$JAVA_HOME/bin:$PATH
       ```
     - Save the file and run `source ~/.bashrc` or `source ~/.zshrc` to apply the changes.

4. **Verify the Installation**
   - Open a terminal or command prompt and type:
     ```bash
     java -version
     ```
   - You should see the Java version information indicating that JDK 23 is installed.

## Folder Structure

```bash
Database/
Program/
├──.vscode/
├──bin/
├──lib/
├──src/
```


## Getting Started

1. **Clone the Repository**
   ```bash
   git clone https://github.com/ThiagoRosa21/Database-Library-Management
