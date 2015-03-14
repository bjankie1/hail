# hail
Scalable stress testing automation

## Components

* Core application - serves the purpose of executing arbitrary scenario code in the cluster
* API - library that defines endpoints that are required by Core application to execute an evaluation.

## Architecture


## Usage

* You should start from writing an arbitrary piece of code that executes a scenario.
* Build and deploy the code to Maven repository.
* Start Master and slave nodes for processing the test.
* Execute submit method that takes address of master node and Maven artifact

## Test API

