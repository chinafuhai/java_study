
export JAVA_HOME=/usr/java14
export ANT_HOME=$HOME/apache-ant-1.7.1
export PATH=$PATH:$JAVA_HOME/bin
export CLASSPATH=.:$JAVA_HOME/bin:

#execute ant ,equals ant -build.xml

if [ $# -ne 1 ]
then
	echo "Usage:$0 compile_add --��������java"
	echo "      $0 compile_all --������������"
	exit
elif [ $1 = "compile_all" ]
then
	ant;	
elif [ $1 = "compile_add" ]
then
	ant -buildfile buildadd.xml;		
fi
