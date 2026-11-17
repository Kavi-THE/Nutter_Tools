# Construction Site Vehicle & Fleet Management System

A Java-based console application developed for object-oriented programming to efficiently manage construction site machinery, track operational hours and fuel usage, monitor vehicle availability, and calculate financial payments.

---

##  Group Details
* **Course:** IIC 1153 - Object-Oriented Programming
* **Group Number:** [Insert Group Number, e.g., B10]
* **Submission Deadline:** 19th November 2026

---

##  Project Overview
Managing heavy machinery and transport vehicles across multiple construction sites can be chaotic. This system centralizes fleet administration by providing:
* **Fleet Tracking:** Monitor whether vehicles are available, deployed on-site, or under maintenance.
* **Operations Logging:** Record daily construction hours, trips, and fuel consumption.
* **Financial Calculations:** Automatically compute operational costs and payments using polymorphic methods based on machinery types.
* **Persistent Storage:** Save and load fleet data and logs using robust file handling.

---

##  Core OOP Principles Implemented
* **Inheritance & Abstraction:** Abstract base class `Vehicle` with specialized subclasses (`HeavyMachinery` and `TransportVehicle`).
* **Encapsulation:** Private fields accessed securely through getter and setter methods.
* **Polymorphism:** Overridden `calculateOperationalCost()` methods for customized payment and expense logic.
* **Interfaces:** `Trackable` and `Payable` interfaces enforcing uniform behavior across assets.
* **Collections & Generics:** `ArrayList` and `HashMap` utilized within managers to handle fleet data structures.
* **Exception Handling:** Custom exceptions (`VehicleNotAvailableException`, `InsufficientFuelException`) to safely manage operational errors.
* **File Handling:** Persistent reading/writing of data to text/CSV files.

---

##  Project Structure

```text
src/
│
├── models/
│   ├── Vehicle.java (Abstract Base Class)
│   ├── HeavyMachinery.java
│   ├── TransportVehicle.java
│   ├── ConstructionSite.java
│   └── OperationLog.java
│
├── interfaces/
│   ├── Trackable.java
│   └── Payable.java
│
├── exceptions/
│   ├── VehicleNotAvailableException.java
│   └── InsufficientFuelException.java
│
├── services/
│   ├── FleetManager.java (Collections & Generics)
│   └── FileManager.java (File Handling)
│
└── Main.java (System Entry Point & Menu)
