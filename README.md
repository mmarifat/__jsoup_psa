# JSoup Scraping

## Introduction

This module will scrap all the movies and tv-series links and other descriptions from psarips.com

## Install the dependencies
```bash
mvn dependency:copy-dependencies -DoutputDirectory='yourfoldername'
#and
phpMyAdmin to save into database
```

### Notice
```bash
To save the result into database, 
# import scrapedData.sql into your phpMyAdmin
# set Databases info in the Connector.java.
# un-comment code from both movies and tv-shows java file.
```