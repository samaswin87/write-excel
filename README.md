# write-excel
POI create excel file from JSON data or XML data

Read a Json File:

Example file format:

```
[ 
  { 
    "title1" : "First Name",
    "title2" : "Last Name",
    "title3" : "Age"	
  },	
  {
    "first" : "John",
    "last" : "Smith",
    "age" : 12
  }, 
  {
    "first" : "Jane",
    "last" : "Doe",
    "age" : 19
  }
]
```
Read a XML File:

Example XML file Format:
```
<?xml version="1.0"?>
<template title="Students">
	<headers>
	<title1>Name</title1>
	<title2>Age</title2>
	<title3>Sex</title3>
	</headers>
	<records>
		<data>
			<name>Nikki</name>
			<age>13</age>
			<sex>female</sex>
		</data>
		<data>
			<name>David</name>
			<age>21</age>
			<sex>male</sex>
		</data>
		<data>
			<name>John</name>
			<age>24</age>
			<sex>male</sex>
		</data>
	</records>
</template>
```


Calling the method:

main(char exceloption, String filePath, String excelFilePath)

* Excel option:

	JSON (J) or XML (X) are the options.

* File Path:

	Source XML or JSON Path.

* Excel File Path:

	Destination File Path.	
	

