import os
import subprocess

def addTestValuesBST():
    path = "/home/alaric/Documents/CSC2/Ass1/CSC2_Binary_Trees/DataFiles/LSArrayApp_Test_Samples"
    filew = open(path, "a")

    s = subprocess.check_output("""java LSArrayApp "DataFile.txt" """, shell=True)
    x = (s.decode("utf-8"))
    x += "\n--------------------\n"
    filew.write(x)
    filew.close()


addTestValuesBST()