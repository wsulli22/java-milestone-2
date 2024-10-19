package edu.nd.cse.paradigms;

//NEW: public class PECollisionEvent extends PEEvent
public class PECollisionEvent extends PEEvent{

  //NEW: PECollisionEvent(PEWorldObject wo1, PEWorldObject wo2)
  public PECollisionEvent(PEWorldObject wo1, PEWorldObject wo2){
    this.wo1 = wo1;                                                   //CODE ADDED
    this.wo2 = wo2;                                                   //CODE ADDED
  }
  //NEW: List<PEWorldObject> getCollidingObjects()
  public List<PEWorldObject> getCollidingObjects(){
    List<PEWorldObject> collidingObjects = new ArrayList<>();         //CODE ADDED
    collidingObjects.add(this.wo1);                                   //CODE ADDED
    collidingObjects.add(this.wo2);                                   //CODE ADDED
    return collidingObjects;                                         //CODE ADDED
  } 
  

  
}