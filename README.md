# hail
Scalable stress testing automation

## Components

* Master node - serves the purpose of executing arbitrary scenario code in the cluster. It also collects feedback from worker nodes.
* Worker node - executes scenarios and sends feedback to the master node
* API - library that defines endpoints that are required by Core application to execute an evaluation.

## Architecture

The benchmark code should be implemented in a JVM language and deployed to a Maven repository. Maven serves the purpose
of exchange point.
Master node uses Akka Remoting to communicate with the worker nodes.
The test execution requests are also using Akka remoting.
The scenario execution is delegated to worker nodes also using a message.
Worker nodes instantiate runtime environment by downloading necessary scenario logic from Maven repository.
Worker nodes communicate progress of scenario and interim results with the master node.

### Messages

TBD: how to collect partial results without a need of sending all observations to master node.
Is it possible to calculate percentiles based on some aggregates being sent from worker nodes?



Scenario execution
```
case class Scenario(groupId: String, artifactId: String, version: String)

case class ExecuteScenario(name: String, scenario: Scenario)

case class ExecutionAcknowledgment(scenario: Scenario, taskId: String)

case class StopTask(taskId: String)

case class TaskProgress ????
```

## Usage

* You should start from writing an arbitrary piece of code that executes a scenario.
* Build and deploy the code to Maven repository.
* Start Master and slave nodes for processing the test.
* Execute submit method that takes address of master node and Maven artifact

## Test API

