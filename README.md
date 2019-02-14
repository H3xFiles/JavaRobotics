<img src="https://www.jpl.nasa.gov/images/msl/20160613/pia20602-16.jpg"> 

# JavaRobotics:  Software Design 2019 VU
#  <img src="https://raw.githubusercontent.com/H3xFiles/JavaRobotics/master/logo.png?token=AOQxifI0mRzajW--ZDSFZW972g54advYks5caI-fwA%3D%3D" alt="Smiley face" height="42" width="42"> Commenting style 
- Every non-obvious class declaration should have an accompanying comment that describes what it is for and how it should be used.
- Almost every function declaration should have comments immediately preceding it that describe what the function does and how to use it.
  - What the inputs and outputs are.
  - How a function is used.
  
Example:
```java
/**
This function take these variable {var1, var2} to {accomplish this},
the return value of this function is {RetVar}.
  Args:
        var1: {type}
        var2: {type}

    Returns:
        retVar: {type}
 */
```
- [Comments](https://google.github.io/styleguide/cppguide.html#Comments)

#  <img src="https://raw.githubusercontent.com/H3xFiles/JavaRobotics/master/logo.png?token=AOQxifI0mRzajW--ZDSFZW972g54advYks5caI-fwA%3D%3D" alt="Smiley face" height="42" width="42"> Algorithm

### A* Theta* Theta-Lazy Algorithm pseudocode
Theta* builds upon A*, bu the key difference between Theta* (Figure 5) and A* is that Theta* allows the parent of a vertex to be any vertex, unlike A* where the parent must be a visible neighbor. Lazy Theta* is simple (to understand and to implement), fast and finds short and realistic looking paths. In fact, the pseudo code for Lazy Theta* has only four more lines than the pseudo code for A*. Lazy Theta* is faster than Theta* because it takes a much more laid back approach as to when it peforms line-of-sight checks and yet it still finds short and realistic looking paths.

![A](http://aigamedev.com/wp-content/blogs.dir/5/files/2013/07/fig53-full.png)
*  Figure 4: Pseudo Code of A* (left), Theta* (center) and Lazy Theta* (right) 

#### Line of Sight pseudocode
![](http://aigamedev.com/static/tutorials/aap-LOS.png)

* [Source1](http://aigamedev.com/open/tutorials/theta-star-any-angle-paths/)
* [Source2](http://aigamedev.com/open/tutorial/lazy-theta-star/)
* [Source3](http://theory.stanford.edu/~amitp/GameProgramming/Variations.html)




# Project documentation 
##  <img src="https://raw.githubusercontent.com/H3xFiles/JavaRobotics/master/logo.png?token=AOQxifI0mRzajW--ZDSFZW972g54advYks5caI-fwA%3D%3D" alt="Smiley face" height="42" width="42"> Links about UML
- [UML 2.5 Diagrams Overview](https://www.uml-diagrams.org/uml-25-diagrams.html)
- [How To: Automatically generate UML diagrams from javacode](https://www.youtube.com/watch?v=0Zlh56mTS6c)

##  <img src="https://raw.githubusercontent.com/H3xFiles/JavaRobotics/master/logo.png?token=AOQxifI0mRzajW--ZDSFZW972g54advYks5caI-fwA%3D%3D" alt="Smiley face" height="42" width="42"> Links about Java
- [Core Java Complete Course](https://www.studytonight.com/java/)

##  <img src="https://raw.githubusercontent.com/H3xFiles/JavaRobotics/master/logo.png?token=AOQxifI0mRzajW--ZDSFZW972g54advYks5caI-fwA%3D%3D" alt="Smiley face" height="42" width="42"> Links about Simbad
- [Simbad Programming Guide](http://simbad.sourceforge.net/guide.php)
- [Simbad: an Autonomous Robot Simulation Package forEducation and Research](https://hal.inria.fr/inria-00116929/document)

##  <img src="https://raw.githubusercontent.com/H3xFiles/JavaRobotics/master/logo.png?token=AOQxifI0mRzajW--ZDSFZW972g54advYks5caI-fwA%3D%3D" alt="Smiley face" height="42" width="42"> Links about Papyrous
- [Papyrus reverse engineering Java](https://wiki.eclipse.org/Java_reverse_engineering)

##  <img src="https://raw.githubusercontent.com/H3xFiles/JavaRobotics/master/logo.png?token=AOQxifI0mRzajW--ZDSFZW972g54advYks5caI-fwA%3D%3D" alt="Smiley face" height="42" width="42"> Links about articles and tutorials
- [An Introductory Robot Programming Tutorial](https://www.toptal.com/robotics/programming-a-robot-an-introductory-tutorial)
- [Making a robot learn how to move, part 2 – reinforcement learning in the real, wild world](https://towardsdatascience.com/making-a-robot-learn-how-to-move-part-2-reinforcement-learning-in-the-real-wild-world-9427da7b9b21)
- [Introduction to Evolutionary Algorithms](https://towardsdatascience.com/introduction-to-evolutionary-algorithms-a8594b484ac)
- [Robots, mazes, and subsumption architecture Programming virtual robots in the Java language](https://www.ibm.com/developerworks/java/library/j-robots/)
- [Introduction to Genetic Algorithms — Including Example Code](https://towardsdatascience.com/introduction-to-genetic-algorithms-including-example-code-e396e98d8bf3)
- [Creating a genetic algorithm for beginners](http://www.theprojectspot.com/tutorial-post/creating-a-genetic-algorithm-for-beginners/3)

##  <img src="https://raw.githubusercontent.com/H3xFiles/JavaRobotics/master/logo.png?token=AOQxifI0mRzajW--ZDSFZW972g54advYks5caI-fwA%3D%3D" alt="Smiley face" height="42" width="42"> Links about algorithms
- [Theta*: Any-Angle Path Planning for Smoother Trajectories in Continuous Environments](http://aigamedev.com/open/tutorials/theta-star-any-angle-paths/)
- [Lazy Theta*](http://aigamedev.com/open/tutorial/lazy-theta-star/)
- [A*, Theta* ](http://theory.stanford.edu/~amitp/GameProgramming/Variations.html)
- [Good explanation MiniMax strategy](http://www.u.arizona.edu/~mwalker/MixedStrategy3.pdf)
- [Video: Game Theory Mixed Strategy](https://www.youtube.com/watch?v=3dd-IRedU0U)
- [Video: theta* with an unknown map](https://www.youtube.com/watch?v=MrQXtZnKgms)
- [VideoL: D* pathfinding](https://www.youtube.com/watch?v=X5a149nSE9s)
- [Video: Intro to Path Planning: D* Lite vs. A*](https://www.youtube.com/watch?v=skK-3UfcXW0)
- [Video: 13 Reinforcement Learning: Policy Gradients, Q Learning, AlphaGo - Vrije(MLVU2018)](https://www.youtube.com/watch?v=_8iWqyWUfoA&feature=youtu.be)
- [Video: A* in C++ tutorial 30min](https://www.youtube.com/watch?v=icZj67PTFhc)
- [Robot Motion Planning - Wolfram Burgard, Cyrill Stachniss](http://ais.informatik.uni-freiburg.de/teaching/ss11/robotics/slides/18-robot-motion-planning.pdf)
- [Search Algorithms and Path-finding](http://gki.informatik.uni-freiburg.de/teaching/ws1011/imap/05_SearchAlgorithmsAndPathPlanningMAS_PartB.pdf)
- [SwarmOps for JavaNumeric & Heuristic Optimization](http://www.hvass-labs.org/projects/swarmops/java/files/SwarmOpsJava1_0.pdf)
- [Reinforcement Learning:An Introduction](http://incompleteideas.net/book/bookdraft2017nov5.pdf)


##  <img src="https://raw.githubusercontent.com/H3xFiles/JavaRobotics/master/logo.png?token=AOQxifI0mRzajW--ZDSFZW972g54advYks5caI-fwA%3D%3D" alt="Smiley face" height="42" width="42"> Links about papers
- [An Optimal Path Algorithm for Autonomous SearchingRobots](http://inf.ucv.ro/~ami/index.php/ami/article/viewFile/264/258)
- [A Hybrid Search Algorithm for Swarm Robots Searching in an Unknown Environment](https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4227730/)
- [Teaching Reinforcement Learning using a Physical Robot](https://pdfs.semanticscholar.org/488a/255be72cbac2cfaf303042d87f932ff1ebf9.pdf)

##  <img src="https://raw.githubusercontent.com/H3xFiles/JavaRobotics/master/logo.png?token=AOQxifI0mRzajW--ZDSFZW972g54advYks5caI-fwA%3D%3D" alt="Smiley face" height="42" width="42"> Links about tools
- [VM-ready]

##  <img src="https://raw.githubusercontent.com/H3xFiles/JavaRobotics/master/logo.png?token=AOQxifI0mRzajW--ZDSFZW972g54advYks5caI-fwA%3D%3D" alt="Smiley face" height="42" width="42"> Links to other github repositories
- [This is a program written by Mike Worth to experiment with using genetic algorithms to evolve Robocode Bots.](https://github.com/MikeWorth/RoboNucleicAcid)
- [Tetha* in C++](https://github.com/palmieri/theta_star/blob/master/stlthetastar.h)

##  <img src="https://raw.githubusercontent.com/H3xFiles/JavaRobotics/master/logo.png?token=AOQxifI0mRzajW--ZDSFZW972g54advYks5caI-fwA%3D%3D" alt="Smiley face" height="42" width="42"> Other Videos
- [3 min maze solving recursion tutorial](https://www.youtube.com/watch?v=R6MbWXxZNaQ)
- [Theta Star Algorithm](https://www.youtube.com/watch?v=__F3QwP30Q0)

## <img src="https://raw.githubusercontent.com/H3xFiles/JavaRobotics/master/logo.png?token=AOQxifI0mRzajW--ZDSFZW972g54advYks5caI-fwA%3D%3D" alt="Smiley face" height="42" width="42"> Fun stuff
- [Sci-Fi Short Film "Wire Cutters"](https://www.youtube.com/watch?v=CIx0a1vcYPc)
  - 2 types of robots used for mining operations. One is fast and equiped with special cameras to spot minerals and the second one cruch big rocks to extract the minerals.
  - every n hours they need to recharge
