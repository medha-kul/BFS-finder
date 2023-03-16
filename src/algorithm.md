Input: The selection of blocks(yellow) from the user
to create obstacles between the starting point and ending point. 


Output: the animation of finding path with BFS

Steps: 
  Simple steps I used for the Breadth First Search Algorithm
  Two types - 
  Visited
  Not Visited
  
need to keep collection of visited nodes so that we don't visit them again. 

1. Take an Empty Queue.

2.  Select a starting node (visiting a node) and insert it into the Queue (jappu).

3.  Provided that the Queue(jappu) is not empty, extract the node from the Queue(jappu) and insert its child nodes (exploring a node) into the Queue.

4.  Print the extracted nodes. 

5. Create MenuBar and MenuOptions for the user to pick. I used Nimbus LookAndFeel along with swing for GUI.

