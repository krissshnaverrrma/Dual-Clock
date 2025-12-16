# ⏰ Dual Clock Application

![Project Status](https://img.shields.io/badge/status-active-brightgreen)
![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)
![License](https://img.shields.io/badge/license-MIT-blue)

## 📄 Description
**My-Clock** is a lightweight, Java-based desktop application that displays time in two distinct formats simultaneously. Built using **Java Swing**, it features a modern **Dark Mode** interface with a precise Digital display and a smoothly animated Analog face.

Designed for efficiency and aesthetics, it serves as a perfect desktop companion or a reference project for Java GUI drawing and thread management.

## 📸 Preview
![Application Screenshot](/src/clock_background.jpg)

## ✨ Features
* **Dual Display:** View both Digital (HH:MM:SS AM/PM) and Analog clocks side-by-side.
* **Dark Theme:** Sleek black background (`#000000`) with high-contrast white elements to reduce eye strain.
* **Real-Time Rendering:**
    * The **Digital Clock** updates every second with the current date and time.
    * The **Analog Clock** features custom-drawn hands (Hour, Minute, Second) using `Graphics2D` for smooth anti-aliased rendering.
* **Developer Footer:** Custom footer crediting the creator.
* **Portable:** Runs as a standalone executable JAR file.

## 🛠️ Tech Stack
* **Language:** Java (JDK 8+)
* **GUI Framework:** Swing (`JFrame`, `JPanel`, `JLabel`)
* **Graphics:** `java.awt.Graphics2D` (for drawing the analog clock face and hands)
* **IDE Config:** VS Code

## 📂 Project Structure
Based on the current directory:

```text
My-Clock/
├── .vscode/          # VS Code workspace settings
├── src/              # Source code
│   └── com/
│       └── myclock/
│           ├── DualClockApp.java      # Main entry point & Layout
│           ├── DigitalClockPanel.java # Logic for digital display
│           └── AnalogClockPanel.java  # Logic for drawing analog clock
├── .gitignore        # Git ignore rules
├── My-Clock.jar      # Executable application
└── README.md         # Documentation
🚀 How to Run
Option 1: Run the Executable (Easiest)
Since the project is already built, you can run the JAR file directly from your terminal.

Open your terminal/command prompt in the My-Clock folder.

Run the following command:

Bash

java -jar My-Clock.jar
Option 2: Run from Source
If you want to compile and run the code yourself:

Navigate to the src folder:

Bash

cd src
Compile the Java files:

Bash

javac com/myclock/*.java
Run the application:

Bash

java com.myclock.DualClockApp
👤 Author
Krishna Verma - Computer Science Student
