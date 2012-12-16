Note: Assumes floodlight is available in the workspace as "floodlight" project

To run from Eclipse:

 1. Create a new Scala Application Run Configuration (name it, say, "ScalaFlow")
 2. the main class should be: `net.floodlightcontroller.core.Main`
 3. add Program arguments: `-cf src/resources/scalaflow.resources`
 4. add the floodlight project to the classpath under "User Entries"
