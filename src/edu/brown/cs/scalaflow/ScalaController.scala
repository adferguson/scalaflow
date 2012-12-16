package edu.brown.cs.scalaflow

import scala.collection.JavaConverters._

import org.openflow.protocol.OFType

import net.floodlightcontroller.core.module.IFloodlightModule
import net.floodlightcontroller.core.module.IFloodlightService
import net.floodlightcontroller.core.module.FloodlightModuleContext
import net.floodlightcontroller.core.IOFSwitchListener
import net.floodlightcontroller.core.IOFSwitch

import net.floodlightcontroller.core.IFloodlightProviderService;

import org.slf4j.Logger
import org.slf4j.LoggerFactory


class ScalaController extends IFloodlightModule with IOFSwitchListener {
  // it would be great to make these val's instead, probably with some kind
  // of singleton object alongside our class
  var floodlightProvider : IFloodlightProviderService = _
  val logger : Logger = LoggerFactory.getLogger(classOf[ScalaController])
  
  def getName() = {
    "ScalaController"
  }
  
  
  def getModuleServices() : java.util.Collection[java.lang.Class[_ <: IFloodlightService]] = {
    Set[java.lang.Class[_ <: IFloodlightService]]().asJava
//    ().asInstanceOf[java.util.Collection[java.lang.Class[_ <: IFloodlightService]]]
  }
  
  def getServiceImpls() : java.util.Map[java.lang.Class[_ <: IFloodlightService], IFloodlightService] = {
      Map[java.lang.Class[_ <: IFloodlightService], IFloodlightService]().asJava
//    ().asInstanceOf[java.util.Map[java.lang.Class[_ <: IFloodlightService], IFloodlightService]]
  }
  
  def getModuleDependencies() : java.util.Collection[java.lang.Class[_ <: IFloodlightService]] = {
    Set[java.lang.Class[_ <: IFloodlightService]](classOf[IFloodlightProviderService]).asJava
  }
  
  /*
  def isCallbackOrderingPrereq(t: OFType, name: String) = {
    false
  }*/
  
  def init(context: FloodlightModuleContext) = {
    floodlightProvider = context.getServiceImpl(classOf[IFloodlightProviderService])
    logger.info("Start me up some Scala!")
  }
  
  def startUp(context : FloodlightModuleContext) = {
    floodlightProvider.addOFSwitchListener(this)
  }
  
  def addedSwitch(sw: IOFSwitch) = {
    println("A SWITCH WAS ADDED!! WOOHOO!! id = " + sw.getId())
  }

  def removedSwitch(sw: IOFSwitch) = {
  }

  def switchPortChanged(switchId: java.lang.Long) = {
  }
}