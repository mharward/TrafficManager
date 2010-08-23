Traffic Manager 0.1

Limitations: 

# Does not currently handle bi-modal signs that can change
the colour of a single light. Possible solution: generalise light so
it handle multiple light colours (in a set). Comparing two lights is 
then a process of comparing the colours available in that light 
and the type as currently.

# Schema for operations in different countries have to be entered
manually into the source code by subclassing LightSetController.
Possible solution: Use an XML document to define the operations.

# Need to revamp the concept of roads. Possible solution: We use a
model with Road <-made of- RoadSection <-Has two- RoadSectionEnd
A RoadSectionEnd may have a FullLightSet, if there are traffic lights,
otherwise it won't.

# How can we define the difference between the two ends of a RoadSection?
We could define them by proximity, but this falls down at the ends of
a road, we could just label them A/B, but that is not amazingly
useful. We could use some kind of geo-positioning. But this requires
additional data and is not necessary for the current pseudo-abstract
model. How about the end of a RoadSection is defined by the road 
section it abuts or a null value if it abuts nothing. A RoadSection
should know what sections it abuts and a RoadSectionEnd should be
defined/null for each. If a traffic light set is not present, an
alternative class should be used. 
Use the following inheritence hierarchy:
RoadSectionEnd <-- TrafficLight, Roundabout, GiveWay, Stop.
For complicated systems this may have to be adjusted to deal with
mulitple lanes. For instance where the left turning lane is a
GiveWay feeder, and the straight and right lanes are traffic lights.

# Does a RoadSection know which RoadSectionEnd it owns or does an
Intersection, or both. Does a RoadSectionEnd know the Intersection
and RoadSection it is owned by? Does a road know the Intersections on
it? It makes sense that a RoadSectionEnd is known by its RS and I.
 