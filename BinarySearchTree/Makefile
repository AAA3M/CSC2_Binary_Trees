# binary search program makefile
# Hussein Suleman
# 27 March 2017

JAVAC=/usr/bin/javac

.SUFFIXES: .java .class

.java.class:
	$(JAVAC) $<

classes: BinaryTreeNode.class BinaryTree.class \
         BTQueueNode.class BTQueue.class \
         BinarySearchTree.class BinarySearchTreeTest.class

default: $(CLASSES)

clean:
	rm *.class
