find . -name "*.java" > sources.txt
javac --release 7 -sourcepath . @sources.txt
java -cp ./src com.gabriel.classes.Main scenario.txt
