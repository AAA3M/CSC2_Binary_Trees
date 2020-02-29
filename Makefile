JAVAC=/usr/bin/javac
.SUFFIXES: .java .class
SRCDIR=src
BINDIR=bin

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES=LSArrayApp.class LSArray.class \
		BinaryTreeNode.class BinaryTree.class \
        BTQueueNode.class BTQueue.class \
        BinarySearchTree.class BinarySearchTreeTest.class \
		BTree.class LSBSTApp.class LSData.class \
		MyBinTree.class BTreeApp.class LSBTree.class

CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)
default: $(CLASS_FILES)
clean:
	rm $(BINDIR)/*.class
runB:
	java -cp bin LSBSTAPP

runL:
	java -cp bin LSArrayApp
	