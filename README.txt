One of the ways to run the app is to open the console in the AltimaTask/target/ folder and enter the command:
java -cp AltimaTask.jar task.Main altima_task.txt

altima_task.txt is the input file for the app, it looks like this:

Adam Ivan
Marko Stjepan
Stjepan Adam
Robert Stjepan
Fran Ivan
Leopold Luka

the expected output is:

Ivan
    Adam
        Stjepan
            Marko
            Robert
    Fran
Luka
    Leopold

the MainTest class contains the unit tests (JUnit4) for methods cycle and findNode.
The tests can be run in your IDE of choosing.