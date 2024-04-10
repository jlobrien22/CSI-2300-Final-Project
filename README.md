Chat App Project

Communication is a vital party of everyday life and this app can help.

How to use:
Launch App
Enter username for User 1
Enter username for User 2
Enjoy Chat App!

Demo: https://youtu.be/ZdGhlbdc4d8?si=cdqYBNsQf10LTx21 

UML Diagram
------------------------------------
|             ChatApp              |
------------------------------------
| - chatArea: TextArea             |
| - user1InputField: TextField     |
| - user2InputField: TextField     |
| - user1Name: String              |
| - user2Name: String              |
------------------------------------
| + start(primaryStage: Stage): void|
| - sendMessage(username: String,  |
|   message: String): void         |
| - appendMessage(message: String):|
|   void                           |
| - getCurrentTime(): String       |
| + main(args: String[]): void     |
------------------------------------



   
