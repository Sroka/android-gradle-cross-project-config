# android-gradle-cross-project-config
Cross project configuration for Android gradle plugin. This was created as a workaround for https://code.google.com/p/android/issues/detail?id=52962 issue.

This basically changes dependency structure from tree (something like npm) to flat dependencies (something like bower) for android library modules.

#Problem
As of now android plugin for gradle has certain limitations for library modules:
* There is no global variant setting for given project. E.g in this project we have main application (app) and two libraies (library1, library2). All of the modules have their own configurable fields. All of modules can have plany of different build variants. Dependencies are as following:

   app depends on library1 and library2 

   library1 depends on library2
   
   Without setting publishNonDefault field to true (what causes building all variants) only release configuration of libraries will be provided. Moreover, developer has to manually set configurations for every library variant and maintain it across different build.gradle files in case of multiple libraries depending on different libraries. E.g.

   ../app/build.gradle
   
   `compile project(path:":android-libraries:library2", configuration: "customBuildType1")`

   ../android-libraries/library1/build.gradle
   
   `compile project(path:":android-libraries:library2", configuration: "customBuildType1")`
   
   Build will fail if dependencies doesn't match and in project with plenty of build types it can get complicated to figure out which build types should use which library versions.
* As mentioned above setting publishNonDefault to true causes all library variants to always be built no matter which ones are needed as per https://code.google.com/p/android/issues/detail?id=78997

#Solution
This repo contains proof of concept for cross-project configuration provided from .gradle file, ../android-libraries/cross-project-config.gradle specifically. I am using gradle file because project tab from Android Studio lists all gradle files in one place so you can have quick access to it. It can be really anything, .csv or whatever, parsing is done in ../android-libraries/build.gradle file so feel free to play with it. This as also quite nice to use with build systems (e.g. Bamboo), you can then provide this configuration externally.

Since config is provided from external file you can just set dependencies simply like this:

   `compile project(":android-libraries:library1")` 

#Build variants tab
Android Studio has build variant tab where you can specify variants to be used. It is not working for android library modules at the moment. When you don not specify which build variant has to be used in dependencies release variant will always be used no matter what you choose in the tab. If you specify build variant in dependencies there is no point of using the tab since it already hardcoded.

In order to not confuse users I used variantFilter wich reomves all configurations not present it config file.


