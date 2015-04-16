
 RAPID ENCRYPTION USING THE GERMAN WW1 ADFGVX CYPHER

This applicatinon is capable of encrypting and decrypting a text using an ADFGVX cypher.
To encrypt text you need to enter 'y' for confirm, then enter the file name and keyword.
Text files must be seved in the root folder. Files with encrypted decrypted texts are storring
in the root folder and cald encText.txt for encrypted text file and decText.txt for decrypted
text file.
Duration time of encrypting and decrypting text are displayed after each process.

STEP1
//********************************************************************************
How to run program?
1)
In the command line need to enter into the root directory where the project exist.
C:\User\UserName\folder>cd g00196984

2)
In the command line type:
java -jar encoder.jar
Program will run.
//*********************************************************************************

STEP2
//**********************************************************************************
How to use?
1) Start
After title and description you will be asking for encrypting:
 	Do you want to try encrypt your text? (y/n) -->
If you print 'n', then program will close.
If you print 'y', then you will be asked for promting the file name.

2) File name
 Then enter file name that contains the text for encryption:
 -->
You need to enter full file name, for example text.txt
In the root folder is at list five text files: 
intro.txt - contains application description;
README.txt - is what you are reading right now;
PoblachtNaHEireann.txt - is small text (3kb);
DeBelloGallico.txt - is large enough text (778kb);
WarAndPeace.txt - is very large text (3130kb);

Also, if this program was priveously running, in the root folder has to be
encText.txt file - last encrypted text
decText.txt file - last decrypted text

Any text file could be added into the root folder and encrypted with this program

3) Keyword
Then you will be asked for entering keyword
 Enter keyword -->  
Keyword can content any of from 32 till 126 simbols from ascii table
(numbers, lowercase letters, uppercase letters, slashes, brackets and so on).
Keyword could be any length, but time of decrypting text is depend of
keyword length. 5-10 simbols is the best.

4) Encrypting
After entering keyword, text will be encrypted and stored into the encText.txt
file that will be created in the root folder. If file already exist, it will be
rewriten with new encrypting text.
On the command prompt the message with encrypting duration time will be displayed.

 Encryptng is done. Encrypted text is stored in encText.txt file.
 Took 641 miliseconds

5) Decrypting
After encrypting program will ask for decrypt encrypting text:
       Do you want to decrypt encrypted text? (y/n) -->

If you choose 'n' you will be asked for encrypt another text:
Do you want to try encrypt another text? (y/n) -->

If you choos 'y', then text will be decrypted into the decText.txt file,
that will be stored in the root folder, and message will be desplayed on the command
prompt:
        Decryptng is done. Decrypted text is stored in decText.txt file.
        Took 391 miliseconds

Decrypting text will contains all punctuation marks and spaces, but will be used
only lowwer case letters.

Then program will ask for encrypting another text.
n - program will be closed.
y - program will process stages 2-5 again
//**********************************************************************************

PROGRAM WAS DEVELOPED BY ANDREY LAVRINOVIC (G00196984)
WORKING VERSION OF THIS PROGRAM IS EXIST IN:
https://github.com/AndrejLavrionovic/JavaProject.git

THANK YOU.