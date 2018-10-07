# Linked Priority Queue
A linked list implementation of the priority queue ADT using Comparable. LinkedPriorityQueue orders its elements according to their natural ordering. **Highest priority being the first in the chain.**

# Documentation
The official documentation (javadoc) can be found [here](https://zmohling.github.io/LinkedPriorityQueue/index.html), while informal visual representations of the implementation are included below.

## `LinkedPriorityQueue`
<p align="center"> 
<img src="https://s3.us-east-2.amazonaws.com/beck.ai/publicimages/figure1.0.png">
</p>

## `Node`
<p align="center"> 
<img src="https://s3.us-east-2.amazonaws.com/beck.ai/publicimages/figure1.1.png">
</p>

## `push()`
When pushing elements to the linked priority queue, we have two special cases. If `newElement` is the first in the chain *(Figure 2.0)* and if `newElement` is larger than the first element in the chain, `firstNode.getElement()` *(Figure 2.1)*.

&nbsp;

<p align="center"> 
<img src="https://s3.us-east-2.amazonaws.com/beck.ai/publicimages/figure2.0.png">
</p>

&nbsp;

<p align="center"> 
<img src="https://s3.us-east-2.amazonaws.com/beck.ai/publicimages/figure2.1.png">
</p>

&nbsp;

If this is not a special case, instantiate a Node called `currentNode` referenced to `firstNode`. If `newElement` has a lesser priority than the next element in the chain, move `newNode` and `currentNode` down the chain. This continues in a `while loop` until either...

 1. `newNode` is prioritized
 2. `newNode.getNextNode() == null`

&nbsp;

<p align="center"> 
<img src="https://s3.us-east-2.amazonaws.com/beck.ai/publicimages/figure2.2.gif">
</p>


## `pop()`
Since the elements are prioritized when they're pushed into the queue, the highest priority element is the first Node in the chain. As shown in *Figure 3.0*, when we call `pop()`, the method returns the element stored in `firstNode`, `firstNode` is then referenced to the next Node, and the empty Node is deallocated by Java's garbage collector.

&nbsp;

<p align="center"> 
<img src="https://s3.us-east-2.amazonaws.com/beck.ai/publicimages/figure3.0.png">
</p>