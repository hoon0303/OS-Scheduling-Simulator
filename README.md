# OS Scheduling Simulator

OS Scheduling Simulator is a Java application designed to simulate various CPU scheduling algorithms. It provides a graphical user interface to input process data, select scheduling algorithms, and visualize the scheduling results.

## Features

- **Process Input**: Users can input process details such as arrival time, service time, priority, and time quantum.
- **Scheduling Algorithms**: Supports multiple scheduling algorithms including FCFS, SJF, SRT, Non-preemptive Priority, Preemptive Priority, RR, and HRN.
- **Result Visualization**: Visual representation of scheduling results including Gantt chart, average turnaround time, and average waiting time.
- **SQLite Integration**: Ability to load test data from an SQLite database.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- SQLite JDBC Driver (included in the project)

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/your-username/OS-Scheduling-Simulator.git
    cd OS-Scheduling-Simulator
    ```

2. Compile the Java files:
    ```bash
    javac OS.java
    ```

3. Run the application:
    ```bash
    java OS
    ```

### Usage

1. **Start the Application**: Run the application to open the main menu.
2. **Input Process Data**: Select 'Start' to input process details.
3. **Load Test Data**: Optionally, load test data from an SQLite database by clicking test data.
4. **Select Scheduling Algorithm**: Choose a scheduling algorithm to visualize the results.
5. **View Results**: See the Gantt chart, average turnaround time, and average waiting time for the selected algorithm.

### GUI Components

- **Main Menu**: Start, Guide, and Developer information.
- **Process Input**: Fields for entering the number of processes, process details, and time quantum.
- **Results**: Buttons to select scheduling algorithms and display results.
- **Guide**: Instructions for using the application.
- **Developer Info**: Information about the development team.

### Scheduling Algorithms

1. **First-Come, First-Served (FCFS)**
2. **Shortest Job First (SJF)**
3. **Shortest Remaining Time (SRT)**
4. **Non-preemptive Priority**
5. **Preemptive Priority**
6. **Round Robin (RR)**
7. **Highest Response Ratio Next (HRN)**
