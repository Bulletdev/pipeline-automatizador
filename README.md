[![CodeQL Advanced](https://github.com/Bulletdev/pipeline-automatizador/actions/workflows/codeql.yml/badge.svg)](https://github.com/Bulletdev/pipeline-automatizador/actions/workflows/codeql.yml)

## 🚀 CI/CD Pipeline Configurator

## 📋 Index
- [About the Project](#-about-the-project)
- [Features](#-features) 
- [System Requirements](#-system-requirements)
- [Installation](#-installation)
- [How to Use](#-how-to-use)
- [Project Structure](#-project-structure)
- [Troubleshooting](#-troubleshooting)
- [Contribution](#-contribution)
- [License](#-license) 

## 🎯 About the Project

The CI/CD Pipeline Configurator is a Java application that allows you to create and configure continuous integration and delivery pipelines in a simple and intuitive way.
With it, you can generate configurations for Jenkins and Docker without having to edit files manually.

DEMO  ↓

<details>
<img src="/example.png">
</details>


## ✨ Features

### Graphical Interface 🖥️

- Easy-to-use interface
- Intuitive form for entering data
- Real-time visualization of the status of operations
- Support for multiple projects

### Supported configurations 🛠️

- Build tools
    - Maven 📦
    - Gradle 🐘
    - npm 📚
    - Docker 🐳
  
### Main Features 🌟
- Automatic generation of Jenkinsfile
- Docker configuration (optional)
- Git repository initialization
- Input validation
- Operations log
- File generation status


## 💻 System requirements

- Java Development Kit (JDK) 21 or higher
- Git installed on the system
- Graphical environment for running Swing
- 512MB of RAM (minimum)
- 100MB of disk space
- Internet connection (for downloading dependencies)
- Maven, Gradle or npm (optional)
- Docker (optional)
- Jenkins (optional)
- Docker Compose (optional)


## 🚀 Installation

1. **Clone the repository:**

```bash
git clone https://bulletdev/pipeline-automatizador.git
cd pipeline-automatizador
```

2. **Compile the project:**
```bash
javac PipelineConfigApp.java
```

3. **Run the application:**
```bash
java PipelineConfigApp
```

## 📖 How to use

### 1. Initial configuration 🎮
1. Open the application
2. Fill in the required fields:
    - Project Name
    - Repository URL
    - Branch (default: main)

### 2. Build configuration 🔧
1. Select the build tool (Maven, Gradle or npm)
2. Configure the desired build commands
3. Check the Docker option if you want to include containerization settings

### 3 Pipeline generation ⚡
1. Click on the “Create Pipeline” button
2. Wait for the process to finish
3. Check the files generated in the `pipeline-configs/[project-name]` folder.


## ❗ Troubleshooting

### Possible Features and Solutions 🔍

1. **Error initializing Git**
    - Check that Git is installed
    - Confirm directory permissions

2. **Interface not loading**
    - Check Java version
    - Check if a graphical environment is available

3. **File generation error
    - Check write permissions
    - Check that the directory is not in use

## 🤝 Contribution

1. Fork the project
2. Create a Branch for your Feature (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is under the MIT license. See the [LICENSE](LICENSE) file for more details.

---

💡 **Tip:** Always keep your Java version up to date for best compatibility.

📫 **Contact:** For suggestions or problems, open an [issue](https://github.com/bulletdev/pipeline-automatizador/issues).

🌟 If this project has helped you, consider giving it a star on GitHub!
