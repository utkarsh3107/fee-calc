# Fee Calculator

## Highlights

- Please import this as gradle project
- Class *ServiceTest.java* has test cases, run *testEndToEnd()* to see the result.
- Project uses Factory Pattern for creating wrappers with CSV, XML etc.
- The Project is segregated such that it can be later included in any REST service framework.
- There are 3 primary methods provided
    - **read(File)** : when the file is provided. In the future this can be used with a multipart request. Method returns a unique ID is which can be used to get the report later.
    - **read(Path)** : when the path is provided. Method returns a unique ID is which can be used to get the report later.
    - **generateReport(ID)** : Given unique id generates the report
 - Framework for reading CSV is *jsefa*.
-  To add new test cases, put the file in src/test/resources and rename resourceName variable inside **ServiceTest.java**



## Result

```
[
  {
    "attrName": null,
    "transactionID": "SAPEXTXN13",
    "clientID": "AP",
    "securityID": "HINDALCO",
    "trasactionType": "BUY",
    "date": 1383417000000,
    "value": 110,
    "priority": "Y",
    "processingValue": 500
  },
  {
    "attrName": null,
    "transactionID": "SAPEXTXN16",
    "clientID": "AP",
    "securityID": "ICICI",
    "trasactionType": "DEPOSIT",
    "date": 1383676200000,
    "value": 500,
    "priority": "Y",
    "processingValue": 500
  },
  {
    "attrName": null,
    "transactionID": "SAPEXTXN19",
    "clientID": "AP",
    "securityID": "ICICI",
    "trasactionType": "BUY",
    "date": 1383935400000,
    "value": 100,
    "priority": "Y",
    "processingValue": 500
  },
  {
    "attrName": null,
    "transactionID": "SAPEXTXN9",
    "clientID": "AP",
    "securityID": "ICICI",
    "trasactionType": "BUY",
    "date": 1384194600000,
    "value": 400,
    "priority": "Y",
    "processingValue": 500
  },
  {
    "attrName": null,
    "transactionID": "SAPEXTXN3",
    "clientID": "AP",
    "securityID": "HINDALCO",
    "trasactionType": "DEPOSIT",
    "date": 1384799400000,
    "value": 120,
    "priority": "Y",
    "processingValue": 0
  },
  {
    "attrName": null,
    "transactionID": "SAPEXTXN6",
    "clientID": "AP",
    "securityID": "ICICI",
    "trasactionType": "SELL",
    "date": 1385317800000,
    "value": 100,
    "priority": "Y",
    "processingValue": 500
  },
  {
    "attrName": null,
    "transactionID": "SAPEXTXN12",
    "clientID": "AS",
    "securityID": "REL",
    "trasactionType": "DEPOSIT",
    "date": 1383330600000,
    "value": 121.9,
    "priority": "N",
    "processingValue": 50
  },
  {
    "attrName": null,
    "transactionID": "SAPEXTXN7",
    "clientID": "AS",
    "securityID": "REL",
    "trasactionType": "BUY",
    "date": 1383676200000,
    "value": 121.1,
    "priority": "N",
    "processingValue": 50
  },
  {
    "attrName": null,
    "transactionID": "SAPEXTXN17",
    "clientID": "AS",
    "securityID": "REL",
    "trasactionType": "SELL",
    "date": 1383762600000,
    "value": 621.1,
    "priority": "N",
    "processingValue": 100
  },
  {
    "attrName": null,
    "transactionID": "SAPEXTXN20",
    "clientID": "AS",
    "securityID": "REL",
    "trasactionType": "SELL",
    "date": 1384021800000,
    "value": 721.1,
    "priority": "N",
    "processingValue": 100
  },
  {
    "attrName": null,
    "transactionID": "SAPEXTXN10",
    "clientID": "AS",
    "securityID": "REL",
    "trasactionType": "SELL",
    "date": 1384281000000,
    "value": 521.1,
    "priority": "N",
    "processingValue": 100
  },
  {
    "attrName": null,
    "transactionID": "SAPEXTXN2",
    "clientID": "AS",
    "securityID": "REL",
    "trasactionType": "SELL",
    "date": 1384885800000,
    "value": 121.9,
    "priority": "N",
    "processingValue": 0
  },
  {
    "attrName": null,
    "transactionID": "SAPEXTXN11",
    "clientID": "GS",
    "securityID": "ICICI",
    "trasactionType": "WITHDRAW",
    "date": 1383244200000,
    "value": 101.9,
    "priority": "Y",
    "processingValue": 500
  },
  {
    "attrName": null,
    "transactionID": "SAPEXTXN15",
    "clientID": "GS",
    "securityID": "RELIND",
    "trasactionType": "WITHDRAW",
    "date": 1383589800000,
    "value": 430,
    "priority": "Y",
    "processingValue": 500
  },
  {
    "attrName": null,
    "transactionID": "SAPEXTXN18",
    "clientID": "GS",
    "securityID": "RELIND",
    "trasactionType": "BUY",
    "date": 1383849000000,
    "value": 500,
    "priority": "Y",
    "processingValue": 500
  },
  {
    "attrName": null,
    "transactionID": "SAPEXTXN8",
    "clientID": "GS",
    "securityID": "RELIND",
    "trasactionType": "DEPOSIT",
    "date": 1384108200000,
    "value": 300,
    "priority": "Y",
    "processingValue": 500
  },
  {
    "attrName": null,
    "transactionID": "SAPEXTXN1",
    "clientID": "GS",
    "securityID": "ICICI",
    "trasactionType": "BUY",
    "date": 1385145000000,
    "value": 101.9,
    "priority": "Y",
    "processingValue": 0
  },
  {
    "attrName": null,
    "transactionID": "SAPEXTXN5",
    "clientID": "GS",
    "securityID": "RELIND",
    "trasactionType": "WITHDRAW",
    "date": 1385404200000,
    "value": 330,
    "priority": "Y",
    "processingValue": 500
  },
  {
    "attrName": null,
    "transactionID": "SAPEXTXN14",
    "clientID": "HJ",
    "securityID": "RELIND",
    "trasactionType": "SELL",
    "date": 1383503400000,
    "value": 330,
    "priority": "N",
    "processingValue": 100
  },
  {
    "attrName": null,
    "transactionID": "SAPEXTXN4",
    "clientID": "HJ",
    "securityID": "RELIND",
    "trasactionType": "WITHDRAW",
    "date": 1385749800000,
    "value": 230,
    "priority": "N",
    "processingValue": 0
  }
]
```
